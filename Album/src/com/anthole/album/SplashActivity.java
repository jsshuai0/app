package com.anthole.album;


import com.anthole.album.MovieView.KenBurnsView;
import com.anthole.album.MovieView.TransitionGenerator;
import com.anthole.album.MovieView.KenBurnsView.TransitionListener;
import com.anthole.album.MovieView.Transition;
import com.anthole.album.base.BaseActivity;
import com.anthole.album.utils.Constants;
import com.anthole.album.utils.Tool;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

import android.app.Activity;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ViewSwitcher;

public class SplashActivity extends BaseActivity  implements TransitionListener {
	
//ViewSwitcher switcher;
	
KenBurnsView movieView1;
//	
//KenBurnsView movieView2;
	
	private int mTransitionsCount = 0;
	
	private int[] SplashID = new int[]{R.drawable.album_63_splash,R.drawable.album_62_splash,R.drawable.album_61_splash};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_splash);
		findView();
		initView();
		
	}
	
	private void findView(){
//		switcher = (ViewSwitcher) findViewById(R.id.view_switcher);
		
		movieView1 = (KenBurnsView) findViewById(R.id.movie_view1);
		
//		movieView2 = (KenBurnsView) findViewById(R.id.movie_view2);
	}
	
	private void initView(){
		movieView1.setTransitionListener(this);
//		movieView2.setTransitionListener(this);
		
		
		ImageLoader.getInstance().displayImage(Tool.getUriForDrawable(SplashID[0]), movieView1,Constants.optionsSplash);
		
//		ImageLoader.getInstance().displayImage(Tool.getUriForDrawable(SplashID[1]), movieView2,Constants.optionsSplash);
	}

	@Override
	public void onTransitionStart(Transition transition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTransitionEnd(Transition transition) {
		// TODO Auto-generated method stub
		mTransitionsCount++;
		if(mTransitionsCount == 2){
			Intent intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
		}
//		switcher.showNext();
	}

}
