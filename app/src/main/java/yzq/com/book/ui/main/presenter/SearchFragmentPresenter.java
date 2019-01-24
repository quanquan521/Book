package yzq.com.book.ui.main.presenter;
/**
 * Created by 无敌小圈圈
 */

import com.yzq.mvpframe.utils.ErrorInfoUtils;

import io.reactivex.functions.Consumer;
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
public class SearchFragmentPresenter extends MainContract.SearchFragmentPresenter {
    @Override
    public void onStart() {

    }

    @Override
    public void getHotWordList() {
       mRxManager.add(mModel.getHotWordList().subscribe(new Consumer<HotWord>() {
           @Override
           public void accept(HotWord hotWord) throws Exception {
               mView.showHotWordList(hotWord);
           }
       }, new Consumer<Throwable>() {
           @Override
           public void accept(Throwable throwable) throws Exception {
               mView.showError(ErrorInfoUtils.parseHttpErrorInfo(throwable));
           }
       }));
    }
}
