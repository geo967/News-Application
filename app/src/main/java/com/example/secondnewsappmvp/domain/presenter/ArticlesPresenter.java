package com.example.secondnewsappmvp.domain.presenter;

import com.example.secondnewsappmvp.data.model.ArticlesItem;
import com.example.secondnewsappmvp.domain.contract.ArticleListContract;
import com.example.secondnewsappmvp.domain.service.ArticleListModel;

import java.util.List;

/**
 * @Class Presenter which implements presenter and model listener
 */

public class ArticlesPresenter implements
        ArticleListContract.Presenter,
        ArticleListContract.Model.OnFinishedListener {

    private ArticleListContract.View articleListView;
    private final ArticleListContract.Model articleListModel;

    public ArticlesPresenter(ArticleListContract.View articleListView) {
        this.articleListView = articleListView;
        articleListModel = new ArticleListModel();
    }

    /**
     * @Method onDestroy() will destroy the list
     */

    @Override
    public void onDestroy() {
        this.articleListView = null;
    }

    /**
     * @param pageNo provides the pageNo
     * @Method getMoreDate() is used for fetching more data from the api upon demand from the user
     */
    @Override
    public void getMoreData(int pageNo) {
        if (articleListView != null) {
            articleListView.showProgress();
        }
        articleListModel.getMovieList(this, pageNo);
    }

    /**
     * @Method requestDataFromServer() is used for fetching more data from the api upon demand from the user
     */
    @Override
    public void requestDataFromServer() {
        if (articleListView != null) {
            articleListView.showProgress();
        }
        articleListModel.getMovieList(this, 1);
    }

    /**
     * @param articleArrayList get the list of articles
     *                         and send the list to set the recycler view
     *                         <p>
     *                         also hide the progress bar spinner if the list is not null
     * @Method OnFinished will send the list of articles to be displayed to the recycler view
     */
    @Override
    public void onFinished(List<ArticlesItem> articleArrayList) {
        articleListView.setDataToRecyclerview(articleArrayList);
        if (articleListView != null) {
            articleListView.hideProgress();
        }
    }

    /**
     * @Method onFailure will throw an exception
     * when the api/response fetch is failed
     * <p>
     * and keep the progressbar spinning if view is null
     */
    @Override
    public void onFailure(Throwable t) {
        articleListView.onResponseFailure(t);
        if (articleListView != null) {
            articleListView.hideProgress();
        }
    }
}
