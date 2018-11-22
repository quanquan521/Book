package yzq.com.book.ui.read;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.hpw.mvpframe.base.CoreBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yzq.com.book.App;
import yzq.com.book.Constant;
import yzq.com.book.R;
import yzq.com.book.bean.BookMixAToc;
import yzq.com.book.bean.ChapterRead;
import yzq.com.book.bean.Recommend;
import yzq.com.book.manager.CacheManager;
import yzq.com.book.manager.SettingManager;
import yzq.com.book.manager.ThemeManager;
import yzq.com.book.ui.read.contract.BookReadContract;
import yzq.com.book.ui.read.model.BookReadModel;
import yzq.com.book.ui.read.presenter.BookReadPresenter;
import yzq.com.book.util.LogUtils;
import yzq.com.book.util.ScreenUtils;
import yzq.com.book.util.SharedPreferencesUtil;
import yzq.com.book.widget.readview.BaseReadView;
import yzq.com.book.widget.readview.NoAimWidget;
import yzq.com.book.widget.readview.OnReadStateChangeListener;
import yzq.com.book.widget.readview.OverlappedWidget;
import yzq.com.book.widget.readview.PageWidget;

public class ReadActivity extends CoreBaseActivity<BookReadPresenter,BookReadModel> implements BookReadContract.BookReadView {
    @BindView(R.id.fl_page)FrameLayout flReadWidget;
    @BindView(R.id.rlBookReadRoot) RelativeLayout mRlBookReadRoot;
    private BaseReadView mPageWidget;
    private String bookId;
    /**
     * 是否开始阅读章节
     **/
    private boolean startRead = false;
    /*章节集合*/
    private List<BookMixAToc.mixToc.Chapters> mChapterList = new ArrayList<>();
    /*当前章节*/
    private int currentChapter = 1;
  //  private TocListAdapter mTocListAdapter;
    /*夜间 白天模式*/
    private int curTheme = -1;
    public static final String INTENT_BEAN = "recommendBooksBean";
    public static final String INTENT_SD = "isFromSD";
    private Recommend.RecommendBooks recommendBooks;


    @Override
    public int getLayoutId() {
        return R.layout.activity_read;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initPagerWidget();
    }
    public static void startActivity(Context context, Recommend.RecommendBooks recommendBooks) {
        startActivity(context, recommendBooks, false);
    }

    public static void startActivity(Context context, Recommend.RecommendBooks recommendBooks, boolean isFromSD) {
        context.startActivity(new Intent(context, ReadActivity.class)
                .putExtra(INTENT_BEAN, recommendBooks)
                .putExtra(INTENT_SD, isFromSD));
    }

    @Override
    public void initParms(Bundle parms) {
        Intent intent=getIntent();
        recommendBooks= (Recommend.RecommendBooks) intent.getSerializableExtra(INTENT_BEAN);
        bookId = recommendBooks._id;
    }

    @Override
    protected void initData() {
        mPresenter.getBookMixAToc(bookId, "chapters");
    }

