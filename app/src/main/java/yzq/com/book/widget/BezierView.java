package yzq.com.book.widget;
/**
 * Created by 无敌小圈圈
 */

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import yzq.com.book.R;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/12/5.
 *
 * 描述：
 *
 *
 */
public class BezierView extends View  {
    private int mRippleWeight;//一个波的周期长度
    private  int mRippleCount;
    private int mScreenWidth;
    private int mScreenHeight;
    private int mCenterY;//需要展示的位置中线
    private int mOffset;
    private Path mPath;
    private Paint mPaint;
    private ValueAnimator mValueAnimatior;
    public BezierView(Context context) {
        super(context);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(8);
        mPaint.setAntiAlias(true);
        mPaint.setColor(context.getResources().getColor(R.color.colorPrimary));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mPath = new Path();
        mScreenHeight = getMeasuredHeight();
        mScreenWidth = getMeasuredWidth();
        mCenterY =mScreenHeight/2;
        mRippleWeight = mScreenWidth;
        mRippleCount = 4;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.reset();//重置笔画
        mPath.moveTo(-mRippleWeight + mOffset, mCenterY);
        for (int i = 0;i <  mRippleCount;i++) {
            mPath.quadTo(-mRippleWeight * 3 / 4 + i * mRippleWeight + mOffset,mCenterY + 50,-mRippleWeight / 2 + i * mRippleWeight + mOffset,mCenterY);
            mPath.quadTo(-mRippleWeight / 4 + i * mRippleWeight + mOffset,mCenterY - 50,i * mRippleWeight + mOffset,mCenterY);
        }
        mPath.lineTo(mScreenWidth, 0);
        mPath.lineTo(0, 0);
        mPath.close();
        canvas.drawPath(mPath,mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mValueAnimatior = ValueAnimator.ofInt(0, mRippleWeight);
        mValueAnimatior.setDuration(2000);
        mValueAnimatior.setInterpolator(new LinearInterpolator());
        mValueAnimatior.setRepeatCount(ValueAnimator.INFINITE);
        mValueAnimatior.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffset = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        mValueAnimatior.start();
    }
}
