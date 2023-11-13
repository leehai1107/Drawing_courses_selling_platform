import { API } from "../../API/API"

export const homeLoader = async()=>{
    const result = await API.getAllTrueCourse()
    return result
}

export const homeCourseLoader = async()=>{
    const result = await API.getTop4Course()
    return result
}

export const beginerCourses = async()=>{
    const result = await API.beginerCourse()
    return result
}