package com.nowcoder.community.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailClient {
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
//        SimpleMailMessage message = new SimpleMailMessage();
        try {
            helper.setFrom(from); //发件人
            helper.setTo(to);//收件人
            helper.setSubject(subject); //标题
            helper.setText(content,true);
            mailSender.send(helper.getMimeMessage());
            System.out.println("简单邮件发送成功！");//
        } catch (MessagingException e) {
            System.out.println("发送简单邮件时发生异常！" + e);
        }


    }
}
