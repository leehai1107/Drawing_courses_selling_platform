const OrderHistory = () => {
  return (
    <>
      <div className="pt-32 pl-20 ">
        <div className=" w-full font-bold text-3xl">
          <div>Edit profile</div>
        </div>

        <div className="mt-12">
          <table className="table-auto">
            <thead>
              <tr>
                <th className="px-4 py-2 text-neutral-600">Course Name</th>
                <th className="px-4 py-2 text-neutral-600">Level</th>
                <th className="px-4 py-2 text-neutral-600">Teacher</th>
                <th className="px-4 py-2 text-neutral-600">Enroll Date</th>
                <th className="px-4 py-2 text-neutral-600">Status</th>
                <th className="px-4 py-2 text-neutral-600">Feedback</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td className=" px-4 py-2 text-neutral-600 font-medium">
                  Intro to Drawing
                </td>
                <td className=" px-4 py-2 text-neutral-600 font-medium">
                  Beginner
                </td>
                <td className=" px-4 py-2 text-neutral-600 font-medium">
                  Loydd
                </td>
                <td className="px-4 py-2 text-neutral-600 font-medium">
                  14-10-2023
                </td>
                <td className=" px-4 py-2 text-neutral-600 font-medium">
                  studying
                </td>
                <td className="px-4 py-2 text-neutral-600 font-medium"></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default OrderHistory;
