import { useRecoilState, useRecoilValue } from "recoil";
import { CartElement, Course } from "../Type/Type";
import { accountState, cartState } from "../atom/atom";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { numberToVietnameseDong } from "../util/util";
import { useEffect, useState } from "react";
import { API } from "../API/API";

export const CourseModal = ({ course }: { course: Course | any }) => {
  const account: any = useRecoilValue(accountState);
  const [myCourse, setMyCourse]: any = useState([]);
  const [cart, setCart]: any = useRecoilState(cartState);

  const callback = async () => {
    const getMC = await API.getCourseByUser(account.userid);
    setMyCourse(getMC);
  };
  useEffect(() => {
    callback();
  }, []);

 const addToCart = () => {
    var cartCourse = cart.find(
      (c: CartElement) => c?.Course.courseId === course.courseId
    );
    if (cartCourse) {
      toast("Khoá học đã trong giỏ hàng", { type: toast.TYPE.WARNING });
    } else {
      toast(
        `${course.title} - ${numberToVietnameseDong(
          course?.price
        )} đã vào giỏ hàng`,
        { type: toast.TYPE.SUCCESS }
      );
      setCart([...cart, { Course: course, EnrollDate: new Date() }]);
    }
  };
  return (
    <>
      {console.log("modal course", course)}
      <div className="w-full">
        <div className="text-center text-2xl font-bold mb-10">
          {course?.title}
        </div>
        <div className="flex">
          <img className="w-1/2" src={course?.courseImage} />
          <div className="w-1/2 px-5 flex flex-col">
            <div className="flex-1">{course?.description}</div>
            <div className="mt-10">
              <div className="flex mb-5 justify-between">
                <div>Tổng bài học: {course?.lession_count} </div>
                <div>Giá: {numberToVietnameseDong(course?.price)} </div>
              </div>
              <Link
                to={`/InstructorProfile/${course?.userModelRespone.id}`}
                className="block text-blue-500 mb-5"
              >
                Giáo viên: {course?.userModelRespone.fullname}{" "}
              </Link>
              <Link
                to={`Courses/${course?.drawingCategoryModel?.drawCategoryName}/${course?.drawingCategoryModel?.drawCategoryId}`}
                className="p-3 bg-orange-500 text-white font-medium mr-5"
              >
                {course?.drawingCategoryModel?.drawCategoryName}
              </Link>
              <span className="p-3 bg-orange-500 text-white font-medium">
                {course?.levelModel?.levelName}
              </span>
            </div>
          </div>
        </div>
        <div className="text-center mt-10">
          {account?.rolename === "CUSTOMER" ? ( myCourse.some((mc: any) => mc.course.courseId === course.courseId) ? (
              <button className="py-2 px-5 border border-yellow-400 rounded-full text-yellow-500 font-medium hover:text-white hover:bg-yellow-500">
                Đã Đăng Ký
              </button>
            ) : (
              <button
                onClick={addToCart}
                className="py-2 px-5 border border-yellow-400 rounded-full text-yellow-500 font-medium hover:text-white hover:bg-yellow-500"
              >
                Đăng Ký Học
              </button>
            )
          ) : (
            <Link
              to={"/SignIn"}
              className="py-2 px-5 border border-yellow-400 rounded-full text-yellow-500 font-medium hover:text-white hover:bg-yellow-500"
            >
              Đăng Nhập
            </Link>
          )}
        </div>
      </div>
    </>
  );
};
