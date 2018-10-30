package com.hpw.mvpframe.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.hpw.mvpframe.AppManager;
import com.hpw.mvpframe.BuildConfig;
import com.hpw.mvpframe.R;
import com.hpw.mvpframe.utils.LogUtil;
import com.hpw.mvpframe.utils.SpUtil;
import com.hpw.mvpframe.utils.StatusBarUtil;
import com.hpw.mvpframe.utils.TUtil;
import com.hpw.mvpframe.utils.ThemeUtil;
import com.hpw.mvpframe.utils.TitleBuilder;
import com.hpw.mvpframe.utils.ToastUtils;
import com.hpw.mvpframe.widget.SwipeBackLayout;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;



public abstract class CoreBaseActivity<T extends CoreBasePresenter, E extends CoreBaseModel> extends SupportActivity {

    protected String TAG;

    public T mPresenter;
    public E mModel;
    protected Context mContext;
    Unbinder binder;

    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏透明
        setStatusBarColor();
        //设置屏幕方向
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        TAG = getClass().getSimpleName();
        //更改主题
        setTheme(ThemeUtil.themeArr[SpUtil.getThemeIndex(this)][
                0]);
        initParms(savedInstanceState);
        this.setContentView(this.getLayoutId());
        binder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof CoreBaseView) mPresenter.attachVM(this, mModel);
        this.initView(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        if (binder != null) binder.unbind();
        if (mPresenter != null) mPresenter.detachVM();
    }

    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    public void setContentView(int layoutResID) {
        if (isOpen()) {
            super.setContentView(layoutResID);
           /* View view = LayoutInflater.from(this)
                    .inflate(layoutResID, null);
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            super.setContentView(view);*/
        } else {
            super.setContentView(getContainer());
            View view = LayoutInflater.from(this).inflate(layoutResID, null);
           //  view.setBackgroundColor(getResources().getColor(R.color.md_lime_500));
            swipeBackLayout.addView(view);
        }
    }

    private View getContainer() {
        //右滑退出
        RelativeLayout container = new RelativeLayout(this);
        swipeBackLayout = new SwipeBackLayout(this);
        swipeBackLayout.setDragEdge(SwipeBackLayout.DragEdge.LEFT);
        ivShadow = new ImageView(this);
       // ivShadow.setBackgroundColor(getResources().getColor(R.color.theme_black_7f));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(swipeBackLayout);
        swipeBackLayout.setOnSwipeBackListener((fa, fs) -> ivShadow.setAlpha(1 - fs));
        return container;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public abstract int getLayoutId();

    public abstract void initView(Bundle savedInstanceState);

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同) fragment 动画
        return new DefaultHorizontalAnimator();

    }
    public void setStatusBarColor() {
        StatusBarUtil.setTransparent(this);
     }
    /**
     * [初始化参数]
     *
     * @param parms
     */
    public abstract void initParms(Bundle parms);

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();//返回上一个fragment
            }
        });
    }

    /**
     * 左侧有返回键的标题栏
     * <p>如果在此基础上还要加其他内容,比如右侧有文字按钮,可以获取该方法返回值继续设置其他内容
     *
     * @param title 标题
     */
    protected TitleBuilder initBackTitle(String title) {
        return new TitleBuilder(this)
                .setTitleText(title)
                .setLeftImage(R.mipmap.ic_back)
                .setLeftOnClickListener(v -> {
                    finish();
                });
    }
    /**
     * 跳转页面,无extra简易型
     *
     * @param tarActivity 目标页面
     */
    public void startActivity(Class<? extends Activity> tarActivity, Bundle options) {
        Intent intent = new Intent(this, tarActivity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, options);
        } else {
            startActivity(intent);
        }
    }
    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    public void startActivity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        startActivity(intent);
    }
    public void showToast(String msg) {
        ToastUtils.showToast(this, msg, Toast.LENGTH_SHORT);
    }
    public void showError(String msg) {
        ToastUtils.showToast(this, msg, Toast.LENGTH_SHORT);
    }


    /**
     * @param msg  显示信息
     * @param b  返回是否取消
     */
   /* public abstract void showLoadingDialog(String msg,boolean b);
    public abstract void dissmissLoadingDialog();*/
}
