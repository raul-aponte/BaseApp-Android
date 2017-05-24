package com.basecompany.baseappandroid.presenters;

import com.basecompany.baseappandroid.models.AccessToken;
import com.basecompany.baseappandroid.network.EntityCallback;
import com.basecompany.baseappandroid.network.UserClient;
import com.basecompany.baseappandroid.views.presenters.LoginPresenter;
import com.basecompany.baseappandroid.views.presenters.impl.LoginPresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTests {
    private static final String VALID_MAIL = "valid@user.com";
    private static final String VALID_PASS = "validPassword";

    private AccessToken validToken;

    @Mock
    private LoginPresenter.LoginView loginView = mock(LoginPresenter.LoginView.class);
    @Mock
    private UserClient client;

    @InjectMocks
    private LoginPresenterImpl presenter;

    @Before
    public void setUp() {
        validToken = new AccessToken();
        validToken.setId(1);
        validToken.setToken("validToken");

        presenter = new LoginPresenterImpl(loginView);
        initMocks(this);
    }

    @Test
    public void testLoginSuccessful() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                EntityCallback<AccessToken> callback = invocation.getArgument(2);
                callback.onSuccess(validToken);
                return null;
            }
        }).when(client).login(eq(VALID_MAIL), eq(VALID_PASS), any(EntityCallback.class));

        presenter.login(VALID_MAIL, VALID_PASS);
        verify(loginView, times(1)).loginSucceeded();
    }
}
