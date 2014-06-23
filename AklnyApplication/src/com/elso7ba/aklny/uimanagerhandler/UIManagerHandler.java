package com.elso7ba.aklny.uimanagerhandler;

import com.elso7ba.aklny.R;
import com.elso7ba.aklny.historyfragment.HistoryFragment;
import com.elso7ba.aklny.sharedlayout.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;




public final class UIManagerHandler {

	
	public static void goToMainPage(Activity context){
		
		Intent intent = new Intent(context, MainActivity.class);
		context.startActivity(intent);
		
	}
	
	public static void goToHistoryPage(Activity context){
	}	
}
