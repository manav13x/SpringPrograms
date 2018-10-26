package com.verizon.amqpdemo.publisher;

import java.time.LocalDateTime;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMessagePublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		AmqpTemplate template = ctx.getBean(RabbitTemplate.class);
		
		while(true){
			LocalDateTime message1 = LocalDateTime.now();
			//String message = "Hello Everybody! msg#"+i; 
			System.out.println("Sending Message "+message1);
			template.convertAndSend(message1);
			System.out.println("sent!");
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
