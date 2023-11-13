import { API } from "../../API/API"

export const instructorCourseLoaderFalse = async ({params}:any)=>{
    const result = await API.getCourseByInstructorFalse(params.userid)
    return result
}