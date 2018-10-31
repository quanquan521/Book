package yzq.com.book.ui.main.presenter;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.utils.ErrorInfoUtils;

import io.reactivex.functions.Consumer;
import rx.functions.Action1;
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
public class MainPresenter extends MainContract.MainPresenter{
    @Override
    public void getSort() {
        mRxManager.add(mModel
                .getSort()
                .subscribe(new Consumer<SortBean>() {
                               @Override
                               public void accept(SortBean data) throws Exception {
                                   mView.showSort(data);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   mView.showError(ErrorInfoUtils.parseHttpErrorInfo(throwable));
                               }
                           }
                ));
    }

    @Override
    public void onStart() {

    }
}
