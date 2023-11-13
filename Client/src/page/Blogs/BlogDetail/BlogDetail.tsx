import { useLoaderData } from "react-router-dom";
import { Blog } from "../../../Type/Type";
import blogImage from "../../../assets/blog.jpg"

const BlogDetail = () => {

  const blog:Blog|any = useLoaderData();

  return (
    <>
      <div className="pt-40 px-32">
        <div className="text-lg w-5/6 m-auto">
          <span className="px-5 bg-neutral-300 font-semibold rounded-xl mr-3">
            {blog?.cateInfo.postCategoryName}
          </span>
          <span className="px-5 bg-neutral-300 font-semibold rounded-xl">
            {blog.postDate}
          </span>
        </div>

        <div className="mb-20">
          <div className="text-5xl font-semibold my-10 w-5/6 m-auto">
            {blog.title}
          </div>

          <img className="w-5/6 m-auto mb-10" src={blog.postImage} />

          <div className="text-xl">{blog.content}</div>
        </div>
      </div>
    </>
  );
};

export default BlogDetail;
