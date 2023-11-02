import { useLoaderData } from "react-router-dom"
import { MyCourseShow } from "../../components/CourseShow"
import { Course } from "../../Type/Type"

export const MyCourses = () => {

    const myCourses:Course[]|any = useLoaderData()
    return <>
    <div className="bg-lime-500 pt-40 pb-20 px-10">
        <div className="text-3xl font-semibold text-amber-300">Khóa học đã mua</div>
        <div className="mt-5 px-5 flex flex-wrap">
            {myCourses?.map((mCourse:Course) => <MyCourseShow course={mCourse} />)}
        </div>
    </div>
    </>
}