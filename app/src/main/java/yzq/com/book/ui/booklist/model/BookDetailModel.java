package yzq.com.book.ui.booklist.model;

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;

import io.reactivex.Observable;
import yzq.com.book.api.BookListApi;
import yzq.com.book.ui.booklist.bean.BookDetail;
import yzq.com.book.ui.booklist.bean.BooksByCats;
import yzq.com.book.ui.booklist.contract.BookListContract;

public class BookDetailModel implements BookListContract.BookDetailModel {

    @Override
    public Observable<BookDetail> getBookDetail(String bookId) {
        return RxService.createApi(BookListApi.class).getBookDetail(bookId).compose(RxUtil.rxSchedulerHelper());
    }
}
