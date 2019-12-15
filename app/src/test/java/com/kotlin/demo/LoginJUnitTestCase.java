package com.kotlin.demo;

import com.kotlin.demo.unittesting.LoginCredentials;
import com.kotlin.demo.unittesting.LoginJUnitActivity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(MockitoJUnitRunner.class)
public class LoginJUnitTestCase {

    @Mock
    LoginCredentials loginCredentials;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        loginCredentials = new LoginCredentials();
        loginCredentials.setMobile("605-8889999");
        loginCredentials.setEmail("sukumar031@gmail.com");
        loginCredentials.setPassword("12345678");
    }

    @Test
    @After
    public void VALIDATE_LOGIN_CREDENTIALS_RETURN(){
       Assert.assertEquals(loginCredentials!=null, true);
    }

    @Test
    @After
    public void VALIDATE_LOGIN_CREDENTIALS_EMAIL_NOT_NULL(){
        Assert.assertEquals(loginCredentials.getEmail()!=null, true);
    }

    @Test
    public void VALIDATE_LOGIN_CREDENTIALS_EMAIL_IS_EMPTY(){
        Assert.assertEquals(loginCredentials.getEmail().length()>0, true);
    }

    @Test
    public void VALIDATE_LOGIN_CREDENTIALS_MOBILE_NOT_NULL(){
        Assert.assertEquals(loginCredentials.getEmail()!=null, true);
    }

    @Test
    public void VALIDATE_LOGIN_CREDENTIALS_MOBILE_IS_EMPTY(){
        Assert.assertEquals(loginCredentials.getEmail().length()>0, true);
    }

    @Test
    public void VALIDATE_LOGIN_CREDENTIALS_MOBILE_IS_VALID(){
        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
        Matcher matcher = pattern.matcher(loginCredentials.getMobile());
        Assert.assertEquals(matcher.matches(), true);
    }
}
