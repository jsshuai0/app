package com.anthole.album.utils;

import android.graphics.Bitmap.Config;

import com.anthole.album.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

public class Constants {
	
	public final static boolean DEVELOPER_MODE = true;
	
	public final static int ID_Splash_Female = R.drawable.album_62_splash;
	
	public final static int ID_Splash_Male = R.drawable.album_61_splash;
	
	public final static int ID_Splash_Together = R.drawable.album_63_splash;
	
	
	
	public final static DisplayImageOptions optionsSplash = new DisplayImageOptions.Builder()
	.cacheInMemory(true)
	.cacheOnDisk(false)
	.considerExifParams(true)
	.bitmapConfig(Config.RGB_565)
	.build();

//	1-16
//	17

}
