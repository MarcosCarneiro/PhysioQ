package br.com.stenio.physioq.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import br.com.stenio.physioq.interfaces.RecyclerViewOnClickListener;

public class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
    private Context mContext;
    private GestureDetector mGestureDector;
    private RecyclerViewOnClickListener mRecyclerListener;

    public RecyclerViewTouchListener(Context context, final RecyclerView recyclerView) {
        mContext = context;

        mGestureDector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if(view != null) {
                    mRecyclerListener.onClickListener(recyclerView.getChildAdapterPosition(view));
                }
                return true;
            }
        });
    }

    public RecyclerViewTouchListener(Context context, final RecyclerView recyclerView, RecyclerViewOnClickListener recyclerListener) {
        mContext = context;
        mRecyclerListener = recyclerListener;

        mGestureDector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View view = recyclerView.findChildViewUnder(e.getX(), e.getY());

                if(view != null && mRecyclerListener != null) {
                    mRecyclerListener.onClickListener(recyclerView.getChildAdapterPosition(view));
                }
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
