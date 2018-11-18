package yzq.com.book.ui.booklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
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
    @BindView(R.id.rv)RecyclerView rv;
    String gender;
    String type;
    String major;
    String minor;
    int start;
    int limit;
    String title;
    ArrayList <BooksByCats.BooksBean>list=new ArrayList();
    BaseQuickAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_sort;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tv_title.setText(title);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter=new BaseQuickAdapter<BooksByCats.BooksBean,BaseViewHolder>(R.layout.item_subject_book_list_detail,list) {
            @Override
            protected void convert(BaseViewHolder helper, BooksByCats.BooksBean item) {
                helper.setText(R.id.tvBookListTitle,item.getTitle());
                helper.setText(R.id.tvBookAuthor,item.getAuthor());
                helper.setText(R.id.tvBookLatelyFollower,item.getLatelyFollower()+"人在追");
                helper.setText(R.id.tvBookWordCount,"  |  留存率"+item.getRetentionRatio()+"%");
                helper.setText(R.id.tvBookDetail,item.getShortIntro());
                Glide.with(mContext).load(App.getInstance().setBaseResUrl()+item.getCover()).into((ImageView) helper.getView(R.id.ivBookCover));

            }
        };
        rv.setAdapter(adapter);
        setListner();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString("bookID",list.get(position).get_id());
               startActivity(BookDetail.class,bundle);
            }
        });

    }

    private void setListner() {

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
        start=bundle.getInt("start");
        limit=bundle.getInt("limit");

    }

    @Override
    protected void initData() {
        mPresenter.getBookList(gender,type,major,minor,start,limit);
    }

    @Override
    public void showBookList(BooksByCats bean) {
        list.clear();
        list.addAll(bean.getBooks());
        adapter.notifyDataSetChanged();
    }


}
