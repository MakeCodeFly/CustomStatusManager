package com.lishijie.zoujuequn;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.LayoutRes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lishijie.zoujuequn.statusManager.OnStatusChildClickListener;
import com.lishijie.zoujuequn.statusManager.StatusLayoutManager;


public class MainActivity extends AppCompatActivity implements OnStatusChildClickListener {

    private StatusLayoutManager statusLayoutManager;
    private LinearLayout llRoot;
    private TextView mTvChildView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llRoot = findViewById(R.id.ll_root);
        mTvChildView = findViewById(R.id.childview);

        setupStatusLayoutManager();

        statusLayoutManager.showLoadingLayout();
        getData(1500);
    }

    private void getData(long time) {
        llRoot.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("---","run");
                statusLayoutManager.hideLoadingLayout();
                statusLayoutManager.showSuccessLayout();
            }
        }, time);
    }

    private void setupStatusLayoutManager() {
        statusLayoutManager = new StatusLayoutManager.Builder(mTvChildView)
                // 设置重试事件监听器
                .setOnStatusChildClickListener(this)
                .setLoadingLayout(R.layout.layout_status_layout_manager_loading)
                .setEmptyLayout(R.layout.layout_status_layout_manager_empty)
                .setErrorLayout(R.layout.layout_status_layout_manager_error)
                .setUnLoginLayout(R.layout.layout_status_layout_manager_unlogin)

                .setEmptyClickViewID(R.id.parent_status_empty_click)
                .setErrorClickViewID(R.id.parent_status_error_click)
                .setUnLoginClickViewID(R.id.parent_status_unlogin_click)

                .setLoadingViewTextColor(ContextCompat.getColor(this,R.color.color_0AD8F0))
                .setEmptyViewTextColor(ContextCompat.getColor(this,R.color.white_alpha_20))
                .setUnLoginTextViewColor(ContextCompat.getColor(this,R.color.white_alpha_20))
                .setErrorViewTextColor(ContextCompat.getColor(this,R.color.color_5ecdcd))

                .setLoadingBackgroundColor(ContextCompat.getColor(this,R.color.transparent))
                .setErrorBackgroundColor(ContextCompat.getColor(this,R.color.color_bg_loading))
                .setEmptyBackgroundColor(ContextCompat.getColor(this,R.color.color_bg_loading))
                .setUnLoginBackgroundColor(ContextCompat.getColor(this,R.color.color_bg_loading))

                .build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.status, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_status_loading:
                // 加载中
                statusLayoutManager.showLoadingLayout();
                break;
            case R.id.menu_status_empty:
                // 空数据
                statusLayoutManager.showEmptyLayout();
                break;
            case R.id.menu_status_error:
                // 加载失败
                statusLayoutManager.showErrorLayout();
                break;
            case R.id.menu_status_success:
                // 加载成功，显示原布局
                statusLayoutManager.showSuccessLayout();
                break;

                case R.id.menu_status_unlogin:
                // 加载成功，显示原布局
                statusLayoutManager.showUnLoginLayout();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEmptyChildClick(View view) {
        ToastUtils.show(MainActivity.this, "空数据状态布局");
        statusLayoutManager.showLoadingLayout();
        getData(1500);
    }

    @Override
    public void onErrorChildClick(View view) {
        ToastUtils.show(MainActivity.this, "出错状态布局");
        statusLayoutManager.showLoadingLayout();
        getData(1500);
    }

    @Override
    public void onUnLoginChildClick(View view) {
        ToastUtils.show(MainActivity.this, "未登陆状态布局");
        statusLayoutManager.showLoadingLayout();
        getData(1500);
    }
}
