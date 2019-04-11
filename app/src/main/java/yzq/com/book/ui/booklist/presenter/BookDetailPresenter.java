package yzq.com.book.ui.booklist.presenter;

import com.yzq.mvpframe.utils.ErrorInfoUtils;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import yzq.com.book.bean.HotReview;
import yzq.com.book.bean.BookDetail;
import yzq.com.book.ui.booklist.contract.BookListContract;

public class BookDetailPresenter extends BookListContract.BookDetailPresenter {

    @Override
    public void getBookDetail(String bookId) {
        mRxManager.add(mModel.getBookDetail(bookId).subscribe(new Consumer<BookDetail>() {
            @Override
            public void accept(BookDetail bookDetail) throws Exception {
                mView.showBookDetail(bookDetail);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.showError(ErrorInfoUtils.parseHttpErrorInfo(throwable));
            }
        }));

    }

    @Override
    public void getHotReview(String bookId) {
        mRxManager.add(mModel.getHotReview(bookId).subscribe(new Consumer<HotReview>() {
            @Override
            public void accept(HotReview hotReview) throws Exception {
                mView.showHotReview(hotReview);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.showError(ErrorInfoUtils.parseHttpErrorInfo(throwable));
            }
        }));
    }

    @Override
    public void onStart() {

    }
}
