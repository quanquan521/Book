package yzq.com.book.api;
/**
 * Created by 无敌小圈圈
 */

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
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
    /**
     * 按分类获取书籍列表
     *
     * @param gender male、female
     * @param type   hot(热门)、new(新书)、reputation(好评)、over(完结)
     * @param major  玄幻
     * @param //minor  东方玄幻、异界大陆、异界争霸、远古神话
     * @param //limit  50
     * @return
     */
    @GET("/book/by-categories")
    Observable<BooksByCats> getBooksByCats(@Query("gender") String gender, @Query("type") String type, @Query("major") String major);


}
