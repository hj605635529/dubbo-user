package com.huangjia.dubbo.user;

import com.huangjia.dubbo.bean.OrderRequest;
import com.huangjia.dubbo.bean.OrderResponse;
import com.huangjia.dubbo.service.OrderServices;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author jia.huang
 * @date 2019/5/25
 */
public class App {
    public static void main( String[] args ) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("order-consumer.xml");

        //用户下单过程
        OrderServices services=(OrderServices)context.getBean("orderServices");

        OrderRequest request=new OrderRequest();
        request.setName("mic");
        OrderResponse response=services.doOrder(request);

        System.out.println(response.getCode());
        System.out.println(response.getMemo());

        //Order.doOrder();
        System.in.read();

        System.out.println("hello world");

    }
}
