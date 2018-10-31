package yzq.com.book.ui.main.model;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;

import io.reactivex.Observable;
import yzq.com.book.api.MainApi;
import yzq.com.book.ui.main.bean.SortBean;
import yzq.com.book.ui.main.contract.MainContract;

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
public class MainModel implements MainContract.MainModel {
    @Override
    public Observable<SortBean> getSort() {
        return RxService.createApi(MainApi.class).getSort().compose(RxUtil.rxSchedulerHelper());
    }
}
