package yzq.com.book.ui.booklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.hpw.mvpframe.base.CoreBaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import yzq.com.book.R;
import yzq.com.book.ui.booklist.adapter.PhotoGridViewAdapter;
import yzq.com.book.ui.booklist.bean.BookBean;
import yzq.com.book.ui.booklist.contract.BookListContract;
import yzq.com.book.ui.booklist.model.BookListModel;
import yzq.com.book.ui.booklist.presenter.BookListPresenter;
import yzq.com.book.ui.read.ReadActivity;

public class BookListActivity extends CoreBaseActivity <BookListPresenter,BookListModel> implements BookListContract.BookListView{
    int id;
    String title;
    @BindView(R.id.gridview)GridView gridView;
    PhotoGridViewAdapter adapter;
    ArrayList list=new ArrayList();
    @BindView(R.id.title)TextView tv_title;
    @Override
    public int getLayoutId() {
        return R.layout.activity_book_sort;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tv_title.setText(title);
        adapter=new PhotoGridViewAdapter(this,list,false);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(ReadActivity.class);
            }
        });
    }

    @Override
    public void initParms(Bundle parms) {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        id=bundle.getInt("id");
        title=bundle.getString("title");

    }

    @Override
    protected void initData() {
        mPresenter.getBookList(id);
    }

    @Override
    public void showBookList(BookBean bean) {
        list.clear();
        list.addAll(bean.getData());
        adapter.notifyDataSetChanged();
    }
}
