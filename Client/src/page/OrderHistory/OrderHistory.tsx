import { useEffect, useState } from "react";
import { API } from "../../API/API";
import { useRecoilValue } from "recoil";
import { accountState } from "../../atom/atom";

const OrderHistory = () => {
  const account: any = useRecoilValue(accountState);
  const [orderHistory, setHistory]: any = useState([]);
  useEffect(() => {
    const callBack = async () => {
      const oh = await API.getOrderHistory(account?.userid);
      setHistory(oh);
    };
    callBack();
  }, []);
  return (
    <>
      <div className="pt-32 pl-20 border-l h-screen">
        <div className=" w-full font-bold text-3xl">
          <div>Order History</div>
        </div>

        <div className="mt-12">
          <table className="table-auto">
            <thead>
              <tr>
                <th className="px-4 py-2 text-neutral-600">Order Id</th>
                <th className="px-4 py-2 text-neutral-600">Order Code</th>
                <th className="px-4 py-2 text-neutral-600">Order Date</th>
                <th className="px-4 py-2 text-neutral-600">Total</th>
                <th className="px-4 py-2 text-neutral-600">Status</th>
              </tr>
            </thead>
            <tbody>
              {orderHistory?.map((oh: any) => (
                <tr>
                  <td className=" px-4 py-2 text-neutral-600 font-medium">
                    {oh.order_id}
                  </td>
                  <td className=" px-4 py-2 text-neutral-600 font-medium">
                    {oh.order_code}
                  </td>
                  <td className=" px-4 py-2 text-neutral-600 font-medium">
                    {oh.order_date}
                  </td>
                  <td className="px-4 py-2 text-neutral-600 font-medium">
                    {oh.price}
                  </td>
                  <td className="px-4 py-2 text-neutral-600 font-medium">
                    {oh.status}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default OrderHistory;
