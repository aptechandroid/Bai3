package vn.uits.bai3.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/10/18.
 */

public class DrawableView extends View {
    public DrawableView(Context context) {
        super(context);
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int codePaint = (int) (Math.random() * 4);

        if (codePaint == 0) {
            paint.setColor(Color.BLACK);
        } else if (codePaint == 1) {
            paint.setColor(Color.RED);
        } else if (codePaint == 2) {
            paint.setColor(Color.BLUE);
        } else {
            paint.setColor(Color.YELLOW);
        }

        //(40,20) and (90,80)
        canvas.drawRect(40, 50, 110, 200, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            float x = event.getX();
            float y = event.getY();

            if (x >= 40 && x <= 90 && y >= 20 && y <= 80) {
                invalidate();
            }
        }
        return true;
    }
}
