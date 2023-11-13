import { Link, useLoaderData } from "react-router-dom";

const getRandomColor = (str:any) => {
  // Simple function to generate a hash code from a string
  let hash = 0;
  for (let i = 0; i < str.length; i++) {
    hash = str.charCodeAt(i) + ((hash << 5) - hash);
  }

  // Convert the hash code to a hexadecimal color
  const color = "#" + ((hash & 0x00FFFFFF) | 0x440000).toString(16).toUpperCase();

  return color;
};

export const CourseCategories = () => {
  const categories: any = useLoaderData();
  return (
    <>
      <div className="bg-lime-400 pt-20">
        <div className="text-7xl font-medium text-center py-10">Các thể loại phổ biến</div>
        <div className="flex flex-wrap">
          {categories.map((category: any) => (
            <Link
              to={`/Courses/${category.drawCategoryName}/${category.drawCategoryId}`}
              className="block w-1/3 px-10"
              key={category.drawCategoryId}
            >
              <div
                className="rounded-2xl border border-black text-white text-center my-10 py-10"
                style={{
                  backgroundColor: getRandomColor(category.drawCategoryName),
                  fontWeight: "bold",
                  fontSize: "1.2rem", // Adjust the font size as needed
                }}
              >
                {category.drawCategoryName}
              </div>
            </Link>
          ))}
        </div>
      </div>
    </>
  );
};
