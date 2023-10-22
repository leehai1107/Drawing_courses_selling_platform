import { authAPI } from "../../../API/authAPI";

export const loginAction = async ({ request }: { request: Request }) => {
    const formData : any = await request.formData();
    console.log(formData.get('password'),)
    const data = {
        username: formData.get('account'),
        password: formData.get('password')
    }
    const result = await authAPI.loginApi(data)
    console.log(result)
    return result

}