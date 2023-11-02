import { Form } from "react-router-dom";

const Profile = () => {
  return (
        <div className="pt-32 pl-20">
          <div className="flex justify-between items-center w-full font-bold text-3xl">
            <div>Edit profile</div>
            <img
              className="rounded-full w-2/12"
              src="https://st3.depositphotos.com/9998432/13335/v/450/depositphotos_133352156-stock-illustration-default-placeholder-profile-icon.jpg"
            />
          </div>
          <Form method="post" className="mt-10 mb-36 font-bold">
                <div className="mb-3">
                <label>UserName</label>
                <input className="block p-2 w-full border"/>
                </div>
                <div className="mb-3">
                <label>Email</label>
                <input type="email" className="block p-2 w-full border"/>
                </div>
                <div className="mb-3">
                <label>Date of Birth</label>
                <input type="date" className="block p-2 w-full border"/>
                </div>
                <div className="mb-3">
                <label>Phone</label>
                <input type="tel" className="block p-2 w-full border"/>
                </div>
                <div className="flex justify-between px-20 mt-10"><button className="text-orange-400 border border-orange-400 py-2 px-5">Cancel</button><button className="bg-orange-400 text-white py-2 px-5">Save</button></div>
          </Form>
        </div>
  );
};

export default Profile;
