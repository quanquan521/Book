package yzq.com.book.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseViewHolder;
import com.hpw.mvpframe.widget.recyclerview.CoreRecyclerView;
import com.hpw.mvpframe.widget.recyclerview.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.bean.SearchDetail;
import yzq.com.book.ui.booklist.BookDetail;
import yzq.com.book.ui.search.contract.SearchContract;
import yzq.com.book.ui.search.model.SearchModel;
import yzq.com.book.ui.search.presenter.SearchPresenter;

public class SearchActivity extends CoreBaseActivity<SearchPresenter,SearchModel>implements SearchContract.SearchView {
    String keyword;
    @BindView(R.id.searchView)SearchView searchView;
    @BindView(R.id.recyclerView)CoreRecyclerView recyclerView;
    BaseQuickAdapter adapter;
    List<SearchDetail.BooksBean> list=new ArrayList<>();



    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
       adapter=new BaseQuickAdapter<SearchDetail.BooksBean,BaseViewHolder>(R.layout.item_search_result_list,list) {
           @Override
           protected void convert(BaseViewHolder helper, SearchDetail.BooksBean item) {
               helper.setText(R.id.tvBookListTitle,item.getTitle());
               Glide.with(SearchActivity.this).load(App.getInstance().setBaseResUrl()+item.getCover()).into((ImageView) helper.getView(R.id.ivBookCover));
               helper.setText(R.id.tvLatelyFollower,item.getLatelyFollower()+"人在追 |");
               helper.setText(R.id.tvRetentionRatio,item.getRetentionRatio()+"%读者留存 | ");
               helper.setText(R.id.tvBookListAuthor,item.getAuthor());

           }
       };
        recyclerView.init(adapter);
        recyclerView.addOnItemClickListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString("bookID",list.get(position).get_id());
                startActivity(BookDetail.class,bundle);
            }

            @Override
            public void SimpleOnItemLongClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                keyword=query;
                mPresenter.getSearchResultList(keyword);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }

    @Override
    protected void initData() {
        mPresenter.getSearchResultList(keyword);
    }

    @Override
    public void initParms(Bundle parms) {
        Intent intent=getIntent();
        keyword=intent.getStringExtra("keyword");


    }
    public  static void startActivity(Context context,String keyword){
        Intent intent=new Intent(context,SearchActivity.class);
        intent.putExtra("keyword",keyword);
        context.startActivity(intent);
    }


    @Override
    public void showSearchResultList(SearchDetail bean) {
        list.clear();
        list.addAll(bean.getBooks());
        adapter.notifyDataSetChanged();
    }
}
