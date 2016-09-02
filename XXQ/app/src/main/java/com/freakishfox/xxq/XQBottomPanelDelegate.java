package com.freakishfox.xxq;

/**
 * Created by Administrator on 9/2 0002.
 */

//专门用来提供 XQBottomPanelLayout 面板的各种回调
public interface XQBottomPanelDelegate {

    /**
        @method: onPanelItemClick
        @method description: 当BottomPanel 的某一个按钮被点击的时候触发这个调用

        @param: itemId - 被点击的那个按钮的Id
        @return:
        @create_time: 9/2 0002 12:28
        @author: freakishfox
    */
    void onPanelItemClick(int itemId);
}
