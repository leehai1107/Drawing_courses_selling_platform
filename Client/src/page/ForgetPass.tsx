const ForgetPass = () => {
  return (
    <>
      <div className="px-72 mb-20 text-center">
        <div className="mb-20 pt-36 text-3xl font-bold">Quên Mật Khẩu</div>
        <div className="border border-dashed border-lime-400 py-20 px-10">
          <label className="text-md text-neutral-400 block text-left">Nhập địa chỉ email</label>
          <input className="p-2 w-full mb-10 border" placeholder="Email của bạn là" />
          <div className="text-center mb-10">Chúng tôi sẽ gửi mật khẩu mới vào email của bạn!</div>
          <button className="font-bold py-2 px-5 text-2xl bg-orange-500 text-white rounded-lg">Gửi</button>
        </div>
      </div>
    </>
  );
};

export default ForgetPass
