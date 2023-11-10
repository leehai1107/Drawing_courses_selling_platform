import { Link, useLoaderData, useParams } from "react-router-dom";
import { InstructorCourseShow } from "../../components/CourseShow";
import { Course } from "../../Type/Type";
import {  useState } from "react";
import { API } from "../../API/API";

export const InstructorCourses = () => {
  const MyCoursesLoader: Course[] | any = useLoaderData();
  const [myCourses, setMyCourses]:any = useState(MyCoursesLoader)
  const {userid}:any = useParams()


  const getMyCourses = async() => {
    const getMyCourses = await API.getCourseByInstructor(userid)
    setMyCourses(getMyCourses)
  }
  return (
    <>
      <div className="bg-lime-500 pt-40 pb-20 px-10">
        <div className="text-3xl font-semibold text-amber-300">
          Khóa học đã tạo
        </div>
        <div className="mt-5 px-5 flex flex-wrap mb-5">
          {myCourses?.map((mCourse: Course) => (
            <InstructorCourseShow course={mCourse} getMyCourses={getMyCourses}/>
          ))}
        </div>
        <div className="text-center mt-10">
          <Link
            to={"/createCourse"}
            className="p-2 bg-green-700 text-white mt-10"
          >
            Tạo Course
          </Link>
        </div>
      </div>
    </>
  );
};
