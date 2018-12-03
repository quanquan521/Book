package yzq.com.book.ui.main.fragment;
/**
 * Created by 无敌小圈圈
 */

import android.content.Intent;
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

import java.util.ArrayList;
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
public class SearchFragment extends CoreBaseFragment<SearchFragmentPresenter,SearchFragmentModel>implements MainContract.SearchFragmentView {
    @BindView(R.id.tag_group)TagGroup tag_group;
    int hotIndex = 0;
    @BindView(R.id.et_search)EditText et_search;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND ||
                        (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:
                            if (TextUtils.isEmpty(et_search.getText().toString())){
                               showToast("不能为空！");
                            }else {
                                SearchActivity.startActivity(getContext(),et_search.getText().toString());
                            }
                            return true;
                        default:
                            return true;
                    }
                }

                return false;
            }
        });
        tag_group.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                SearchActivity.startActivity(getContext(),tag);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getHotWordList();

    }
    public    static SearchFragment newInstance(){
        SearchFragment fragment=new SearchFragment();

        return  fragment;
    }

    @Override
    public void showHotWordList(HotWord bean) {
        int tagSize = 8;
        String[] tags = new String[tagSize];
        for (int j = 0; j < tagSize && j < bean.getHotWords().size(); hotIndex++, j++) {
            tags[j] = bean.getHotWords().get(hotIndex % bean.getHotWords().size());
        }
        List<TagColor> colors = TagColor.getRandomColors(tagSize);
        tag_group.setTags(colors, tags);
    }
}
