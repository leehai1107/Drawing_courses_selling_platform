import { API } from "../../API/API"

export const myCourseLoader = async ({params}:any)=>{
    const result = await API.getCourseByUser(params.userid)
    return result
}