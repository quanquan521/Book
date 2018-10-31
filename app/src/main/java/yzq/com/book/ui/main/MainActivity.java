package yzq.com.book.ui.main;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import yzq.com.book.R;
import yzq.com.book.ui.main.adapter.PhotoGridViewAdapter;

public class MainActivity extends CoreBaseActivity {
    @BindView(R.id.navigation_view)NavigationView navigationView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawerLayout)DrawerLayout drawerlayout;
    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.gridview)GridView gridView;
    ArrayList list=new ArrayList();
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
        PhotoGridViewAdapter adapter=new PhotoGridViewAdapter(this,list,true);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==adapterView.getChildCount()-1){

                }else {

                }
            }
        });
    }

    @Override
    public void initParms(Bundle parms) {

    }

}
