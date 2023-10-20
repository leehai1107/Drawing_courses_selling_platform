import { Link } from "react-router-dom";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import { useRecoilState } from "recoil";
import { accountState } from "../atom/atom";
import MenuLogo from "../assets/MenuLogo.jpg";
import MenuData from "../data/MenuData";
import { authAPI } from "../API/authAPI";

const HomeNavbar = () => {
  const [account, setAccount]: any = useRecoilState(accountState);

  const logout = async () => {
    await authAPI.logoutApi(account.refreshToken)
    setAccount(undefined)
  }

  return (
    <>
      <div className="flex items-center px-20 justify-between fixed bg-white bg-opacity-90">
        <div className="w-1/12">
          <Link to={"/"}>
            <img src={MenuLogo} alt="Logo" />
          </Link>
        </div>
        <div className="flex justify-between">
          {MenuData.map((data) => (
            <>
              <Link
                className="font-semibold mr-10 hover:text-yellow-500"
                to={data.link}
              >
                {data.label}
              </Link>
            </>
          ))}
        </div>
        <div className="flex items-center">
          {account?.role === "CUSTOMER" ? (
            <>
              <Link to={"/Cart"}>
                <ShoppingCartIcon
                  sx={{ fontSize: "35px" }}
                  className="hover:text-blue-500"
                />
              </Link>
              <div className="ml-5 hover:text-yellow-400 font-semibold py-2 px-5">
                <Link to={"/"}>{account?.userName}</Link>
              </div>
              <div className="mx-5 border-2 border-yellow-400 text-yellow-500 hover:bg-yellow-400 hover:text-white font-semibold rounded-full py-2 px-10">
                <div onClick={logout}>Logout</div>
              </div>
            </>
          ) : (
            <>
              <div className="ml-5  hover:bg-black bg-white hover:text-white font-semibold rounded-full py-2 px-5">
                <Link to={"/SignIn"}>Login</Link>
              </div>

              <div className="mx-5 border-2 border-yellow-400 text-yellow-500 hover:bg-yellow-400 hover:text-white font-semibold rounded-full py-2 px-10">
                <Link to={"/LandingPage"}>Đăng Ký Học</Link>
              </div>
            </>
          )}
        </div>
      </div>
    </>
  );
};

export default HomeNavbar;
