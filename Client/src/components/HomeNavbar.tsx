import { Link, useNavigate } from "react-router-dom";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import { useRecoilState } from "recoil";
import { useEffect } from "react";
import { accountState } from "../atom/atom";
import MenuLogo from "../assets/MenuLogo.jpg";
import MenuData from "../data/MenuData";
import { authAPI } from "../API/authAPI";
import { getTitem } from "../util/sessionExtension";

const HomeNavbar = () => {
  const [account, setAccount]: any = useRecoilState(accountState);
  const navigate = useNavigate();

  useEffect(() => {
    const accountStr = getTitem("account");
    console.log(accountStr);
    if (accountStr) {
      setAccount(accountStr);
    }
  }, []);

  const logout = async () => {
    const token = account.refreshToken;
    setAccount(undefined);
    sessionStorage.clear();
    await authAPI.logoutApi(token);

    navigate("/");
  };

  return (
    <>
      <div className="flex items-center px-20 justify-between fixed z-10 bg-white bg-opacity-90">
        <div className="w-1/12">
          <Link to={"/"}>
            <img src={MenuLogo} alt="Logo" />
          </Link>
        </div>
        <div className="flex justify-between">
          {MenuData.map((data) => (
            <Link
              className="font-semibold mr-10 hover:text-yellow-500"
              to={data.link}
            >
              {data.label}
            </Link>
          ))}
          {account?.rolename === "CUSTOMER" ? (
            <>
              <Link
                className="font-semibold mr-10 hover:text-yellow-500"
                to={`/MyCourses/${account?.userid}`}
              >
                Khóa học của tôi
              </Link>
              <Link to={"/Cart"}>
                <ShoppingCartIcon
                  sx={{ fontSize: "35px" }}
                  className="hover:text-blue-500"
                />
              </Link>
            </>
          ) : account?.rolename === "INSTRUCTOR" ? (
            <Link
              className="font-semibold mr-10 hover:text-yellow-500"
              to={`/InstructorCourses/${account?.userid}`}
            >
              Khóa học đã tạo
            </Link>
          ) : account?.rolename === "STAFF" ? (
            <>
              <Link
                className="font-semibold mr-10 hover:text-yellow-500"
                to={"/FalseCourse"}
              >
                Duyệt khóa học
              </Link>
            </>
          ) : account?.rolename === "ADMIN" ? (
            <>
              <Link
                className="font-semibold mr-10 hover:text-yellow-500"
                to={"/AccountManager"}
              >
                Quản lý tài khoản
              </Link>
            </>
          ) : (
            <>
              <Link to={"/Cart"}>
                <ShoppingCartIcon
                  sx={{ fontSize: "35px" }}
                  className="hover:text-blue-500"
                />
              </Link>
            </>
          )}
        </div>
        <div className="flex items-center">
          {account ? (
            <>
              <div className="ml-5 hover:text-yellow-400 font-semibold py-2 px-5">
                <Link to={"/Profile"}>{account?.username}</Link>
              </div>
              <div
                onClick={logout}
                className="mx-5 border-2 border-yellow-400 text-yellow-500 hover:bg-yellow-400 hover:text-white font-semibold rounded-full py-2 px-10"
              >
                <div>Logout</div>
              </div>
            </>
          ) : (
            <>
              <Link
                to={"/SignIn"}
                className="ml-5 block hover:bg-black bg-white hover:text-white font-semibold rounded-full py-2 px-5"
              >
                Login
              </Link>

              <Link
                to={"/signUp"}
                className="mx-5 block border-2 border-yellow-400 text-yellow-500 hover:bg-yellow-400 hover:text-white font-semibold rounded-full py-2 px-10"
              >
                Đăng Ký Học
              </Link>
            </>
          )}
        </div>
      </div>
    </>
  );
};

export default HomeNavbar;
