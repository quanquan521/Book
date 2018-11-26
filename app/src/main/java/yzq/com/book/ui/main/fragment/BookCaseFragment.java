package yzq.com.book.ui.main.fragment;
/**
 * Created by 无敌小圈圈
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseViewHolder;
import com.hpw.mvpframe.widget.recyclerview.CoreRecyclerView;

import java.util.List;

import butterknife.BindView;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.bean.Recommend;
import yzq.com.book.manager.CollectionsManager;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/11/15.
 *
 * 描述：
 *
 *
 */
public class BookCaseFragment extends CoreBaseFragment {
    @BindView(R.id.recyclerView)CoreRecyclerView recyclerView;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_bookcase;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {


    }

    @Override
    public void initData() {
       List<Recommend.RecommendBooks>list= CollectionsManager.getInstance().getCollectionList();
       recyclerView.init(new GridLayoutManager(getContext(),3),new BaseQuickAdapter<Recommend.RecommendBooks,BaseViewHolder>(R.layout.item_bookcase,list) {
           @Override
           protected void convert(BaseViewHolder helper, Recommend.RecommendBooks item) {
               View view=helper.getConvertView();
               TextView tv=view.findViewById(R.id.tv);
               ImageView iv=view.findViewById(R.id.iv);
               tv.setText(item.title);
               Glide.with(getContext()).load(App.getInstance().setBaseResUrl()+item.cover).into(iv);
           }
       });

    }

    public    static BookCaseFragment newInstance(){
        BookCaseFragment fragment=new BookCaseFragment();
        return  fragment;
    }
}
