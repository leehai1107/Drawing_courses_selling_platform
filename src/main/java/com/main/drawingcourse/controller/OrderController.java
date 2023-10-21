package com.main.drawingcourse.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.entity.Order;
import com.main.drawingcourse.repository.OrderRepository;
import com.main.drawingcourse.service.IOrderService;
import com.main.drawingcourse.vnpay.PaymentResponse;
import com.main.drawingcourse.vnpay.VNPayService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("public/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
	OrderRepository orderRepository;
    @Autowired
	private VNPayService vnPayService;
    
    
    @GetMapping("/view")
    public void view(){
        System.out.printf("hello");
    }
    
    @PostMapping("/payment")
    public PaymentResponse makeOrder(@RequestBody OrderModel orderModel)throws UnsupportedEncodingException {
        OrderModel addedOrder = orderService.addOrder(orderModel);
        
        if (addedOrder != null) {
        	long price = Math.round(addedOrder.getPrice());
        	String paymentUrl = vnPayService.makePayment(price, null, addedOrder.getOrder_code());
        	String code = "00";
        	String message="Success";
            return new PaymentResponse(code, message, paymentUrl);
        } else {
            return new PaymentResponse("01", "Fail", null);
        }
    }
    
    @GetMapping("/vnpay/payment-callback")
    public void paymentCallback(@RequestParam Map<String, String> queryParams,HttpServletResponse response) throws IOException {
        String vnp_ResponseCode = queryParams.get("vnp_ResponseCode");
        String orderCode = queryParams.get("vnp_Data");
        if(orderCode!= null && !orderCode.equals("")) {
            if ("00".equals(vnp_ResponseCode)) {
                // Giao dịch thành công
                // Thực hiện các xử lý cần thiết, ví dụ: cập nhật CSDL
            Order order = orderRepository.findByOrderCode(orderCode);
            if(order!=null) {
                order.setOrderStatus(true);
                orderRepository.save(order);
            }

            response.sendRedirect("http://localhost:5173/info-student");//to done page
            } else {
                // Giao dịch thất bại
                // Thực hiện các xử lý cần thiết, ví dụ: không cập nhật CSDL\
                response.sendRedirect("http://localhost:5173/payment-failed");//to fail page
                
            }
        }        
    }
}
