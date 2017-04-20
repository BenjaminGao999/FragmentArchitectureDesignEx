package com.gaos.fragmentnestedex.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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

public class FragmentA extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "Fragment";
    private ImageView miv;
    private final String imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493016407&di=f945579fb9ac5ad6833f0794e2724c67&imgtype=jpg&er=1&src=http%3A%2F%2Fpic36.nipic.com%2F20131203%2F3822951_100920265000_2.jpg";

    @Override
    protected void initView(View view) {
        miv = (ImageView) view.findViewById(R.id.iv_fa);
        Glide.with(getActivity()).load(imgUrl).into(miv);
        Button btnShowA = (Button) view.findViewById(R.id.btn_back_a);
        Button btnToB = (Button) view.findViewById(R.id.btn_tob);
        btnShowA.setOnClickListener(this);
        btnToB.setOnClickListener(this);
    }

    @Override
    protected View onChildCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_a, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_a:
                getActivity().finish();
                break;
            case R.id.btn_tob:
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right);
                transaction.addToBackStack(null).replace(R.id.fragmnet_container, new FragmentB(), "fb").commit();
                break;
            default:
                break;
        }
    }
}
