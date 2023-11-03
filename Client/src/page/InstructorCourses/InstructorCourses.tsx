import { Link, useLoaderData } from "react-router-dom"
import { MyCourseShow } from "../../components/CourseShow"
import { Course } from "../../Type/Type"

export const InstructorCourses = () => {

    const myCourses:Course[]|any = useLoaderData()
    return <>
    <div className="bg-lime-500 pt-40 pb-20 px-10">
        <div className="text-3xl font-semibold text-amber-300">Khóa học đã tạo</div>
        <div className="mt-5 px-5 flex flex-wrap mb-5">
            {myCourses?.map((mCourse:Course) => <MyCourseShow course={mCourse} />)}
        </div>
        <div className="text-center mt-10">
            <Link to={"/createCourse"} className="p-2 bg-green-700 text-white mt-10">Tạo Course</Link>
        </div>
    </div>
    </>
}