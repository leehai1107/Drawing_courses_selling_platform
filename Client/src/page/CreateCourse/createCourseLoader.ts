import { API } from "../../API/API"

export const createCourseLoader = async() => {
    const categories = await API.getCourseCategories()
    const levels = await API.getCourseLevel()

    return {categories, levels}
}