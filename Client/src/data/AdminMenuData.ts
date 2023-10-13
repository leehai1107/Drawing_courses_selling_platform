import DashboardIcon from '@mui/icons-material/Dashboard';
import EventIcon from '@mui/icons-material/Event';
import PersonIcon from '@mui/icons-material/Person';
import SchoolIcon from '@mui/icons-material/School';
import TvIcon from '@mui/icons-material/Tv';
import HourglassEmptyIcon from '@mui/icons-material/HourglassEmpty';
import MailOutlineIcon from '@mui/icons-material/MailOutline';
import SettingsIcon from '@mui/icons-material/Settings';
import LogoutIcon from '@mui/icons-material/Logout';

const AdminMenuData = [
    {
        icon: DashboardIcon,
        label: "DashBoard",
        link:"/dashboard"
    },
    {
        icon: EventIcon,
        label: "Calendar",
        link:"/calendar"
    },
    {
        icon: PersonIcon,
        label: "Student",
        link:"/student"
    },
    {
        icon: SchoolIcon,
        label: "Supervisor",
        link:"/supervisor"
    },
    {
        icon: TvIcon,
        label: "News",
        link:"/news"
    },
    {
        icon: HourglassEmptyIcon,
        label: "Timesheet",
        link:"/timesheet"
    },
    {
        icon: MailOutlineIcon,
        label: "Mail",
        link:"/mail"
    },
    {
        icon: SettingsIcon,
        label: "Setting",
        link:"/setting"
    },
    {
        icon: LogoutIcon,
        label: "Logout",
        link:"/"
    },
    
]

export default AdminMenuData