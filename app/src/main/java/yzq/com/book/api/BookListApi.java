package yzq.com.book.api;
/**
 * Created by 无敌小圈圈
 */

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import yzq.com.book.ui.booklist.bean.BookBean;
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
public interface BookListApi {
    @FormUrlEncoded
    @POST("bookList")
    Observable<BookBean> getBookList(@Field("sort_id") int sort_id);
}
