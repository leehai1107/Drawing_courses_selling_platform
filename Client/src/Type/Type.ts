export interface userInfo {
  id: number;
  roleInfo: {
    roleId: number;
    roleName: string;
  };
  fullname: string;
}

export interface postCateInfo {
  postCategoryId: number;
  postCategoryName: string;
}

export interface blogCateInfo {
  drawCategoryId: number;
  drawCategoryName: string;
}

export interface levelinfo {
  levelId: number;
  levelName: string;
}

export interface Blog {
  postId: number;
  title: string;
  content: number;
  postDate: string;
  userInfo: userInfo | null;
  cateInfo: postCateInfo | null;
  postImage: string;
}

export interface Course {
  courseid: number;
  description: string;
  price: number;
  title: string;
  rating: number;
  userinfo: userInfo | null;
  levelinfo: levelinfo | null;
  courseImg: string;
  cateInfo: blogCateInfo|null;
}

export interface CartElement {
  Course: Course,
  EnrollDate: Date,
  Teacher: string
}
