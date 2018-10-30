package yzq.com.book;
/**
 * Created by 无敌小圈圈
 */

import com.hpw.mvpframe.CoreApp;
import com.hpw.mvpframe.utils.SpUtil;

import me.yokeyword.fragmentation.Fragmentation;

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
    @Override
    public String setBaseUrl() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SpUtil.init(this);
        getScreenSize();
        Fragmentation.builder()
                // show stack view. Mode: BUBBLE, SHAKE, NONE
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .install();
    }
}
