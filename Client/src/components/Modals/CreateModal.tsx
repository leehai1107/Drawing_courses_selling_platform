import { useState } from "react";
import { Form } from "react-router-dom";
import { generateRandomPassword } from "../../util/util";
import { API } from "../../API/API";
import { useRecoilValue } from "recoil";
import { accountState } from "../../atom/atom";

export const CreateModalInstructor = ({handleClose}:any) => {
    const account:any = useRecoilValue(accountState)
    const [password, setPass]:any = useState("")

    const addIns = async (event:any) => {
       event.preventDefault();
       const formData = new FormData(event.target)

       const data:any = {};
       formData.forEach((value, key) => {
           data[key] = value;
       });
       console.log(data)

       await API.addIns(data, account.token)
       await handleClose()
    }
  return (
    <>
      <div className="px-10 py-5">
        <Form onSubmit={addIns} method="post">
            <div>
                <label className="text-sm">Tên đăng nhập</label>
                <input className="w-full rounded-full p-2 border mb-5" name="username" required/>
                <label className="text-sm">Họ và Tên</label>
                <input className="w-full rounded-full p-2 border mb-5" name="fullname" required/>
                <label className="text-sm">Email</label>
                <input className="w-full rounded-full p-2 border mb-5" name="email" required type="email"/>
                <label className="text-sm">Số điện thoại</label>
                <input className="w-full rounded-full p-2 border mb-5" name="phone" required type="tel" pattern="[0-9]+"/>
                <label className="text-sm">Ngày tháng năm sinh</label>
                <input className="w-full rounded-full p-2 border mb-5" name="dob" type="date" required/>
                <label className="text-sm">Mật khẩu</label>
                <div><input value={password} onChange={(event)=>setPass(event.target.value)} className="w-2/3 rounded-full p-2 border mr-3 mb-5" name="password" required/><span onClick={()=>setPass(generateRandomPassword(6))} className="p-2 bg-blue-500 text-white rounded-xl">Tạo ngẫu nhiên</span></div>
                <button type="submit" className="p-2 bg-blue-500 text-white rounded-xl">Tạo giáo viên</button>
            </div>
        </Form>
      </div>
    </>
  );
};

export const CreateModalStaff = ({handleClose}:any) => {
  const account:any = useRecoilValue(accountState)
  const [password, setPass]:any = useState("")

  const addIns = async (event:any) => {
     event.preventDefault();
     const formData = new FormData(event.target)

     const data:any = {};
     formData.forEach((value, key) => {
         data[key] = value;
     });
     console.log(data)

     await API.addStaff(data, account.token)
     await handleClose()
  }
return (
  <>
    <div className="px-10 py-5">
      <Form onSubmit={addIns} method="post">
          <div>
              <label className="text-sm">Tên đăng nhập</label>
              <input className="w-full rounded-full p-2 border mb-5" name="username" required/>
              <label className="text-sm">Họ và Tên</label>
              <input className="w-full rounded-full p-2 border mb-5" name="fullname" required/>
              <label className="text-sm">Email</label>
              <input className="w-full rounded-full p-2 border mb-5" name="email" required type="email"/>
              <label className="text-sm">Số điện thoại</label>
              <input className="w-full rounded-full p-2 border mb-5" name="phone" required type="tel" pattern="[0-9]+"/>
              <label className="text-sm">Ngày tháng năm sinh</label>
              <input className="w-full rounded-full p-2 border mb-5" name="dob" type="date" required/>
              <label className="text-sm">Mật khẩu</label>
              <div><input value={password} onChange={(event)=>setPass(event.target.value)} className="w-2/3 rounded-full p-2 border mr-3 mb-5" name="password" required/><span onClick={()=>setPass(generateRandomPassword(6))} className="p-2 bg-blue-500 text-white rounded-xl">Tạo ngẫu nhiên</span></div>
              <button type="submit" className="p-2 bg-blue-500 text-white rounded-xl">Tạo nhân viên</button>
          </div>
      </Form>
    </div>
  </>
);
};
