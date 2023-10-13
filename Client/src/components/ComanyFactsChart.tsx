import { AreaChart, XAxis, YAxis, CartesianGrid, Tooltip, Area, Legend } from "recharts";
import CompanyFactsData from "../data/CompanyFactsData";

const ComanyFactsChart = () => {
  return (
    <>
      <AreaChart
        width={400}
        height={300}
        data={CompanyFactsData}
        margin={{ top: 50, right: 30, left: 0, bottom: 0 }}
      >
        <defs>
          <linearGradient id="colorParis" x1="0" y1="0" x2="0" y2="1">
            <stop offset="5%" stopColor="#e37a02" stopOpacity={1} />
            <stop offset="95%" stopColor="#e37a02" stopOpacity={0} />
          </linearGradient>
          <linearGradient id="colorBangkok" x1="0" y1="0" x2="0" y2="1">
            <stop offset="5%" stopColor="#018257" stopOpacity={1} />
            <stop offset="95%" stopColor="#018257" stopOpacity={0} />
          </linearGradient>
          <linearGradient id="colorSan" x1="0" y1="0" x2="0" y2="1">
            <stop offset="5%" stopColor="#9102d9" stopOpacity={1} />
            <stop offset="95%" stopColor="#9102d9" stopOpacity={0} />
          </linearGradient>
        </defs>
        <XAxis dataKey="name" />
        <YAxis label={{ value: "Total", position: "insideTopRight", dy: -45}} />
        <CartesianGrid strokeDasharray="3 3" />
        <Tooltip />
        <Area
          type="monotone"
          dataKey="Paris"
          stroke="#e37a02"
          fillOpacity={1}
          fill="url(#colorParis)"
        />
        <Area
          type="monotone"
          dataKey="Bangkok"
          stroke="#018257"
          fillOpacity={1}
          fill="url(#colorBangkok)"
        />
         <Area
          type="monotone"
          dataKey="San Francisco"
          stroke="#9102d9"
          fillOpacity={1}
          fill="url(#colorSan)"
        />
        <Legend />
      </AreaChart>
    </>
  );
};

export default ComanyFactsChart
