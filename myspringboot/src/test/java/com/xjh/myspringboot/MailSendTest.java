package com.xjh.myspringboot;

import com.xjh.myspringboot.enetity.CacheEmp;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * spring boot
 * 邮件发送
 */
@SpringBootTest
public class MailSendTest {

    /**
     * 发送邮件的类
     */
    @Autowired
    private JavaMailSenderImpl javaMailSender;




    /**
     * 发送简单邮件
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("开会通知");
        simpleMailMessage.setText("今晚7点开会");

        simpleMailMessage.setTo("jianhongxu@sina.cn");
        simpleMailMessage.setFrom("363722188@qq.com");

        javaMailSender.send(simpleMailMessage);

    }


    /**
     * 发送带附件的邮件
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("开会通知");
        mimeMessageHelper.setText("<b>今晚7点开会</b>", true);

        mimeMessageHelper.setTo("jianhongxu@sina.cn");
        mimeMessageHelper.setFrom("363722188@qq.com");

        mimeMessageHelper.addAttachment("20170516163534.jpg", new File("D:\\Pictures\\微信图片_20170516163534.jpg"));
        javaMailSender.send(mimeMessage);
    }
}
