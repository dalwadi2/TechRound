package io.github.dalwadi2.techround.navigators;


import java.util.List;

import io.github.dalwadi2.techround.models.RespProducts;

/**
 * Created by: Harsh Dalwadi - Software Engineer
 * Created Date: 22-09-2018
 */
public interface ListProductNavigator extends IView {
    void load(List<RespProducts> products);
}
