package com.freakishfox.xxq;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements  XQBottomPanelDelegate {

    //消息页面的Fragment
    private MessageFragment messageFragment = null;

    //联系人页面的Fragment
    private ContactFragment contactFragment = null;

    //动态页面Fragment
    private NewsFragment newsFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //监听底部面板事件
        XQBottomPanelLayout bottomPanel = (XQBottomPanelLayout)findViewById(R.id.bottom_panel_layout);
        if(null != bottomPanel){
            bottomPanel.setBottomPanelListener(this);

            //默认选中首页
            bottomPanel.selectItem(Constants.BOTTOM_PANEL_ITEM_ID_CONTACT);
        }
    }

    @Override
    public void onPanelItemClick(int itemId){
        Log.d(Constants.TAG_MAIN_ACTIVITY, "onItemClick -- :" + itemId);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction trans = fragmentManager.beginTransaction();

        //在这里切换Fragment
        switch(itemId){
            case Constants.BOTTOM_PANEL_ITEM_ID_MESSAGE:{
                if(messageFragment == null){
                    messageFragment = new MessageFragment();
                }

                trans.replace(R.id.middle_view_fragment, messageFragment);
                //trans.addToBackStack(null);
                break;
            }
            case Constants.BOTTOM_PANEL_ITEM_ID_CONTACT:{
                if(contactFragment == null){
                    contactFragment = new ContactFragment();
                }

                trans.replace(R.id.middle_view_fragment, contactFragment);
                //trans.addToBackStack(null);
                break;
            }
            case Constants.BOTTOM_PANEL_ITEM_ID_NEWS:{
                if(newsFragment == null){
                    newsFragment = new NewsFragment();
                }

                trans.replace(R.id.middle_view_fragment, newsFragment);
                //trans.addToBackStack(null);
                break;
            }
        }

        trans.commit();
    }
}
