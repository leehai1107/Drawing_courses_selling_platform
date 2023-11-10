package com.main.drawingcourse.controller;

import java.util.List;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.main.drawingcourse.converter.CourseConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.service.ICourseService;

@RestController
@RequestMapping("public/course")
public class CourseController {
	@Autowired
	ICourseService CourseService;

	@Autowired
	CourseConverter courseConverter;

	@PostMapping(value = "/addCourse")
	public CourseModel AddCourse(@RequestBody CourseModel courseModel) {
		return CourseService.AddCourse(courseModel);
	}

	@GetMapping(value = "/find-by-title")
	public List<ResponseCourse> findByCourseName(@RequestParam("title") String title) {
		return CourseService.findByCourseTitle(title);
	}

	@GetMapping("/view")

	public List<ResponseCourse> findAll() {

		return CourseService.findAll();
	}


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id) {
        try {
            CourseService.DeleteCoursebyid(id);
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@PutMapping("/edit/{id}")
	public void updateCourse(@PathVariable int id, @RequestBody CourseModel courseModel) {
		CourseModel courseModel1 = CourseService.GetCoursebyid(id);
		if (courseModel != null) {
			courseModel1.setTitle(courseModel.getTitle());
			courseModel1.setDescription(courseModel.getDescription());
			courseModel1.setPrice(courseModel.getPrice());
			courseModel1.setRating(courseModel.getRating());
			courseModel1.setLevelId(courseModel.getLevelId());
			courseModel1.setDrawCategoryId(courseModel.getDrawCategoryId());
			courseModel1.setInstructorId(courseModel.getInstructorId());
			courseModel1.setStatus(courseModel1.isStatus());
			// Update the courseImage if it's not null in CourseModel
			if (courseModel.getCourseImage() != null) {
				courseModel1.setCourseImage(courseModel.getCourseImage());
			}

			CourseService.UpdateCourse(courseModel1);
		}
	}

	@GetMapping(value = "/find-Course-By-PriceRange/{start_price}/{end_price}")
	public List<ResponseCourse> findCourseByPriceRange(@PathVariable("start_price") double start_price,
			@PathVariable("end_price") double end_price) {
		return CourseService.findCoursesByPriceRange(start_price, end_price);
	}

	@GetMapping(value = "/find-Course-Has-Order/{id}")
	public List<ResponseCourse> findAllCourseHasOrderByUserId(@PathVariable int id) {
		return CourseService.findAllCourseHasOrderByUserId(id);
	}

	@GetMapping("/find-by-InstructorId/{id}")
	public List<ResponseCourse> getCoursesByInstructorId(@PathVariable int id) {
		return CourseService.findCourseByInstructorID(id);
	}

	@GetMapping(value = "/find-Course-Of-Instructor-By-UserName")
	public List<ResponseCourse> findAllCourseOfInstructorByUserName(@RequestParam("name") String name) {
		return CourseService.findAllCourseOfInstructorByUserName(name);
	}

	@GetMapping(value = "/find-Top4-Best-Seller-Course")
	public List<ResponseCourse> findTop4BestSellerCourse() {
		return CourseService.findTop4BestSellerCourse();
	}

	//View course has status == true
	@GetMapping("/coursestatustrue")

	public List<ResponseCourse> viewcoursehasstatustrue() {

		return CourseService.viewcoursehasstatustrue();
	}

	@GetMapping("/get")
	public ResponseCourse findCourseById(@RequestParam int courseid, @RequestParam int userid) {
		ResponseCourse result = courseConverter.toResponse(CourseService.getReferenceById(courseid));
		List<ResponseCourse> list = CourseService.findAllCourseHasOrderByUserId(userid);
		if (CourseService.containsResponseCourse(list, result)) {
			result.setHasorder(true);
		}
		return result;
	}

	@PutMapping("/update-status/{id}")
	public ResponseEntity<String> updateStatusOfCourseById(@PathVariable("id") int id) {
		String result = CourseService.UpdateStatusOfCourse(id);
		if (result.equals("Successfully changed the course status")) {
			return ResponseEntity.ok(result);
		} else if (result.equals("The course status is already true")) {
			return ResponseEntity.badRequest().body(result);
		} else if (result.equals("No course found")) {
			return ResponseEntity.badRequest().body(result);
		}
		return null;
	}

	@GetMapping("/find")
	public List<ResponseCourse> getCoursesByCategoryAndLevel(@RequestParam("category") int categoryId,
			@RequestParam("level") int levelId) {
		return courseConverter.toResponseList(CourseService.findByCateIdandLevelId(categoryId, levelId));
	}

	@GetMapping(value = "/find-courses-by-category/{id}")
	public List<CourseModel> findCourseBycategoryID(@PathVariable int id) {
		return CourseService.findCourseByCategoryid(id);

	}
	@GetMapping("/getcourse/{courseid}")
	public ResponseCourse getCourse(@PathVariable int courseid) {
		ResponseCourse result = courseConverter.toResponse(CourseService.getReferenceById(courseid));
		return result;
	}

	@GetMapping(value = "/course-status-1/by-cateid/{id}")
	public List<ResponseCourse> findcoursestatus1bycateid(@PathVariable int id) {
		return CourseService.coursehasstatus1bycateid(id);
	}

	@GetMapping(value = "/course-status-1/by-levelid/{id}")
	public  List<ResponseCourse> findcoursestatus1bylevelid(@PathVariable int id) {
		return CourseService.coursehasstatustruebylevelid(id);
	}

	@GetMapping(value = "/course-status-1/{cateid}/{levelid}")
	public  List<ResponseCourse> viewcoursestatus1bylevelidandcateid(@PathVariable int cateid, @PathVariable int levelid) {
		return CourseService.coursehasstatustruebylevelidandcateid(cateid,levelid);
	}
	
	@GetMapping(value = "/coursenotverify")
	public List<ResponseCourse> viewCourseNotVerify(){
		return CourseService.findAllCourseNotVerify();
	}

	@PatchMapping("/{id}/toggle-status")
	public ResponseEntity<String> toggleCourseStatus(@PathVariable int id) {
		CourseService.toggleCourseStatus(id);
		return ResponseEntity.ok("Course status toggled successfully");
	}
}
