package yzq.com.book.widget.test;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import yzq.com.book.App;
import yzq.com.book.R;

public class PorterImageView extends FrameLayout {
    PointF  mStartPoint,mCurPoint;
    private Paint mPaint;
    private Path mPath;
    private int mRadius=20;
    private boolean mTouch;



    public PorterImageView(Context context) {
        super(context);
        initView(context);
    }

    public PorterImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PorterImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mStartPoint = new PointF(100, 100);
        mCurPoint = new PointF();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        mPath = new Path();

    }
    @Override
    protected void dispatchDraw(Canvas canvas) {

        //canvas.saveLayer(new RectF(0, 0, getWidth(), getHeight()), mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawCircle(mStartPoint.x, mStartPoint.y, mRadius, mPaint);
        if (mTouch) {
            calculatePath();
            canvas.drawCircle(mCurPoint.x, mCurPoint.y, mRadius, mPaint);
            canvas.drawPath(mPath, mPaint);
        }
     //   canvas.restore();
        super.dispatchDraw(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mTouch = true;
            }
            break;
            case MotionEvent.ACTION_UP: {
                mTouch = false;
            }
            case MotionEvent.ACTION_CANCEL:
                mTouch=false;
                postInvalidate();
                break;

        }
        mCurPoint.set(event.getX(), event.getY());
        postInvalidate();
        return true;
    }
    private void calculatePath() {

        float x = mCurPoint.x;
        float y = mCurPoint.y;
        float startX = mStartPoint.x;
        float startY = mStartPoint.y;
        // 根据角度算出四边形的四个点
        float dx = x - startX;
        float dy = y - startY;
        double a = Math.atan(dy / dx);
        float offsetX = (float) (mRadius * Math.sin(a));
        float offsetY = (float) (mRadius * Math.cos(a));

        // 根据角度算出四边形的四个点
        float x1 = startX + offsetX;
        float y1 = startY - offsetY;

        float x2 = x + offsetX;
        float y2 = y - offsetY;

        float x3 = x - offsetX;
        float y3 = y + offsetY;

        float x4 = startX - offsetX;
        float y4 = startY + offsetY;

        float anchorX = (startX + x) / 2;
        float anchorY = (startY + y) / 2;

        mPath.reset();
        mPath.moveTo(x1, y1);
        mPath.quadTo(anchorX, anchorY, x2, y2);
        mPath.lineTo(x3, y3);
        mPath.quadTo(anchorX, anchorY, x4, y4);
        mPath.lineTo(x1, y1);
    }
}
