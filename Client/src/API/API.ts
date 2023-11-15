import axios from "axios";
import { toast } from "react-toastify";

const getAllCourse = async () => {
  const res = await axios.get(`http://localhost:8088/public/course/view`);
  console.log(res);
  return res?.data;
};

const getAllTrueCourse = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/course/coursestatustrue`
  );

  return res?.data;
};

const getAllFalseCourse = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/course/coursenotverify`
  );

  return res?.data;
};

const getCourseById = async (id: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/getcourse/${id}`
  );
  return res?.data;
};

const getAllPost = async () => {
  const res = await axios.get(`http://localhost:8088/public/post/viewallpost`);
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

const getCourseByInstructorFalse = async (userid: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/find-by-InstructorIdFalse/${userid}`
  );
  console.log(res);
  return res?.data;
};

const getCourseByInstructorTrue = async (userid: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/find-by-InstructorIdTrue/${userid}`
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

const getAllCusInfo = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/user/find-All-Customer`
  );
  console.log(res);
  return res?.data;
};

const getAllStaffInfo = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/user/find-All-Staff`
  );
  console.log(res);
  return res?.data;
};

const getAllInsInfo = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/user/find-All-Instructor`
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

const getTrueCourseByCategory = async (categoryId: number) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/course-status-1/by-cateid/${categoryId}`
  );
  console.log(res);
  return res?.data;
};

const getTrueCourseByLevel = async (levelid: number) => {
  const res = await axios.get(
    `http://localhost:8088/public/course/course-status-1/by-levelid/${levelid}`
  );
  console.log(res);
  return res?.data;
};

const changePassword = async (data: any) => {
  const res = await axios.post(
    `http://localhost:8088/public/account/change-password`,
    data
  );
  console.log(res);
  return res?.data;
};

const addCourse = async (data: any) => {
  const res: any = await axios
    .post(`http://localhost:8088/public/course/addCourse`, data)
    .catch((err) => console.log(err));
  console.log(res);
  return res?.data;
};

const editCourse = async (id: string, data: any) => {
  const res: any = await axios
    .put(`http://localhost:8088/public/course/edit/${id}`, data)
    .catch((err) => console.log(err));
  console.log(res);
  return res?.data;
};

const deleteCourse = async (id: string) => {
  const res: any = await axios
    .delete(`http://localhost:8088/public/course/delete/${id}`)
    .catch((err) => {
      console.log(err);
      toast("Không thể xoá vì khoá học đã có người mua!", {
        type: toast.TYPE.ERROR,
      });
    });
  console.log(res);
  return res?.data;
};

const setTrueCourse = async (id: string) => {
  const res: any = await axios
    .put(`http://localhost:8088/public/course/update-status/${id}`)
    .catch((err) => {
      console.log(err);
      toast("Không thành công", { type: toast.TYPE.ERROR });
    });
    toast("Đã duyệt khoá học", {
      type: toast.TYPE.SUCCESS,
    });
  return res?.data;
};

const getLessionByCourseId = async (id: string) => {
  const res = await axios.get(
    `http://localhost:8088/public/lesson/find-by-course-id/${id}`
  );
  console.log(res);
  return res?.data;
};

const editLessionByCourseId = async (data: any) => {
  const res = await axios.put(`http://localhost:8088/public/lesson/edit`, data);
  console.log(res);
  return res?.data;
};

const addLession = async (data: any) => {
  const res = await axios.post(`http://localhost:8088/public/lesson/add`, data);
  console.log(res);
  return res?.data;
};

const addFeedback = async (data: any) => {
  const res = await axios.post(`http://localhost:8088/public/review/add`, data);
  return res?.data;
};

const addStaff = async (data: any, token: any) => {
  // axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;

  const res: any = await axios
    .post(`http://localhost:8088/public/account/add-staff`, data)
    .catch((err) => {
      console.log(err);
      toast(err.message, { type: toast.TYPE.ERROR })
    });
    toast("Đã thêm nhân viên", {
      type: toast.TYPE.SUCCESS,
    });
  return res?.data;
};

const addIns = async (data: any, token: any) => {
  // axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;

  const res: any = await axios
    .post(`http://localhost:8088/public/account/add-instructor`, data)
    .catch((err) => {
      console.log(err);
      toast(err.message, { type: toast.TYPE.ERROR })
    });
    toast("Đã thêm giáo viên", {
      type: toast.TYPE.SUCCESS,
    });
  return res?.data;
};

const banAccount = async (userid: number) => {
  const res = await axios.put(
    `http://localhost:8088/public/user/toggle-status/${userid}`
  );
  toast("Đã thay đổi", {
    type: toast.TYPE.SUCCESS,
  });
  return res?.data;
};

const getAllFeedBack = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/review/find-All-FeedBacks`
  );
  console.log(res);
  return res?.data;
};

const toggleCourse = async (id: string) => {
  const res = await axios.put(
    `http://localhost:8088/public/course/${id}/toggle-status`
  );
  toast("Đã thu hồi khoá học", {
    type: toast.TYPE.SUCCESS,
  });
  return res?.data;
};

const beginerCourse = async () => {
  const res = await axios.get(
    `http://localhost:8088/public/course/course-status-1/by-levelid/1`
  );
  console.log(res);
  return res?.data;
};



export const API = {
  getAllCourse,
  getAllPost,
  getPostById,
  getTop4Course,
  getCourseById,
  getLessionByCourseId,
  getUserInfo,
  getOrderHistory,
  getCourseCategories,
  getCourseByCategory,
  getCourseByInstructor,
  getCourseLevel,
  getCourseByUser,
  getLessionByCourse,
  getTrueCourseByCategory,
  getAllTrueCourse,
  getAllFalseCourse,
  getAllCusInfo,
  getAllStaffInfo,
  getAllInsInfo,
  getAllFeedBack,
  getCourseByInstructorFalse,
  addCourse,
  addLession,
  addFeedback,
  addStaff,
  addIns,
  getCourseByInstructorTrue,
  editUser,
  editCourse,
  editLessionByCourseId,
  setTrueCourse,
  beginerCourse,
  deleteCourse,
  toggleCourse,
  payment,
  changePassword,
  banAccount,
  getTrueCourseByLevel,
};
