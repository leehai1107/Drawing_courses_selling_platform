import ShoppingCart from "@mui/icons-material/ShoppingCart";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Link } from "react-router-dom";
import { useRecoilState, useRecoilValue } from "recoil";
import { accountState, cartState } from "../atom/atom";
import { CartElement, Course } from "../Type/Type";
import RemoveIcon from "@mui/icons-material/Remove";
import { getTotalInCart, numberToVietnameseDong } from "../util/util";

const Cart = () => {
  const account: any = useRecoilValue(accountState);
  const [cart, setCart]: any = useRecoilState(cartState);
  const removeFromCart = (course: Course) => {
    const removeCourse = cart.filter(
      (c: CartElement) => c?.Course.courseId !== course.courseId
    );

    setCart(removeCourse);
  };

  return (
    <>
      <div className="bg-lime-300 pt-40 font-medium">
        <div className="w-4/5 m-auto bg-white border-2 mb-10 border-black">
          <div className="text-center mb-14 text-xl">
            Giỏ hàng <ShoppingCart />
          </div>
          <div className="m-auto w-4/5 mb-20">
            <TableContainer component={Paper} style={{ whiteSpace: 'nowrap' }}>
              <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell>Tên Khóa Học</TableCell>
                    <TableCell align="center">Trình độ</TableCell>
                    <TableCell align="center">Giáo viên</TableCell>
                    <TableCell align="center">Ngày đăng ký</TableCell>
                    <TableCell align="center">Giá tiền&nbsp;(vnđ)</TableCell>
                    <TableCell align="center"></TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {cart.map((data: CartElement, index: number) => (
                    <TableRow
                      key={index}
                      sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                    >
                      <TableCell component="th" scope="row">
                        {data.Course.title}
                      </TableCell>
                      <TableCell align="center">
                        {data?.Course?.levelModel === undefined
                          ? "CHƯA LỰA CHỌN CẤP ĐỘ"
                          : data.Course.levelModel?.levelName}
                      </TableCell>
                      <TableCell align="center">{data.Course?.userModelRespone?.fullname}</TableCell>
                      <TableCell align="center">
                        {data.EnrollDate.toLocaleDateString()}
                      </TableCell>
                      <TableCell align="center">{numberToVietnameseDong(data.Course.price)}</TableCell>
                      <TableCell align="center">
                        <div onClick={() => removeFromCart(data.Course)}>
                          <RemoveIcon />
                        </div>
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
            <div className="text-right mb-2 mt-5 font-bold">
          Thành tiền: {numberToVietnameseDong(getTotalInCart(cart))}
          </div>
          </div>
          
        </div>
        <div className="text-center">
          {cart.length < 1 || !account ? (
            <Link to={"/"}>
              <button className="text-white bg-orange-500 py-2 px-6 mb-20">
                Đăng Kí Học
              </button>
            </Link>
          ) : (
            <Link to={"/Payment"}>
              <button className="text-white bg-orange-500 py-2 px-6 mb-20">
                Xác nhận
              </button>
            </Link>
          )}
        </div>
      </div>
    </>
  );
};

export default Cart;
