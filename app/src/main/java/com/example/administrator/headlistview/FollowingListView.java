package com.example.administrator.headlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by zdb on 2017/2/8.
 */

public class FollowingListView extends LinearLayout {

    private ListView mListView;
    private FrameLayout mFrameLayout;
    private int mFramenLayoutHeight;
    float downY = 0;
    private float height;
    private float moveHeight;
    private int oldMargin;

    public FollowingListView(Context context) {
        super(context);
    }

    public FollowingListView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public FollowingListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mFrameLayout = (FrameLayout) findViewById(R.id.headListView_Frame);
        mListView = (ListView) findViewById(R.id.headListView_List);
        mFrameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mFramenLayoutHeight = mFrameLayout.getMeasuredHeight();
            }
        });

        mListView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downY = event.getRawY();//float DownY
                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) FollowingListView.this.getLayoutParams();
                        oldMargin = params.topMargin;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        height = event.getRawY();
                        moveHeight = height - downY;
                        setLayoutMoveHeight((int) moveHeight);
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
    }

    private void setLayoutMoveHeight(int f) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.getLayoutParams();
        f = oldMargin + f;
        if (f <= -mFramenLayoutHeight) {
            f = -mFramenLayoutHeight;
        }
        if (f > 0) {
            f = 0;
        }
        params.setMargins(0, f, 0, 0);
        this.setLayoutParams(params);
    }
}
