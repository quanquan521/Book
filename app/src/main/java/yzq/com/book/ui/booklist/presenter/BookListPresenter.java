package yzq.com.book.ui.booklist.presenter;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.utils.ErrorInfoUtils;

import io.reactivex.functions.Consumer;
import yzq.com.book.ui.booklist.bean.BookBean;
import yzq.com.book.ui.booklist.contract.BookListContract;

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
public class BookListPresenter extends BookListContract.BookListPresenter {
    @Override
    public void onStart() {

    }

    @Override
    public void getBookList(int id) {
        mRxManager.add(mModel.getBookList(id).subscribe(new Consumer<BookBean>() {
            @Override
            public void accept(BookBean bean) throws Exception {
                mView.showBookList(bean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.showError(ErrorInfoUtils.parseHttpErrorInfo(throwable));
            }
        }));

    }
}