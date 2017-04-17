package com.gaos.fragmentnestedex.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gaos.fragmentnestedex.R;

/**
 * Author:　Created by benjamin
 * DATE :  2017/4/17 15:57
 * versionCode:　1.0.0
 */

public class FragmentC extends BaseFragment {

    @Override
    protected View onChildCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_c, container, false);
    }

    @Override
    protected void initView(View view) {
        Button btnBackC = (Button) view.findViewById(R.id.btn_back_c);
        btnBackC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().popBackStack();
                getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                clearAllFragmentTransaction();

//                goToFragmentWithoutBackStack(new FragmentB());
            }
        });
    }
}
