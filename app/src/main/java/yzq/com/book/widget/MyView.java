package yzq.com.book.widget;
/**
 * Created by 无敌小圈圈
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/10/18.
 *
 * 描述：
 *
 *
 */
public class MyView extends View{
    private Paint mPaint;
    private PointF start,end,contro;
    private int centerX,centerY;
    private Context context;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    void  init(Context context){
        this.context=context;
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        start=new PointF(0,0);
        end=new PointF(0,0);
        contro=new PointF(0,0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getSize(widthMeasureSpec);
        int height = getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制数据点和控制点
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.x,start.y,mPaint);
        canvas.drawPoint(end.x,end.y,mPaint);
        canvas.drawPoint(contro.x,contro.y,mPaint);
        //绘制连线
        mPaint.setStrokeWidth(4);
        canvas.drawLine(start.x,start.y,contro.x,contro.y,mPaint);
        canvas.drawLine(contro.x,contro.y,end.x,end.y,mPaint);
        //绘制贝塞尔曲线
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        Path path=new Path();
        path.moveTo(start.x,start.y);
        path.quadTo(contro.x,contro.y,end.x,end.y);
        canvas.drawPath(path,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        contro.x=event.getX();
        contro.y=event.getY();
        invalidate();
        return true;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX=w/2;
        centerY=h/2;
        //初始化起始坐标
        start.x=centerX-300;
        start.y=centerY;
        end.x=centerX+300;
        end.y=centerY;
        contro.x=centerX;
        contro.y=centerY;

    }

    public int getSize(int measureSpec) {
        int defaultSize=0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.AT_MOST:
                defaultSize = Math.min(specSize, 600);
                break;
            case MeasureSpec.EXACTLY:
                defaultSize = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                defaultSize = Math.max(defaultSize, specSize);
        }
        return defaultSize;
    }
}
