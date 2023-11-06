package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.entity.Course;
import org.springframework.data.repository.query.Param;

public interface ICourseService {
	CourseModel AddCourse(CourseModel courseModel);

	List<ResponseCourse> findByCourseTitle(String title);

	CourseModel GetCoursebyid(int id);

	List<ResponseCourse> findAll();

	List<ResponseCourse> findCourseByInstructorID(int instructor_id);

	void DeleteCoursebyid(int id);

	void UpdateCourse(CourseModel CourseModel);

	void editCourse(int courseId, CourseModel courseModel);

	Course findByCoursebyId(int id);

	List<ResponseCourse> findCoursesByPriceRange(double start_price, double end_price);

	List<ResponseCourse> findAllCourseHasOrderTrueByUserId(int id);

	List<ResponseCourse> findAllCourseHasOrderByUserId(int id);

	List<ResponseCourse> findAllCourseOfInstructorByUserName(String name);

	List<ResponseCourse> findTop4BestSellerCourse();

	String UpdateStatusOfCourse(int id);

	List<ResponseCourse> viewcoursehasstatustrue();

	Course getReferenceById(Integer id);

	List<Course> findByCateIdandLevelId(int cateid, int levelid);

	boolean containsResponseCourse(List<ResponseCourse> responseCourseList, ResponseCourse desiredResponseCourse);

	List<CourseModel> findCourseByCategoryid(int id);

	List<ResponseCourse> coursehasstatus1bycateid(int cateid);

	List<ResponseCourse> coursehasstatustruebylevelid(int levelid);

	List<ResponseCourse> coursehasstatustruebylevelidandcateid(int cateid, int levelid);

	List<ResponseCourse> findAllCourseNotVerify();

}
