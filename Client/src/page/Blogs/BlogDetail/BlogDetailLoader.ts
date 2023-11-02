import { API } from "../../../API/API"

export const blogDetailLoader = ({params}:any) => {
    const result = API.getPostById(params.id)
    return result
}