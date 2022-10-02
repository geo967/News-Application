package com.example.secondnewsappmvp.domain.contract;

import com.example.secondnewsappmvp.data.model.ArticlesItem;

import java.util.List;

/**
 * Contract which helps communication between data layer and view,
 * it contains 3 interfaces Model, View, presenter which is implemented at Presenter and activity
 * respectively
 *
 * @Interface Model contains another interface
 * @Interface OnFinishedListener contains 2 abstract functions
 * @Abstract onFinished
 * @Abstract onFailure
 * @Abstract getMovieList
 * @Interface View interface to be implemented in activity to get data from model to recycler
 * @Abstract showProgress() to show progress bar
 * @Abstract hideProgress() to hide progress bar
 * @Abstract setDataToRecyclerview() to set data to recyclerview
 * @Abstract onResponseFailure() to display api failure message
 * @Interface Presenter to be implemented in presnter class
 * @Abstract requestDataFromServer()
 */

public interface ArticleListContract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(List<ArticlesItem> articleArrayList);

            void onFailure(Throwable t);
        }

        void getMovieList(OnFinishedListener onFinishedListener, int pageNo);
    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerview(List<ArticlesItem> movieListArray);

        void onResponseFailure(Throwable throwable);
    }

    interface Presenter {

        void onDestroy();

        void getMoreData(int pageNo);

        void requestDataFromServer();
    }
}