import { useRecoilState, useRecoilValue } from "recoil";
import { CartElement, Course } from "../Type/Type";
import { accountState, cartState } from "../atom/atom";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";

export const CourseModal = ({ course }: { course: Course | any }) => {
  const account: any = useRecoilValue(accountState);
  const [cart, setCart]: any = useRecoilState(cartState);

  const addToCart = () => {
    var cartCourse = cart.find(
      (c: CartElement) => c?.Course.courseid === course.courseid
    );
    if (cartCourse) {
      toast("Course already added", { type: toast.TYPE.WARNING });
    } else {
      setCart([
        ...cart,
        { Course: course, EnrollDate: new Date(), Teacher: "cô A" },
      ]);
    }
  };
  return (
    <>
      <div className="w-full">
        <div className="text-center text-2xl font-bold mb-10">
          {course?.title}
        </div>
        <div className="flex">
          <img className="w-1/2" src={course?.courseImg} />
          <div className="w-1/2 px-5 flex flex-col">
            <div className="flex-1">{course?.description}</div>
            <div className="mt-10">
              <span className="p-3 bg-orange-500 text-white font-medium">
                {course?.levelinfo?.levelName}
              </span>
            </div>
          </div>
        </div>
        <div className="text-center mt-5">
          {account?.rolename === "CUSTOMER" ? (
            <button
              onClick={addToCart}
              className="py-2 px-5 border border-yellow-400 rounded-full text-yellow-500 font-medium hover:text-white hover:bg-yellow-500"
            >
              Đăng Ký Học
            </button>
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
