package yzq.com.book.ui.main.contract;
/**
 * Created by 无敌小圈圈
 */

import com.yzq.mvpframe.base.CoreBaseModel;
import com.yzq.mvpframe.base.CoreBasePresenter;
import com.yzq.mvpframe.base.CoreBaseView;

import io.reactivex.Observable;
import yzq.com.book.bean.HotWord;
import yzq.com.book.bean.CategoryList;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/10/31.
 *
 * 描述：
 *
 *
 */
public interface MainContract {

    abstract class MainPresenter extends CoreBasePresenter<MainModel,MainView>{
        public abstract void getSort();
    }
    interface MainModel extends CoreBaseModel {
        Observable<CategoryList> getSort();
    }

    interface MainView extends CoreBaseView {
        void  showSort(CategoryList bean);
    }
    abstract class SearchFragmentPresenter extends CoreBasePresenter<SearchFragmentModel,SearchFragmentView>{
        public abstract void getHotWordList();
    }
    interface SearchFragmentModel extends CoreBaseModel{
        Observable<HotWord>getHotWordList();

    }
    interface SearchFragmentView extends CoreBaseView{
        void showHotWordList(HotWord bean);
    }
}
