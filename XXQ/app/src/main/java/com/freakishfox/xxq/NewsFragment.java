package com.freakishfox.xxq;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Administrator on 9/2 0002.
 */
public class NewsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View newsFragment = inflater.inflate(R.layout.news_fragment, container, false);

        if(newsFragment != null){
            WebView webView = (WebView) newsFragment.findViewById(R.id.news_web_view);
            if(webView != null){
                webView.loadUrl("http://www.cnblogs.com/tinyphp/p/3858997.html");
            }
        }
        return newsFragment;
    }
}
