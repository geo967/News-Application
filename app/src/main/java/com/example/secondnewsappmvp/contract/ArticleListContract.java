package com.example.secondnewsappmvp.contract;

import com.example.secondnewsappmvp.data.model.ArticlesItem;

import java.util.List;

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