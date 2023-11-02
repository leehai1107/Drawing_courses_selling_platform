const ForgetPass = () => {
  return (
    <>
      <div className="px-72 mb-20 text-center">
        <div className="mb-20 pt-36 text-3xl font-bold">Forget Password</div>
        <div className="border border-dashed border-lime-400 py-20 px-10">
          <label className="text-sm text-neutral-400 block text-left">Enter your email</label>
          <input className="p-2 w-full mb-10 border" placeholder="your email" />
          <div className="text-center mb-10">we will send a code to your email to rest your password</div>
          <button className="font-bold py-2 px-5 text-2xl bg-orange-500 text-white rounded-lg">Send</button>
        </div>
      </div>
    </>
  );
};

export default ForgetPass
