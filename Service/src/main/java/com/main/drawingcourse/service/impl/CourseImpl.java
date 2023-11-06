package com.main.drawingcourse.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponsePostByCate;
import com.main.drawingcourse.entity.Post;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.converter.CourseConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.DrawingCategoryRepository;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.ICourseService;

@Service
public class CourseImpl implements ICourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	DrawingCategoryRepository categoryRepository;

	@Autowired
	CourseConverter courseConverter;

	@Autowired
	LevelRepository levelRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DrawingCategoryRepository drawingCategoryRepository;
	
	@Autowired
	LessonRepository lessonRepository;

	@Override
	public Course getReferenceById(Integer id) {
		return courseRepository.getReferenceById(id);
	}

	@Override
	public CourseModel AddCourse(CourseModel courseModel) {
		Course existingCourse = courseRepository.findCoursesByTitleAndInstructorID(courseModel.getTitle(),
				courseModel.getInstructorId());
		List<User> instructor = userRepository.findAllInstructor();
		if (existingCourse != null) {
			throw new IllegalArgumentException("Course already exists");
		}

		// Kiểm tra và khởi tạo drawing category
		DrawingCategory categoryEntity = categoryRepository.findOneByDrawCategoryId(courseModel.getDrawCategoryId());
		if (categoryEntity == null) {
			throw new IllegalArgumentException("Invalid drawing category");
		}

		// Chuyển đổi courseModel thành entity và thiết lập drawing category
		Course courseEntity = courseConverter.toEntity(courseModel);
		courseEntity.setDrawingCategory(categoryEntity);

		// Lưu courseEntity
		courseEntity = courseRepository.save(courseEntity);

		// Trả về courseModel đã được chuyển đổi từ entity
		return courseConverter.toDTO(courseEntity);
	}

	@Override
	public List<ResponseCourse> findByCourseTitle(String title) {
		List<ResponseCourse> courseModels = courseRepository.findCoursesByTitle(title).stream()
				.map(courseConverter::toResponse).collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public CourseModel GetCoursebyid(int id) {
		var course = courseRepository.findById(id).orElse(null);
		if (course != null) {
			return courseConverter.toDTO(course);

		}
		return new CourseModel();
	}

	@Override
	public List<ResponseCourse> findAll() {
		List<ResponseCourse> courseModels = courseRepository.findAll().stream().map(courseConverter::toResponse)
				.collect(Collectors.toList());

		return courseModels;

	}

	@Override
	public List<ResponseCourse> findCourseByInstructorID(int instructorId) {
		List<Course> courseEntities = courseRepository.findAllCoursesByInstructorId(instructorId);
		List<ResponseCourse> courseModels = courseEntities.stream().map(courseConverter::toResponse)
				.collect(Collectors.toList());

		return courseModels;

	}

	@Override

	public void DeleteCoursebyid(int id) {
		lessonRepository.deleteLessonsByCourseId(id);
		courseRepository.deleteById(id);
	}

	@Override
	public void UpdateCourse(CourseModel CourseModel) {
		Course course = courseConverter.toEntity(CourseModel);

		if (course != null) {
			// Update the course entity with data from CourseModel
			course.setDescription(CourseModel.getDescription());
			course.setPrice(CourseModel.getPrice());
			course.setRating(CourseModel.getRating());
			course.setTitle(CourseModel.getTitle());

			// Update the drawing category, level, and user, similar to the way you did it
			var draw = drawingCategoryRepository.findById(CourseModel.getDrawCategoryId()).orElse(null);
			if (draw != null) {
				course.setDrawingCategory(draw);
			}

			var level = levelRepository.findById(CourseModel.getLevelId()).orElse(null);
			if (level != null) {
				course.setLevel(level);
			}

			var userByIdAndRole = userRepository.findByIdAndRole(CourseModel.getInstructorId()).orElse(null);
			if (userByIdAndRole != null) {
				course.setUser(userByIdAndRole);
			}

			// Update the courseImage if it's not null in CourseModel
			if (CourseModel.getCourseImage() != null) {
				course.setCourseImage(CourseModel.getCourseImage());
			}
			if (CourseModel.isStatus()) {
				course.setStatus(CourseModel.isStatus());
			}

			// Finally, save the updated course entity
			course = courseRepository.save(course);
		}
	}

	@Override
	public void editCourse(int courseId, CourseModel courseModel) {
		Course existingCourse = courseRepository.findCourseByID(courseId);

		if (existingCourse != null) {
			// Update the existing course with the new data from the courseModel
			BeanUtils.copyProperties(courseModel, existingCourse, "courseId");

			// Save the updated course
			courseRepository.save(existingCourse);
		}
	}

	@Override
	public List<ResponseCourse> findCoursesByPriceRange(double start_price, double end_price) {
		List<Course> courseEntity = courseRepository.findCoursesByPriceRange(start_price, end_price);
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse)
				.collect(Collectors.toList());
		return courseModels;
	}

	@Override
	public List<ResponseCourse> findAllCourseHasOrderByUserId(int id) {
		List<Course> courseEntity = courseRepository.findAllCourseHasOrderByUserId(id);
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse)
				.collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public List<ResponseCourse> findAllCourseOfInstructorByUserName(String name) {
		List<Course> courseEntity = courseRepository.findAllCourseOfInstructorByUserName(name);
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse)
				.collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public List<ResponseCourse> findTop4BestSellerCourse() {
		List<ResponseCourse> courseModels = courseRepository.findTop4BestSellerCourse().stream()
				.map(courseConverter::toResponse).collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public String UpdateStatusOfCourse(int id) {
		Course course = courseRepository.findCourseByID(id);

		if (course != null) {
			if (course.isStatus()) {
				return "The course status is already true";
			} else {
				course.setStatus(true);
				courseRepository.save(course);
				return "Successfully changed the course status";
			}
		}

		return "No course found";
	}

	@Override
	public Course findByCoursebyId(int id) {
		var course = courseRepository.findById(id).orElse(null);
		if (course != null) {
			return course;

		}
		return new Course();
	}

	@Override
	public List<ResponseCourse> viewcoursehasstatustrue() {
		List<ResponseCourse> courseModels = courseRepository.viewcoursewithstatustrue().stream()
				.map(courseConverter::toResponse).collect(Collectors.toList());
		return courseModels;
	}

	@Override
	public List<Course> findByCateIdandLevelId(int cateid, int levelid) {
		return courseRepository.findbycateidandlevelid(cateid, levelid);
	}

	@Override
	public boolean containsResponseCourse(List<ResponseCourse> responseCourseList,
			ResponseCourse desiredResponseCourse) {
		for (ResponseCourse course : responseCourseList) {
			if (course.equals(desiredResponseCourse)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<CourseModel> findCourseByCategoryid(int id) {
		List<Course> courseEntity = courseRepository.findAllPostByPostCategoryID(id);
		List<CourseModel> courseModels = courseEntity.stream().map(courseConverter::toDTO).collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public List<ResponseCourse> coursehasstatus1bycateid(int cateid) {
		List<Course> courseEntity = courseRepository.coursehasstatus1bycateid(cateid);
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse).collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public List<ResponseCourse> coursehasstatustruebylevelid(int levelid) {
		List<Course> courseEntity = courseRepository.coursehasstatustruebylevelid(levelid);
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse).collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public List<ResponseCourse> coursehasstatustruebylevelidandcateid(int cateid, int levelid) {
		List<Course> courseEntity = courseRepository.coursehasstatustruebylevelidandcateid(cateid,levelid);
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse).collect(Collectors.toList());

		return courseModels;	}

	@Override
	public List<ResponseCourse> findAllCourseHasOrderTrueByUserId(int id) {
		List<Course> courseEntity = courseRepository.findAllCourseHasOrderTrueByUserId(id);
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse)
				.collect(Collectors.toList());

		return courseModels;
	}

	@Override
	public List<ResponseCourse> findAllCourseNotVerify(){
		List<Course> courseEntity = courseRepository.viewcoursewithstatusFalse();
		List<ResponseCourse> courseModels = courseEntity.stream().map(courseConverter::toResponse)
				.collect(Collectors.toList());
		return courseModels;
	}
}
