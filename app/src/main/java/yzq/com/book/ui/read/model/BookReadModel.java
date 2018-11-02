package yzq.com.book.ui.read.model;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;

import io.reactivex.Observable;
import yzq.com.book.api.BookApi;
import yzq.com.book.api.MainApi;
import yzq.com.book.bean.BookMixAToc;
import yzq.com.book.bean.ChapterRead;
import yzq.com.book.ui.main.bean.SortBean;
import yzq.com.book.ui.main.contract.MainContract;
import yzq.com.book.ui.read.contract.BookReadContract;

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
public class BookReadModel implements BookReadContract.BookReadModel {

    /**
     * @param bookId
     * @param viewChapters
     * @return
     */
    @Override
    public Observable<BookMixAToc.mixToc> getBookMixAToc(String bookId, String viewChapters) {
        return RxService.createApiZhuiShu(BookApi.class).getBookMixAToc(bookId,viewChapters).compose(RxUtil.rxSchedulerHelper());
    }

    /**
     * @param link
     * @param currentChapter
     * @return
     */
    @Override
    public Observable<ChapterRead> getChapterRead(String link, int currentChapter) {
        return RxService.createApiZhuiShu1(BookApi.class).getChapterRead(link).compose(RxUtil.rxSchedulerHelper());
    }
}
