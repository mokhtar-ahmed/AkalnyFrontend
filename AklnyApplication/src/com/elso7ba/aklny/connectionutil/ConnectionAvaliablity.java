package com.elso7ba.aklny.connectionutil;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;


public class ConnectionAvaliablity 
{

	Activity activity;
	private AsyncTask<String, Void, String> asyncTask;
	String urlParam;
	
	
	public ConnectionAvaliablity(Activity activity) 
	{
		this.activity = activity;
	}
	
	
	public ConnectionAvaliablity(Activity activity, AsyncTask<String, Void, String> asyncTask, String urlParam) 
	{
		this.activity = activity;
		this.setAsyncTaskAndUrlParam(asyncTask, urlParam);
	}
	

	//check for WIFI availability
	public boolean isOnline() 
	{
		ConnectivityManager connMgr = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		return (networkInfo != null && networkInfo.isConnected());
	}
	
	public boolean makeAndShowConnectionDialogBox() 
	{
		if(!isOnline())
		{
			//Toast.makeText(ResourcesManager.getInstance().activity, "Wifi is Open", Toast.LENGTH_LONG).show();
			makeConnectionDialogBox("Please check your internet connection and try again!").show();
		}
		else 
		{
			return true;
		}
		return false;
	}
	
	private AlertDialog makeConnectionDialogBox(String msg)
    {
        AlertDialog myQuittingDialogBox =  new AlertDialog.Builder(activity) 

            .setCancelable(false)
            .setTitle("Connection Error!") 
            .setMessage(msg) 

            .setPositiveButton("Retry", new DialogInterface.OnClickListener() 
			{ 
                public void onClick(DialogInterface dialog, int whichButton) 
				{				
                	makeAndShowConnectionDialogBox();
                }              
            })//setPositiveButton
            .setNegativeButton("Exit", new DialogInterface.OnClickListener() 
			{ 
                public void onClick(DialogInterface dialog, int whichButton) 
				{ 
					//whatever should be done when answering "NO" goes here
                    //activity.finish();
				} 
            }).create();

            return myQuittingDialogBox;
    }



	public AsyncTask<String, Void, String> getAsyncTask() 
	{
		return asyncTask;
	}



	public void setAsyncTaskAndUrlParam(AsyncTask<String, Void, String> asyncTask, String urlParam) 
	{
		this.asyncTask = asyncTask;
		this.urlParam = urlParam;
	}

}
