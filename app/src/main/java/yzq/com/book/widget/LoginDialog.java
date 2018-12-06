package yzq.com.book.widget;
/**
 * Created by 无敌小圈圈
 */

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import yzq.com.book.R;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/12/6.
 *
 * 描述：
 *
 *
 */
public class LoginDialog extends Dialog implements View.OnTouchListener {
    private ImageView qq;
    private ImageView weibo;
    private ImageView wechat;
    private Context context;
     LoginTypeListener listener;
    public interface LoginTypeListener {
        void onLogin(ImageView view, String type);
    }

    public void setLoginTypeListener(LoginTypeListener listener){
        this.listener = listener;
    }
    public LoginDialog(@NonNull Context context) {
        this(context, R.style.AdvertisementDialog);
        this.context=context;
    }

    public LoginDialog(@NonNull Context context, int themeResId) {

        super(context, R.style.AdvertisementDialog);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_login_popup_window, null);
        setContentView(view);
        qq = (ImageView) view.findViewById(R.id.ivQQ);
        weibo = (ImageView) view.findViewById(R.id.ivWeibo);
        wechat = (ImageView) view.findViewById(R.id.ivWechat);
        qq.setOnTouchListener(this);
        weibo.setOnTouchListener(this);
        wechat.setOnTouchListener(this);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width= WindowManager.LayoutParams.MATCH_PARENT;
        params.height= WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER ;
        getWindow().setAttributes(params);
    }
    private void scale(View v, boolean isDown) {
        if (v.getId() == qq.getId() || v.getId() == weibo.getId() || v.getId() == wechat.getId()) {
            if (isDown) {
                Animation testAnim = AnimationUtils.loadAnimation(context, R.anim.scale_down);
                v.startAnimation(testAnim);
            } else {
                Animation testAnim = AnimationUtils.loadAnimation(context, R.anim.scale_up);
                v.startAnimation(testAnim);
            }
        }
        if (!isDown && listener!=null) {
            switch (v.getId()) {
                case R.id.ivQQ:
                    listener.onLogin(qq, "QQ");
                    break;
            }

            qq.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dismiss();
                }
            }, 500);

        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                scale(v, true);
                break;
            case MotionEvent.ACTION_UP:
                scale(v, false);
                break;
        }
        return false;
    }
}
