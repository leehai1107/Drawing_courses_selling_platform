import { API } from "../../API/API"

export const courseCategoriesLoader = async () => {
    const result = await API.getCourseCategories()
    return result
}