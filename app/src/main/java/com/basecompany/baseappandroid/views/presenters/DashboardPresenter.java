package com.basecompany.baseappandroid.views.presenters;

import com.basecompany.baseappandroid.views.BaseView;
import com.basecompany.baseappandroid.views.presenters.base.BasePresenter;

/**
 * Created by Raul Aponte on 17/01/17.
 */
public class DashboardPresenter implements BasePresenter {
    private final DashboardView view;

    public DashboardPresenter(DashboardView view) {
        this.view = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    public interface DashboardView extends BaseView {

    }
}
