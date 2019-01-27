package yzq.com.book.api;
/**
 * Created by 无敌小圈圈
 */

import io.reactivex.Observable;
import retrofit2.http.GET;
import yzq.com.book.bean.HotWord;
import yzq.com.book.bean.CategoryList;

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
public interface MainApi {
    @GET("/cats/lv2/statistics")
    Observable<CategoryList> getCategoryList();
    @GET("/book/hot-word")
    Observable<HotWord> getHotWord();

}
