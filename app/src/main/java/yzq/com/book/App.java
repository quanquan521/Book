package yzq.com.book;
/**
 * Created by 无敌小圈圈
 */

import android.content.Context;

import com.hpw.mvpframe.CoreApp;
import com.hpw.mvpframe.utils.SpUtil;
import com.mob.MobSDK;

import me.yokeyword.fragmentation.Fragmentation;
import yzq.com.book.util.AppUtils;
import yzq.com.book.util.SharedPreferencesUtil;

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
public class App extends CoreApp {
    App instance;
    @Override
    public String setBaseUrl() {
        return "http://api.zhuishushenqi.com";
    }
    public String setBaseResUrl() {
        return "http://statics.zhuishushenqi.com";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        SharedPreferencesUtil.init(this,"book",Context.MODE_PRIVATE);
        AppUtils.init(this);
        SpUtil.init(this);
        getScreenSize();
        Fragmentation.builder()
                // show stack view. Mode: BUBBLE, SHAKE, NONE
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .install();
        MobSDK.init(this);
    }


}
