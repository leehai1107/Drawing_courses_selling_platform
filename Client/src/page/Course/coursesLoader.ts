import { API } from "../../API/API"

export const coursesLoader = async({params}:{params:any}) => {
    const result = await API.getTrueCourseByCategory(params.categoryId)
    return result
}