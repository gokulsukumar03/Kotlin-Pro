package com.kotlin.demo;

import com.kotlin.demo.base.remote.AppWebServices;
import com.kotlin.demo.base.remote.RetrofitConfig;
import com.kotlin.demo.unittesting.JunitDto;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class MyJUnitTestCase {

    private String HTTP_SUCCESS = "OK";

    @Mock
    private AppWebServices appWebServices;

    @Before
    public void SETUP() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private JunitDto mJunitDto;

    @Test
    @Before
    public void fetchUsers(){
        System.out.println("*******************  start");
      appWebServices = RetrofitConfig.Companion.create();
        appWebServices.getUsers()
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())
                .subscribe(new Observer<JunitDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(JunitDto junitDto) {
                        System.out.println("******************* onnext");
                        mJunitDto = junitDto;
                        Assert.assertEquals(mJunitDto!=null, true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("******************* error");
                    }

                    @Override
                    public void onComplete() {
                    }
                });


    }

    @Test
    @After
    public void MY_JUNIT_RESPONSE_IS_NULL() {
        Assert.assertEquals(mJunitDto!=null, true);
        System.out.println("******************* not null executed");
    }
    @Test
    @After
    public void MY_JUNIT_RESPONSE_CODE_IS_NULL() {
        if (mJunitDto != null) {
            Assert.assertEquals(mJunitDto.getResponseCode()!=null, true);
            System.out.println("******************* not null code ");
        }
    }
    @Test
    @After
    public void MY_JUNIT_RESPONSE_CODE_IS_OK() {
        if (mJunitDto != null && mJunitDto.getResponseCode()!=null) {
           Assert.assertEquals(mJunitDto.getResponseCode(), HTTP_SUCCESS);
            System.out.println("*******************" +mJunitDto.getResponseCode());
        }
    }
    @Test
    @After
    public void MY_JUNIT_RESPONSE_USERS_IS_NULL() {
        if (mJunitDto != null) {
            Assert.assertEquals(mJunitDto.getUsers()!=null, true);
            System.out.println("******************* not null users list ");
        }
    }
    @Test
    @After
    public void MY_JUNIT_RESPONSE_USER_IS_EMPTY() {
        if (mJunitDto != null && mJunitDto.getUsers() != null) {
            Assert.assertEquals(mJunitDto.getUsers().size() > 0, true);
            System.out.println("******************* users list size " + mJunitDto.getUsers().size());
        }
    }
    @Test
    @After
    public void MY_JUNIT_RESPONSE_USER_NAME_IS_EMPTY(){
        if (mJunitDto != null && mJunitDto.getUsers() != null && mJunitDto.getUsers().size()>0) {
            for(int i=0; i<mJunitDto.getUsers().size(); i++){
                Assert.assertNotNull(mJunitDto.getUsers().get(i).getName());
                System.out.println("******************* users list size " + mJunitDto.getUsers().get(i).getName());
            }
        }
    }
    @Test
    @After
    public void MY_JUNIT_RESPONSE_USER_TYPE_IS_EMPTY(){
        if (mJunitDto != null && mJunitDto.getUsers() != null && mJunitDto.getUsers().size()>0) {
            for(int i=0; i<mJunitDto.getUsers().size(); i++){
                Assert.assertNotNull(mJunitDto.getUsers().get(i).getType());
            }
        }
    }
    @Test
    @After
    public void MY_JUNIT_RESPONSE_USER_COMPANY_IS_EMPTY(){
        if (mJunitDto != null && mJunitDto.getUsers() != null && mJunitDto.getUsers().size()>0) {
            for(int i=0; i<mJunitDto.getUsers().size(); i++){
                Assert.assertNotNull(mJunitDto.getUsers().get(i).getCompany());
                System.out.println("company " + mJunitDto.getUsers().get(i).getCompany());
            }
        }
    }
}
