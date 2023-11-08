import { Form, useLoaderData, useNavigate, useParams } from "react-router-dom";
import { Course, DrawingCategoryModel, levelModel } from "../../Type/Type";
import { useRecoilValue } from "recoil";
import { accountState } from "../../atom/atom";
import { API } from "../../API/API";
import { toast } from "react-toastify";

export const EditCourse = () => {
  const account: any = useRecoilValue(accountState);
  const {courseId}:any = useParams()
  const navigate = useNavigate();
  const {
    categories,
    levels,
    course,
  }:
    | { categories: DrawingCategoryModel[]; levels: levelModel[]; course: any }
    | any = useLoaderData();

  const submit = async (event: any) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    var data: any = {};

    for (var pair of formData.entries()) {
      data[pair[0]] = pair[1];
    }

    data.instructorId = account.userid;

     await API.editCourse(courseId, data);
     navigate(`/EditLession/${courseId}`);
    
  };
  return (
    <>
      <div className="bg-lime-200 pt-40">
        <Form onSubmit={submit} method="post">
          <div className="w-1/2 m-auto border border-dashed border-lime-500 px-10 py-14 rounded-2xl">
            <label className="text-sm">Tựa đề</label>
            <input
              name="title"
              required
              className="p-2 w-full rounded-2xl mb-5"
              placeholder="Tựa đề"
              defaultValue={course.title}
            />
            <label className="text-sm">Giới thiệu</label>
            <textarea
              name="description"
              required
              className="w-full h-32 rounded-2xl mb-5"
              defaultValue={course.description}
            ></textarea>
            <label className="text-sm">Giá tiền</label>
            <input
              name="price"
              required
              pattern="[0-9]+"
              className="p-2 w-full rounded-2xl mb-5"
              placeholder="vnđ"
              defaultValue={course.price}
            />
            <div className="flex mb-5">
              <div className="w-1/2 mr-5">
                <label className="text-sm">Level</label>
                <select name="levelId" className="p-2 w-full rounded-2xl">
                  {levels?.map((level: levelModel) => (
                    <>
                      {course.levelId === level.levelId ? (
                        <option selected value={level.levelId}>
                          {level.levelName}
                        </option>
                      ) : (
                        <option value={level.levelId}>{level.levelName}</option>
                      )}
                    </>
                  ))}
                </select>
              </div>
              <div className="w-1/2">
                <label className="text-sm">Category</label>
                <select
                  name="drawCategoryId"
                  className="p-2 w-full rounded-2xl"
                >
                  {categories?.map((category: DrawingCategoryModel) => (
                    <>
                      {course.drawCategoryId === category.drawCategoryId ? (
                        <option selected value={category.drawCategoryId}>
                          {category.drawCategoryName}
                        </option>
                      ) : (
                        <option value={category.drawCategoryId}>
                          {category.drawCategoryName}
                        </option>
                      )}
                    </>
                  ))}
                </select>
              </div>
            </div>
            <label className="text-sm">Link ảnh nền</label>
            <input
              name="courseImage"
              required
              className="p-2 w-full rounded-2xl"
              placeholder="link ảnh nền"
              defaultValue={course.courseImage}
            />
          </div>
          <div className="mt-10 pb-20 text-center">
            <button className="p-2 bg-orange-400 text-white">
              Edit Course
            </button>
          </div>
        </Form>
      </div>
    </>
  );
};
