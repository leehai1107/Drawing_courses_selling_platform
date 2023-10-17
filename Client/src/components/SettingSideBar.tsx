import { useState } from "react";
import EditIcon from "@mui/icons-material/Edit";
import ShoppingBagIcon from "@mui/icons-material/ShoppingBag";
import RemoveRedEyeIcon from "@mui/icons-material/RemoveRedEye";
import LockIcon from "@mui/icons-material/Lock";
import HelpOutlineIcon from "@mui/icons-material/HelpOutline";
import ReportGmailerrorredIcon from "@mui/icons-material/ReportGmailerrorred";
import EditProfile from "../page/EditProfile";
import ChangePassword from "../page/ChangePassword";
import SideBar from "./SideBar";


const options = [
  {
    label: "Edit Profile",
    Icon: EditIcon,
    Link: "/Profile",
  },
  {
    label: "Order History",
    Icon: ShoppingBagIcon,
    Link: "/Profile",
  },
  {
    label: "View Profile",
    Icon: RemoveRedEyeIcon,
    Link: "/Profile",
  },
  {
    label: "Change Password",
    Icon: LockIcon,
    Link: "/Profile/ChangePassword",
  },
  {
    label: "Help",
    Icon: HelpOutlineIcon,
    Link: "/Profile",
  },
  {
    label: "Report",
    Icon: ReportGmailerrorredIcon,
    Link: "/Profile/Report",
  },
];

const SettingSideBar = () => {
  const [selectedOption, setSelectedOption] = useState("Edit Profile");

  const prop = () => {
    switch (selectedOption) {
      case "Edit Profile":
        return <EditProfile />;
      case "Change Password":
        return <ChangePassword />;     
      default:
        return <EditProfile />;
    }
  };

  return (
    <>
      <SideBar>
        <div className="flex h-full">
          <div className="w-3/12 pt-36 px-5 flex flex-col items-center h-full border-r">
            <div className="text-2xl font-bold mb-10"> Settings</div>
            <div className="flex flex-col justify-between font-medium text-neutral-600">
              {options.map((option) => (
                <>
                  {option.label !== selectedOption ? (
                    <div
                      onClick={() => setSelectedOption(option.label)}
                      className="hover:bg-neutral-300 p-3 rounded-full"
                    >
                      <option.Icon /> {option.label}
                    </div>
                  ) : (
                    <div
                      onClick={() => setSelectedOption(option.label)}
                      className="bg-neutral-300 p-3 rounded-full"
                    >
                      <option.Icon /> {option.label}
                    </div>
                  )}
                </>
              ))}
            </div>
          </div>
          <div className="w-9/12">{prop()}</div>
        </div>
      </SideBar>
    </>
  );
};

export default SettingSideBar;
