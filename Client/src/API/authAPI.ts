import axios from "axios";
import {toast} from "react-toastify"

const loginApi = async ({
  username,
  password,
}: {
  username: string | null;
  password: string | null;
}) => {
  const res: any = await axios
    .post(`http://localhost:8088/public/account/login`, { username, password })
    .catch((err) => {
      console.log(err.message);
      toast("unauthenticated", {type: toast.TYPE.ERROR})
      setTimeout(() => window.location.href = "http://localhost:5173/SignIn", 3000)
    });
  console.log(res);
  return res?.data;
};


const registerApi = async (data:any) => {
    const res: any = await axios
      .post(`http://localhost:8088/public/account/signup`, data)
      .catch((err) => {
        console.log(err.message);
        toast("unauthenticated", {type: toast.TYPE.ERROR})
        setTimeout(() => window.location.href = "http://localhost:5173", 3000)
      });
    console.log(res);
    return res?.data;
  };

const logoutApi = async (token:string) => {
    const res: any = await axios
      .post(`http://localhost:8088/public/account/logout`, {token})
      .catch((err) => {
        console.log(err.message);
        toast("unauthenticated", {type: toast.TYPE.ERROR})
      });
    console.log(res);
}

export const authAPI = { loginApi, registerApi, logoutApi };
