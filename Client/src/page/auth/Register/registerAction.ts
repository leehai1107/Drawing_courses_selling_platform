import { authAPI } from "../../../API/authAPI";

export const registerAction = async ({request}:{request:Request}) => {
    const formData = await request.formData()

    let data:any = {}

    formData.forEach((value, key) => {
        data = {
            ...data,
            [key]:value
        };
    });


    const {repassword, submitdata} = data

    console.log(submitdata);

    const result = await authAPI.registerApi(submitdata)

    return result??null
    
}
