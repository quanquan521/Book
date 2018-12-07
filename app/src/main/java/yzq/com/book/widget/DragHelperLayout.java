package yzq.com.book.widget;
/**
 * Created by 无敌小圈圈
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

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
public class DragHelperLayout extends LinearLayout {
    private ViewDragHelper mDragHelper;
    private View topView,bottomView;
    int viewH;
    private GestureDetectorCompat gestureDC;
    public DragHelperLayout(Context context) {
        super(context);
    }

    public DragHelperLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mDragHelper = ViewDragHelper.create(this, 10.0f,new DragHelperCallback());
        gestureDC = new GestureDetectorCompat(context,new YSlideDetector());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        topView=getChildAt(0);
        bottomView=getChildAt(1);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean is_y_slide = gestureDC.onTouchEvent(event);
        boolean shouldIntercept = mDragHelper.shouldInterceptTouchEvent(event);
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_DOWN) {
            mDragHelper.processTouchEvent(event);// action_down时就让mDragHelper开始工作，否则有时候导致异常
        }
        return shouldIntercept && is_y_slide;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }
    class DragHelperCallback extends ViewDragHelper.Callback{
        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            return true;
        }

        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            int slideTop = top;
            if (child == topView) {
                if (top > 0) {
                    slideTop = 0;
                }
            } else if (child == bottomView) {
                if (top < 0) {
                    slideTop = 0;
                }
            }
            return child.getTop() + (slideTop - child.getTop());
        }

        @Override
        public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
            int childIndex = 1;
            if (changedView == bottomView) {
                childIndex = 2;
            }
            viewFollowChanged(childIndex, top);
        }

        private void viewFollowChanged(int childIndex, int top) {
            viewH = topView.getMeasuredHeight();
            if (childIndex == 1) {
                int offsetTopBottom = viewH + topView.getTop() - bottomView.getTop();
                bottomView.offsetTopAndBottom(offsetTopBottom);
            } else if (childIndex == 2) {
                int offsetTopBottom = bottomView.getTop() - viewH - topView.getTop();
                topView.offsetTopAndBottom(offsetTopBottom);
            }
            invalidate();
        }

        @Override
        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
            putStickOrDown(releasedChild,-1.0f);
        }


    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(
                resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
                resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
    }

    public static int resolveSizeAndState(int size, int measureSpec,
                                          int childMeasuredState) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case MeasureSpec.AT_MOST:
                if (specSize < size) {
                    result = specSize | MEASURED_STATE_TOO_SMALL;
                } else {
                    result = size;
                }
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result | (childMeasuredState & MEASURED_STATE_MASK);
    }
    private void putStickOrDown(View releasedChild, float yvel) {
        int finalTop = 0; // 默认是粘到最顶端
        if (releasedChild == topView) {
            // 滑动第一个view松开
            finalTop = -viewH;

        } else {
            finalTop = viewH;

        }
        if (mDragHelper.smoothSlideViewTo(releasedChild, 0, finalTop)) {
            ViewCompat.postInvalidateOnAnimation(this);// 会在下一个Frame开始的时候，发起一些invalidate操作
        }
    }
    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
    class YSlideDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            // TODO Auto-generated method stub
            return Math.abs(distanceY) > Math.abs(distanceX);//Y方向绝对值大于X方向，上下滑动
        }
    }


}
