import { Slide } from "react-slideshow-image";
import BackGround from "../assets/background.jpg";
import Cum1 from "../assets/1cum.png"
import Cum3 from "../assets/1cum3.png"
import { HotCourses, StartCourse } from "../data/Course";
const Home = () => {

  const CourseShow = (course: any) => {
    return (
      <div className="w-1/3 mx-4 mb-8"> {/* Adjust the width and margin */}
        <div className="border-4 border-black">
          <img
            className="w-full"
            src={course?.image}
            alt={course?.title}
          />
          <div className="flex justify-end">
            <div className="text-center text-xs bg-yellow-500 w-1/4">
              {course?.level !== undefined ? course?.level : "CHƯA LỰA CHỌN CẤP ĐỘ"}
            </div>
          </div>
          <div className="text-center text-3xl font-normal py-3">
            {course?.title}
          </div>
        </div>
      </div>
    );
  }  

  const SlideShow = (Courses: any[]) => {
    var slides = [];
    for (var i = 0; i < Courses.length; i += 3) {
      slides.push(
        <div key={i} className="flex px-4"> {/* Adjust the padding */}
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
        <button
          style={{ right: "45%", bottom: "10%" }}
          className="absolute bg-lime-600 text-white px-3 py-4 font-normal text-xl rounded-sm"
        >
          Đăng ký học thử
        </button>
      </div>
      <div className="text-7xl font-medium text-center py-10">
        KHÓA HỌC CHO BÉ
      </div>
      <div className="text-4xl font-medium text-yellow-500 px-10 mt-10 mb-10">
        BÁN CHẠY NHẤT
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(HotCourses)}</Slide>
        
      </div>
      <div className="text-4xl font-medium text-yellow-500 px-10 mt-10 mb-10">
        CHO BÉ BẮT ĐẦU
      </div>
      <div className="slide-container">
        <Slide>{SlideShow(StartCourse)}</Slide>
        
      </div>
      <div className="text-5xl font-serif text-center px-10 mt-10 mb-10">
        Đội ngũ giáo viên
      </div>
      <div className="text-xl font-sans text-center px-10 mt-10 mb-10">
        Các họa sĩ trẻ, nhiệt tình và nhiều kinh nghiệm giảng dạy học viện không chuyên
      </div>
      <img className="w-full" src={Cum1} alt="Logo" />
      <div className="text-5xl font-bold text-lime-600 text-center px-10 mt-10 mb-10">
        Cùng Ngắm Tranh Với Các Con
      </div>
      <img className="w-full" src={Cum3} alt="Logo" />
    </>
  );
};

export default Home;
