package com.elso7ba.aklny.webserviceshandler;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.elso7ba.aklny.connectionutil.*;

public class ViewMeal extends AsyncTask<Void, Void, Void>
{
	
	Activity activity;
	String serverResult;
	
	public ViewMeal(Activity a) 
	{
		activity = a;
	}
	
	@Override
	protected void onPreExecute(){
	}

	@Override
	protected Void doInBackground(Void... params) 
	{
		ServiceHandler sh = new ServiceHandler(activity);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		nameValuePairs.add(new BasicNameValuePair("id", "1"));
	    serverResult =  sh.makeServiceCall(HttpConstants.VIEW_MEAL_URL, ServiceHandler.POST,nameValuePairs);
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) 
	{
		
	
	}
	
}
