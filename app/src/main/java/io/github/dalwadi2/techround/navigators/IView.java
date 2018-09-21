package io.github.dalwadi2.techround.navigators;

/**
 * View part of MVVM, the activities and fragment implement this
 * and is is used for interaction between ViewModel and Activities/Fragments
 * Created Date: 22-09-2018
 */

public interface IView {

    void error(Throwable e, boolean isNetworkIssue);
}
