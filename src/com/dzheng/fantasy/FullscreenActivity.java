package com.dzheng.fantasy;




import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;



public class FullscreenActivity extends Activity implements OnRefreshListener{  
	  
    private SwipeRefreshLayout swipeRefreshLayout;  

    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.home);  
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe);  
        swipeRefreshLayout.setOnRefreshListener(this);  
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light,
				android.R.color.holo_green_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_orange_light);
  
    }  
  
    @Override
	public void onRefresh() {

		new Handler().postDelayed(new Runnable() {
			public void run() {

				

				swipeRefreshLayout.setRefreshing(false);

			}
		}, 1500);
	}

}
