import { API } from "../../API/API"

export const lessionLoader = async ({params}:any) => {
    const result = await API.getLessionByCourse(params.courseid)
    return result
}