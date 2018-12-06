package yzq.com.book.api;
/**
 * Created by 无敌小圈圈
 */

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import yzq.com.book.bean.HotReview;
import yzq.com.book.ui.booklist.bean.BookDetail;
import yzq.com.book.ui.booklist.bean.BooksByCats;

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

    /*http://api.zhuishushenqi.com*/

    /**
     * 按分类获取书籍列表
     *
     * @param gender male、female
     * @param type   hot(热门)、new(新书)、reputation(好评)、over(完结)
     * @param major  玄幻
     * @param start
     * @param limit  50
     * @return
     */
    @GET("/book/by-categories")
    Observable<BooksByCats> getBooksByCats(@Query("gender") String gender, @Query("type") String type, @Query("major") String major,@Query("start") int start,@Query("limit") int limit);

    @GET("/book/{bookId}")
    Observable<BookDetail> getBookDetail(@Path("bookId") String bookId);

    /**
     * 热门评论
     *
     * @param bookid
     * @return
     */
    @GET("/post/by-book")
    Observable<HotReview> getHotReview(@Query("book") String bookid);
}
