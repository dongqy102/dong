package com.bawei.ryi.presenter;
/*
 *@auther:董青勇
 *@Date: 2019/11/4
 *@Time:15:38
 *@Description:${DESCRIPTION}
 **/

import com.bawei.ryi.concacts.Concacts;
import com.bawei.ryi.model.Modelmvp;
import com.bawei.ryi.net.NetUtils;

public class Presentermvp implements Concacts.Ipresenter {
  private Concacts.Iview iview;
  private Concacts.Imodel imodel;

    @Override
    public void attch(Concacts.Iview iview) {
        this.iview=iview;
        imodel=new Modelmvp();
    }

    @Override
    public void start(String url) {
         imodel.getInfo(url, new Concacts.MyCallBack() {
             @Override
             public void onSccess(String json) {
                iview.onSccess(json);
             }

             @Override
             public void onFaild(String error) {
               iview.onError(error);
             }
         });

    }

    @Override
    public void deAttch() {
        if (iview != null) {
            iview=null;
        }

        if (imodel != null) {
            imodel=null;
        }
    }
}
