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

export interface levelModel {
  levelId: number;
  levelName: string;
}

export interface DrawingCategoryModel {
	drawCategoryId: number ;
	drawCategoryName: String ;
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

export interface userModelRespone {
  id:number;
  RoleModelResponse: {roleId:number, roleName:string};
	fullname: string;
}

export interface Course {
  courseId: number;
  description: string;
  price: number;
  title: string;
  rating: number;
  userinfo: userInfo | null;
  levelModel: levelModel | null;
  courseImage: string;
  cateInfo: blogCateInfo|null;
  userModelRespone: userModelRespone|null
}

export interface CartElement {
  Course: Course,
  EnrollDate: Date,
}

export interface Lession {
    lessonId: number;
    title: string ;
    content: string ;
    videoUrl: string ;
    videoduration: Date ;
    lessonstatus: boolean ;
}
