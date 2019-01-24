package yzq.com.book.ui.main.model;
/**
 * Created by 无敌小圈圈
 */

import com.yzq.mvpframe.data.net.RxService;
import com.yzq.mvpframe.utils.helper.RxUtil;

import io.reactivex.Observable;
import yzq.com.book.api.MainApi;
import yzq.com.book.bean.HotWord;
import yzq.com.book.ui.main.contract.MainContract;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/11/26.
 *
 * 描述：
 *
 *
 */
public class SearchFragmentModel implements MainContract.SearchFragmentModel {
    @Override
    public Observable<HotWord> getHotWordList() {
        return RxService.createApi(MainApi.class).getHotWord().compose(RxUtil.rxSchedulerHelper());
    }
}
