package yzq.com.book.ui.search.presenter;

import com.yzq.mvpframe.utils.ErrorInfoUtils;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import yzq.com.book.bean.SearchDetail;
import yzq.com.book.ui.search.contract.SearchContract;

public class SearchPresenter extends SearchContract.SearchPresenter {
    @Override
    public void onStart() {

    }

    @Override
    public void getSearchResultList(String query) {
        mRxManager.add(mModel.getSearchResultList(query).subscribe(new Consumer<SearchDetail>() {
            @Override
            public void accept(SearchDetail searchDetail) throws Exception {
                mView.showSearchResultList(searchDetail);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.showToast(ErrorInfoUtils.parseHttpErrorInfo(throwable));
            }
        }));

    }
}
