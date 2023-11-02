import { useLoaderData, useParams } from "react-router-dom";
import { Course } from "../../Type/Type";
import { CourseShow } from "../../components/CourseShow";

export const Courses = () => {
  const courses: Course | any = useLoaderData();
  const { category } = useParams();
  return (
    <>
      <div className="bg-lime-400 pt-20">
        <div className="text-7xl font-medium text-center py-10">{category}</div>
        <div className="mt-5 px-5 flex flex-wrap">
            {courses?.map((mCourse:Course) => <CourseShow course={mCourse} />)}
        </div>
      </div>
    </>
  );
};
