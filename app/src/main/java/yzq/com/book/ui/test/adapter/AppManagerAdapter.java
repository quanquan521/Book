package yzq.com.book.ui.test.adapter;
/**
 * Created by 无敌小圈圈
 */

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/10/15.
 *
 * 描述：
 *
 *
 */
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import yzq.com.book.R;
import yzq.com.book.ui.test.bean.AppInfo;

/**
 * App管理的Adapter类
 * @author liuyazhuang
 *
 */
public class AppManagerAdapter extends BaseAdapter {

    private Context context;
    //布局加载器
    private LayoutInflater mInflater;
    private List<AppInfo> appInfos;

    //动态改变appInfos
    public void setAppInfos(List<AppInfo> appInfos) {
        this.appInfos = appInfos;
    }

    public AppManagerAdapter(Context context,List<AppInfo> appInfos) {
        this.context = context;
        this.appInfos = appInfos;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return appInfos.size();
    }

    public Object getItem(int position) {
        return appInfos.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //1 得到控件
        //2 得到数据
        //3 绑定数据
        View view = null;
        if(convertView != null){
            view = convertView;
        }else{
            view = mInflater.inflate(R.layout.applationinstall_item, null);
        }

        //获取布局控件
        ImageView iv_appicon = (ImageView) view.findViewById(R.id.iv_appicon);
        TextView tv_appname = (TextView) view.findViewById(R.id.tv_appname);
        TextView tv_appversion = (TextView) view.findViewById(R.id.tv_appversion);

        //获取position位置上的AppInfo对象
        AppInfo appInfo = appInfos.get(position);

        iv_appicon.setImageDrawable(appInfo.getApp_icon());
        tv_appname.setText(appInfo.getApp_name());
        tv_appversion.setText(appInfo.getApp_version());
        return view;
    }

}