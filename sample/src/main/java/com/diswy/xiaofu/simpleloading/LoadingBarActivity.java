package com.diswy.xiaofu.simpleloading;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diswy.xiaofu.graceloading.loading.avi.AviLoading;
import com.diswy.xiaofu.graceloading.loading.bar.LoadingBar;
import com.diswy.xiaofu.graceloading.loading.factory.LoadingFactory;

public class LoadingBarActivity extends AppCompatActivity implements View.OnClickListener {
    private View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_activity);
        initView();
    }

    private void initView() {
        container = findViewById(R.id.container);

        findViewById(R.id.btn_default_style).setOnClickListener(this);
        findViewById(R.id.btn_custom_style).setOnClickListener(this);
        findViewById(R.id.btn_cancel_loading).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_default_style:
                LoadingBar.make(container).show();
                break;
            case R.id.btn_custom_style:
                LoadingBar.make(container, new LoadingFactory() {
                    @Override
                    public View onCreateView(ViewGroup parent) {
                        return LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_loading, parent, false);
                    }
                }).show();
                break;
            case R.id.btn_cancel_loading:
                LoadingBar.cancel(container);
                break;
        }
    }

}
