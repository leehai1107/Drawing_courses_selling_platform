import {
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
  Route,
} from "react-router-dom";
import "./App.css";
import 'react-slideshow-image/dist/styles.css'
import AdminLayout from "./layout/AminLayout";
import Error from "./page/Error";
import Admin from "./page/Admin";
import PageLayout from "./layout/PageLayout";
import Home from "./page/Home";
import LandingPage from "./page/LandingPage";
import Cart from "./page/Cart";
import Payment from "./page/Payment";
import Login from "./page/Login";
import SettingSideBar from "./components/SettingSideBar";
import ForgetPass from "./page/ForgetPass";
import Register from "./page/Register";
import BlogsPage from "./page/BlogsPage";
import BlogDetail from "./page/BlogDetail";

function App() {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route errorElement={<Error />}>
        <Route path="/" element={<AdminLayout />}>
           <Route path="admin" element={<Admin />}></Route>
        </Route>
        <Route path="/" element={<PageLayout />}>
            <Route index element={<Home />}/>
            <Route path="LandingPage" element={<LandingPage />}/>
            <Route path="Cart" element={<Cart />}/>
            <Route path="Payment" element={<Payment />}/>
            <Route path="SignIn" element={<Login />}/>
            <Route path="forgotpass" element={<ForgetPass />}/>
            <Route path="Profile" element={<SettingSideBar />}/>
            <Route path="signUp" element={<Register />}/>
            <Route path="Blogs" element={<BlogsPage />}/>
            <Route path="BlogDetail/:index" element={<BlogDetail />}/>
        </Route>
      </Route>
    ),
    { basename: "" }
  );

  return (
    <>
      <RouterProvider router={router} fallbackElement={<p>Loading</p>} />
    </>
  );
}

export default App;
