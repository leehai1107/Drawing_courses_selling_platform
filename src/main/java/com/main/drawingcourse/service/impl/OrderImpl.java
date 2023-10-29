package com.main.drawingcourse.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.converter.CourseConverter;
import com.main.drawingcourse.converter.Course_OrderConverter;
import com.main.drawingcourse.converter.OrderConverter;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.repository.OrderRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.ICourseService;
import com.main.drawingcourse.service.IOrderService;

@Service
public class OrderImpl implements IOrderService {
    @Autowired
    OrderConverter orderConverter;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    Course_OrderRepository courseOrderRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    Course_OrderConverter courseOrderConverter;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseConverter courseConverter;
    @Autowired
    ICourseService courseService;


    @Override
    public OrderModel addOrder(OrderModel orderModel) {
    	
    	List<Integer> courseIdList = orderModel.getCourseIds();
    			List<ResponseCourse> responseCourseList = new ArrayList<>();

    			for (Integer courseId : courseIdList) {
    			    ResponseCourse result = courseConverter.toResponse(courseService.getReferenceById(courseId));
    			    responseCourseList.add(result);
    			}
    			List<ResponseCourse> databaseList = courseService.findAllCourseHasOrderTrueByUserId(orderModel.getUserid());
    	
    	
       if(!hasCommonItems(responseCourseList, databaseList)) {
    	   // Chuyển đổi OrderModel thành Order entity
           Order order = orderConverter.toEntity(orderModel);

           // Kiểm tra xem đơn hàng đã tồn tại trong cơ sở dữ liệu chưa
           Order existingOrder = orderRepository.findByOrderCode(orderModel.getOrder_code());

           if (existingOrder == null) {
               // Lưu đơn hàng vào cơ sở dữ liệu
               order.setOrderCode(order.getOrderCode());
               order.setOrderDate(LocalDate.now());
               order.setOrderStatus(false); // Mặc định là đã đặt hàng
               order = orderRepository.save(order);
               orderConverter.toDTO(order);

               // Tạo danh sách để lưu thông tin các Course_Order đã thêm
               List<Course_Order> addedCourseOrders = new ArrayList<>();

               // Thêm các khóa học vào đơn hàng thông qua Course_Order
               for (Integer courseId : orderModel.getCourseIds()) {
                   Course_Order courseOrder = new Course_Order();
                   Course course = courseRepository.findById(courseId).orElse(null);
                   if (course != null) {
                       courseOrder.setCourse(course);
                       courseOrder.setRating(course.getRating());
                       courseOrder.setRegisteredAt(LocalDate.now());
                       courseOrder.setOrder(order);
                       courseOrderRepository.save(courseOrder);
                       addedCourseOrders.add(courseOrder);
                   }
               }

               // Chuyển đổi danh sách các Course_Order thành danh sách Course_OrderModel
               List<Course_OrderModel> courseOrderModels = addedCourseOrders.stream()
                       .map(courseOrderConverter::toDTO)
                       .collect(Collectors.toList());

               // Trả về OrderModel cùng với danh sách các Course_OrderModel
               OrderModel result = orderConverter.toDTO(order);
               result.setCourseOrders(courseOrderModels);
               return result;
           }

           return null;
       }else {
    	   return null;
       }
    }

    @Override
	public List<Order> getOrderHistoryByUserId(int userId) {
        return orderRepository.findByUser(userRepository.getReferenceById(userId));
    }
    
    private boolean hasCommonItems(List<ResponseCourse> list1, List<ResponseCourse> list2) {
        for (ResponseCourse item : list1) {
            if (list2.contains(item)) {
                return true;
            }
        }
        return false;
    }

}

