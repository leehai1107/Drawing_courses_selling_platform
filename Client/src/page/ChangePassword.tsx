import { Form, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { useRecoilValue } from "recoil";
import { accountState } from "../atom/atom";
import { API } from "../API/API";

const ChangePassword = () => {
  const account:any = useRecoilValue(accountState)

  const navigate = useNavigate()

  const submitChange = async(event:any) => {
      event.preventDefault(); 
      const formData = new FormData(event.target)
      const passwordEntered = formData.get('passwordEntered')
      const newPassword = formData.get('newPassword')
      const confPassword = formData.get('confPassword')
      if(newPassword!==confPassword) {
        toast("new password and confirm password are different", {type: toast.TYPE.WARNING})
      }else{
        const result = await API.changePassword({
          userid: account.userid,
          passwordEntered,
          newPassword
        })

        if(result==="Change password fail!"||result==="Password has enter does not match with old password!"){
          toast(result, {type: toast.TYPE.ERROR})
        }
        else{
          sessionStorage.clear()
          navigate("/SignIn")
        }
      }
  }
  return (
    <div className="pt-32 pl-20 border border-l">
      <div className="flex justify-between items-center w-full font-bold text-3xl">
        <div>Đổi mật khẩu</div>
        <img
          className="rounded-full w-2/12"
          src="https://st3.depositphotos.com/9998432/13335/v/450/depositphotos_133352156-stock-illustration-default-placeholder-profile-icon.jpg"
        />
      </div>
      <Form onSubmit={submitChange} method="post" className="mt-10 mb-36 font-bold">
        <div className="mb-3">
          <label>Mật khẩu cũ</label>
          <input required name="passwordEntered" type="password" className="block p-2 w-full border" />
        </div>
        <div className="mb-3">
          <label>Mật khẩu mới</label>
          <input required name="newPassword" type="password" className="block p-2 w-full border" />
        </div>
        <div className="mb-3">
          <label>Nhập lại mật khẩu mới</label>
          <input required name="confPassword" type="password" className="block p-2 w-full border" />
        </div>

        <div className="flex justify-center px-20 mt-10">
          <button className="bg-orange-400 text-white py-2 px-5">Thay đổi mật khẩu</button>
        </div>
      </Form>
    </div>
  );
};

export default ChangePassword;
