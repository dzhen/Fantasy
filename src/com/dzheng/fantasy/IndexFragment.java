package com.dzheng.fantasy;



import static android.text.TextUtils.isEmpty;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.dzheng.fantasy.utils.AppMsg;
import com.dzheng.fantasy.utils.AppMsgUtils;
import com.dzheng.fantasy.utils.MaterialRippleLayout;



public class IndexFragment extends Fragment implements
		OnClickListener,
		android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener {

	private SwipeRefreshLayout swipeRefreshLayout; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);// Ϊ����Fragment����ʾ���Ͻǵ�menu

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home,
				container, false);
		
		View view1 = (View)view.findViewById(R.id.ripple_layout_2); 
		MaterialRippleLayout.on(view1)
        .rippleColor(Color.parseColor("#FFFF00"))
        .rippleAlpha(0.2f)
        .rippleHover(true)
        .create();
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe);  
        swipeRefreshLayout.setOnRefreshListener(this);  
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light,
				android.R.color.holo_green_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_orange_light);
		
        view1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AppMsgUtils.showAppMsg(getActivity(), 0, "测试");
			}
		});
		
		return view;
	}

	 
	

	@Override
	public void onRefresh() {

		new Handler().postDelayed(new Runnable() {
			public void run() {
				swipeRefreshLayout.setRefreshing(false);
			}
		}, 1500);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		getActivity().getMenuInflater().inflate(R.menu.time, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
}
