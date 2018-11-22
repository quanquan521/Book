package yzq.com.book.ui.main.fragment;
/**
 * Created by 无敌小圈圈
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hpw.mvpframe.base.CoreBaseFragment;

import yzq.com.book.R;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/11/20.
 *
 * 描述：
 *
 *
 */
public class SearchFragment extends CoreBaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {


    }
    public    static SearchFragment newInstance(){
        SearchFragment fragment=new SearchFragment();

        return  fragment;
    }
}
