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
