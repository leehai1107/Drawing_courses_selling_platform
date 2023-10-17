import { Link } from "react-router-dom";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import MenuLogo from "../assets/MenuLogo.jpg";
import MenuData from "../data/MenuData";

const HomeNavbar = () => {
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
          <Link to={"/Cart"}>
            <ShoppingCartIcon
              sx={{ fontSize: "35px" }}
              className="hover:text-blue-500"
            />
          </Link>

          <div className="ml-5  hover:bg-black bg-white hover:text-white font-semibold rounded-full py-2 px-5">
            <Link to={"/SignIn"}>Login</Link>
          </div>

          <div className="mx-5 border-2 border-yellow-400 text-yellow-500 hover:bg-yellow-400 hover:text-white font-semibold rounded-full py-2 px-10">
            <Link to={"/LandingPage"}>Đăng Ký Học</Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default HomeNavbar;
