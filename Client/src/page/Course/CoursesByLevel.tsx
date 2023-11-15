import { useState } from "react";
import { useLoaderData, useParams } from "react-router-dom";
import { Course } from "../../Type/Type";
import { CourseShow } from "../../components/CourseShow";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { CourseModal } from "../../components/CourseModal";
import { modalCOurseStyle } from "../../css/modalStyle";
import ReactPaginate from "react-paginate";

export const CoursesByLevel = () => {
  const courses: Course[] | any = useLoaderData();
  const { level } = useParams();
  const [open, setOpen] = useState(false);
  const [modalCourse, setModalCourse]: any = useState();
  const [pageNumber, setPageNumber] = useState(0);
  const coursesPerPage = 3; // Adjust the number of courses per page as needed

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const pageCount = Math.ceil(courses.length / coursesPerPage);

  const handlePageChange = ({ selected }: { selected: number }) => {
    setPageNumber(selected);
  };

  const offset = pageNumber * coursesPerPage;
  const paginatedCourses = courses.slice(offset, offset + coursesPerPage);

  return (
    <>
      <div className="bg-lime-400 pt-20 pb-10">
        <div className="text-7xl font-medium text-center py-10">{level}</div>
        <div className="mt-5 px-5 flex justify-center items-center">
          {paginatedCourses?.map((mCourse: Course) => (
            <div
              key={mCourse.courseId}
              className="w-3/12 mx-10 border-4"
              onClick={() => {
                setModalCourse(mCourse);
                handleOpen();
              }}
            >
              <CourseShow course={mCourse} />
            </div>
          ))}
        </div>
        <div className="mt-5 flex justify-center items-center">
          {/* Add 50px margin top */}
          <div style={{ marginTop: "50px" }}>
            <ReactPaginate
              previousLabel={
                <div className="text-center text-white pagination-btn">
                  Trước
                </div>
              }
              nextLabel={
                <div className="text-center text-white pagination-btn">
                  Sau
                </div>
              }
              
              breakLabel={"..."}
              breakClassName={"break-me"}
              pageCount={pageCount}
              marginPagesDisplayed={2}
              pageRangeDisplayed={5}
              onPageChange={handlePageChange}
              containerClassName={"pagination"}
              pageLinkClassName={
                "border-2 border-gray-500 rounded-full p-2 mx-1 text-gray-700"
              }
              activeClassName={"active"}
              previousLinkClassName={
                "border-2 border-gray-500 rounded-full p-2 mx-1 text-gray-700"
              }
              nextLinkClassName={
                "border-2 border-gray-500 rounded-full p-2 mx-1 text-gray-700"
              }
              activeLinkClassName={
                `bg-blue-500 text-white border-2 border-blue-500 rounded-full p-2 mx-1`
              }
            />
          </div>
        </div>
      </div>

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={modalCOurseStyle}>
          <CourseModal course={modalCourse} />
        </Box>
      </Modal>
    </>
  );
};
