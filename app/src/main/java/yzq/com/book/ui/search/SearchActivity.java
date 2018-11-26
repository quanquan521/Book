package yzq.com.book.ui.search;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hpw.mvpframe.base.CoreBaseActivity;

import yzq.com.book.R;

public class SearchActivity extends CoreBaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initParms(Bundle parms) {

    }
    public  static void startActivity(Context context,String keyword){
        Intent intent=new Intent(context,SearchActivity.class);
        intent.putExtra("keyword",keyword);
        context.startActivity(intent);
    }
}
