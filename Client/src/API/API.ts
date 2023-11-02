import axios from "axios";
import { toast } from "react-toastify";

const getAllCourse = async () => {
  const res = await axios.get(`http://localhost:8088/public/course/view`);
  console.log(res);
  return res?.data;
};

const getAllPost = async () => {
  const res = await axios.get(`http://localhost:8088/public/post/viewallpost`);
  console.log(res);
  return res?.data;
};

const getPostById = async (id: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/post/find-Post-By-id/${id}`
  );
  console.log(res);
  if (res?.data instanceof Array) {
    return res?.data[0];
  }
  return res?.data;
};

const getTop4Course = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/course/find-Top4-Best-Seller-Course`
  );
  return res?.data;
};

const payment = async (data: any) => {
  const res = await axios.post(
    `http://localhost:8088/public/orders/payment`,
    data
  );
  return res?.data;
};

const getCourseByUser = async (userid: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/find-Course-Has-Order/${userid}`
  );
  console.log(res);
  return res?.data;
};

const getCourseByInstructor = async (userid: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/find-by-InstructorId/${userid}`
  );
  console.log(res);
  return res?.data;
};

const getLessionByCourse = async (courseid: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/lesson/find-by-course-id/${courseid}`
  );
  console.log(res);
  return res?.data;
};

const editUser = async (data: any) => {
  const res = await axios.put(`http://localhost:8088/public/user/edit`, data);
  console.log(res);
  return res?.data;
};

const getUserInfo = async (userid: number) => {
  const res = await axios.get(
    `http://localhost:8088/public/user/infor/${userid}`
  );
  console.log(res);
  return res?.data;
};

const getOrderHistory = async (userid: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/user/orders/${userid}`
  );
  console.log(res);
  return res?.data;
};

const getCourseCategories = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/courseCategory/ViewAllDrawingCategories`
  );
  console.log(res);
  return res?.data;
};

const getCourseLevel = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/level/ViewAllLevels`
  );
  console.log(res);
  return res?.data;
};

const getCourseByCategory = async (categoryId: number) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/find?category=${categoryId}`
  );
  console.log(res);
  return res?.data;
};

const changePassword = async (data: any) => {
  const res = await axios.put(
    `http://localhost:8088/public/account/change-password`,
    data
  );
  console.log(res);
  return res?.data;
};

const addCourse = async (data: any) => {
  const res:any = await axios
    .post(`http://localhost:8088/public/course/addCourse`, data)
    .catch((err) => console.log(err));
  console.log(res);
  return res?.data;
};

const addLession = async (data: any) => {
  const res = await axios.post(`http://localhost:8088/public/lesson/add`, data);
  console.log(res);
  return res?.data;
};

export const API = {
  getAllCourse,
  getAllPost,
  getPostById,
  getTop4Course,
  payment,
  getCourseByUser,
  getLessionByCourse,
  editUser,
  getUserInfo,
  getOrderHistory,
  getCourseCategories,
  getCourseByCategory,
  changePassword,
  getCourseByInstructor,
  getCourseLevel,
  addCourse,
  addLession,
};
