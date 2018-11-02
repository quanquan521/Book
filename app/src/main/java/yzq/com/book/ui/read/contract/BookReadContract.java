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
import yzq.com.book.ui.main.bean.SortBean;

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
        public abstract void getBookMixAToc(String bookId, String viewChapters);
        public abstract void getChapterRead(String link, int currentChapter);
    }
    interface BookReadModel extends CoreBaseModel {
        Observable<BookMixAToc.mixToc> getBookMixAToc(String bookId, String viewChapters);
        Observable<ChapterRead> getChapterRead(String link, int currentChapter);
    }

    interface BookReadView extends CoreBaseView {
         void  showBookToc(BookMixAToc.mixToc bean);
         void  showChapterRead(ChapterRead.Chapter chapter,int currentChapter);
    }
}
