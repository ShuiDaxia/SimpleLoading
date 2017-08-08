package com.diswy.xiaofu.graceloading.loading.avi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diswy.xiaofu.graceloading.R;
import com.diswy.xiaofu.graceloading.loading.factory.LoadingFactory;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Author:          FHMY
 * Date:            2017/8/8 11:05
 * Description:     描述该类功能
 * <p>
 * 大人者，言不必信，行不必果，惟义所在
 */

public class AviLoading {

    /**
     * 默认大小的Loading
     *
     * @param string indicator
     * @return 普通大小的indicator
     */
    public static LoadingFactory getAviLoading(final String string, final int color) {
        return new LoadingFactory() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_avi, parent, false);
                AVLoadingIndicatorView avi = (AVLoadingIndicatorView) v.findViewById(R.id.avi);
                avi.setIndicator(string);
                avi.setIndicatorColor(color);
                return v;
            }
        };
    }

    /**
     * 较小的Loading
     *
     * @param string indicator
     * @return 普通大小的indicator
     */
    public static LoadingFactory getSmallAviLoading(final String string, final int color) {
        return new LoadingFactory() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_avi_small, parent, false);
                AVLoadingIndicatorView avi = (AVLoadingIndicatorView) v.findViewById(R.id.avi);
                avi.setIndicator(string);
                avi.setIndicatorColor(color);
                return v;
            }
        };
    }

    /**
     * 较小的Loading
     *
     * @param string indicator
     * @return 普通大小的indicator
     */
    public static LoadingFactory getLargeAviLoading(final String string, final int color) {
        return new LoadingFactory() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_avi_large, parent, false);
                AVLoadingIndicatorView avi = (AVLoadingIndicatorView) v.findViewById(R.id.avi);
                avi.setIndicator(string);
                avi.setIndicatorColor(color);
                return v;
            }
        };
    }

}
