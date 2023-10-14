import AdminMenuData from "../data/AdminMenuData"
import { NavLink } from "react-router-dom"

const AdminMenu = () => {
    return <>
    <div className="flex flex-col">
        {AdminMenuData.map(data => <>
        <div className="flex items-center mb-5">
            <data.icon className="mr-5"/>
            <NavLink to={data.link}>{data.label}</NavLink>
        </div>
        </>)}
    </div>
    </>
}

export default AdminMenu