package yzq.com.book.ui.booklist.presenter;

import com.hpw.mvpframe.RxManager;
import com.hpw.mvpframe.utils.ErrorInfoUtils;

import io.reactivex.functions.Consumer;
import yzq.com.book.ui.booklist.bean.BookDetail;
import yzq.com.book.ui.booklist.bean.BooksByCats;
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
    public void onStart() {

    }
}
