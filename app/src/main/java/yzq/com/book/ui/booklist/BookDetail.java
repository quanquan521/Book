package yzq.com.book.ui.booklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hpw.mvpframe.base.CoreBaseActivity;

import butterknife.BindView;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.ui.booklist.contract.BookListContract;
import yzq.com.book.ui.booklist.model.BookDetailModel;
import yzq.com.book.ui.booklist.presenter.BookDetailPresenter;

public class BookDetail extends CoreBaseActivity<BookDetailPresenter,BookDetailModel>implements BookListContract.BookDetailView{
    @BindView(R.id.ivBookCover)ImageView ivBookCover;
    @BindView(R.id.tvBookListTitle)TextView tvBookListTitle;
    @BindView(R.id.tvBookListAuthor)TextView tvBookListAuthor;
    @BindView(R.id.tvCatgory)TextView tvCatgory;
    @BindView(R.id.tvWordCount)TextView tvWordCount;
    @BindView(R.id.tvLatelyUpdate)TextView tvLatelyUpdate;
    @BindView(R.id.tvLatelyFollower)TextView tvLatelyFollower;
    @BindView(R.id.tvRetentionRatio)TextView tvRetentionRatio;
    @BindView(R.id.tvSerializeWordCount)TextView tvSerializeWordCount;
    String bookID;


    @Override
    public int getLayoutId() {
        return R.layout.activity_book_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initParms(Bundle parms) {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        bookID=bundle.getString("bookID");
    }

    @Override
    protected void initData() {
        mPresenter.getBookDetail(bookID);
    }

    @Override
    public void showBookDetail(yzq.com.book.ui.booklist.bean.BookDetail bean) {
        Glide.with(this).load(App.getInstance().setBaseResUrl()+bean.getCover()).into(ivBookCover);
        tvBookListTitle.setText(bean.getTitle());
        tvBookListAuthor.setText(bean.getAuthor()+"  |  ");
        tvCatgory.setText(bean.getMajorCate()+"  |  ");
        tvWordCount.setText(bean.getWordCount()+"字");
        tvLatelyUpdate.setText(bean.getUpdated()+"");
        tvLatelyFollower.setText(bean.getLatelyFollower()+"");
        tvRetentionRatio.setText(bean.getRetentionRatio()+"%");
        tvSerializeWordCount.setText(bean.getSerializeWordCount()+"字");




    }
}
