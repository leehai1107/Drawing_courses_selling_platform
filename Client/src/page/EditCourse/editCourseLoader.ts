import { API } from "../../API/API"

export const editCourseLoader = async({params}:any) => {
    const categories = await API.getCourseCategories()
    const levels = await API.getCourseLevel()
    const course = await API.getCourseById(params.courseId)

    return {categories, levels, course}
}