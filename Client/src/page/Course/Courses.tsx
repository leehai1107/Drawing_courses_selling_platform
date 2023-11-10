import { useState } from "react";
import { useLoaderData, useParams } from "react-router-dom";
import { Course } from "../../Type/Type";
import { CourseShow } from "../../components/CourseShow";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { CourseModal } from "../../components/CourseModal";
import { modalCOurseStyle } from "../../css/modalStyle";

export const Courses = () => {
  const courses: Course | any = useLoaderData();
  const { category } = useParams();
  const [open, setOpen] = useState(false);
  const [modalCourse, setModalCourse]: any = useState();
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  return (
    <>
      <div className="bg-lime-400 pt-20 pb-10">
        <div className="text-7xl font-medium text-center py-10">{category}</div>
        <div className="mt-5 px-5 flex flex-wrap">
          {courses?.map((mCourse: Course) => (
            <div
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
