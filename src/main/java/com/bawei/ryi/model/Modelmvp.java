package com.bawei.ryi.model;
/*
 *@auther:董青勇
 *@Date: 2019/11/4
 *@Time:15:09
 *@Description:${DESCRIPTION}
 **/

import com.bawei.ryi.concacts.Concacts;
import com.bawei.ryi.net.NetUtils;

public class Modelmvp implements Concacts.Imodel {
    @Override
    public void getInfo(String url, final Concacts.MyCallBack myCallBack) {
         NetUtils.getInstance().doGet(url, new NetUtils.MyCallBace() {
             @Override
             public void onDoGetSuccess(String json) {
                 myCallBack.onSccess(json);
             }

             @Override
             public void onDoErrorSuccess(String error) {
                  myCallBack.onFaild(error);
             }
         });
    }

    @Override
    public void postInfo(String url, Concacts.MyCallBack myCallBack) {

    }
}
