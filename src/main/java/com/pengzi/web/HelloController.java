package com.pengzi.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private JavaMailSender mailSender;
	
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    
	
	
    @RequestMapping("/send")
    public String  sendSimpleMail() throws Exception {
		
        try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("492782442@qq.com");
			message.setTo("1497187976@qq.com");
			message.setSubject("主题：励志程序员");
			message.setText("一分钟掌握邮件发送");
			mailSender.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("发送失败:" + e.getMessage());
			return "send error:" + e.getMessage();
		}
        return "send success";
        
    }

}