import ShoppingCart from "@mui/icons-material/ShoppingCart";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import CartData from "../data/CartData";
import { numberToVietnameseDong } from "../util/util";
import { Link } from "react-router-dom";

const Cart = () => {
  return (
    <>
      <div className="bg-lime-300 pt-40 font-medium">
        <div className="w-2/3 m-auto bg-white border-2 mb-10 border-black">
          <div className="text-center mb-14">
            Giỏ hàng <ShoppingCart />
          </div>
          <div className="m-auto w-4/5 mb-20">
            <TableContainer component={Paper}>
              <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell>Tên Khóa Học</TableCell>
                    <TableCell align="right">Level</TableCell>
                    <TableCell align="right">Giáo Viên</TableCell>
                    <TableCell align="right">Ngày đăng ký</TableCell>
                    <TableCell align="right">Giá tiền&nbsp;(VND)</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {CartData.map((data, index) => (
                    <TableRow
                      key={index}
                      sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                    >
                      <TableCell component="th" scope="row">
                        {data.Course}
                      </TableCell>
                      <TableCell align="right">
                        {data?.Level === undefined
                          ? "CHƯA LỰA CHỌN CẤP ĐỘ"
                          : data.Level}
                      </TableCell>
                      <TableCell align="right">{data.Teacher}</TableCell>
                      <TableCell align="right">{data.EnrollDate}</TableCell>
                      <TableCell align="right">
                        {numberToVietnameseDong(data.UnitPrice)}
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
          </div>
        </div>
        <div className="text-center">
          <Link to={"/Payment"}>
            <button className="text-white bg-orange-500 py-2 px-6 mb-20">
              Xác nhận
            </button>
          </Link>
        </div>
      </div>
    </>
  );
};

export default Cart;
