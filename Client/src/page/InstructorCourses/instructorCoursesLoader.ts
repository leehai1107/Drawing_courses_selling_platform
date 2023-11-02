import { API } from "../../API/API"

export const instructorCourseLoader = async ({params}:any)=>{
    const result = await API.getCourseByInstructor(params.userid)
    return result
}