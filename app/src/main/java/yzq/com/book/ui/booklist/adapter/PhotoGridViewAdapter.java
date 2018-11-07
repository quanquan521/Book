package yzq.com.book.ui.booklist.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.ui.booklist.bean.BookBean;
import yzq.com.book.ui.main.bean.SortBean;

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

    public PhotoGridViewAdapter(Context context, ArrayList  mList, boolean flag) {
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
       /* convertView.setLayoutParams(new LinearLayout.LayoutParams(App.SCREEN_WIDTH/3,App.SCREEN_WIDTH/3));*/
        ImageView photo=convertView.findViewById(R.id.photo);
        photo.setLayoutParams(new LinearLayout.LayoutParams(App.SCREEN_WIDTH/3,App.SCREEN_WIDTH/3));
        TextView name=convertView.findViewById(R.id.name);
        name.setText(((BookBean.DataBean)mList.get(position)).getBook());
        if (position == mList.size()) {
            photo.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.photo_evaluation_));
        }else {
            if (!TextUtils.isEmpty(((BookBean.DataBean)mList.get(position)).getImg()))
            Glide.with(mContext).load(((BookBean.DataBean)mList.get(position)).getImg()).into(photo);
        }
        return convertView;
    }
    public void setListner(MyListner listner){
        this.myListner=listner;
    }
}
