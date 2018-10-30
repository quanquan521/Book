package yzq.com.book.util;
/**
 * Created by 无敌小圈圈
 */

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/10/18.
 *
 * 描述：
 *
 *
 */
public class PXUtil {
 public static    int getScreenWidthPixels(Context context){
       DisplayMetrics dm = new DisplayMetrics();
       ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
               .getMetrics(dm);
       return dm.widthPixels;
    }
    public static  int getScreenHeightPixels(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.heightPixels;
    }
    public static  float getScreenDensity(Context context) {
        try {
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                    .getMetrics(dm);
            return dm.density;
        } catch (Exception e) {
            return DisplayMetrics.DENSITY_DEFAULT;
        }
   }
   public static  int dipToPx(Context context, int dip) {
        return (int) (dip * getScreenDensity(context) + 0.5f);
    }
    public static double getStatusBarHeight(Context context){
        double statusBarHeight = Math.ceil(25 * context.getResources().getDisplayMetrics().density);
        return statusBarHeight;
    }

}
