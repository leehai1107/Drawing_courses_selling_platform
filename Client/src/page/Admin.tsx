import AdminMenu from "../components/AdminMenu";
import ComanyFactsChart from "../components/ComanyFactsChart";
import StatisticChart from "../components/StatisticChart";

const Admin = () => {
  return (
    <>
      <div className="grid grid-cols-6 bg-neutral-100 p-5">
        <div className="col-span-1 bg-white rounded-2xl p-5">
          <AdminMenu />
        </div>
        <div className="col-span-1 col-start-1 row-start-2 self-end bg-white rounded-2xl p-5 mb-5">
          <div className="flex flex-col text-center">
            <div className="font-medium">CAMIOCA</div>
            <div className="text-neutral-400">Version: 1.0.0.11</div>
          </div>
        </div>
        <div className="col-span-2 mx-5 bg-white rounded-2xl p-5">
          <div className="font-semibold text-lg">Comany Facts</div>
          <div className="text-neutral-400 mb-10">Employees</div>
          <ComanyFactsChart />
        </div>
        <div className="col-span-2 mx-5 bg-white rounded-2xl p-5">
          <div className="font-semibold text-lg">Statistic</div>
          <div className="text-neutral-400 mb-10"></div>
          <StatisticChart />
        </div>
        <div className="col-span-2 col-start-2 mx-5 my-5 bg-white rounded-2xl p-5">
          <div className="font-semibold text-lg">Assigned Risks</div>
          <div className="flex justify-center">
            <div className="text-neutral-400 my-36">
              There are no risks assigned.
            </div>
          </div>
        </div>
        <div className="col-span-2 mx-5 my-5 bg-white rounded-2xl p-5">
          <div className="font-semibold text-lg">Assigned Action Items</div>
          <div className="flex justify-center">
            <div className="text-neutral-400 my-36">
              There are no risks assigned.
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Admin;
