import { PieChart, Pie, Legend } from "recharts";
import StatisticData from "../data/StatisticData";

const StatisticChart = () => {
  return (
    <>
      <div>
        <PieChart width={400} height={350}>
          <Pie
            data={StatisticData}
            dataKey="value"
            nameKey="name"
            cx="50%"
            cy="50%"
            innerRadius={70}
            outerRadius={100}
            fill="#82ca9d"
            label
          />
          <Legend />
        </PieChart>
      </div>
    </>
  );
};

export default StatisticChart;
