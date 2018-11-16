package yzq.com.book.ui.main.adapter;
/**
 * Created by 无敌小圈圈
 */


import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.ui.main.bean.CategoryList;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/11/16.
 *
 * 描述：
 *
 *
 */
public class CateListAdapter extends BaseQuickAdapter<CategoryList.MaleBean,BaseViewHolder> {


    public CateListAdapter(int layoutResId, @Nullable List<CategoryList.MaleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryList.MaleBean item) {


    }
}
