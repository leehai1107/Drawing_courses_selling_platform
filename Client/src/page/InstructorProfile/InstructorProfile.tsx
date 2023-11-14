import { useLoaderData } from "react-router-dom";
import { Course } from "../../Type/Type";
import { useState } from "react";
import { Slide } from "react-slideshow-image";
import { Box, Modal } from "@mui/material";
import { CourseModal } from "../../components/CourseModal";
import { modalCOurseStyle } from "../../css/modalStyle";

interface InstructorProfileData {
  instructor: any;
  courses: Course[];
}


export const InstructorProfile = () => {
  const { instructor, courses }: { instructor: any; courses: Course[] } =
    useLoaderData() as InstructorProfileData;
  const [open, setOpen] = useState(false);
  const [modalCourse, setModalCourse] = useState<Course | undefined>(undefined);

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  

  const CourseShow = (course: Course) => (
    <>
      {course ? (
        <div className="w-4/12 mx-10 border-4">
          <div
            onClick={() => {
              setModalCourse(course);
              handleOpen();
            }}
            className="border-b-4 border-black"
          >
            <img
              className="w-4/5 h-40 m-auto mt-5 mb-10"
              src={course.courseImage}
              alt={course.title}
            />
            <div className="flex justify-end">
              <div className="text-center text-xs bg-yellow-500 w-1/4">
                {course.levelModel !== null && course.levelModel !== undefined
                  ? course.levelModel.levelName
                  : "CHƯA LỰA CHỌN CẤP ĐỘ"}
              </div>
            </div>
          </div>
          <div className="text-center text-3xl font-normal py-3">
            {course.title}
          </div>
        </div>
      ) : (
        ""
      )}
    </>
  );

  const SlideShow = (Courses: Course[]) => {
    var slides = [];
    for (var i = 0; i < Courses.length; i += 3) {
      slides.push(
        <div key={i} className="flex px-10">
          {CourseShow(Courses[i])}
          {CourseShow(Courses[i + 1])}
          {CourseShow(Courses[i + 2])}
        </div>
      );
    }
    return slides;
  };

  return (
    <>
      <div className="h-screen pt-20 mb-30">
        <div className="h-1/2 pt-14 bg-green-300">
          <img
            className="rounded-full m-auto w-1/12"
            src={instructor.avatar}
            alt="Instructor Avatar"
          />
          <div className="absolute rounded-xl border bg-white left-96 right-96 mt-5 px-20 py-10 grid grid-cols-2 grid-rows-5">
            <div className="text-center text-xl font-bold mb-10 col-span-2">
              {instructor.fullname}
            </div>
            <div className="mb-5">Email: </div>
            <div>{instructor.email}</div>
            <div className="mb-5">Số điện thoại: </div>
            <div>{instructor.phone}</div>
            <div className="mb-5">Ngày tháng năm sinh: </div>
            <div>{instructor.dob}</div>
            <div className="mb-5">Mô tả: </div>
            <div>{instructor.description}</div>
          </div>
        </div>
      </div>

      <div className="text-4xl font-bold text-yellow-500 px-10 mt-10 mb-10">
        KHOÁ HỌC ĐANG DẠY
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(courses)}</Slide>
      </div>
      <div>
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
      </div>

      <div className="px-10 mt-10 mb-20"></div>
      
    </>
  );
};
