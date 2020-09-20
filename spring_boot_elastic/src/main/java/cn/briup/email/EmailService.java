package cn.briup.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {
    @Autowired
    JavaMailSenderImpl javaMailSender;//实现对象
    public void sendEmail(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();//简单邮件的对象创建
        mailMessage.setSubject("七夕佳节，良辰美景");//设置邮件主题
        mailMessage.setText("87463789246手感很舒服更加受到广泛世界各地撒旦给");//邮件文本
        mailMessage.setTo("956486587@12306.com");//收件人
        mailMessage.setFrom("197927742@qq.com");//发件人
        javaMailSender.send(mailMessage);
    }
    //带附件的邮件发送
    public  void sendEmail2() throws Exception{
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);//同简单邮件对象一样
        messageHelper.setSubject("今晚月色真美");
        messageHelper.setText("<b>一往情深深几许</b>",true);
        //上传文件
        messageHelper.addAttachment("1.jpg",new File("\u202AC:\\Users\\19792\\Pictures\\Saved Pictures\\.1.jpg"));
        javaMailSender.send(message);//发送文件
    }
}
