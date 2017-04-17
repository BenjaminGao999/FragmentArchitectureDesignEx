package com.gaos.fragmentnestedex.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gaos.fragmentnestedex.R;

/**
 * Author:　Created by benjamin
 * DATE :  2017/4/17 14:44
 * versionCode:　1.0.0
 */

public class FragmentB extends BaseFragment {
    private static final String TAG = "Fragment";
    private final String imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492422923839&di=82b0681ceddead9a3fc402101018af9d&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2012%2F1210%2Fczs%2F02%2Fqihuanfengjing%2520%25284%2529.jpg";

    @Override
    protected void initView(View view) {
        final ImageView ivB = (ImageView) view.findViewById(R.id.iv_fb);
        Glide.with(getActivity()).load(imgUrl).into(ivB);
        Button btnBack = (Button) view.findViewById(R.id.btn_back_b);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        Button btnToC = (Button) view.findViewById(R.id.btn_toc);
        btnToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right);
                transaction.addToBackStack(null).replace(R.id.fragmnet_container, new FragmentC(), "fc").commit();
            }
        });
    }

    @Override
    protected View onChildCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_b, container, false);
    }
}
