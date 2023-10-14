import NotificationsActiveIcon from "@mui/icons-material/NotificationsActive";
import SearchIcon from "@mui/icons-material/Search";
import { BlackSwitch } from "./Switch";
import adminJpg from "../assets/admin.jpg";

const Navbar = () => {
  return (
    <>
      <div className="flex justify-between items-center py-4 px-7">
        <div className="flex items-center w-10/12">
          <div className="w-1/12 flex items-center">
            <img src={adminJpg} className="rounded-full w-11" />
            <div className="font-medium text-lg mx-2">Admin</div>
          </div>
          <div className="w-11/12 mx-24 flex items-center">
            <SearchIcon className="text-blue-600 absolute left-56" />
            <input className="rounded-3xl p-2 px-12 mr-2 w-full" placeholder="Quick Search" />
          </div>
        </div>
        <div className="flex items-center w-2/12 justify-end">
          <BlackSwitch defaultChecked />
          <NotificationsActiveIcon className="text-blue-600 ml-20" />
        </div>
      </div>
    </>
  );
};

export default Navbar;
