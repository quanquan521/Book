package yzq.com.book.ui.booklist.model;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;

import io.reactivex.Observable;
import yzq.com.book.api.BookListApi;
import yzq.com.book.ui.booklist.bean.BooksByCats;
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
public class BookListModel implements BookListContract.BookListModel {
    @Override
    public Observable<BooksByCats> getBookList(String gender,String type,String major,String minor,int start,int limit) {
        return RxService.createApi(BookListApi.class).getBooksByCats(gender,type,major,start,limit).compose(RxUtil.rxSchedulerHelper());
    }
}
