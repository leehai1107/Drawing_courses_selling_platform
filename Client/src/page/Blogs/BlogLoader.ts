import { API } from "../../API/API"

export const blogLoader = async() => {
    const result = await API.getAllPost();
    return result
}