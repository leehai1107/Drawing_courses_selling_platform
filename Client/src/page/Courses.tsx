import { useState } from 'react'
import { Slide } from "react-slideshow-image";
import { Course } from "../Type/Type";
import { useLoaderData } from "react-router-dom";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { modalCOurseStyle } from '../css/modalStyle';
import { CourseModal } from "../components/CourseModal";

export const Courses = () => {

    const [open, setOpen] = useState(false);
  const [modalCourse, setModalCourse]: any = useState();
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const courses: Course | any = useLoaderData();

  const CourseShow = (course: Course) => {
    return (
      <div className="w-4/12 mx-10 border-4 bg-white">
        <div
          onClick={() => {
            setModalCourse(course);
            handleOpen();
          }}
          className="border-b-4 border-black"
        >
          <img className="w-4/5 m-auto mt-5 mb-10" src={course.courseImg} />
          <div className="flex justify-end">
            <div className="text-center text-xs bg-yellow-500 w-1/4">
              {course?.levelinfo !== undefined
                ? course?.levelinfo?.levelName
                : "CHƯA LỰA CHỌN CẤP ĐỘ"}
            </div>
          </div>
        </div>
        <div className="text-center text-3xl font-normal py-3">
          {course?.title}
        </div>
      </div>
    );
  };

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

    return <>
    <div className="bg-lime-400">
    <div className="text-7xl font-medium text-center py-10">
        KHÓA HỌC CHO BÉ
      </div>
      <div className="text-4xl font-medium text-yellow-500 px-10 mt-10 mb-10">
        BÁN CHẠY NHẤT
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(courses.slice(3))}</Slide>
      </div>
      <div className="text-4xl font-medium text-yellow-500 px-10 mt-10 mb-10">
        CHO BÉ BẮT ĐẦU
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(courses.slice(3))}</Slide>
      </div>
      <div className="text-4xl font-medium text-yellow-500 px-10 mt-10 mb-10">
        Mới Cập Nhập
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(courses)}</Slide>
      </div>
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
    </>
}