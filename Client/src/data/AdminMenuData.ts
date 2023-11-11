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
        link:"/admin"
    },
    {
        icon: EventIcon,
        label: "Calendar",
        link:"/admin"
    },
    {
        icon: PersonIcon,
        label: "Users",
        link:"/admin/users"
    },
    {
        icon: SchoolIcon,
        label: "Instructors",
        link:"/admin/instructors"
    },
    {
        icon: TvIcon,
        label: "Staffs",
        link:"/admin/staffs"
    },
    // {
    //     icon: HourglassEmptyIcon,
    //     label: "Timesheet",
    //     link:"/admin"
    // },
    // {
    //     icon: MailOutlineIcon,
    //     label: "Feedback",
    //     link:"/admin/feedback"
    // },
    // {
    //     icon: SettingsIcon,
    //     label: "Setting",
    //     link:"/admin"
    // },
    {
        icon: LogoutIcon,
        label: "Logout",
        link:"/SignIn"
    },
    
]

export default AdminMenuData