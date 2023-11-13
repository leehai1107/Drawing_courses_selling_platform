import { useLoaderData } from "react-router-dom";

export const InstructorProfile = () => {
  const instructor: any = useLoaderData();

  return (
    <>
      <div className="h-screen pt-20 mb-40">
        <div className="h-1/2 pt-14 bg-green-300">
          <img className="rounded-full m-auto w-1/12" src={instructor.avatar} />
          <div className="absolute rounded-xl border bg-white left-96 right-96 mt-5 px-20 py-10 grid grid-cols-2 grid-rows-5">
          <div className="text-center text-xl font-bold mb-10 col-span-2">{instructor.fullname}</div>
          <div className="mb-5">Email: </div><div>{instructor.email}</div>
          <div className="mb-5">Số điện thoại: </div><div>{instructor.phone}</div>
          <div className="mb-5">Ngày tháng năm sinh: </div><div>{instructor.dob}</div>
          <div className="mb-5">Mô tả: </div><div>{instructor.description}</div>
          </div>
        </div>
        <div className="h-1/2"></div>
      </div>
    </>
  );
};
