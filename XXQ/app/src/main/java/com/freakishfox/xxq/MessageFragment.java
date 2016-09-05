package com.freakishfox.xxq;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 9/2 0002.
 */
public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View messageFragment = inflater.inflate(R.layout.message_fragment, container, false);
        if(messageFragment != null){
            MessageAdapter listAdpater = new MessageAdapter(inflater);

            ListView listView = (ListView)messageFragment.findViewById(R.id.message_list_view);
            if(listView != null){
                listView.setAdapter(listAdpater);
            }
        }

        return messageFragment;
    }
}

//列表每一项的数据
class ItemValue{
    int userImageId;
    String userName;
    String lastMessage;
}

//列表每一项的View, 用来做缓存用
class ItemView{
    ImageView userImageView;
    TextView userNameView;
    TextView lastMessageView;
}

//用来实现
class MessageAdapter extends BaseAdapter{

    //列表项xml Item加载器
    private LayoutInflater itemInflater = null;

    MessageAdapter(LayoutInflater inflater){
        itemInflater = inflater;
    }

    @Override
    public int getCount(){
        return 100;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public ItemValue getItem(int position){
        ItemValue itemValue = new ItemValue();

        itemValue.userName = "大敌法";
        itemValue.lastMessage = "我之前的钱，你给我打过来了吗?";
        itemValue.userImageId = R.drawable.user_image;

        return itemValue;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemView itemView = null;
        if (convertView == null) {
            convertView = itemInflater.inflate(R.layout.message_list_item, null);

            itemView = new ItemView();
            itemView.userImageView = (ImageView)convertView.findViewById(R.id.message_user_image);
            itemView.userNameView = (TextView)convertView.findViewById(R.id.message_user_name);
            itemView.lastMessageView = (TextView)convertView.findViewById(R.id.message_last_message);

            //itemView.userImageView.setMaxWidth(64);
            //itemView.userImageView.setMaxHeight(64);

            convertView.setTag(itemView);
        } else {
            itemView = (ItemView)convertView.getTag();
        }

        ItemValue itemValue = getItem(position);
        itemView.userNameView.setText(itemValue.userName);
        itemView.lastMessageView.setText(itemValue.lastMessage);
        itemView.userImageView.setImageResource(itemValue.userImageId);

        return convertView;
    }
}
