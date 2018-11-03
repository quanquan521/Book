package yzq.com.book.ui.read.presenter;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.utils.ErrorInfoUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import yzq.com.book.bean.BookMixAToc;
import yzq.com.book.bean.ChapterRead;
import yzq.com.book.ui.main.bean.SortBean;
import yzq.com.book.ui.main.contract.MainContract;
import yzq.com.book.ui.read.contract.BookReadContract;
import yzq.com.book.util.StringUtils;

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
public class BookReadPresenter extends BookReadContract.BookReadPresenter{

    @Override
    public void onStart() {

    }

    @Override
    public void getBookMixAToc(String bookId, String viewChapters) {
         mRxManager.add(mModel.getBookMixAToc(bookId,viewChapters).subscribe(new Consumer<BookMixAToc.mixToc>() {
             @Override
             public void accept(BookMixAToc.mixToc mixToc) throws Exception {
                 mView.showBookToc(mixToc);
             }
         }, new Consumer<Throwable>() {
             @Override
             public void accept(Throwable throwable) throws Exception {
             throw   new Exception(throwable);
             }
         }));
    }

    @Override
    public void getChapterRead(String book_id, int currentChapter) {
       mRxManager.add(mModel.getChapterRead(book_id,currentChapter).subscribe(new Consumer<ChapterRead>() {
           @Override
           public void accept(ChapterRead chapterRead) throws Exception {
               mView.showChapterRead(chapterRead.chapter,currentChapter);
           }
       }, new Consumer<Throwable>() {
           @Override
           public void accept(Throwable throwable) throws Exception {
               mView.showError(ErrorInfoUtils.parseHttpErrorInfo(throwable));
           }
       }));
    }
}
