package com.bawei.ryi.concacts;
/*
 *@auther:董青勇
 *@Date: 2019/11/4
 *@Time:15:01
 *@Description:${DESCRIPTION}
 **/

public interface Concacts {
    interface MyCallBack{
        void  onSccess(String json);
        void  onFaild(String error);
    }
    interface Imodel{
        void  getInfo(String url,MyCallBack myCallBack);
        void  postInfo(String url,MyCallBack myCallBack);
    }
    interface  Iview{
        void onSccess(String jsonStr);
        void onError(String error);
    }
    interface  Ipresenter{
        void attch(Iview iview);
        void start(String url);
        void deAttch();
    }




}
