package yzq.com.book.ui.main;

import android.os.Bundle;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.utils.SpUtil;
import com.hpw.mvpframe.utils.helper.RxUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import yzq.com.book.R;
import yzq.com.book.ui.main.MainActivity;

public class SplashActivity extends CoreBaseActivity {

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                //统一进程管理
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(permission -> {
                    // if (permission.granted) {
                    if (SpUtil.getFirstEnter()){
                        startActivity(MainActivity.class);
                        finish();
                    }else {
                        startActivity(MainActivity.class);
                        finish();
                    }

                });


    }

    @Override
    public void initParms(Bundle parms) {

    }
}
