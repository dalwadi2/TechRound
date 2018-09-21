package io.github.dalwadi2.techround;

import android.app.Activity;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.github.dalwadi2.techround.di.component.DaggerMyAppComponent;
import io.github.dalwadi2.techround.di.component.MyAppComponent;
import timber.log.Timber;


/**
 * Created by: Harsh Dalwadi - Senior Software Engineer
 * Created Date: 22-09-2018
 */

public class MyApp extends DaggerApplication {
    private static final String TAG = MyApp.class.getSimpleName();

    public static MyApp get(Activity activity) {
        return (MyApp) activity.getApplication();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        MyAppComponent appComponent = DaggerMyAppComponent.builder()
                .application(this)
                .build();
        appComponent.inject(this);
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
