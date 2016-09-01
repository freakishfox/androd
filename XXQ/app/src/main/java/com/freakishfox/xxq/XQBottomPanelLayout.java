package com.freakishfox.xxq;

import java.util.HashMap;
import java.util.Map;

import android.widget.LinearLayout;
import android.widget.ImageView;
import android.content.Context;

/**
 * Created by Administrator on 9/1 0001.
 */
public class XQBottomPanelLayout extends LinearLayout{
    public XQBottomPanelLayout(Context context){
        super(context);

        //初始化各个panel
        bottom_panel_images.put(Constants.BOTTOM_PANEL_ITEM_ID_MESSAGE, new PanelItem(false, R.drawable.skin_tab_icon_conversation_normal, R.drawable.skin_tab_icon_conversation_selected));
        bottom_panel_images.put(Constants.BOTTOM_PANEL_ITEM_ID_CONTACT, new PanelItem(false, R.drawable.skin_tab_icon_contact_normal, R.drawable.skin_tab_icon_contact_selected));
        bottom_panel_images.put(Constants.BOTTOM_PANEL_ITEM_ID_NEWS, new PanelItem(false, R.drawable.skin_tab_icon_plugin_normal, R.drawable.skin_tab_icon_plugin_selected));
    }

    class PanelItem{
        public PanelItem(boolean selected, int normalImage, int selectedImage){
            isSelected = selected;
            normalBkgImage = normalImage;
            selectedBkgImage = selectedImage;
        }

        boolean isSelected;             //当前Item是否选中

        ImageView imageView;            //图片对象
        int normalBkgImage;          //非选中状态下的图片
        int selectedBkgImage;        //选中状态下的图片
    }

    //保存底部按钮对象数组
    private Map<Integer, PanelItem> bottom_panel_images = new HashMap<>();

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
}
