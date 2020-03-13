package cc.joe.springboot.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private JavaMailSender jms;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    private String to = "461919397@qq.com";

    private String path = "D:\\Workstation\\IDEA\\joe-spring-demo\\14.springboot-mail\\target\\classes\\static\\document.docx";
    private String inlinePath = "D:\\Workstation\\IDEA\\joe-spring-demo\\14.springboot-mail\\src\\main\\resources\\static\\img\\sunshine.jpg";

    @RequestMapping("sendMail")
    public String sendMail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            setMail(message, "A simple email");
            message.setText("sending email with spring mail");
            jms.send(message);
            return "success sending";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("sendHtmlMail")
    public String sendHtmlMail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helperSetMail(helper, "THIS IS A HTML MAIL");
            StringBuffer sb = new StringBuffer("<p style='color:#6db33f'>使用Spring Boot发送HTML格式邮件。</p>");
            helper.setText(sb.toString(), true);
            jms.send(message);
            return "success sending";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("sendAttachmentMail")
    public String sendAttachmentMail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helperSetMail(helper, "A mail with attachment");
            helper.setText("Details are in attachment");
            FileSystemResource resource = new FileSystemResource(new File(path));
            helper.addAttachment("document.docx",resource);
            jms.send(message);
            return "send successfully";
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch ( Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("sendInlineMail")
    public String sendInlineMail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helperSetMail(helper, "An inline mail");
            helper.setText("<html><body>Blog image：<img src='cid:img'/></body></html>", true);
            FileSystemResource resource = new FileSystemResource(new File(inlinePath));
            helper.addInline("img", resource);
            jms.send(message);
            return "send successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("/sendTemplateMail")
    public String sendTemplateMail(String code) {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helperSetMail(helper, "A mail with template html");
            helper.setText("Test mail template");

            Context context = new Context();
            context.setVariable("code", code);
            String template = templateEngine.process("emailTemplate", context);
            helper.setText(template, true);
            jms.send(message);
            return "send successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    private void setMail(SimpleMailMessage message, String subject) {
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
    }

    private void helperSetMail(MimeMessageHelper helper, String subject) throws MessagingException {
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
    }
}
