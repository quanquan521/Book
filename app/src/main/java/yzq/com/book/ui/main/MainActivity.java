package yzq.com.book.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import yzq.com.book.R;
import yzq.com.book.ui.main.fragment.BookCaseFragment;
import yzq.com.book.ui.main.fragment.RankingListFragment;
import yzq.com.book.ui.main.fragment.SearchFragment;

public class MainActivity extends CoreBaseActivity{
    @BindView(R.id.navigation_view)NavigationView navigationView;
    @BindView(R.id.drawerLayout)DrawerLayout drawerlayout;
    @BindView(R.id.radioGroup)RadioGroup radioGroup;
    private List<CoreBaseFragment> fragments=new ArrayList();


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
        fragments.add( BookCaseFragment.newInstance());fragments.add(RankingListFragment.newInstance());fragments.add(SearchFragment.newInstance());

        loadMultipleRootFragment(R.id.fragmentContainner,0,fragments.get(0),fragments.get(1),fragments.get(2) );
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.bookCase:
                        showHideFragment(fragments.get(0));
                        break;
                    case R.id.rankingList:
                        showHideFragment(fragments.get(1));
                        break;
                    case R.id.search:
                        showHideFragment(fragments.get(2));

                }
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
}
