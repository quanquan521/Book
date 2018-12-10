package yzq.com.book.ui.main.adapter;
/**
 * Created by 无敌小圈圈
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.hpw.mvpframe.base.CoreBaseFragment;

import java.util.List;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/12/10.
 *
 * 描述：
 *
 *
 */
public class MyFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    List<CoreBaseFragment> fragmentList;
    public MyFragmentPagerAdapter(FragmentManager fm, List<CoreBaseFragment> list) {
        super(fm);
        fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
