package com.dzheng.fantasy;

import static android.text.TextUtils.isEmpty;
import static android.view.Gravity.BOTTOM;

import java.io.File;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dzheng.fantasy.utils.ActionBarDrawerToggle;
import com.dzheng.fantasy.utils.AppMsg;
import com.dzheng.fantasy.utils.DrawerArrowDrawable;



public class MainActivity extends FragmentActivity {

	private TranslateAnimation myAnimation_Left;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	RelativeLayout rl;
	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerArrowDrawable drawerArrow;
	public static FragmentManager fm;
	Boolean openOrClose = false;

	TextView user_name;
	RelativeLayout toprl;
	ImageView login_tv;
	LinearLayout animll_id;

	protected static final int UPDATE_TEXT = 0;
	File sdcardDir;
	String path;
	File f;
	File[] fl;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		toprl = (RelativeLayout) findViewById(R.id.toprl);
		animll_id = (LinearLayout) findViewById(R.id.animll_id);

		user_name = (TextView) findViewById(R.id.user_name);

		ActionBar ab = getActionBar();
		
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setHomeButtonEnabled(true);
		init();
		fm = this.getSupportFragmentManager();
		rl = (RelativeLayout) findViewById(R.id.rl);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.navdrawer);

		drawerArrow = new DrawerArrowDrawable(this) {
			@Override
			public boolean isLayoutRtl() {
				return false;
			}
		};
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				drawerArrow, R.string.drawer_open, R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				invalidateOptionsMenu();
				openOrClose = false;
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
				openOrClose = true;
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerToggle.syncState();
		String[] values = new String[] { "1", "2", "3", "4" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.item_text, values);
		mDrawerList.setAdapter(adapter);
		mDrawerList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@SuppressLint({ "ResourceAsColor", "Recycle" })
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						switch (position) {
						case 0:
//							initFragment(new EveryDayEnglishFragment());

							setTitle("1");
							break;
						case 1:
//							initFragment(new OtherFragment());
							setTitle("2");
							break;
						case 2:
//							initFragment(new HomeFragment());
							setTitle("3");

							break;
						case 3:
//							initFragment(new AppTuiFragment());
							setTitle("4");

							break;

						}
						mDrawerLayout.closeDrawers();
						openOrClose = false;
					}
				});

	}
	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();


	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			if (mDrawerLayout.isDrawerOpen(rl)) {
				mDrawerLayout.closeDrawer(rl);
				openOrClose = false;
			} else {
				mDrawerLayout.openDrawer(rl);
				openOrClose = true;
			}
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private void init() {
		fm = getSupportFragmentManager();
		initFragment(new IndexFragment());
	}

	public void changeFragment(Fragment f) {
		changeFragment(f, false);
	}
	public void initFragment(Fragment f) {
		changeFragment(f, true);
	}

	private void changeFragment(Fragment f, boolean init) {
		FragmentTransaction ft = fm.beginTransaction().setCustomAnimations(
				R.anim.umeng_fb_slide_in_from_left,
				R.anim.umeng_fb_slide_out_from_left,
				R.anim.umeng_fb_slide_in_from_right,
				R.anim.umeng_fb_slide_out_from_right);
		;
		ft.replace(R.id.fragment_layout, f);
		if (!init)
			ft.addToBackStack(null);
		ft.commitAllowingStateLoss();
	}

	


}
