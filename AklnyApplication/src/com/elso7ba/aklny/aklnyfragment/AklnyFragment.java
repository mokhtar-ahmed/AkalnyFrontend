package com.elso7ba.aklny.aklnyfragment;

import info.androidhive.tabsswipe.R;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AklnyFragment extends Fragment 
{
	
	Button aklnyBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.akalny_fragmeny, container, false);
		aklnyBtn =  (Button) rootView.findViewById(R.id.aklnyBtn);
		aklnyBtn.setOnClickListener(new btnListenerClass());
		
		return rootView;
	}
	
	
	class btnListenerClass implements View.OnClickListener
	{

		@Override
		public void onClick(View v) 
		{
			System.out.println("async");
		}
	}
}
