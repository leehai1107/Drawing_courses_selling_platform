import { Form, Link, useActionData, useNavigate } from "react-router-dom";
import TextField from "@mui/material/TextField";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { useRecoilState } from "recoil";
import { accountState } from "../../../atom/atom";
import { setTitem } from "../../../util/sessionExtension";

const Login = () => {
  const [account, setAccount] = useRecoilState(accountState);
  const [mount, setMount] = useState(true);
  const result: any = useActionData();
  const navigate = useNavigate();

  useEffect(() => {
    setAccount(undefined);
    if (!result && !mount) {
      toast("Unthentication", { type: toast.TYPE.ERROR });
    } else if (result) {
      setAccount(result);
      setTitem("account", result);
      if (result?.rolename == "ADMIN") {
        navigate("/admin");
      } else navigate("/");
    }

    setMount(false);
  }, [result]);
  return (
    <>
      <div className="mx-10 text-center">
        <div className="pt-32 mb-12 text-5xl font-bold">Đăng Nhập</div>
        <Form method="post" className="mb-10">
          <div className="mb-5">
            <TextField
              required
              name="account"
              id="standard-basic"
              label="Tài khoản"
              variant="standard"
              className="w-1/4"
              sx={{ "& .MuiInputBase-root": { height: 40, fontSize: 20 } }}
            />
          </div>
          <div>
            <TextField
              required
              name="password"
              id="standard-basic"
              label="Mật khẩu"
              variant="standard"
              type="password"
              className="w-1/4"
              sx={{ "& .MuiInputBase-root": { height: 40, fontSize: 20 } }}
            />
          </div>
          <button className="px-20 py-3 rounded-full mt-10 mb-3 bg-indigo-500 font-medium text-white">
            Đăng Nhập
          </button>
          <div className="font-sans font-medium">
            <Link to={"/forgotpass"}>Quên mật khẩu?</Link>
          </div>
        </Form>
        <div className="flex justify-center mb-10 items-center">
          <hr className="w-1/4" />
          <span className="mx-10">Hoặc </span>
          <hr className="w-1/4" />
        </div>
        {/* <button className="w-1/4 px-4 py-2 border justify-center items-center flex gap-2 border-slate-200 rounded-lg text-slate-700 hover:border-slate-400 hover:text-slate-900 hover:shadow transition duration-150 m-auto">
          <img
            className="w-5 h-5"
            src="https://www.svgrepo.com/show/475656/google-color.svg"
            loading="lazy"
            alt="google logo"
          />
          <span>Login with Google</span>
        </button> */}
        <div className="mt-3 font-medium mb-20">
          Lần đầu bạn tới trang ? <Link to={"/signUp"}>Đăng ký ngay</Link>
        </div>
      </div>
    </>
  );
};

export default Login;
