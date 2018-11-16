package yzq.com.book.ui.booklist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hpw.mvpframe.base.CoreBaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.ui.booklist.bean.BooksByCats;
import yzq.com.book.ui.booklist.contract.BookListContract;
import yzq.com.book.ui.booklist.model.BookListModel;
import yzq.com.book.ui.booklist.presenter.BookListPresenter;

public class BookListActivity extends CoreBaseActivity <BookListPresenter,BookListModel> implements BookListContract.BookListView{
    @BindView(R.id.title)TextView tv_title;
    String gender;
    String type;
    String major;
    String minor;
    String start;
    String limit;

    String title;
    ArrayList list=new ArrayList();

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_sort;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tv_title.setText(title);

    }

    @Override
    public void initParms(Bundle parms) {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        title=bundle.getString("title");
        gender=bundle.getString("gender");
        type=bundle.getString("type");
        major=bundle.getString("major");
        minor=bundle.getString("minor");
        start=bundle.getString("start");
        limit=bundle.getString("limit");

    }

    @Override
    protected void initData() {
        mPresenter.getBookList(gender,type,major,minor,start,limit);
    }

    @Override
    public void showBookList(BooksByCats bean) {
        list.clear();
        list.addAll(bean.getBooks());
    }


}
