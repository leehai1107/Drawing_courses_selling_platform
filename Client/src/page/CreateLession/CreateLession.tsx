import { useState } from "react";
import { Form, useNavigate, useParams } from "react-router-dom";
import { API } from "../../API/API";
import { useRecoilValue } from "recoil";
import { accountState } from "../../atom/atom";

export const CreateLession = () => {
  const account: any = useRecoilValue(accountState);
  const { courseId } = useParams();
  const [lessions, setLessions] = useState([
    { title: "", videoUrl: "", content:"", courseId },
  ]);
  const navigate = useNavigate();

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
    const updateLessions = lessions.filter((Mlession) => Mlession !== lession);
    setLessions(updateLessions);
  };
  const submit = (event: any) => {
    event.preventDefault();
    lessions.forEach(async (lession) => {
      await API.addLession(lession);
    });
    navigate(`/InstructorCourses/${account.userid}`);
  };
  return (
    <>
      <div className="bg-lime-200 pt-40">
        <Form onSubmit={submit} method="post">
          <div className="w-1/2 m-auto border border-dashed border-lime-500 px-10 py-14 rounded-2xl max-h-screen overflow-y-scroll">
            <label className="text-sm">Tổng số lessions</label>
            <input
              className="p-2 w-full rounded-2xl mb-5"
              defaultValue={1}
              type="number"
              min={1}
              value={lessions.length}
            />
            {lessions.map((lession, index) => (
              <>
                <label className="text-sm">Tựa đề lession {index + 1}</label>
                <input
                  required
                  className="p-2 w-full rounded-2xl mb-5"
                  placeholder="tựa đề"
                  defaultValue={lession.title}
                  onChange={(event) => setTitle(index, event.target.value)}
                />
                <label className="text-sm">Link lession {index + 1}</label>
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
                    remove lession
                  </button>
                ) : (
                  ""
                )}
              </>
            ))}
            <br />
            <button onClick={addLession} className="p-2 mt-5 bg-lime-600">
              add lession
            </button>
          </div>
          <div className="mt-10 pb-20 text-center">
            <button className="p-2 bg-orange-400 text-white">
              Create Lession
            </button>
          </div>
        </Form>
      </div>
    </>
  );
};
