package yzq.com.book.ui.main.fragment;
/**
 * Created by 无敌小圈圈
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.widget.TagColor;
import com.hpw.mvpframe.widget.TagGroup;

import java.util.List;

import butterknife.BindView;
import yzq.com.book.R;
import yzq.com.book.bean.HotWord;
import yzq.com.book.ui.main.contract.MainContract;
import yzq.com.book.ui.main.model.SearchFragmentModel;
import yzq.com.book.ui.main.presenter.SearchFragmentPresenter;
import yzq.com.book.ui.search.SearchActivity;

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
public class CommunityFragment extends CoreBaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_community;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {


    }

    @Override
    public void initData() {


    }
    public    static CommunityFragment newInstance(){
        CommunityFragment fragment=new CommunityFragment();
        return  fragment;
    }

}
