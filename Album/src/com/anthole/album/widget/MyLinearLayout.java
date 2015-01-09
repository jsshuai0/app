package com.anthole.album.widget;

import com.anthole.album.R;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class MyLinearLayout extends FrameLayout {
	
	Scroller mScroller;
	
	ViewConfiguration configuration ;
	
	int touch_slop;
	
	float startX;
	float startY;
	
	
	float lastX;
	float lastY;
	
	boolean moved;

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mScroller = new Scroller(context);
		configuration = ViewConfiguration.get(context);
		touch_slop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
	}
	
	
	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		if(mScroller.computeScrollOffset()){
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			postInvalidate(); 
		}
		super.computeScroll();
		
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			lastX = startX = event.getX();
			lastY = startY = event.getY();
			
			return true;
		case MotionEvent.ACTION_MOVE:
			
			if(moved){
				
				scrollBy(-(int)(event.getX()-lastX), -(int)(event.getY()-lastY));
				postInvalidate();
				
			}else{
				if(Math.abs(startX-event.getX())>touch_slop||Math.abs(startY-event.getY())>touch_slop){
					moved = true;
				}else{
				}
			}
			lastX = event.getX();
			lastY = event.getY();
			
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			moved = false;
			mScroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), -getScrollY(),300);
			postInvalidate();
			break;
		}
		return super.onTouchEvent(event);
	}



}
