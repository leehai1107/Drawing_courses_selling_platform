import { Form, Link } from "react-router-dom";
import CreditCardIcon from "@mui/icons-material/CreditCard";
import CartData from "../data/CartData";
import { numberToVietnameseDong } from "../util/util";

const Payment = () => {
  return (
    <>
      <div className="bg-lime-300 pt-40 font-medium">
        <div className="text-center text-5xl mb-14">
          Thanh Toán{" "}
          <CreditCardIcon sx={{ fontSize: "70px" }} className="opacity-70" />
        </div>
        <div className="m-auto w-2/5 mb-20">
          <Form method="post">
            <div className="mb-14">
              <label className="mb-2 text-sm opacity-70 block">User name</label>
              <input
                name="username"
                className="w-full p-2 rounded-lg"
                placeholder="Type here"
              />
            </div>

            <div className="mb-14">
              <label className="mb-2 text-sm opacity-70 block">Email</label>
              <input
                name="email"
                className="w-full p-2 rounded-lg"
                placeholder="Type here"
              />
            </div>

            <div className="mb-14">
              <label className="mb-2 text-sm opacity-70 block">
                Phone number
              </label>
              <input
                name="phone"
                className="w-full p-2 rounded-lg"
                placeholder="Type here"
              />
            </div>

            <div className="mb-14 flex">
              <div className="w-1/2">
                <label className="mb-2 text-sm opacity-70 block">
                  Phương Thức Thanh Toán
                </label>
                <select name="payMethod" className="w-11/12 p-2 rounded-lg">
                  <option>Momo</option>
                  <option>VNPay</option>
                  <option>TPBank</option>
                  <option>Visa</option>
                </select>
              </div>
              <div className="w-1/2">
                <label className="mb-2 text-sm opacity-70 block">
                  Tổng tiền
                </label>
                <input
                  name="ammount"
                  className="w-full p-2 rounded-lg"
                  readOnly
                  value={numberToVietnameseDong(CartData.reduce((accumulator, currentObject) => {
                    return accumulator + currentObject.UnitPrice;
                  }, 0))}
                />
              </div>
            </div>
          </Form>
        </div>
        <div className="text-center">
          <Link to={"/"}>
            <button className="text-white bg-orange-500 py-2 px-6 mb-20">
              Thanh toán
            </button>
          </Link>
        </div>
      </div>
    </>
  );
};

export default Payment;
