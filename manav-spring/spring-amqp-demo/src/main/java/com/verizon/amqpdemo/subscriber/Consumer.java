package com.verizon.amqpdemo.subscriber;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Consumer {
	public void listen(LocalDateTime message) throws Exception
	{
	
		DateTimeFormatter format = DateTimeFormatter.ofPattern( "dd/MM/uuuu HH:mm:ss");
		String mes = format.format(message).toString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 Date date = sdf.parse(mes);
		LocalDateTime ti = LocalDateTime.parse(mes,format);
		System.out.println("Recieved Date Format 1"+date);
		System.out.println("Recieved Date Format 2 "+ti);
		
	}
}
