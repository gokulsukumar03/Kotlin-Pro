package com.kotlin.demo;

import com.kotlin.demo.base.remote.AppWebServices;
import com.kotlin.demo.base.remote.RetrofitConfig;
import com.kotlin.demo.unittesting.JunitDto;
import com.kotlin.demo.unittesting.MyJUnitActivity;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class MyJUnitTestCase {

    private String HTTP_SUCCESS = "OK";

    @Mock
    private AppWebServices appWebServices;

    @Mock
    MyJUnitActivity mActivity;

    @Before
    public void SETUP() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private JunitDto mJunitDto;


    @Test
    public void fetchUsers(){
        System.out.println("*******************  start");
      appWebServices = RetrofitConfig.Companion.create();
        appWebServices.getUsers()
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())
                .subscribe(new Observer<JunitDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("******************* d");
                    }

                    @Override
                    public void onNext(JunitDto junitDto) {
                        System.out.println("******************* onnext");
                        System.out.println(junitDto.getResponseCode());
                        mJunitDto = junitDto;
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("******************* error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("******************* completed");
                    }
                });


    }

    @After
    @Test
    public void MY_JUNIT_RESPONSE_IS_NULL() {
        Assert.assertEquals(mJunitDto!=null, true);
        System.out.println("******************* ddfd");

    }

    @Test
    public void MY_JUNIT_RESPONSE_CODE_IS_NULL() {
        if (mActivity.getUserData() != null) {
            Assert.assertNull(mActivity.getUserData().getResponseCode());
        }
    }

    @Test
    public void MY_JUNIT_RESPONSE_CODE_IS_EMPTY() {
        if (mActivity.getUserData() != null && mActivity.getUserData().getResponseCode() != null) {
            Assert.assertFalse(mActivity.getUserData().getResponseCode().isEmpty());
        }
    }
    @Test
    public void MY_JUNIT_RESPONSE_CODE_IS_OK() {
        if (mActivity.getUserData() != null && mActivity.getUserData().getResponseCode() != null) {
            Assert.assertSame(mActivity.getUserData().getResponseCode(), HTTP_SUCCESS);
        }
    }

    @Test
    public void MY_JUNIT_RESPONSE_USERS_IS_NULL() {
        if (mActivity.getUserData() != null) {
            Assert.assertNull(mActivity.getUserData().getUsers());
        }
    }

    @Test
    public void MY_JUNIT_RESPONSE_USER_IS_EMPTY() {
        if (mActivity.getUserData() != null && mActivity.getUserData() != null && mActivity.getUserData().getUsers() != null) {
            Assert.assertFalse(mActivity.getUserData().getUsers().size() > 0);
        }
    }

    @Test
    public void MY_JUNIT_RESPONSE_USER_NAME_IS_EMPTY(){
        if (mActivity.getUserData() != null && mActivity.getUserData() != null && mActivity.getUserData().getUsers() != null) {
            for(int i=0; i<mActivity.getUserData().getUsers().size(); i++){
                Assert.assertNull(mActivity.getUserData().getUsers().get(i).getName());
            }
        }
    }

    @Test
    public void MY_JUNIT_RESPONSE_USER_TYPE_IS_EMPTY(){
        if (mActivity.getUserData() != null && mActivity.getUserData() != null && mActivity.getUserData().getUsers() != null) {
            for(int i=0; i<mActivity.getUserData().getUsers().size(); i++){
                Assert.assertNull(mActivity.getUserData().getUsers().get(i).getType());
            }
        }
    }

    @Test
    public void MY_JUNIT_RESPONSE_USER_COMPANY_IS_EMPTY(){
        if (mActivity.getUserData() != null && mActivity.getUserData() != null && mActivity.getUserData().getUsers() != null) {
            for(int i=0; i<mActivity.getUserData().getUsers().size(); i++){
                Assert.assertNull(mActivity.getUserData().getUsers().get(i).getCompany());
            }
        }
    }
}
