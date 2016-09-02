package com.freakishfox.xxq;

import java.util.HashMap;
import java.util.Map;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.content.Context;

/**
 * Created by Administrator on 9/1 0001.
 */


public class XQBottomPanelLayout extends LinearLayout{
    public XQBottomPanelLayout(Context context, AttributeSet attrs){
        super(context, attrs);

        initBottomPanel(context);
    }

    class PanelItem{
        public PanelItem(boolean selected, int normalImage, int selectedImage, ImageView image){
            isSelected = selected;
            normalBkgImage = normalImage;
            selectedBkgImage = selectedImage;

            imageView = image;
        }

        boolean isSelected;             //当前Item是否选中

        ImageView imageView;            //图片对象
        int normalBkgImage;          //非选中状态下的图片
        int selectedBkgImage;        //选中状态下的图片
    }

    //保存底部按钮对象数组
    private Map<Integer, PanelItem> bottom_panel_images = new HashMap<>();

    //回调接口
    private XQBottomPanelDelegate bottom_panel_delegate = null;

    /**
        @method: initBottomPanel
        @method description: 初始化BottomPanel

        @param: ctx
        @return:
        @create_time: 9/2 0002 12:17
        @author: freakishfox
    */
    private void initBottomPanel(Context ctx){
        Log.d(Constants.TAG_BOTTOM_PANEL, "开始初始化XQButtomPanel组件...");
        Log.d(Constants.TAG_BOTTOM_PANEL, Log.getStackTraceString(new Throwable()));

        View parentView = LinearLayout.inflate(ctx, R.layout.bottom_panel_layout, this);

        //初始化各个panel
        bottom_panel_images.put(Constants.BOTTOM_PANEL_ITEM_ID_MESSAGE,
                new PanelItem(false, R.drawable.skin_tab_icon_conversation_normal, R.drawable.skin_tab_icon_conversation_selected, (ImageView)parentView.findViewById(R.id.image_message_list)));
        bottom_panel_images.put(Constants.BOTTOM_PANEL_ITEM_ID_CONTACT,
                new PanelItem(false, R.drawable.skin_tab_icon_contact_normal, R.drawable.skin_tab_icon_contact_selected, (ImageView)parentView.findViewById(R.id.image_contact_list)));
        bottom_panel_images.put(Constants.BOTTOM_PANEL_ITEM_ID_NEWS,
                new PanelItem(false, R.drawable.skin_tab_icon_plugin_normal, R.drawable.skin_tab_icon_plugin_selected, (ImageView)parentView.findViewById(R.id.image_news_list)));

        //绑定各个ImageView的点击事件
        for (Map.Entry<Integer, PanelItem> item : bottom_panel_images.entrySet()){
            PanelItem singleItem = item.getValue();

            ImageView imageView = singleItem.imageView;
            if(imageView != null){
                imageView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        onPanelItemSelected(v.getId());

                        //接受到UI点击事件，通知到监听者
                        if(bottom_panel_delegate != null){
                            bottom_panel_delegate.onPanelItemClick(v.getId());
                        }
                    }
                });
            }
        }
    }

    /**
        @method: onPanelItemSelected
        @method description: 处理底部按钮选中UI事件

        @param: itemId - 被选中的按钮的Id
        @return:
        @create_time: 9/1 0001 22:45
        @author: freakishfox
    */
    private void onPanelItemSelected(int itemId){

        //先把三个按钮全都设置成非选中状态，然后设置点击的那个为选中状态
        setItemState(Constants.BOTTOM_PANEL_ITEM_ID_MESSAGE, false);
        setItemState(Constants.BOTTOM_PANEL_ITEM_ID_CONTACT, false);
        setItemState(Constants.BOTTOM_PANEL_ITEM_ID_NEWS, false);

        switch (itemId){
            case Constants.BOTTOM_PANEL_ITEM_ID_MESSAGE:{
                setItemState(Constants.BOTTOM_PANEL_ITEM_ID_MESSAGE, true);
                break;
            }

            case Constants.BOTTOM_PANEL_ITEM_ID_CONTACT:{
                setItemState(Constants.BOTTOM_PANEL_ITEM_ID_CONTACT, true);
                break;
            }

            case Constants.BOTTOM_PANEL_ITEM_ID_NEWS:{
                setItemState(Constants.BOTTOM_PANEL_ITEM_ID_NEWS, true);
                break;
            }
            default:
                break;
        }
    }

    /**
        @method: setItemState
        @method description: 根据Item的选中状态，设置Item的背景图片

        @param: itemId - 按钮的Id, selectState - 按钮的选中状态
        @return:
        @create_time: 9/1 0001 22:48
        @author: freakishfox
    */
    private boolean setItemState(int itemId, boolean selectState){
        PanelItem item = bottom_panel_images.get(itemId);
        if(item == null){
            return false;
        }

        item.isSelected = selectState;
        if(item.isSelected){
            item.imageView.setImageResource(item.selectedBkgImage);
        }else{
            item.imageView.setImageResource(item.normalBkgImage);
        }
        return true;
    }

    /**
        @method: setBottomPanelListener
        @method description: 注册底部面板的事件监听器

        @param:
        @return:
        @create_time: 9/2 0002 12:18
        @author: freakishfox
    */
    public boolean setBottomPanelListener(XQBottomPanelDelegate listener){
        Log.d(Constants.TAG_BOTTOM_PANEL, "初始化 XQBottomPanelDelegate:" + listener);

        bottom_panel_delegate = listener;
        return true;
    }
}
