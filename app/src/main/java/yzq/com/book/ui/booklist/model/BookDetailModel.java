package yzq.com.book.ui.booklist.model;

import com.yzq.mvpframe.data.net.RxService;
import com.yzq.mvpframe.utils.helper.RxUtil;

import io.reactivex.Observable;
import yzq.com.book.api.BookListApi;
import yzq.com.book.bean.HotReview;
import yzq.com.book.ui.booklist.bean.BookDetail;
import yzq.com.book.ui.booklist.bean.BooksByCats;
import yzq.com.book.ui.booklist.contract.BookListContract;

public class BookDetailModel implements BookListContract.BookDetailModel {

    @Override
    public Observable<BookDetail> getBookDetail(String bookId) {
        return RxService.createApi(BookListApi.class).getBookDetail(bookId).compose(RxUtil.rxSchedulerHelper());
    }

    @Override
    public Observable<HotReview> getHotReview(String bookId) {
        return RxService.createApi(BookListApi.class).getHotReview(bookId).compose(RxUtil.rxSchedulerHelper());
    }
}
