package com.diswy.xiaofu.simpleloading;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.diswy.xiaofu.graceloading.loading.bar.LoadingBar;
import com.diswy.xiaofu.graceloading.loading.dialog.LoadingDialog;
import com.diswy.xiaofu.graceloading.loading.factory.DialogFactory;

public class LoadingDialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_activity);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_default_style).setOnClickListener(this);
        findViewById(R.id.btn_custom_style).setOnClickListener(this);
        findViewById(R.id.btn_cancel_loading).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_default_style:
                LoadingDialog.make(this).show();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoadingDialog.cancel();
                    }
                }, 2000);
                break;
            case R.id.btn_custom_style:
                Dialog dialog = LoadingDialog
                        .make(this, new DialogFactory() {
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
                                return 0;
                            }
                        })
                        .setCancelable(true)// 是否可以取消
                        .create();
                // 可以监听取消状态
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(LoadingDialogActivity.this, "Dialog取消了", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

                // 无动作延时2S后取消，可自行更换别的线程操作
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoadingDialog.cancel();
                    }
                }, 2000);
                break;
            case R.id.btn_cancel_loading:
                LoadingDialog.cancel();
                break;
        }
    }
}
