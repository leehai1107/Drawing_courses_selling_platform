import { Link } from "react-router-dom";
import FPTLogo from "../assets/FPTLogo.png";
import GoogleLogin from "../assets/login-with-google-icon-3.jpg";

const Login = () => {
  return (
    <>
      <div className="mx-10">
        <img src={FPTLogo} className="w-3/12" alt="fpt logo" />
        <div className="p-10 mx-24 bg-neutral-400 text-center">
          <div className="text-yellow-600 font-semibold text-6xl my-5">
            Exam Schedule Management System
          </div>
          <Link to="/admin">
            <img className="my-40 w-5/12 m-auto" src={GoogleLogin} />
          </Link>
        </div>
      </div>
    </>
  );
};

export default Login;
