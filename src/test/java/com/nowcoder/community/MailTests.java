package com.nowcoder.community;
import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;
    @Test
    public void testMail() throws MessagingException {
        mailClient.sendSimpleMail("1791283692@qq.com","test","你好");
    }

}
