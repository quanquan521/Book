package yzq.com.book.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yzq.com.book.bean.SearchDetail;

public interface SearchApi {
    /**
     * 书籍查询
     *
     * @param query
     * @return
     */
    @GET("/book/fuzzy-search")
    Observable<SearchDetail> searchBooks(@Query("query") String query);
}
