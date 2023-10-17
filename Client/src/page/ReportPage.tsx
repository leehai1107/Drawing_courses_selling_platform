import { Form } from "react-router-dom";

const ReportPage = () => {
  return (
    
      <div className="pt-32 pl-20">
        <div className="flex justify-between items-center w-full font-bold text-3xl">
          <div>Report/Feedback</div>
          <img
            className="rounded-full w-2/12"
            src="https://st3.depositphotos.com/9998432/13335/v/450/depositphotos_133352156-stock-illustration-default-placeholder-profile-icon.jpg"
          />
        </div>
        <Form method="post" className="mt-10 mb-36 font-bold">
          <div className="mb-3">
            <label>UserName</label>
            <input className="block p-2 w-full border" />
          </div>
          <div className="mb-3">
            <label>Email</label>
            <input type="email" className="block p-2 w-full border" />
          </div>
          <div className="mb-3">
            <label>Title</label>
            <input className="block p-2 w-full border" />
          </div>
          <div className="mb-3">
            <label>Content</label>
            <textarea className="block p-2 w-full border h-60"></textarea>
          </div>
          <div className="flex justify-center px-20 mt-10">
            <button className="bg-orange-400 text-white py-2 px-5">
              Submit
            </button>
          </div>
        </Form>
      </div>
    
  );
};

export default ReportPage;
