import { ReactNode } from "react";
import SettingsIcon from "@mui/icons-material/Settings";
import HomeIcon from "@mui/icons-material/Home";
import NotificationsIcon from "@mui/icons-material/Notifications";
import CalendarTodayIcon from "@mui/icons-material/CalendarToday";
import ShowChartIcon from "@mui/icons-material/ShowChart";
import PersonIcon from "@mui/icons-material/Person";

const SideBar = ({ children }: { children: ReactNode }) => {
  return (
    <>
      <div className="flex">
        <div className="w-20 pt-32 bg-green-300 text-orange-500 flex flex-col items-center">
          <img
            src="https://st3.depositphotos.com/9998432/13335/v/450/depositphotos_133352156-stock-illustration-default-placeholder-profile-icon.jpg"
            className="rounded-full mb-5 w-1/2"
          />
          <div className="flex flex-col justify-between mb-20 h-60">
            <HomeIcon className="hover:text-white"/>
            <NotificationsIcon className="hover:text-white"/>
            <CalendarTodayIcon className="hover:text-white"/>
            <ShowChartIcon className="hover:text-white"/>
            <PersonIcon className="hover:text-white"/>
          </div>
          <SettingsIcon className="text-neutral-500 mb-10" sx={{fontSize: 40}}/>
        </div>
        <div className="w-11/12">{children}</div>
      </div>
    </>
  );
};

export default SideBar;
