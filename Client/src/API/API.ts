import axios from "axios";

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
  const res = await axios.get(`http://localhost:8088/public/post/find-Post-By-id/${id}`);
  console.log(res);
  if(res?.data instanceof Array){
    return res?.data[0];
  }
  return res?.data;
};

const getTop4Course = async() => {
  const res = await axios.get(`http://localhost:8088/public/course/find-Top4-Best-Seller-Course`)
  return res?.data
}

const payment = async (data:any) => {
  const res = await axios.post(`http://localhost:8088/public/orders/payment`, data)
  return res?.data
}

export const API = { getAllCourse, getAllPost, getPostById, getTop4Course, payment };
