import { Link } from "react-router-dom";

export const SuccessPayment = () => {
  return (
    <>
      <div className="bg-lime-300 py-40 font-medium">
        <div className="m-auto w-2/5 my-20 bg-white">
          <div className="text-xl font-bold pt-20 text-center">Thanh Toán Thành Công</div>
          <div className="text-center mt-20 pb-20">
            <Link to={"/"} className="text-white bg-orange-500 py-2 px-6 mb-20">
              HomePage
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};
