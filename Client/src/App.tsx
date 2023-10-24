import {
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
  Route,
} from "react-router-dom";
import "./App.css";
import "react-slideshow-image/dist/styles.css";
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
import { RecoilRoot } from "recoil";
import AdminLayout from "./layout/AminLayout";
import Error from "./page/Error";
import Admin from "./page/Admin";
import PageLayout from "./layout/PageLayout";
import Home from "./page/Home/Home";
import LandingPage from "./page/LandingPage";
import Cart from "./page/Cart";
import Payment from "./page/payment/Payment";
import Login from "./page/auth/LoginPage/Login";
import SettingSideBar from "./components/SettingSideBar";
import ForgetPass from "./page/ForgetPass";
import Register from "./page/auth/Register/Register";
import BlogsPage from "./page/Blogs/BlogsPage";
import BlogDetail from "./page/Blogs/BlogDetail/BlogDetail";
import { loginAction } from "./page/auth/LoginPage/loginAction";
import { registerAction } from "./page/auth/Register/registerAction";
import { blogLoader } from "./page/Blogs/BlogLoader";
import { homeLoader } from "./page/Home/HomeLoader";
import { blogDetailLoader } from "./page/Blogs/BlogDetail/BlogDetailLoader";
import { Courses } from "./page/Courses";
import { SuccessPayment } from "./page/SuccessPayment";

function App() {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route errorElement={<Error />}>
        <Route path="/" element={<AdminLayout />}>
          <Route path="admin" element={<Admin />}></Route>
        </Route>
        <Route path="/" element={<PageLayout />}>
          <Route index element={<Home />} loader={homeLoader}/>
          <Route path="LandingPage" element={<LandingPage />} />
          <Route path="Cart" element={<Cart />} />
          <Route path="Payment" element={<Payment />} />
          <Route path="SignIn" element={<Login />} action={loginAction} />
          <Route path="forgotpass" element={<ForgetPass />} />
          <Route path="Profile" element={<SettingSideBar />} />
          <Route path="signUp" element={<Register />} action={registerAction} />
          <Route path="Blogs" element={<BlogsPage />} loader={blogLoader}/>
          <Route path="BlogDetail/:id" element={<BlogDetail />} loader={blogDetailLoader}/>
          <Route path="Courses" element={<Courses />} loader={homeLoader}/>SuccessPayment
          <Route path="SuccessPayment" element={<SuccessPayment />}/>
          <Route path="info-student" element={<SuccessPayment />}/>
        </Route>
      </Route>
    ),
    { basename: "" }
  );

  return (
    <>
      <RecoilRoot>
        <RouterProvider router={router} fallbackElement={<p>Loading</p>} />
        <ToastContainer />
      </RecoilRoot>
    </>
  );
}

export default App;
