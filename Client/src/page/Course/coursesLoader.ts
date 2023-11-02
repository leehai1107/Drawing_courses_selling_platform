import { API } from "../../API/API"

export const coursesLoader = async({params}:{params:any}) => {
    const result = await API.getCourseByCategory(params.categoryId)
    return result
}