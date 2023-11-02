import BackGround from "../assets/background.jpg";

const LandingPage = () => {
  return (
    <>
      <div>
        <img className="w-full" src={BackGround} alt="Logo" />
        <div
          style={{ right: "35%", bottom: "30%" }}
          className="absolute w-1/3 bg-lime-400 bg-opacity-60 py-4 font-medium text-xl text-black rounded-3xl"
        >
          <div className="text-center mb-10">Khóa học thử trong 3 ngày</div>
          <ul className="m-auto w-2/3 mb-10">
            <li className="mb-5">• Khám phá tiềm năng của con em</li>
            <li className="mb-5">• Các bài học tiếp cận đơn giản, dễ hiểu</li>
            <li className="mb-5">• Tìm ra sở thích phù hợp với bé </li>
          </ul>
          <div className="text-center">
            <button className="text-white bg-orange-500 py-2 px-6">Đăng Kí</button>
          </div>
        </div>
      </div>
    </>
  );
};

export default LandingPage;
