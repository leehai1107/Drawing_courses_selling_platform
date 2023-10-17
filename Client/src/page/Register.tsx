import { Form } from "react-router-dom";

const Register = () => {
  return (
    <>
      <div className="px-72 mb-20">
        <div className="mb-20 pt-36 text-4xl text-center font-bold">Register</div>
        <Form method="post">
          <div className="mb-3">
            <label className="font-bold">User Name</label>
            <input
              className="p-2 w-full mb-10 border"
              placeholder="User Name"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Password</label>
            <input
              type="password"
              className="p-2 w-full mb-10 border"
              placeholder="Password"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Re-Password</label>
            <input
              type="password"
              className="p-2 w-full mb-10 border"
              placeholder="re input your password"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Email</label>
            <input
              type="email"
              className="p-2 w-full mb-10 border"
              placeholder="Email"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Phone</label>
            <input
              type="tel"
              className="p-2 w-full mb-10 border"
              placeholder="Phone Number"
              required
            />
          </div>

          <div className="mb-3">
            <label className="font-bold">Date of Birth</label>
            <input
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
