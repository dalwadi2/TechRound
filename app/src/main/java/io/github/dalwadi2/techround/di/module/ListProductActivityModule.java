package io.github.dalwadi2.techround.di.module;


import android.app.Application;

import dagger.Module;
import dagger.Provides;
import io.github.dalwadi2.techround.api.service.NetworkService;
import io.github.dalwadi2.techround.viewmodels.ListProductVM;

/**
 * Created by: Harsh Dalwadi - Senior Software Engineer
 * Created Date: 22-09-2018
 */

@Module
public class ListProductActivityModule {

    @Provides
    ListProductVM provideAllCoursesActivityModule(Application application, NetworkService networkService) {
        return new ListProductVM(application, networkService);
    }

}
