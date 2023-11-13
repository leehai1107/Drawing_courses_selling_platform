import {Outlet, useLocation} from "react-router-dom"
import HomeNavbar from "../components/HomeNavbar"
import Footer from "../components/Footer"
import { useEffect } from "react";

const PageLayout = () => {
    const { pathname } = useLocation();

  useEffect(() => {
    window.scrollTo(0, 0);
  }, [pathname]);

    return <>
    <HomeNavbar />
    <Outlet />
    <Footer />
    </>
}

export default PageLayout