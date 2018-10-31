package yzq.com.book.ui.test;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import yzq.com.book.R;

public class AllApp extends CoreBaseActivity {
    @BindView(R.id.listView)ListView listView;
    List<AppInfo> list=new ArrayList<>();
    List<AppInfo> userAppInfos=new ArrayList<>();
    private PackageManager pm;


    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void setStatusBarColor() {
        super.setStatusBarColor();
        StatusBarUtil.setColor(this,getResources().getColor(R.color.md_green_500));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_app;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        yzq.com.book.ui.test.adapter.AppManagerAdapter appManagerAdapter=new AppManagerAdapter(this,userAppInfos);
        listView.setAdapter(appManagerAdapter);
        AppInfoService appInfoService = new AppInfoService(this);
        //包管理器
        pm = getPackageManager();

        //在子线程中获取手机安装的应用程序信息
        list.addAll(appInfoService.getAppInfos());
        for(AppInfo appInfo:list){
            if(appInfo.isUserApp()){
                userAppInfos.add(appInfo);
            }
        }
        appManagerAdapter.notifyDataSetChanged();

    }

    @Override
    public void initParms(Bundle parms) {

    }
}
