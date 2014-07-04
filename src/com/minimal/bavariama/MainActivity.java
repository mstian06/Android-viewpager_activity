package com.minimal.bavariama;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.minimal.adapter.BasePagerAdapter;
import com.minimal.custom.VerticalPagerAdapter;
import com.minimal.custom.VerticalViewPager;
import com.minimal.adapter.*;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

	private ViewPager basePager;
	private BasePagerAdapter baseAdapter;
	private VerticalAdapter vAdapter1;
	private VerticalAdapter vAdapter2;
	private VerticalViewPager verticalPager1;
	private VerticalViewPager verticalPager2;
	private List<View> pageViews;
	private List<View> verticalViews1;
	private List<View> verticalViews2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		LayoutInflater inflater = getLayoutInflater();
		pageViews = new ArrayList<View>();
		verticalViews1 = new ArrayList<View>();
		verticalViews2 = new ArrayList<View>();

		verticalViews1.add(inflater.inflate(R.layout.item01, null));
		verticalViews1.add(inflater.inflate(R.layout.item02, null));
		verticalViews1.add(inflater.inflate(R.layout.item03, null));
		verticalViews2.add(inflater.inflate(R.layout.item04, null));
		verticalViews2.add(inflater.inflate(R.layout.item05, null));
		verticalViews2.add(inflater.inflate(R.layout.item06, null));

		// 获得布局文件，不然会出现空指针异常
		View view1 = inflater.inflate(R.layout.vertical_pager1, null);
		View view2 = inflater.inflate(R.layout.vertical_pager2, null);
		pageViews.add(view1);
		pageViews.add(view2);

		verticalPager1 = (VerticalViewPager) view1.findViewById(R.id.pager1);
		verticalPager2 = (VerticalViewPager) view2.findViewById(R.id.pager2);
		basePager = (ViewPager) findViewById(R.id.basePager);

		vAdapter1 = new VerticalAdapter(verticalViews1);
		vAdapter2 = new VerticalAdapter(verticalViews2);

		verticalPager1.setAdapter(vAdapter1);
		verticalPager2.setAdapter(vAdapter2);
		baseAdapter = new BasePagerAdapter(pageViews);

		basePager.setAdapter(baseAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
