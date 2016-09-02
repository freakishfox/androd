package com.freakishfox.xxq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements  XQBottomPanelDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //监听底部面板事件
        XQBottomPanelLayout bottomPanel = (XQBottomPanelLayout)findViewById(R.id.bottom_panel_layout);
        if(null != bottomPanel){
            bottomPanel.setBottomPanelListener(this);
        }
    }

    @Override
    public void onPanelItemClick(int itemId){
        Log.d(Constants.TAG_MAIN_ACTIVITY, "onItemClick -- :" + itemId);

        //在这里切换Fragment
    }
}
