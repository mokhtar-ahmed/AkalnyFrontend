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

public class AklnyAsync extends AsyncTask<Void, Void, Void>
{
	
	String userID;
	Activity activity;
	String serverResult;
	
	public AklnyAsync(Activity a) 
	{
		activity = a;
	}
	
	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		
		
	}

	@Override
	protected Void doInBackground(Void... params) 
	{
		ServiceHandler sh = new ServiceHandler(activity);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);

		
//		getPref(String key , Context con);
		nameValuePairs.add(new BasicNameValuePair("id", "1"));
		
		
		
	    serverResult =  sh.makeServiceCall(HttpConstants.AKLNY_URL, ServiceHandler.POST,nameValuePairs);
	    
	    System.out.println("getScore: "+serverResult);
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) 
	{
		super.onPostExecute(result);
		
		/*
		try 
		{
			JSONObject obj = new JSONObject(serverResult);
			scene.changeDialogText(""+obj.get("order") , ""+obj.get("nu"));
			System.out.println("Order: "+obj.get("order"));
			System.out.println("Number: "+obj.get("nu"));
			
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		*/
		
	
	}
	
}
