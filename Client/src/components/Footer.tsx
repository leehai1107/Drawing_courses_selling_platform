import { Link } from "react-router-dom";
import MenuLogo from "../assets/MenuLogo.jpg";

const Footer = () => {
  return (
    <>
      <div className="flex bg-green-50">
        <div className="w-1/5">
          <img className="w-1/3" src={MenuLogo} />
        </div>
        <div className="w-2/5 flex flex-col font-medium text-xl pt-20">
            <Link className="mb-5" to={"/"}>Giới Thiệu</Link>
            <Link className="mb-5" to={"/"}>Blog</Link>
            <Link className="mb-5" to={"/"}>Khóa Học Thử 3 Ngày</Link>
            <Link className="mb-5" to={"/"}>Các Khóa Học Cho Bé</Link>
        </div>
        <div className="w-2/5 flex flex-col font-medium text-xl pt-20">
            <Link className="mb-5" to={"/"}>Liên hệ hợp tác</Link>
            <Link className="mb-5" to={"/"}>09012345678</Link>
            <Link className="mb-5" to={"/"}>mythuatbui@gmail.com</Link>
        </div>
      </div>
    </>
  );
};

export default Footer
