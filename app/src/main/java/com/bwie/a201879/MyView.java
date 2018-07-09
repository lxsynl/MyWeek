package com.bwie.a201879;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by li li on 2018/7/9.
 */

@SuppressLint("AppCompatCustomView")
public class MyView extends TextView {

    private Paint paint;
    private Path path;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //初始化
    private void init(Context context) {
        paint = new Paint();
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
    }

    private void init(Context context, AttributeSet attrs) {
        init(context);
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
 //视图大小改变后触发
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
        //布局
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //设置事件分发
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float cx = event.getX();
                float cy = event.getY();
                path.moveTo(cx, cy);
                break;
            case MotionEvent.ACTION_MOVE:
                float nx = event.getX();
                float ny = event.getY();
                path.lineTo(nx, ny);
                invalidate();
                break;

        }
        return true;
    }

    //进行绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //通过Bitmap生成画布
        Bitmap bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.img6);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        paint.setColor(Color.LTGRAY);
        canvas.drawPath(path, paint);
//        paint.setAlpha(0);
//
//        Path path = new Path();
//
//        Rect rect = new Rect();

//        canvas.drawRect(0, 0, 500, 500, paint);
    }


}
