import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { StaffCourseShowTrue } from "../../components/CourseShow";
import { Course } from "../../Type/Type";
import { API } from "../../API/API";

export const TrueCourse = () => {
  const [myCourses, setMyCourses] = useState<Course[]>([]);
  const [pageNumber, setPageNumber] = useState(0);
  const coursesPerPage = 3; // Adjust the number of courses per page as needed

  useEffect(() => {
    getMyTrueCourses();
  }, [pageNumber]); // Reload courses when the page number changes

  const getMyTrueCourses = async () => {
    const allMyCourses = await API.getAllTrueCourse();
    setMyCourses(allMyCourses);
  };

  const pageCount = Math.ceil(myCourses.length / coursesPerPage);

  const handlePageChange = ({ selected }: { selected: number }) => {
    setPageNumber(selected);
  };

  const offset = pageNumber * coursesPerPage;
  const paginatedCourses = myCourses.slice(offset, offset + coursesPerPage);

  return (
    <>
      <div className="bg-lime-500 pt-40 pb-20 px-10">
        <div className="text-3xl font-semibold text-amber-300">
          Khóa học đã duyệt
        </div>
        <div className="mt-5 px-5 flex justify-center items-center">
          {paginatedCourses.map((mCourse: Course) => (
            <StaffCourseShowTrue
              key={mCourse.courseId}
              course={mCourse}
              getMyTrueCourses={getMyTrueCourses}
            />
          ))}
        </div>
        <div className="flex justify-center items-center">
          <ReactPaginate
          previousLabel={<div className="text-center text-white pagination-btn">Trước</div>}
          nextLabel={<div className="text-center text-white pagination-btn">Sau</div>}
            breakLabel={"..."}
            breakClassName={"break-me"}
            pageCount={pageCount}
            marginPagesDisplayed={2}
            pageRangeDisplayed={5}
            onPageChange={handlePageChange}
            containerClassName={"pagination"}
            pageLinkClassName={"border-2 border-gray-500 rounded-full p-2 mx-1 text-gray-700"}
            activeClassName={"active"}
            previousLinkClassName={"border-2 border-gray-500 rounded-full p-2 mx-1 text-gray-700"}
            nextLinkClassName={"border-2 border-gray-500 rounded-full p-2 mx-1 text-gray-700"}
            activeLinkClassName={"bg-gray-500 text-white border-2 border-gray-500 rounded-full p-2 mx-1"}
          />
        </div>
      </div>
    </>
  );
};
