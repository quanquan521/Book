package yzq.com.book.ui.search;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.widget.recyclerview.BaseItemDraggableAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseSectionQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseViewHolder;
import com.hpw.mvpframe.widget.recyclerview.CoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yzq.com.book.R;
import yzq.com.book.bean.SearchDetail;
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
       adapter=new BaseQuickAdapter<SearchDetail.BooksBean,BaseViewHolder>(R.layout.item_search,list) {
           @Override
           protected void convert(BaseViewHolder helper, SearchDetail.BooksBean item) {
               helper.setText(R.id.tvBookListTitle,item.getTitle());

           }
       };
        recyclerView.init(adapter);
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
        list.addAll(bean.getBooks());
        adapter.notifyDataSetChanged();
    }
}
