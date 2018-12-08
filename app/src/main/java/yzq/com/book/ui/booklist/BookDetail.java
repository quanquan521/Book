package yzq.com.book.ui.booklist;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.widget.GlideCircleTransform;
import com.hpw.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.bean.HotReview;
import yzq.com.book.bean.Recommend;
import yzq.com.book.manager.CacheManager;
import yzq.com.book.manager.CollectionsManager;
import yzq.com.book.ui.booklist.contract.BookListContract;
import yzq.com.book.ui.booklist.model.BookDetailModel;
import yzq.com.book.ui.booklist.presenter.BookDetailPresenter;
import yzq.com.book.ui.read.ReadActivity;
import yzq.com.book.widget.DrawableCenterButton;
import yzq.com.book.widget.MyScrollView;

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
    @BindView(R.id.tvlongIntro)TextView tvlongIntro;
    @BindView(R.id.btnJoinCollection)DrawableCenterButton collection;
    String bookID;
    private boolean collapseLongIntro = true;
    private Recommend.RecommendBooks recommendBooks;
    @BindView(R.id.rvHotReview)RecyclerView rvHotReview;
    List<HotReview.PostsBean>listHot=new ArrayList<>();
    BaseQuickAdapter adapterHot;
    @Override
    public int getLayoutId() {
        return R.layout.activity_book_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        adapterHot=new BaseQuickAdapter<HotReview.PostsBean,BaseViewHolder>(R.layout.item_book_detai_hot_review_list,listHot) {
            @Override
            protected void convert(BaseViewHolder holder, HotReview.PostsBean item) {
                Glide.with(BookDetail.this).load(App.getInstance().setBaseResUrl()+item.getAuthor().getActivityAvatar()).placeholder(R.drawable.timg).transform(new GlideCircleTransform(BookDetail.this)).into((ImageView) holder.getView(R.id.ivBookCover));
                holder.setText(R.id.tvBookTitle, item.getAuthor().getNickname());
                holder.setText(R.id.tvBookType, "lv."+item.getAuthor().getLv() );
                holder .setText(R.id.tvTitle, item.getTitle());
                holder .setText(R.id.tvContent, String.valueOf(item.getContent()));
            }
        };
        rvHotReview.setLayoutManager(new LinearLayoutManager(this));
        rvHotReview.setAdapter(adapterHot);
    }

    @OnClick(R.id.tvlongIntro)
    public void collapseLongIntro() {
        if (collapseLongIntro) {
            tvlongIntro.setMaxLines(20);
            collapseLongIntro = false;
        } else {
            tvlongIntro.setMaxLines(4);
            collapseLongIntro = true;
        }
    }

    @Override
    public void initParms(Bundle parms) {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        bookID=bundle.getString("bookID");
    }

    @Override
    protected void initData() {
        mPresenter.getHotReview(bookID);
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
        tvlongIntro.setText(bean.getLongIntro());
        recommendBooks = new Recommend.RecommendBooks();
        recommendBooks.title = bean.getTitle();
        recommendBooks._id = bean.get_id();
        recommendBooks.cover = bean.getCover();
        recommendBooks.lastChapter = bean.getLastChapter();
        recommendBooks.updated = bean.getUpdated();
    }

    @Override
    public void showHotReview(HotReview bean) {
        listHot.addAll(bean.getPosts());
        adapterHot.notifyDataSetChanged();
    }

    @OnClick(R.id.btnRead)
    public void onClickRead() {
        if (recommendBooks == null) return;
        ReadActivity.startActivity(this, recommendBooks);
    }
    @OnClick(R.id.btnJoinCollection)
    public void onClickCollection() {
       if (CollectionsManager.getInstance().add(recommendBooks)){
           collection.setBackgroundColor(Color.GRAY);
           collection.setText("已添加");
       } else
           showToast("书架里已存在！");
        collection.setBackgroundColor(Color.GRAY);
        collection.setText("已添加!!!!!");
    }

}
