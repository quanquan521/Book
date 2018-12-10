package yzq.com.book.ui.main.fragment;
/**
 * Created by 无敌小圈圈
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.widget.GlideCircleTransform;
import com.hpw.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseViewHolder;
import com.hpw.mvpframe.widget.recyclerview.CoreRecyclerView;
import com.hpw.mvpframe.widget.recyclerview.listener.OnItemClickListener;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import yzq.com.book.App;
import yzq.com.book.R;
import yzq.com.book.bean.Recommend;
import yzq.com.book.manager.CollectionsManager;
import yzq.com.book.ui.read.ReadActivity;
import yzq.com.book.widget.LoginDialog;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/11/15.
 *
 * 描述：
 *
 *
 */
public class BookCaseFragment extends CoreBaseFragment {
    @BindView(R.id.recyclerView)CoreRecyclerView recyclerView;
    List<Recommend.RecommendBooks>list;
    BaseQuickAdapter adapter;
    @BindView(R.id.photo)ImageView photo;
    @BindView(R.id.nickname)TextView nickname;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_bookcase;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.onRefresh();
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {


    }

    @Override
    public void initData() {
       list= CollectionsManager.getInstance().getCollectionList();
       adapter=new BaseQuickAdapter<Recommend.RecommendBooks,BaseViewHolder>(R.layout.item_bookcase,list) {
           @Override
           protected void convert(BaseViewHolder helper, Recommend.RecommendBooks item) {
               View view=helper.getConvertView();
               TextView tv=view.findViewById(R.id.tv);
               ImageView iv=view.findViewById(R.id.iv);
               tv.setText(item.title);
               Glide.with(getContext()).load(App.getInstance().setBaseResUrl()+item.cover).into(iv);
           }
       };
       recyclerView.init(new GridLayoutManager(getContext(),3),adapter,true);
       recyclerView.openLoadMore(1000, new CoreRecyclerView.addDataListener() {
           @Override
           public void addData(int page) {
              list.addAll(CollectionsManager.getInstance().getCollectionList());
              adapter.notifyDataSetChanged();
           }
       });
       recyclerView.openLoadAnimation();
       recyclerView.openRefresh();
       View view= LayoutInflater.from(getContext()).inflate(R.layout.bookcase_emptyview,null,false);
       view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
       recyclerView.setEmptyView(view);
       setListner();
    }


    private void setListner() {

        recyclerView.addOnItemClickListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
                ReadActivity.startActivity(getContext(), list.get(position));
            }

            @Override
            public void SimpleOnItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                CollectionsManager.getInstance().remove(list.get(position)._id);
                recyclerView.remove(position);

            }

        });
    }

    public    static BookCaseFragment newInstance(){
        BookCaseFragment fragment=new BookCaseFragment();
        return  fragment;
    }
    @OnClick(R.id.photo)
    void photoClicked(){
        LoginDialog dialog=new LoginDialog(getContext());
        dialog.show();
        dialog.setLoginTypeListener(new LoginDialog.LoginTypeListener() {
            @Override
            public void onLogin(ImageView view, String type) {
                switch (type){
                    case "QQ":
                        Platform plat = ShareSDK.getPlatform(QQ.NAME);
                        plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
                        plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
                        plat.setPlatformActionListener(new PlatformActionListener() {
                            @Override
                            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                              Observable.create(new ObservableOnSubscribe<HashMap>() {
                                  @Override
                                  public void subscribe(ObservableEmitter<HashMap> e) throws Exception {
                                      e.onNext(hashMap);
                                  }
                              }) .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HashMap>() {

                                  @Override
                                  public void accept(HashMap o) throws Exception {
                                      Glide.with(getContext()).load(o.get("figureurl_qq_2")).placeholder(R.drawable.timg).transform(new GlideCircleTransform(getContext())).into(photo);
                                      nickname.setText((CharSequence) hashMap.get("nickname"));
                                  }
                              });
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
                        break;
                    case "":break;
                }
            }
        });
    }
}
