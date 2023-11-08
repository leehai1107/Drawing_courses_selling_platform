import { useParams } from "react-router-dom";
import { Lession } from "../../Type/Type";
import { useEffect, useState } from "react";
import axios from "axios";
import { API } from "../../API/API";

export const Lessions = () => {
  
  const {courseid}:any = useParams()
  const [Lessions, setLesssions]:any = useState([]);
  const [selectedL, setSelectedL]:any = useState();

  const apiKey = "AIzaSyBMYI96nG9oT_8IYLchT37ifV8cfHcAzTg";

  useEffect(() => {
    setThumnail();
  }, []);


  // Construct the API URL
  const getThumbNail = async (videoId: string) => {
    const result = await axios.get(
      `https://www.googleapis.com/youtube/v3/videos?part=snippet&id=${videoId}&key=${apiKey}`
    );
    return result.data.items[0].snippet.thumbnails.default.url;
  };

  const setThumnail = async () => {
    const updateLession = await API.getLessionByCourse(courseid)
    for (let lession of updateLession) {
      // Edit the array element here, for example, double each element.
      lession.thumbnail = await getThumbNail(lession.videoUrl);
    }
    setLesssions(updateLession);
    setSelectedL(updateLession[0])
  };

  return (
    <>
      <div className="pt-28 flex px-10">
        <div className="w-3/4">
          <iframe
            className="w-full h-3/4 mb-5"
            src={`https://www.youtube.com/embed/${selectedL?.videoUrl}`}
          ></iframe>

          <div className="text-4xl font-light mb-3">{selectedL?.title}</div>
          <div className="text-2xl font-light">{selectedL?.content}</div>
        </div>
        <div className="w-1/4 h-screen overflow-x-scroll py-10 px-5 bg-neutral-200">
          {Lessions?.map((lession: Lession | any) => (
            <div
              onClick={() => setSelectedL(lession)}
              className={`px-5 mb-5 bg-white`}
            >
              <img className="w-full" src={lession.thumbnail}></img>
              <hr
                className={`mt-5 ${
                  lession === selectedL ? "border-2 border-black" : <></>
                }`}
              />
              <div className="text-center text-xl font-bold">
                {lession.title}
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
};
