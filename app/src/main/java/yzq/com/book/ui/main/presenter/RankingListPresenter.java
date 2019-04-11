package yzq.com.book.ui.main.presenter;
/**
 * Created by 无敌小圈圈
 */

import com.yzq.mvpframe.utils.ErrorInfoUtils;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import yzq.com.book.bean.CategoryList;
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
public class RankingListPresenter extends MainContract.MainPresenter{
    @Override
    public void getSort() {
        mRxManager.add(mModel
                .getSort()
                .subscribe(new Consumer<CategoryList>() {
                               @Override
                               public void accept(CategoryList data) throws Exception {
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
