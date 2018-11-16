package yzq.com.book.ui.read.contract;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;

import io.reactivex.Observable;
import yzq.com.book.bean.BookMixAToc;
import yzq.com.book.bean.ChapterRead;

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
public interface BookReadContract {

    abstract class BookReadPresenter extends CoreBasePresenter<BookReadModel,BookReadView>{
        public abstract void getBookMixAToc(String book_id, String viewChapters);
        public abstract void getChapterRead(String book_id, int currentChapter);
    }
    interface BookReadModel extends CoreBaseModel {
        Observable<BookMixAToc.mixToc> getBookMixAToc(String book_id, String viewChapters);
        Observable<ChapterRead> getChapterRead(String book_id, int currentChapter);
    }

    interface BookReadView extends CoreBaseView {
         void  showBookToc(BookMixAToc.mixToc bean);
         void  showChapterRead(ChapterRead.Chapter chapter,int currentChapter);
    }
}
