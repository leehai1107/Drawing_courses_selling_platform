import { Form } from "react-router-dom";
import { API } from "../API/API";
import { toast } from "react-toastify";

const ReportPage = ({
  courseId,
  handleClose,
  order,
}: {
  courseId: number;
  handleClose: any;
  order: any;
}) => {
  const submitFeedback = async (event: any) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const data = {
      comment: formData.get("comment"),
      course_id: courseId,
      reviewDate: new Date(),
      orderModel: order,
      order_id: order.order_id,
    };

    const result = await API.addFeedback(data);
    if(result?.comment){
      toast("Feedback đã được gửi!",{type: toast.TYPE.SUCCESS})
    }
    handleClose();
  };
  return (
    <div className="pt-32 pl-20">
      <div className="flex justify-between items-center w-full font-bold text-3xl">
        <div>Report/Feedback</div>
        <img
          className="rounded-full w-2/12"
          src="https://st3.depositphotos.com/9998432/13335/v/450/depositphotos_133352156-stock-illustration-default-placeholder-profile-icon.jpg"
        />
      </div>
      <Form
        onSubmit={submitFeedback}
        method="post"
        className="mt-10 mb-36 font-bold"
      >
        <div className="mb-3">
          <label>Feedback</label>
          <textarea
            name="comment"
            required
            className="block p-2 w-full border h-60"
          ></textarea>
        </div>
        <div className="flex justify-center px-20 mt-10">
          <button className="bg-orange-400 text-white py-2 px-5">Gửi</button>
        </div>
      </Form>
    </div>
  );
};

export default ReportPage;
