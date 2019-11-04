package com.bawei.ryi;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bawei.ryi.adapter.Myadapter;
import com.bawei.ryi.bace.BaceActivity;
import com.bawei.ryi.concacts.Concacts;
import com.bawei.ryi.json.JsonBean;
import com.bawei.ryi.presenter.Presentermvp;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaceActivity implements Concacts.Iview {

     private String urls="http://blog.zhaoliang5156.cn/api/shop/fulishe1.json";
    private XBanner xbanner;
    private GridView gv;
 private   List<JsonBean.DataBean>list=new ArrayList<>();
    private Presentermvp presentermvp;
    private Myadapter myadapter;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
       xbanner=findViewById(R.id.xbanner);
       gv=findViewById(R.id.gv);
    }

    @Override
    protected void initData() {
        presentermvp = new Presentermvp();
        presentermvp.attch(this);
        presentermvp.start(urls);
        myadapter = new Myadapter(this,list);
        gv.setAdapter(myadapter);

    }


    @Override
    public void onSccess(String jsonStr) {
        JsonBean jsonBean = new Gson().fromJson(jsonStr, JsonBean.class);
        final List<JsonBean.BannerBean> banners = jsonBean.getBanner();
        List<JsonBean.DataBean> data = jsonBean.getData();
        xbanner.setBannerData(banners);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(MainActivity.this).load(banners.get(position).getImageUrl()).into((ImageView) view);
            }
        });

        list.addAll(data);
        //刷新
      myadapter.notifyDataSetChanged();


    }

    @Override
    public void onError(String error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presentermvp != null) {
            presentermvp.deAttch();
            presentermvp=null;
        }
    }
}
