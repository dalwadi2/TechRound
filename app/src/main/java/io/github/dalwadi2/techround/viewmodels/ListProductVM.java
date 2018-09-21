package io.github.dalwadi2.techround.viewmodels;

import android.app.Application;

import io.github.dalwadi2.techround.api.service.NetworkService;
import io.github.dalwadi2.techround.navigators.ListProductNavigator;
import io.github.dalwadi2.techround.view.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by: Harsh Dalwadi - Senior Software Engineer
 * Created Date: 22-09-2018
 */
public class ListProductVM extends BaseViewModel<ListProductNavigator> {
    private final Application application;

    public ListProductVM(Application application, NetworkService networkService) {
        super(application, networkService);
        this.application = application;
    }

    public void loadData() {
        getCompositeDisposable().add(getNetworkService().PRODUCTS()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(products -> getNavigator().load(products)
                        , throwable -> getNavigator().error(throwable, false))
        );
    }
}
