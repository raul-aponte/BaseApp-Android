package com.basecompany.baseappandroid;

import com.basecompany.baseappandroid.models.AccessToken;
import com.basecompany.baseappandroid.network.EntityCallback;
import com.basecompany.baseappandroid.network.UserClient;
import com.basecompany.baseappandroid.views.presenters.LoginPresenter;
import com.basecompany.baseappandroid.views.presenters.impl.LoginPresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.doAnswer;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTests {
    private static final String VALID_MAIL = "valid@user.com";
    private static final String VALID_PASS = "validPassword";

    private AccessToken validToken;

    @Before
    public void setUp() {
        validToken = new AccessToken();
        validToken.setId(1);
        validToken.setToken("validToken");
    }

    @Mock
    private LoginPresenter.LoginView loginView;
    @Mock
    private UserClient client;
    @Mock
    private EntityCallback<AccessToken> callback;

    @Test
    public void testLoginSuccessful() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((EntityCallback<AccessToken>)invocation.getArguments()[0]).onSuccess(validToken);
                return null;
            }
        }).when(client).login(VALID_MAIL, VALID_MAIL, callback);
        LoginPresenterImpl presenter = new LoginPresenterImpl(loginView, client);
        presenter.login(VALID_MAIL, VALID_PASS);
    }
}
