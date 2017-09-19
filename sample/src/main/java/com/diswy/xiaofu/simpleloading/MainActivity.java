package com.diswy.xiaofu.simpleloading;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.diswy.xiaofu.graceloading.loading.LoadingConfig;
import com.diswy.xiaofu.graceloading.loading.avi.AviLoading;
import com.diswy.xiaofu.graceloading.loading.bar.LoadingBar;
import com.diswy.xiaofu.graceloading.loading.dialog.LoadingDialog;
import com.diswy.xiaofu.graceloading.loading.factory.DialogFactory;
import com.diswy.xiaofu.graceloading.loading.factory.LoadingFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        // 测试201717-9-19
    }

    private void initView() {
        findViewById(R.id.btn_loading_bar).setOnClickListener(this);
        findViewById(R.id.btn_loading_dialog).setOnClickListener(this);
        findViewById(R.id.btn_global_setting).setOnClickListener(this);
        findViewById(R.id.btn_default_setting).setOnClickListener(this);
        findViewById(R.id.btn_beautiful_loading).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_loading_bar:
                startActivity(new Intent(this, LoadingBarActivity.class));
                break;
            case R.id.btn_loading_dialog:
                startActivity(new Intent(this, LoadingDialogActivity.class));
                break;
            case R.id.btn_global_setting:
                setGlobalStyle();
                break;
            case R.id.btn_default_setting:
                setDefaultStyle();
                break;
            case R.id.btn_beautiful_loading:
                startActivity(new Intent(this, BeautifulLoading.class));
                break;

        }
    }

    // 设置全局样式，一次设置，都有效果，建议写到Application里面
    // 偷懒，配置成我自定义的样式，配置后，在点默认，会显示新样式
    private void setGlobalStyle() {
        LoadingConfig.setFactory(new LoadingFactory() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_loading, parent, false);
            }
        }, new DialogFactory() {
            @Override
            public Dialog onCreateDialog(Context context) {
                Dialog dialog = new Dialog(context, R.style.Dialog);
                dialog.setContentView(R.layout.custom_dialog);
                return dialog;
            }

            @Override
            public void setMessage(Dialog dialog, CharSequence message) {

            }

            @Override
            public int getAnimateStyleId() {
                return 0;//  这里可以写动画
            }
        });
        Toast.makeText(this, "自定义Loading样式已经应用全局", Toast.LENGTH_SHORT).show();
    }

    // 清除设置的全局样式
    private void setDefaultStyle() {
        LoadingConfig.defaultFactory();
        Toast.makeText(this, "Loading还原到默认样式", Toast.LENGTH_SHORT).show();
    }


}
