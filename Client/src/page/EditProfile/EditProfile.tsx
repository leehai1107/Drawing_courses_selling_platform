import { Form, useNavigate } from "react-router-dom"
import { useRecoilState } from "recoil"
import { accountState } from "../../atom/atom"
import { isPhoneNumberValid } from "../../util/util"
import { toast } from "react-toastify";
import { API } from "../../API/API";

const EditProfile = ()=> {
    const [account, setAccount]:any = useRecoilState(accountState)
    const navigate = useNavigate()
    const callback = async() => {
      const userInfo = await API.getUserInfo(account?.userid)
      setAccount(userInfo)
    }

    const submitFrm = (event:any) => {
        event.preventDefault()
        const formData = new FormData(event.target)
        const string:string|any = formData.get("phone")
        if(!isPhoneNumberValid(string)){
          toast("phone number is invalid", {type: toast.TYPE.ERROR})
        }
        else{
          editProfileAction(formData, account.userid)
        }
    }

    const editProfileAction = async (formData:FormData, userid:number) => {
      const data: any = {};
      formData.forEach((value, key) => {
        data[key] = value;
      });
      data.status = true
      data.userid = userid
    
      await API.editUser(data)
      await callback()
      navigate("/SignIn")
    };

    return <div className="pt-32 pl-20 border border-l">
    <div className="flex justify-between items-center w-full font-bold text-3xl">
      <div>Edit profile</div>
      <img
        className="rounded-full w-2/12"
        src="https://st3.depositphotos.com/9998432/13335/v/450/depositphotos_133352156-stock-illustration-default-placeholder-profile-icon.jpg"
      />
    </div>
    <Form method="post" onSubmit={(event) => submitFrm(event)} className="mt-10 mb-36 font-bold">
          <div className="mb-3">
          <label>UserName</label>
          <input name="username" required className="block p-2 w-full border" value={account?.username}/>
          </div>
          <div className="mb-3">
          <label>Email</label>
          <input name="email" required type="email" className="block p-2 w-full border" defaultValue={account?.email}/>
          </div>
          <div className="mb-3">
          <label>Date of Birth</label> 
          <input name="dob" type="date" className="block p-2 w-full border" defaultValue={account?.dob}/>
          </div>
          <div className="mb-3">
          <label>Phone</label>
          <input name="phone" required type="tel" className="block p-2 w-full border" defaultValue={account?.phone}/>
          </div>
          <div className="flex justify-between px-20 mt-10"><span onClick={() => navigate("/")} className="text-orange-400 border border-orange-400 py-2 px-5">Cancel</span><button type="submit" className="bg-orange-400 text-white py-2 px-5">Save</button></div>
    </Form>
  </div>
}

export default EditProfile