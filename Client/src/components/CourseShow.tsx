import { Link, useNavigate } from "react-router-dom";
import { Course } from "../Type/Type";
import { API } from "../API/API";
import { useState } from "react";
import { Box, Modal } from "@mui/material";
import { modalCOurseStyle } from "../css/modalStyle";
import ReportPage from "../page/ReportPage";

export const MyCourseShow = ({ mcourse }: { mcourse: any }) => {
  const [open, setOpen] = useState(false);
  const [modalCourse, setModalCourse]: any = useState();
  const [course, setCourse]: any = useState(mcourse.course);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const navigate = useNavigate();
  return (
    <div className="w-3/12 mx-10 border-4 mb-5">
      <div
        onClick={() => navigate(`/Lessions/${course.courseId}`)}
        className="border-b-4 border-black"
      >
        <img
          className="w-4/5 h-40 m-auto mt-5 mb-10"
          src={course.courseImage}
        />
        <div className="flex justify-end">
          <div className="text-center text-xs bg-yellow-500 w-1/4">
            {course?.levelModel !== undefined
              ? course?.levelModel?.levelName
              : "CHƯA LỰA CHỌN CẤP ĐỘ"}
          </div>
        </div>
      </div>
      <div className="text-center text-3xl font-normal py-3">
        {course?.title}
      </div>

      <div className="text-center my-5">
        <Link
          to={`/Lessions/${course.courseId}`}
          className="p-2 bg-green-700 text-white mt-10 px-5"
        >
          Học
        </Link>
      </div>
      <div className="text-center my-5">
        <button>
          <button
            onClick={() => {
              setModalCourse(course);
              handleOpen();
            }}
            className="p-2 px-6 bg-green-700 text-white"
          >
            Feedback
          </button>
        </button>
      </div>

      <div>
        <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={modalCOurseStyle}>
            <ReportPage
              courseId={modalCourse?.courseId}
              handleClose={handleClose}
              order={mcourse.order}
            />
          </Box>
        </Modal>
      </div>
    </div>
  );
};

export const InstructorCourseShow = ({
  course,
  getMyCourses,
}: {
  course: Course | any;
  getMyCourses: any;
}) => {
  const navigate = useNavigate();
  return (
    <div className="w-3/12 mx-10 border-4 mb-5">
      <div
        onClick={() => navigate(`/Lessions/${course.courseId}`)}
        className="border-b-4 border-black"
      >
        <img className="w-4/5 m-auto mt-5 mb-10" src={course.courseImage} />
        <div className="flex justify-end">
          <div className="text-center text-xs bg-yellow-500 w-1/4">
            {course?.levelModel !== undefined
              ? course?.levelModel?.levelName
              : "CHƯA LỰA CHỌN CẤP ĐỘ"}
          </div>
        </div>
      </div>
      <div className="text-center text-3xl font-normal py-3 px-5 truncate">
        {course?.title}
      </div>

      <div className="text-center my-5">
        <Link
          to={`/EditCourse/${course.courseId}`}
          className="p-2 bg-green-700 text-white mt-10"
        >
          Chỉnh sửa khoá học
        </Link>
        <div>
          <button
            onClick={async () => {
              await API.deleteCourse(course.courseId);
              await getMyCourses();
            }}
            className="p-2 px-6 bg-green-700 text-white mt-10"
          >
            Xoá khoá học
          </button>
        </div>
      </div>
    </div>
  );
};

export const StaffCourseShow = ({
  course,
  getMyCourses,
}: {
  course: Course | any;
  getMyCourses: any;
}) => {
  const navigate = useNavigate();
  return (
    <div className="w-3/12 mx-10 border-4 mb-5">
      <div
        onClick={() => navigate(`/Lessions/${course.courseId}`)}
        className="border-b-4 border-black"
      >
        <img
          className="w-4/5 h-40 m-auto mt-5 mb-10"
          src={course.courseImage}
        />
        <div className="flex justify-end">
          <div className="text-center text-xs bg-yellow-500 w-1/4">
            {course?.levelModel !== undefined
              ? course?.levelModel?.levelName
              : "CHƯA LỰA CHỌN CẤP ĐỘ"}
          </div>
        </div>
      </div>
      <div className="text-center text-3xl font-normal py-3 px-5 truncate">
        {course?.title}
      </div>

      <div className="text-center my-5">
        <div>
          <button
            onClick={async () => {
              await API.setTrueCourse(course.courseId);
              await getMyCourses();
            }}
            className="p-2 px-6 bg-green-700 text-white mt-10"
          >
            Phê Duyệt
          </button>
        </div>
      </div>
    </div>
  );
};

export const StaffCourseShowTrue = ({
  course,
  getMyTrueCourses,
}: {
  course: Course | any;
  getMyTrueCourses: any;
}) => {
  const navigate = useNavigate();
  return (
    <div className="w-3/12 mx-10 border-4 mb-5">
      <div
        onClick={() => navigate(`/Lessions/${course.courseId}`)}
        className="border-b-4 border-black"
      >
        <img
          className="w-4/5 h-40 m-auto mt-5 mb-10"
          src={course.courseImage}
        />
        <div className="flex justify-end">
          <div className="text-center text-xs bg-yellow-500 w-1/4">
            {course?.levelModel !== undefined
              ? course?.levelModel?.levelName
              : "CHƯA LỰA CHỌN CẤP ĐỘ"}
          </div>
        </div>
      </div>
      <div className="text-center text-3xl font-normal py-3 px-5 truncate">
        {course?.title}
      </div>

      <div className="text-center my-5">
        <div>
          <button
            onClick={async () => {
              await API.toggleCourse(course.courseId);
              await getMyTrueCourses();
            }}
            className="p-2 px-6 bg-green-700 text-white mt-10"
          >
            Thu hồi
          </button>
        </div>
      </div>
    </div>
  );
};

export const CourseShow = ({ course }: { course: Course | any }) => {
  return (
    <div>
      <div className="border-b-4 border-black">
        <img className="w-4/5 m-auto mt-5 mb-10" src={course.courseImage} />
        <div className="flex justify-end">
          <div className="text-center text-xs bg-yellow-500 w-1/4">
            {course?.levelModel !== undefined
              ? course?.levelModel?.levelName
              : "CHƯA LỰA CHỌN CẤP ĐỘ"}
          </div>
        </div>
      </div>
      <div className="text-center text-3xl font-normal py-3">
        {course?.title}
      </div>
    </div>
  );
};
