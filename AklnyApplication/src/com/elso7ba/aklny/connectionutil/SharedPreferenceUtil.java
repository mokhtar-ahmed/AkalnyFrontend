package com.elso7ba.aklny.connectionutil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceUtil 
{
	
	
	public String getPref(String key , Context con) 
	{
	    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(con);
	    return preferences.getString(key, null);
	}
	
	public void savePref(String id , String name ,  Context con)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(con);
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.putString(id, name);
	    editor.commit();
	}
}
