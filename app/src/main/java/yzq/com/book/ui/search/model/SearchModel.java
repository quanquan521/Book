package yzq.com.book.ui.search.model;

import com.yzq.mvpframe.data.net.RxService;
import com.yzq.mvpframe.utils.helper.RxUtil;

import io.reactivex.Observable;
import yzq.com.book.api.SearchApi;
import yzq.com.book.bean.SearchDetail;
import yzq.com.book.ui.search.contract.SearchContract;

public class SearchModel implements SearchContract.SearchModel{


    @Override
    public Observable<SearchDetail> getSearchResultList(String query) {
        return RxService.createApi(SearchApi.class).searchBooks(query).compose(RxUtil.rxSchedulerHelper());
    }
}
