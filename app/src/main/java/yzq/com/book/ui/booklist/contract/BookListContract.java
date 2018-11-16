package yzq.com.book.ui.booklist.contract;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;

import io.reactivex.Observable;
import yzq.com.book.ui.booklist.bean.BooksByCats;

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
public interface BookListContract {
    abstract class BookListPresenter extends CoreBasePresenter<BookListModel,BookListView>{
       public abstract void getBookList(String gender, String type, String major, String minor, String start, String limit);
    }
    interface BookListModel extends CoreBaseModel{
        Observable<BooksByCats>getBookList(String gender, String type, String major, String minor, String start, String limit);

    }
    interface BookListView extends CoreBaseView{
        void showBookList(BooksByCats bean);
    }
}
