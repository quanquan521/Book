package yzq.com.book.ui.main.contract;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;

import io.reactivex.Observable;
import yzq.com.book.ui.main.bean.CategoryList;

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
}
