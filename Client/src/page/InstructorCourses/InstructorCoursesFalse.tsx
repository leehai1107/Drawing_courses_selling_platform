import { useLoaderData, useParams } from "react-router-dom";
import { InstructorCourseShow } from "../../components/CourseShow";
import { Course } from "../../Type/Type";
import { useState, useEffect } from "react";
import ReactPaginate from "react-paginate";
import { API } from "../../API/API";

export const InstructorCoursesFalse = () => {
  const MyCoursesLoader: Course[] | any = useLoaderData();
  const [myCourses, setMyCourses]: any = useState(MyCoursesLoader);
  const [pageNumber, setPageNumber] = useState(0);
  const coursesPerPage = 3; // Adjust the number of courses per page as needed
  const { userid }: any = useParams();

  useEffect(() => {
    getMyCourses();
  }, [pageNumber, userid]); // Reload courses when the page number or userid changes

  const getMyCourses = async () => {
    const getMyCourses = await API.getCourseByInstructorFalse(userid);
    setMyCourses(getMyCourses);
  };

  const pageCount = Math.ceil(myCourses.length / coursesPerPage);

  const handlePageChange = ({ selected }: { selected: number }) => {
    setPageNumber(selected);
  };

  const offset = pageNumber * coursesPerPage;
  const paginatedCourses = myCourses.slice(offset, offset + coursesPerPage);

  return (
    <div className="bg-lime-500 pt-40 pb-20 px-10">
      <div className="text-3xl font-semibold text-amber-300 mb-5">
        Khóa đang chờ duyệt
      </div>
      <div className="mt-5 px-5 flex justify-center items-center">
        {paginatedCourses.map((mCourse: Course) => (
          <InstructorCourseShow
            key={mCourse.courseId}
            course={mCourse}
            getMyCourses={getMyCourses}
          />
        ))}
      </div>

      <div className="flex justify-center ">
        <ReactPaginate
          previousLabel={<div className="text-center text-white pagination-btn">Trước</div>}
          nextLabel={<div className="text-center text-white pagination-btn">Sau</div>}
          breakLabel={"..."}
          breakClassName={"break-me"}
          pageCount={pageCount}
          marginPagesDisplayed={2}
          pageRangeDisplayed={5}
          onPageChange={handlePageChange}
          containerClassName={"pagination "}
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
            "bg-gray-500 text-white border-2 border-gray-500 rounded-full p-2 mx-1"
          }
        />
      </div>

    </div>
  );
};
