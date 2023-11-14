import { API } from "../../API/API"

export const forgotEmail = async({params}:{params:any}) => {
    const result = await API.changePassword(params)
    return result
}