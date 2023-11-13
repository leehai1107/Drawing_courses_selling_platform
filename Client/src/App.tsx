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
import AdminLayout from "./layout/AminLayout";
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
import { HomeCourses } from "./page/HomeCourses";
import { SuccessPayment } from "./page/SuccessPayment";
import { MyCourses } from "./page/myCourses/MyCourses";
import { myCourseLoader } from "./page/myCourses/MyCourseLoader";
import { Lessions } from "./page/lessions/Lessions";
import { lessionLoader } from "./page/lessions/LessionsLoader";
import { CourseCategories } from "./page/CourseCategory/CourseCategories";
import { courseCategoriesLoader } from "./page/CourseCategory/courseCategoriesLoader";
import { Courses } from "./page/Course/Courses";
import { coursesLoader } from "./page/Course/coursesLoader";
import { InstructorCourses } from "./page/InstructorCourses/InstructorCourses";
import { instructorCourseLoader } from "./page/InstructorCourses/instructorCoursesLoader";
import { CreateCourse } from "./page/CreateCourse/CreateCourse";
import { CreateLession } from "./page/CreateLession/CreateLession";
import { createCourseLoader } from "./page/CreateCourse/createCourseLoader";
import { EditCourse } from "./page/EditCourse/EditCourse";
import { EditLession } from "./page/EditLession/EditLession";
import { editCourseLoader } from "./page/EditCourse/editCourseLoader";
import { InstructorProfile } from "./page/InstructorProfile/InstructorProfile";
import { instructorLoader } from "./page/InstructorProfile/InstructorLoader";
import { FalseCourse } from "./page/FalseCourse/FalseCourse";
import { TrueCourse } from "./page/FalseCourse/TrueCourse";
import { AccountTable, InsTable, StaffsTable } from "./page/AccountManagerTable";
import { FeedbackTable } from "./page/FeedbackTable";

function App() {

  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route>
        <Route path="/" element={<AdminLayout />}>
          <Route path="admin" element={<AccountTable />} />
          <Route path="admin/users" element={<AccountTable />} />
          <Route path="admin/instructors" element={<InsTable />} />
          <Route path="admin/staffs" element={<StaffsTable />} />
          <Route path="admin/feedback" element={<FeedbackTable />} />
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
          <Route path="Courses" element={<HomeCourses />} loader={homeLoader}/>
          <Route path="SuccessPayment" element={<SuccessPayment />}/>
          <Route path="info-student" element={<SuccessPayment />}/>
          <Route path="MyCourses/:userid" element={<MyCourses />} loader={myCourseLoader}/>
          <Route path="InstructorCourses/:userid" element={<InstructorCourses />} loader={instructorCourseLoader}/>
          <Route path="Lessions/:courseid" element={<Lessions />} loader={lessionLoader}/>
          <Route path="CourseCategories" element={<CourseCategories />} loader={courseCategoriesLoader}/>
          <Route path="Courses/:category/:categoryId" element={<Courses />} loader={coursesLoader}/>
          <Route path="createCourse" element={<CreateCourse />} loader={createCourseLoader}/>
          <Route path="CreateLession/:courseId" element={<CreateLession />}/>
          <Route path="EditCourse/:courseId" element={<EditCourse />} loader={editCourseLoader}/>
          <Route path="EditLession/:courseId" element={<EditLession />}/>
          <Route path="InstructorProfile/:userId" element={<InstructorProfile />} loader={instructorLoader}/>
          <Route path="FalseCourse" element={<FalseCourse />} />
          <Route path="TrueCourse" element={<TrueCourse />} />
        </Route>
      </Route>
    ),
    { basename: "" }
  );

  return (
    <>
        <RouterProvider router={router} fallbackElement={<p>Loading</p>} />
        <ToastContainer />
    </>
  );
}

export default App;
