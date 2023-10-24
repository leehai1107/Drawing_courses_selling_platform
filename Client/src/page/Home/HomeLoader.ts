import { API } from "../../API/API"

export const homeLoader = async()=>{
    const result = await API.getAllCourse()
    return result
}