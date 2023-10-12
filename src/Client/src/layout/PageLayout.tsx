import {Outlet} from "react-router-dom"
import HomeNavbar from "../components/HomeNavbar"
import Footer from "../components/Footer"

const PageLayout = () => {
    return <>
    <HomeNavbar />
    <Outlet />
    <Footer />
    </>
}

export default PageLayout