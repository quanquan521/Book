package yzq.com.book.ui.booklist.contract;
/**
 * Created by 无敌小圈圈
 */

import com.yzq.mvpframe.base.CoreBaseModel;
import com.yzq.mvpframe.base.CoreBasePresenter;
import com.yzq.mvpframe.base.CoreBaseView;

import io.reactivex.Observable;
import yzq.com.book.bean.HotReview;
import yzq.com.book.bean.BookDetail;
import yzq.com.book.bean.BooksByCats;

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
       public abstract void getBookList(String gender, String type, String major, String minor, int start, int limit);
    }
    interface BookListModel extends CoreBaseModel{
        Observable<BooksByCats>getBookList(String gender, String type, String major, String minor, int start, int limit);

    }
    interface BookListView extends CoreBaseView{
        void showBookList(BooksByCats bean);
    }

    abstract class BookDetailPresenter extends CoreBasePresenter<BookDetailModel,BookDetailView>{
        public abstract void getBookDetail(String bookId);
        public abstract void  getHotReview(String bookId);
    }
    interface BookDetailModel extends CoreBaseModel{
        Observable<BookDetail>getBookDetail(String bookId);
        Observable<HotReview>getHotReview(String bookId);
    }
    interface BookDetailView extends CoreBaseView{
        void showBookDetail(BookDetail bean);
        void showHotReview(HotReview bean);
    }
}
