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
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yzq.mvpframe.base.CoreBaseFragment;
import com.yzq.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.yzq.mvpframe.widget.recyclerview.BaseViewHolder;
import com.yzq.mvpframe.widget.recyclerview.CoreRecyclerView;
import com.yzq.mvpframe.widget.recyclerview.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.ui.booklist.BookListActivity;
import yzq.com.book.ui.main.adapter.SortFragmentTypeAdapter;
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
    @BindView(R.id.bookRecyclerView)CoreRecyclerView bookRecyclerView;
    @BindView(R.id.sortRecyclerView)RecyclerView sortRecyclerView;

    BaseQuickAdapter maleAdapter;
    BaseQuickAdapter femaleAdapter;
    BaseQuickAdapter pictureAdapter;
    List<CategoryList.MaleBean> maleBeanList=new ArrayList<>();
    List<CategoryList.FemaleBean> femaleBeanList=new ArrayList<>();
    List<CategoryList.PictureBean> pictureBeanList=new ArrayList<>();
    List<String> sortName=new ArrayList<>();
    SortFragmentTypeAdapter sortNameAdapter;
    private int sortPosition=-1;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_rankinglist;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        sortNameAdapter=new SortFragmentTypeAdapter(getContext(), (ArrayList<String>) sortName);
        sortRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        sortRecyclerView.setAdapter(sortNameAdapter);
        maleAdapter=new BaseQuickAdapter<CategoryList.MaleBean, BaseViewHolder>(R.layout.item_catelist,maleBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, CategoryList.MaleBean item) {
                helper.setText(R.id.tv,item.getName());
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(1)).crossFade().into((ImageView) helper.getView(R.id.iv));
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(0)).crossFade().into((ImageView) helper.getView(R.id.iv1));
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(2)).crossFade().into((ImageView) helper.getView(R.id.iv2));

            }
        };
        femaleAdapter= new BaseQuickAdapter<CategoryList.FemaleBean, BaseViewHolder>(R.layout.item_catelist,femaleBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, CategoryList.FemaleBean item) {
                helper.setText(R.id.tv,item.getName());
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(1)).crossFade().into((ImageView) helper.getView(R.id.iv));
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(0)).crossFade().into((ImageView) helper.getView(R.id.iv1));
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(1)).crossFade().into((ImageView) helper.getView(R.id.iv2));
            }
        };
        pictureAdapter= new BaseQuickAdapter<CategoryList.PictureBean, BaseViewHolder>(R.layout.item_catelist,pictureBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, CategoryList.PictureBean item) {
                helper.setText(R.id.tv,item.getName());
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(1)).crossFade().into((ImageView) helper.getView(R.id.iv));
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(0)).crossFade().into((ImageView) helper.getView(R.id.iv1));
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getBookCover().get(2)).crossFade().into((ImageView) helper.getView(R.id.iv2));
            }
        };
        sortNameAdapter.changeState(0);
        sortPosition=0;
        bookRecyclerView.init(new GridLayoutManager(getContext(),3),maleAdapter);
        setListner();
    }


    private void setListner() {
        sortNameAdapter.setOnItemClickListener(new SortFragmentTypeAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                sortNameAdapter. changeState(postion);
                if (0==postion){
                    sortPosition=0;
                    bookRecyclerView.init(new GridLayoutManager(getContext(),3),maleAdapter);
                }else if (1==postion){
                    sortPosition=1;
                    bookRecyclerView.init(new GridLayoutManager(getContext(),3),femaleAdapter);
                }else if (2==postion){
                    sortPosition=2;
                    bookRecyclerView.init(new GridLayoutManager(getContext(),3),pictureAdapter);
                }
            }
        });
        bookRecyclerView.addOnItemClickListener(new OnItemClickListener() {
           @Override
           public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
               Intent intent=new Intent(getContext(),BookListActivity.class);
               Bundle bundle=new Bundle();
               if (0==sortPosition){
                   bundle.putString("title",maleBeanList.get(position).getName());
                   bundle.putString("major",maleBeanList.get(position).getName());
                   bundle.putString("gender","male");
               }else if (1==sortPosition){
                   bundle.putString("title",femaleBeanList.get(position).getName());
                   bundle.putString("major",femaleBeanList.get(position).getName());
                   bundle.putString("gender","female");
               }else if (2==sortPosition){
                   bundle.putString("title",pictureBeanList.get(position).getName());
                   bundle.putString("major",pictureBeanList.get(position).getName());
                   bundle.putString("gender","picture");
               }
               bundle.putString("type","hot");
               bundle.putString("minor","");
               bundle.putInt("start",0);
               bundle.putInt("limit",20);
               intent.putExtras(bundle);
               startActivity(intent);
           }

            @Override
            public void SimpleOnItemLongClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    public    static RankingListFragment newInstance(){
        RankingListFragment fragment=new RankingListFragment();

        return  fragment;
    }

    @Override
    public void initData() {
        sortName.add("男生"); sortName.add("女生"); //sortName.add("漫画");
        mPresenter.getSort();
    }

    @Override
    public void showSort(CategoryList bean) {
        maleBeanList.clear();femaleBeanList.clear();pictureBeanList.clear();
        maleBeanList.addAll(bean.getMale() );femaleBeanList.addAll(bean.getFemale());pictureBeanList.addAll(bean.getPicture());
        maleAdapter.notifyDataSetChanged();femaleAdapter.notifyDataSetChanged();pictureAdapter.notifyDataSetChanged();

    }
}
