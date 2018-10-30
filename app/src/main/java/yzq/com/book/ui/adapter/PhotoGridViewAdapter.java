package yzq.com.book.ui.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import yzq.com.book.App;
import yzq.com.book.R;

/**
 * Created by Alex on 2017/3/24.
 */

public class PhotoGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Object> mList;//数据源
    private boolean flag;
    public interface MyListner{//默认地址设置监听
        void click(int position);
    }
    private MyListner myListner;

    public PhotoGridViewAdapter(Context context,ArrayList  mList,boolean flag) {
        //type 0 为商家列表  1   2为用户列表
        this.mContext = context;
        this.mList = mList;
        this.flag=flag;

    }

    @Override
    public int getCount() {
        int count=0;
        if (flag){
           count = mList == null ? 1 : mList.size() + 1;
        }else {
            count=mList.size();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        return  mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(mContext, R.layout.item_photo, null);
        ImageView photo=convertView.findViewById(R.id.photo);
        convertView.setLayoutParams(new LinearLayout.LayoutParams(App.SCREEN_WIDTH/3,App.SCREEN_WIDTH/3));
        ViewGroup.LayoutParams params = photo.getLayoutParams();
        photo.setLayoutParams(params);
        if (position == mList.size()) {
            photo.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.photo_evaluation_));
        }else {

        }

        return convertView;
    }
    public void setListner(MyListner listner){
        this.myListner=listner;
    }
}
