package com.elso7ba.aklny.sharedlayout;

import com.elso7ba.aklny.aklnyfragment.AklnyFragment;
import com.elso7ba.aklny.historyfragment.HistoryFragment;
import com.elso7ba.aklny.resturantfragment.ResturantFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter 
{

	public TabsPagerAdapter(FragmentManager fm) 
	{
		super(fm);
	}

	@Override
	public Fragment getItem(int index) 
	{

		switch (index) 
		{
		case 0:
			// Top Rated fragment activity
			return new AklnyFragment();
		case 1:
			// Games fragment activity
			return new ResturantFragment();
		case 2:
			// Movies fragment activity
			return new HistoryFragment();
		}

		return null;
	}

	@Override
	public int getCount() 
	{
		// get item count - equal to number of tabs
		return 3;
	}

}
