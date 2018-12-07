package yzq.com.book.ui.test;
/**
 * Created by 无敌小圈圈
 */

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

import yzq.com.book.R;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/12/7.
 *
 * 描述：
 *
 *
 */
public class MyRefresh extends LinearLayout implements View.OnTouchListener {
    /*
    * 状态定义
    * */
    /**
     * 下拉状态
     */
    public static final int STATUS_PULL_TO_REFRESH = 0;
    /**
     * 释放立即刷新状态
     */
    public static final int STATUS_RELEASE_TO_REFRESH = 1;
    /**
     * 正在刷新状态
     */
    public static final int STATUS_REFRESHING = 2;
    /**
     * 刷新完成或未刷新状态
     */
    public static final int STATUS_REFRESH_FINISHED = 3;

    /*
    * 头部
    * */
    View head;

    /**
     * 下拉头的高度
     */
    private int hideHeaderHeight;

    private Scroller scroller;
    /**
     * 是否已加载过一次layout，这里onLayout中的初始化只需加载一次
     */
    private boolean loadOnce;
    /*
    *
    * 第一个view
    * */

    private RecyclerView recyclerView;

    /**
     * 当前是否可以下拉，只有ListView滚动到头的时候才允许下拉
     */
    private boolean ableToPull=true;

    /**
     * 手指按下时的屏幕纵坐标
     */
    private float yDown;



    public MyRefresh(Context context) {
        super(context);
    }

    public MyRefresh(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        scroller=new Scroller(context);
        head= LayoutInflater.from(context).inflate(R.layout.myrefreshlayout,null,false);
        setOrientation(VERTICAL);
        addView(head);
    }

    /**
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     * 隐藏头布局
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed && !loadOnce) {
            hideHeaderHeight = head.getHeight();
            scrollTo(0,hideHeaderHeight);
            recyclerView = (RecyclerView) getChildAt(1);
            recyclerView.setOnTouchListener(this);
            loadOnce = true;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (ableToPull){
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    yDown=motionEvent.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float yMove = motionEvent.getRawY();
                    int distance = (int) (yMove - yDown);
                    if (distance <= 0 ) {
                        return false;
                    }else {
                        scrollTo(0,-distance);
                    }

                    break;
                case MotionEvent.ACTION_UP:
                    scrollTo(0,hideHeaderHeight);
                    break;

            }
            return true;


        }
        return false;
    }
}
