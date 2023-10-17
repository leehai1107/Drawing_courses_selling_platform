import { useParams } from "react-router-dom";
import { Blogs } from "../data/Blogs";

const BlogDetail = () => {
  const { index } = useParams();

  let blogIndex = index ? index : "0";

  const blog = Blogs[Number.parseInt(blogIndex)];
  return (
    <>
      <div className="pt-40 px-32">
        <div className="text-lg w-5/6 m-auto">
          <span className="px-5 bg-neutral-300 font-semibold rounded-xl mr-3">
            {blog.type}
          </span>
          <span className="px-5 bg-neutral-300 font-semibold rounded-xl">
            {blog.createdDate}
          </span>
        </div>

        <div className="mb-20">
          <div className="text-5xl font-semibold my-10 w-5/6 m-auto">
            {blog.title}
          </div>

          <img className="w-5/6 m-auto mb-10" src={blog.image} />

          <div className="text-xl">{blog.content}</div>
        </div>
      </div>
    </>
  );
};

export default BlogDetail;
