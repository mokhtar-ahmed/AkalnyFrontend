package com.elso7ba.aklny.connectionutil;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import android.content.Context;

public class ServiceHandler
{
	static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;
    Context context;
    
    
    
    
    public ServiceHandler(Context con)
	{
    	context =  con;
    	//context.displayToast();
    	//con.getBaseContext().
    	//
	}
    
    public String makeServiceCall(String url , int method)
    {
    	return this.makeServiceCall(url, method , null);
    }
    
    public String makeServiceCall(String url , int method , List<NameValuePair> param)
    {
    	
    	
    	HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, 15000);
        HttpConnectionParams.setSoTimeout(httpParameters, 15000);
    	
        
    	DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
    	//DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
    	
        
        //post -------------------------------------------------------------
    	if(method == POST)
    	{
    		try
    		{
    			HttpPost post = new HttpPost(url);
    			
    			if(param != null)
    			{
    				System.out.println("Not Nulllllllllllllllllllll: "+param.get(0).getName());
    				post.setEntity(new UrlEncodedFormEntity(param));
    			}
    			
    			httpResponse = httpClient.execute(post); 
    		}
    		catch (Exception e) 
    		{
    			e.printStackTrace();
    			//Toast.makeText(context, "server is Down", Toast.LENGTH_LONG).show();
			}
    	}
    	
    	//GET  --------------------------------------------------------------------------
    	else if(method == GET)
    	{
    		try
    		{
    			if (param != null) 
    			{
                    String paramString = URLEncodedUtils.format(param, "utf-8");
                    url += "?" + paramString;
                }
    			
    			HttpGet get = new HttpGet(url);
    			httpResponse = httpClient.execute(get);
    			
    		}
    		catch (Exception e) 
    		{
				e.printStackTrace();
			}
    	}
    	
    	
    	try
    	{
    		httpEntity = httpResponse.getEntity();
    		response = EntityUtils.toString(httpEntity);
    		//System.out.println("Response from Service Handler "+response);
    		//response = entity.toString();
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		//Toast.makeText(context, "server is Down", Toast.LENGTH_LONG).show();
		}
    	
    	
    	return response;
    }
}
