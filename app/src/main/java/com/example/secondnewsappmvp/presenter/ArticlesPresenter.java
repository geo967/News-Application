package com.example.secondnewsappmvp.presenter;

import com.example.secondnewsappmvp.contract.ArticleListContract;
import com.example.secondnewsappmvp.model.ArticlesItem;
import com.example.secondnewsappmvp.service.ArticleListModel;

import java.util.List;

public class ArticlesPresenter implements
        ArticleListContract.Presenter,
        ArticleListContract.Model.OnFinishedListener {

    private ArticleListContract.View articleListView;
    private final ArticleListContract.Model articleListModel;

    public ArticlesPresenter(ArticleListContract.View articleListView) {
        this.articleListView = articleListView;
        articleListModel = new ArticleListModel();
    }

    @Override
    public void onDestroy() {
        this.articleListView = null;
    }

    @Override
    public void getMoreData(int pageNo) {

        if (articleListView != null) {
            articleListView.showProgress();
        }

        articleListModel.getMovieList(this, pageNo);

    }

    @Override
    public void requestDataFromServer() {

        if (articleListView != null) {
            articleListView.showProgress();
        }

        articleListModel.getMovieList(this, 1);

    }

    @Override
    public void onFinished(List<ArticlesItem> articleArrayList) {

        articleListView.setDataToRecyclerview(articleArrayList);

        if (articleListView != null) {
            articleListView.hideProgress();
        }

    }

    @Override
    public void onFailure(Throwable t) {

        articleListView.onResponseFailure(t);

        if (articleListView != null) {
            articleListView.hideProgress();
        }

    }
}
