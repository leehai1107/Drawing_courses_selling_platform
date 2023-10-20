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
          Register
        </div>
        <Form onSubmit={(event) => submitRegister(event)} method="post">
          <div className="mb-3">
            <label className="font-bold">User Name</label>
            <input
              name="username"
              className="p-2 w-full mb-10 border"
              placeholder="User Name"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Password</label>
            <input
              name="password"
              type="password"
              className="p-2 w-full mb-10 border"
              placeholder="Password"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Re-Password</label>
            <input
              name="repassword"
              type="password"
              className="p-2 w-full mb-10 border"
              placeholder="re input your password"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Email</label>
            <input
              name="email"
              type="email"
              className="p-2 w-full mb-10 border"
              placeholder="Email"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Phone</label>
            <input
              name="phone"
              type="tel"
              className="p-2 w-full mb-10 border"
              placeholder="Phone Number"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Date of Birth</label>
            <input
              name="dob"
              type="date"
              className="p-2 w-full mb-10 border"
              placeholder="Date of Birth"
              required
            />
          </div>
          <div className="text-center">
            <button className="font-bold py-2 px-5 text-2xl bg-orange-500 text-white rounded-lg">
              Confirm
            </button>
          </div>
        </Form>
      </div>
    </>
  );
};

export default Register;
