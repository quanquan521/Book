package yzq.com.book.ui.read.presenter;
/**
 * Created by 无敌小圈圈
 */

import com.yzq.mvpframe.utils.ErrorInfoUtils;

import io.reactivex.functions.Consumer;
import yzq.com.book.bean.BookMixAToc;
import yzq.com.book.bean.ChapterRead;
import yzq.com.book.ui.read.contract.BookReadContract;

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
         mRxManager.add(mModel.getBookMixAToc(bookId,viewChapters).subscribe(new Consumer<BookMixAToc>() {
             @Override
             public void accept(BookMixAToc bookMixAToc) throws Exception {
                 mView.showBookToc(bookMixAToc);
             }
         }, new Consumer<Throwable>() {
             @Override
             public void accept(Throwable throwable) throws Exception {
                 throw new Exception(throwable);
             }
         }));
    }

    @Override
    public void getChapterRead(String url, int currentChapter) {
       mRxManager.add(mModel.getChapterRead(url,currentChapter).subscribe(new Consumer<ChapterRead>() {
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
