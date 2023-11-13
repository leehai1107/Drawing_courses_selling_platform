import { useEffect } from "react";
import { Form, useActionData, useNavigate, useSubmit } from "react-router-dom";
import { toast } from "react-toastify";

const Register = () => {
  const submit = useSubmit();

  const result = useActionData();

  const navigate = useNavigate();

  useEffect(() => {
    if (result) {
      navigate("/")
    }
  }, [result]);

  const submitRegister = (event: any) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const password = formData.get("password");
    const repassword = formData.get("repassword");
    if (repassword !== password) {
      toast("password and repassword is different", {
        type: toast.TYPE.WARNING,
      });
    } else {
      submit(formData, {method:"post"});
    }
  };
  return (
    <>
      <div className="px-72 mb-20">
        <div className="mb-20 pt-36 text-4xl text-center font-bold">
          ĐĂNG KÝ TÀI KHOẢN
        </div>
        <Form onSubmit={(event) => submitRegister(event)} method="post">
          <div className="mb-3">
            <label className="font-bold">Tên đăng nhập</label>
            <input
              name="username"
              className="p-2 w-full mb-10 border"
              placeholder="Tên đăng nhập"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Mật khẩu</label>
            <input
              name="password"
              type="password"
              className="p-2 w-full mb-10 border"
              placeholder="Mật khẩu"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Nhập lại mật khẩu</label>
            <input
              name="repassword"
              type="password"
              className="p-2 w-full mb-10 border"
              placeholder="Vui lòng nhập lại mật khẩu"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Email</label>
            <input
              name="email"
              type="email"
              className="p-2 w-full mb-10 border"
              placeholder="Email của bạn"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Số điện thoại</label>
            <input
              name="phone"
              type="tel"
              className="p-2 w-full mb-10 border"
              placeholder="Số điện thoại của bạn"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Ngày tháng năm sinh</label>
            <input
              name="dob"
              type="date"
              className="p-2 w-full mb-10 border"
              placeholder="Ngày tháng năm sinh"
              required
            />
          </div>
          <div className="text-center">
            <button className="font-bold py-2 px-5 text-2xl bg-orange-500 text-white rounded-lg">
              Xác nhận
            </button>
          </div>
        </Form>
      </div>
    </>
  );
};

export default Register;
