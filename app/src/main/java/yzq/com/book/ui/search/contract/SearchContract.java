package yzq.com.book.ui.search.contract;

import com.yzq.mvpframe.base.CoreBaseModel;
import com.yzq.mvpframe.base.CoreBasePresenter;
import com.yzq.mvpframe.base.CoreBaseView;

import io.reactivex.Observable;
import yzq.com.book.bean.SearchDetail;

public interface SearchContract  {
     abstract class  SearchPresenter extends CoreBasePresenter<SearchModel,SearchView> {
         public abstract void getSearchResultList(String query);

    }
    interface SearchModel extends CoreBaseModel{
        Observable<SearchDetail> getSearchResultList(String query);

    }
    interface SearchView extends CoreBaseView{
         void  showSearchResultList(SearchDetail bean);
    }

}
