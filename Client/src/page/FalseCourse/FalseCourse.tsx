import { useEffect } from "react";
import { StaffCourseShow } from "../../components/CourseShow";
import { Course } from "../../Type/Type";
import { useState } from "react";
import { API } from "../../API/API";

export const FalseCourse = () => {
  const [myCourses, setMyCourses]: any = useState();

  useEffect(() => {
    getMyCourses();
  }, []);

  const getMyCourses = async () => {
    const getMyCourses = await API.getAllFalseCourse();
    setMyCourses(getMyCourses);
  };
  return (
    <>
      <div className="bg-lime-500 pt-40 pb-20 px-10">
        <div className="text-3xl font-semibold text-amber-300">
          Khóa học chưa duyệt
        </div>
        <div className="mt-5 px-5 flex flex-wrap mb-5">
          {myCourses?.map((mCourse: Course) => (
            <StaffCourseShow course={mCourse} getMyCourses={getMyCourses} />
          ))}
        </div>
      </div>
    </>
  );
};
