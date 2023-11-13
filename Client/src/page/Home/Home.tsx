import { useState } from "react";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { Slide } from "react-slideshow-image";
import BackGround from "../../assets/background.jpg";
import Cum1 from "../../assets/1cum.png";
import Cum3 from "../../assets/1cum3.png";
import { Course } from "../../Type/Type";
import { Link, useLoaderData } from "react-router-dom";
import { modalCOurseStyle } from "../../css/modalStyle";
import { CourseModal } from "../../components/CourseModal";
const Home = () => {
  const [open, setOpen] = useState(false);
  const [modalCourse, setModalCourse]: any = useState();
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

 // Use combinedHomeLoader to get both sets of data
 const { courses, bestCourses }:Course|any = useLoaderData();
 console.log(courses);
  

  const CourseShow = (course: Course) => {
    return (
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
                src={course?.courseImage}
              />
              <div className="flex justify-end">
                <div className="text-center text-xs bg-yellow-500 w-1/4">
                  {course?.levelModel !== undefined
                    ? course?.levelModel?.levelName
                    : "CHƯA LỰA CHỌN CẤP ĐỘ"}
                </div>
              </div>
            </div>
            <div className="text-center text-3xl font-normal py-3">
              {course?.title}
            </div>
          </div>
        ) : (
          ""
        )}
      </>
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
  
  return (
    <>
      <div>
        <img className="w-full" src={BackGround} alt="Logo" />
        <Link
          to={"/Courses"}
          style={{ right: "45%", bottom: "10%" }}
          className="absolute bg-lime-600 text-white px-3 py-4 font-normal text-xl rounded-sm"
        >
          Đăng ký học ngay
        </Link>
      </div>
      <div className="text-6xl font-bold text-center py-10">
        KHÓA HỌC CHO BÉ
      </div>
      <div className="text-4xl font-bold text-yellow-500 px-10 mt-10 mb-10">
        BÁN CHẠY NHẤT
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(bestCourses)}</Slide>
      </div>
      <div className="text-4xl font-bold text-yellow-500 px-10 mt-10 mb-10">
        CHO BÉ BẮT ĐẦU
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(courses)}</Slide>
      </div>
      <div className="text-5xl font-bold text-center px-10 mt-10 mb-10">
        Đội Ngũ Giáo Viên
      </div>
      <div className="text-xl font-sans text-center px-10 mt-10 mb-10">
        Các họa sĩ trẻ, nhiệt tình và nhiều kinh nghiệm giảng dạy học viện không
        chuyên
      </div>
      <img className="w-full" src={Cum1} alt="Logo" />
      <div className="text-5xl font-bold text-lime-600 text-center px-10 mt-10 mb-10">
        Cùng Ngắm Tranh Với Các Con
      </div>
      <img className="w-full" src={Cum3} alt="Logo" />

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
  );
};

export default Home;
