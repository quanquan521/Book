package yzq.com.book.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import yzq.com.book.R;
import yzq.com.book.ui.booklist.BookListActivity;
import yzq.com.book.ui.main.adapter.PhotoGridViewAdapter;
import yzq.com.book.ui.main.bean.SortBean;
import yzq.com.book.ui.main.contract.MainContract;
import yzq.com.book.ui.main.model.MainModel;
import yzq.com.book.ui.main.presenter.MainPresenter;

public class MainActivity extends CoreBaseActivity<MainPresenter,MainModel> implements MainContract.MainView{
    @BindView(R.id.navigation_view)NavigationView navigationView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawerLayout)DrawerLayout drawerlayout;
    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.gridview)GridView gridView;
    ArrayList list=new ArrayList();
    PhotoGridViewAdapter adapter;

    @Override
    public boolean isOpen() {
        return true;
    }
    @Override
    public void setStatusBarColor() {
        super.setStatusBarColor();
        StatusBarUtil.setColor(this,getResources().getColor(R.color.md_green_500));

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        mDrawerToggle.syncState();
        drawerlayout.setDrawerListener(mDrawerToggle);
        adapter=new PhotoGridViewAdapter(this,list,false);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle=new Bundle();
                bundle.putInt("id",((SortBean.DataBean)list.get(i)).getId());
                bundle.putString("title",((SortBean.DataBean)list.get(i)).getName());
                startActivity(BookListActivity.class,bundle);
            }
        });
      navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()){
                  case R.id.favorite:
                      Platform plat = ShareSDK.getPlatform(QQ.NAME);
                      plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
                      plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
                      plat.setPlatformActionListener(new PlatformActionListener() {
                          @Override
                          public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                              showToast(platform.getName());

                          }

                          @Override
                          public void onError(Platform platform, int i, Throwable throwable) {
                              showToast("授权失败！");
                          }

                          @Override
                          public void onCancel(Platform platform, int i) {
                              showToast("授权已取消！");
                          }
                      });
                      plat.showUser(null);
                      drawerlayout.closeDrawers();

                      break;

              }


              return false;
          }
      });
    }

    @Override
    public void initParms(Bundle parms) {

    }
    @Override
    protected void initData() {
        mPresenter.getSort();
    }

    @Override
    public void showSort(SortBean bean) {
        list.clear();
        list.addAll(bean.getData());
        adapter.notifyDataSetChanged();

    }
}
