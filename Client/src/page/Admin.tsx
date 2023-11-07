
import ComanyFactsChart from "../components/ComanyFactsChart";
import StatisticChart from "../components/StatisticChart";

const Admin = () => {
  return (
    <>
      <div className="grid grid-cols-6 bg-neutral-100 p-5 gap-5">
        <div className="col-span-3 mx-5 bg-white rounded-2xl p-5">
          <div className="font-semibold text-lg">Comany Facts</div>
          <div className="text-neutral-400 mb-10">Employees</div>
          <ComanyFactsChart />
        </div>
        <div className="col-span-3 mx-5 bg-white rounded-2xl p-5">
          <div className="font-semibold text-lg">Statistic</div>
          <div className="text-neutral-400 mb-10"></div>
          <StatisticChart />
        </div>
        
      </div>
    </>
  );
};

export default Admin;
