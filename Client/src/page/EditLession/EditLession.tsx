import { useEffect, useState } from "react";
import { Form, useNavigate, useParams } from "react-router-dom";
import { API } from "../../API/API";
import { useRecoilValue } from "recoil";
import { accountState } from "../../atom/atom";

export const EditLession = () => {
  const account: any = useRecoilValue(accountState);
  const { courseId }:any = useParams();
  const [lessions, setLessions]:any = useState([]);
  const navigate = useNavigate();

  useEffect(()=>{
    const callback = async() => {
      const getLessions = await API.getLessionByCourseId(courseId)

      const getLessions2 = getLessions.map((element:any) => {
        const data = { title: element.title, videoUrl: element.videoUrl, content:element.content, courseId:element.courseInfo.courseId }
        return data;
      });

      console.log(getLessions2)

      setLessions(getLessions2)
    }
    callback()
  },[])

  const setTitle = (index: number, title: string) => {
    const updateLessions = lessions;
    updateLessions[index].title = title;
    setLessions(updateLessions);
  };

  const setUrl = (index: number, url: string) => {
    const updateLessions = lessions;
    updateLessions[index].videoUrl = url;
    setLessions(updateLessions);
  };

  const addLession = (event: any) => {
    event.preventDefault();
    setLessions([...lessions, { title: "", videoUrl: "", content:"", courseId }]);
  };

  const removeLession = (lession: any) => {
    const updateLessions = lessions.filter((Mlession:any) => Mlession !== lession);
    setLessions(updateLessions);
  };
  const submit = async (event: any) => {
    event.preventDefault();
    await API.editLessionByCourseId(lessions)
    navigate(`/InstructorCourses/${account.userid}`);
  };
  return (
    <>
      <div className="bg-lime-200 pt-40">
        <Form onSubmit={submit} method="post">
          <div className="w-1/2 m-auto border border-dashed border-lime-500 px-10 py-14 rounded-2xl max-h-screen overflow-y-scroll">
            <label className="text-sm">Tổng số bài học</label>
            <input
              className="p-2 w-full rounded-2xl mb-5"
              defaultValue={1}
              type="number"
              min={1}
              value={lessions.length}
            />
            {lessions.map((lession:any, index:number) => (
              <>
                <label className="text-sm">Tựa đề bài học {index + 1}</label>
                <input
                  required
                  className="p-2 w-full rounded-2xl mb-5"
                  placeholder="tựa đề"
                  defaultValue={lession.title}
                  onChange={(event) => setTitle(index, event.target.value)}
                />
                <label className="text-sm">Link bài học {index + 1}</label>
                <input
                  required
                  className="p-2 w-full rounded-2xl mb-5"
                  placeholder="link lession"
                  defaultValue={lession.videoUrl}
                  onChange={(event) => setUrl(index, event.target.value)}
                />
                {index > 0 ? (
                  <button
                    onClick={() => removeLession(lession)}
                    className="block p-2 bg-lime-600 mb-5"
                  >
                    Xoá bài học
                  </button>
                ) : (
                  ""
                )}
              </>
            ))}
            <br />
            <button onClick={addLession} className="p-2 mt-5 bg-lime-600">
              Thêm bài học
            </button>
          </div>
          <div className="mt-10 pb-20 text-center">
            <button className="p-2 bg-orange-400 text-white">
              Sửa bài học
            </button>
          </div>
        </Form>
      </div>
    </>
  );
};