    /*设置模式和seekbar*/
    private void initAASet() {
     /*   curTheme = SettingManager.getInstance().getReadTheme();
        ThemeManager.setReaderTheme(curTheme, mRlBookReadRoot);

        seekbarFontSize.setMax(10);
        //int fontSizePx = SettingManager.getInstance().getReadFontSize(bookId);
        int fontSizePx = SettingManager.getInstance().getReadFontSize();
        int progress = (int) ((ScreenUtils.pxToDpInt(fontSizePx) - 12) / 1.7f);
        seekbarFontSize.setProgress(progress);
        seekbarFontSize.setOnSeekBarChangeListener(new SeekBarChangeListener());

        seekbarLightness.setMax(100);
        seekbarLightness.setOnSeekBarChangeListener(new SeekBarChangeListener());
        seekbarLightness.setProgress(ScreenUtils.getScreenBrightness());
        isAutoLightness = ScreenUtils.isAutoBrightness(this);


        this.getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS), true, Brightness);

        if (SettingManager.getInstance().isAutoBrightness()) {
            startAutoLightness();
        } else {
            stopAutoLightness();
        }

        cbVolume.setChecked(SettingManager.getInstance().isVolumeFlipEnable());
        cbVolume.setOnCheckedChangeListener(new ChechBoxChangeListener());

        cbAutoBrightness.setChecked(SettingManager.getInstance().isAutoBrightness());
        cbAutoBrightness.setOnCheckedChangeListener(new ChechBoxChangeListener());

        gvAdapter = new ReadThemeAdapter(this, (themes = ThemeManager.getReaderThemeData(curTheme)), curTheme);
        gvTheme.setAdapter(gvAdapter);
        gvTheme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < themes.size() - 1) {
                    changedMode(false, position);
                } else {
                    changedMode(true, position);
                }
            }
        });*/
    }
    private void initPagerWidget() {
        switch (SharedPreferencesUtil.getInstance().getInt(Constant.FLIP_STYLE, 0)) {
            case 0:
                mPageWidget = new PageWidget(this, bookId, mChapterList, new ReadListener());
                break;
            case 1:
                mPageWidget = new OverlappedWidget(this, bookId, mChapterList, new ReadListener());
                break;
            case 2:
                mPageWidget = new NoAimWidget(this, bookId, mChapterList, new ReadListener());
        }

     //   registerReceiver(receiver, intentFilter);
        if (SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT, false)) {
            mPageWidget.setTextColor(ContextCompat.getColor(this, R.color.chapter_content_night),
                    ContextCompat.getColor(this, R.color.chapter_title_night));
        }
        flReadWidget.removeAllViews();
        flReadWidget.addView(mPageWidget);
    }
/*
加载章节内容*/
    @Override
    public void showBookToc(BookMixAToc bean) {
        mChapterList.clear();
        mChapterList.addAll(bean.mixToc.chapters);
        readCurrentChapter();
    }
    /**
     * 获取当前章节。章节文件存在则直接阅读，不存在则请求
     */
    public void readCurrentChapter() {
        if (CacheManager.getInstance().getChapterFile(bookId, currentChapter) != null) {
            showChapterRead(null, currentChapter);
        } else {
            mPresenter.getChapterRead(mChapterList.get(currentChapter - 1).link, currentChapter);
        }
    }
    public synchronized void showChapterRead(ChapterRead.Chapter data, int chapter) { // 加载章节内容
        if (data != null) {
            CacheManager.getInstance().saveChapterFile(bookId, chapter, data);
        }
        if (!startRead) {
            startRead = true;
            currentChapter = chapter;
            if (!mPageWidget.isPrepared) {
                mPageWidget.init(curTheme);
            } else {
                mPageWidget.jumpToChapter(currentChapter);
            }
         //   hideDialog();
        }
    }

    private class ReadListener implements OnReadStateChangeListener {
        @Override
        public void onChapterChanged(int chapter) {
            LogUtils.i("onChapterChanged:" + chapter);
            currentChapter = chapter;
         //   mTocListAdapter.setCurrentChapter(currentChapter);
            // 加载前一节 与 后三节
            for (int i = chapter - 1; i <= chapter + 3 && i <= mChapterList.size(); i++) {
                if (i > 0 && i != chapter
                        && CacheManager.getInstance().getChapterFile(bookId, i) == null) {
                    mPresenter.getChapterRead(mChapterList.get(i - 1).link, i);
                }
            }
        }

        @Override
        public void onPageChanged(int chapter, int page) {
            LogUtils.i("onPageChanged:" + chapter + "-" + page);
        }

        @Override
        public void onLoadChapterFailure(int chapter) {
            LogUtils.i("onLoadChapterFailure:" + chapter);
            startRead = false;
            if (CacheManager.getInstance().getChapterFile(bookId, chapter) == null){
                //  mPresenter.getChapterRead(mChapterList.get(chapter - 1).link, chapter);
            }

        }

        @Override
        public void onCenterClick() {
            LogUtils.i("onCenterClick");
            //toggleReadBar();
        }

        @Override
        public void onFlip() {
          //  hideReadBar();
        }
    }
    /*private class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (seekBar.getId() == seekbarFontSize.getId() && fromUser) {
               // calcFontSize(progress);
            } else if (seekBar.getId() == seekbarLightness.getId() && fromUser
                    && !SettingManager.getInstance().isAutoBrightness()) { // 非自动调节模式下 才可调整屏幕亮度
                ScreenUtils.saveScreenBrightnessInt100(progress, ReadActivity.this);

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }*/
}
