package com.example.autowireannotation;

import com.example.autowireannotation.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




@SpringBootApplication
public class AutowireannotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutowireannotationApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Payment payment = context.getBean(Payment.class);
		Customer customer = context.getBean(Customer.class);
		System.out.println(payment.getProviderName());
		System.out.println(customer.getName());
		System.out.println(customer.getPayment());
	}

}
