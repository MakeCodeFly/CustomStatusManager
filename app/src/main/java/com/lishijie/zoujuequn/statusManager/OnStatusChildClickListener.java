package com.lishijie.zoujuequn.statusManager;

import android.view.View;


public interface OnStatusChildClickListener {

    /**
     * 空数据布局子 View 被点击
     *
     * @param view 被点击的 View
     */
    void onEmptyChildClick(View view);

    /**
     * 出错布局子 View 被点击
     *
     * @param view 被点击的 View
     */
    void onErrorChildClick(View view);

}
