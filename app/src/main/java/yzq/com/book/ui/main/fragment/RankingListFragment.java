package yzq.com.book.ui.main.fragment;
/**
 * Created by 无敌小圈圈
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpw.mvpframe.base.CoreBaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.ui.booklist.BookListActivity;
import yzq.com.book.ui.main.adapter.CateListAdapter;
import yzq.com.book.ui.main.bean.CategoryList;
import yzq.com.book.ui.main.contract.MainContract;
import yzq.com.book.ui.main.model.RankingListModel;
import yzq.com.book.ui.main.presenter.RankingListPresenter;

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
public class RankingListFragment extends CoreBaseFragment <RankingListPresenter,RankingListModel> implements MainContract.MainView{
    @BindView(R.id.maleRecyclerView)RecyclerView maleRecyclerView;
    @BindView(R.id.femaleRerecyclerView)RecyclerView femaleRerecyclerView;
    @BindView(R.id.pictureRerecyclerView)RecyclerView pictureRerecyclerView;
    BaseQuickAdapter maleAdapter;
    BaseQuickAdapter femaleAdapter;
    BaseQuickAdapter pictureAdapter;
    List<CategoryList.MaleBean> maleBeanList=new ArrayList<>();
    List<CategoryList.FemaleBean> femaleBeanList=new ArrayList<>();
    List<CategoryList.PictureBean> pictureBeanList=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.fragment_rankinglist;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        maleRecyclerView.setHasFixedSize(true);
        maleRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        femaleRerecyclerView.setHasFixedSize(true);
        femaleRerecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        pictureRerecyclerView.setHasFixedSize(true);
        pictureRerecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        maleAdapter=new BaseQuickAdapter<CategoryList.MaleBean, BaseViewHolder>(R.layout.item_catelist,maleBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, CategoryList.MaleBean item) {
                helper.setText(R.id.tv,item.getName());
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(0)).crossFade().into((ImageView) helper.getView(R.id.iv));
            }
        };
        femaleAdapter= new BaseQuickAdapter<CategoryList.FemaleBean, BaseViewHolder>(R.layout.item_catelist,femaleBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, CategoryList.FemaleBean item) {
                helper.setText(R.id.tv,item.getName());
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(0)).crossFade().into((ImageView) helper.getView(R.id.iv));
            }
        };
        pictureAdapter= new BaseQuickAdapter<CategoryList.PictureBean, BaseViewHolder>(R.layout.item_catelist,pictureBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, CategoryList.PictureBean item) {
                helper.setText(R.id.tv,item.getName());
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(0)).crossFade().into((ImageView) helper.getView(R.id.iv));
            }
        };

        maleRecyclerView.setAdapter(maleAdapter);
        femaleRerecyclerView.setAdapter(femaleAdapter);
        pictureRerecyclerView.setAdapter(pictureAdapter);
        setListner();
    }

    private void setListner() {
        maleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(getContext(),BookListActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("title",maleBeanList.get(position).getName());
                bundle.putString("gender","male");
                bundle.putString("type","hot");
                bundle.putString("major",maleBeanList.get(position).getName());
                bundle.putString("minor","");
                bundle.putString("start","0");
                bundle.putString("limit","0");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public    static RankingListFragment newInstance(){
        RankingListFragment fragment=new RankingListFragment();

        return  fragment;
    }

    @Override
    public void initData() {
        mPresenter.getSort();
    }

    @Override
    public void showSort(CategoryList bean) {
        maleBeanList.clear();femaleBeanList.clear();pictureBeanList.clear();
        maleBeanList.addAll(bean.getMale() );femaleBeanList.addAll(bean.getFemale());pictureBeanList.addAll(bean.getPicture());
        maleAdapter.notifyDataSetChanged();femaleAdapter.notifyDataSetChanged();pictureAdapter.notifyDataSetChanged();
    }
}
