package io.github.dalwadi2.techround.api.service;


import java.util.List;

import io.github.dalwadi2.techround.models.RespProducts;
import io.github.dalwadi2.techround.utils.AppConfig;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by: Harsh Dalwadi - Senior Software Engineer
 * Created Date: 22-09-2018
 */

public interface NetworkService {

    @GET(AppConfig.URL.URL_PRODUCTS)
    Observable<List<RespProducts>> PRODUCTS();

}
