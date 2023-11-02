import { Link, useLoaderData } from "react-router-dom";

export const CourseCategories = () => {
  const categories: any = useLoaderData();
  return (
    <>
      <div className="bg-lime-400 pt-20">
        <div className="text-7xl font-medium text-center py-10">Mục Lục</div>
        <div className="flex flex-wrap">
          {categories.map((category: any) => (
            <>
              <Link
                to={`/Courses/${category.drawCategoryName}/${category.drawCategoryId}`}
                className="block w-1/3 px-10"
              >
                <div className="rounded-2xl border border-black bg-neutral-300 text-center my-10 py-10">
                  {category.drawCategoryName}
                </div>
              </Link>
            </>
          ))}
        </div>
      </div>
    </>
  );
};
