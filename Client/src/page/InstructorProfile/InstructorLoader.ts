import { API } from "../../API/API"

export const instructorLoader = async ({params}:{params:any}) => {
    const instructor = await API.getUserInfo(params.userId)
    return instructor
}

export const instructorCourseLoaderTrue = async ({params}:{params:any}) => {
    const courses = await API.getCourseByInstructorTrue(params.userId)
    return courses
}