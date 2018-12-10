package com.ssmelnikov.demo.controllers.api;

import com.ssmelnikov.demo.entity.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Controller
public class SendQuestionController {
    private final Logger logger = LoggerFactory.getLogger(SendQuestionController.class);

    @Value("${smtp.server}")
    private String smtpServer;
    @Value("${smtp.port}")
    private String smtpPort;
    @Value("${smtp.username}")
    private String username;
    @Value("${smtp.password}")
    private String password;
    @Value("${smtp.mailFrom}")
    private String mailFrom;
    @Value("${smtp.mailTo}")
    private String mailTo;
    @Value("${smtp.subject}")
    private String subject;

    @RequestMapping(value = "/api/send_question", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse sendAnswer(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("text") String text) {
        logger.info("user with name:{}, email:{}, sent question:{}", name, email, text);

        Properties properties = new Properties();
        properties.put("mail.smtp.host"               , smtpServer);
        properties.put("mail.smtp.port"               , smtpPort  );
        properties.put("mail.smtp.auth"               , "true"     );
        properties.put("mail.smtp.ssl.enable"         , "true"     );
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        try {
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };
            Session session = Session.getDefaultInstance(properties,auth);
            session.setDebug(false);

            InternetAddress emailFrom = new InternetAddress(mailFrom);
            InternetAddress emailTo   = new InternetAddress(mailTo);
            Message message = new MimeMessage(session);
            message.setFrom(emailFrom);
            message.setRecipient(Message.RecipientType.TO, emailTo);
            message.setSubject(subject);
            message.setText("Здравствуйте! Пользователь " + name + " c e-mail " + email + " задал Вам вопрос:" + text);
            Transport.send(message);
        } catch (Exception e) {
            logger.error("", e);
            return new ApiResponse(ApiResponse.INTERNAL_SERVER_CODE, "Error Occurred");
        }

        return new ApiResponse(ApiResponse.SUCCESS_CODE, ApiResponse.SUCCESS_DESC);
    }

}
