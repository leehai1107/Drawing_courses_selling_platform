package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.Course_OrderConverter;
import com.main.drawingcourse.converter.OrderConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Course_Order;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.repository.OrderRepository;
import com.main.drawingcourse.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.stream.Collectors;

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



    @Override
    public OrderModel addOrder(OrderModel orderModel, List<Integer> courseIds) {
        // Chuyển đổi OrderModel thành Order entity
        Order order = orderConverter.toEntity(orderModel);

        // Kiểm tra xem đơn hàng đã tồn tại trong cơ sở dữ liệu chưa
        Order existingOrder = orderRepository.findByOrderCode(orderModel.getOrder_code());

        if (existingOrder == null) {
            // Lưu đơn hàng vào cơ sở dữ liệu
            order.setOrderDate(LocalDate.now());
            order.setOrderStatus(true); // Mặc định là đã đặt hàng
            order = orderRepository.save(order);
            orderConverter.toDTO(order);

            // Tạo danh sách để lưu thông tin các Course_Order đã thêm
            List<Course_Order> addedCourseOrders = new ArrayList<>();

            // Thêm các khóa học vào đơn hàng thông qua Course_Order
            for (Integer courseId : courseIds) {
                Course_Order courseOrder = new Course_Order();
                courseOrder.setCourse(courseRepository.findById(courseId).orElse(null));
                var rating = courseRepository.findById(courseId).orElse(null);
                courseOrder.setRating(rating.getRating());

                courseOrder.setOrder(order);
                courseOrderRepository.save(courseOrder);

                addedCourseOrders.add(courseOrder);
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
    }



}

