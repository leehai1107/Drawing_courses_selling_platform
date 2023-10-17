import { Link } from "react-router-dom"
import { Blogs } from "../data/Blogs"

const BlogsPage = () => {
    return <>
    <div className="pt-36 px-32">
        <div className="font-semibold text-5xl py-10 rounded-2xl bg-lime-500 mb-20 text-center">Blog</div>
        <div>
            {Blogs.map((blog, index) => <>
            <Link to={`/BlogDetail/${index}`} className="h-60 mb-20 block">
            <div><span className="px-5 bg-neutral-300 font-semibold rounded-xl mr-3">{blog.type}</span><span className="px-5 bg-neutral-300 font-semibold rounded-xl">{blog.createdDate}</span></div>
            <div className="flex flex-wrap justify-between">
                <div className="w-8/12">
                    <div className="text-4xl font-semibold">{blog.title}</div>
                    <div className="truncate text-xl">{blog.content}</div>
                </div>
                <div className="w-3/12"><img src={blog.image}/></div>
            </div>
            </Link>
            </>)}
        </div>
    </div>
    </>
}

export default BlogsPage