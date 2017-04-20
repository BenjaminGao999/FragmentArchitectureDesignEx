package com.gaos.fragmentnestedex.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaos.fragmentnestedex.R;

/**
 * Author:　Created by benjamin
 * DATE :  2017/4/14 10:53
 * versionCode:　1.0.0
 */

public abstract class BaseFragment extends Fragment {
    private boolean mIsOnCreateExcute;
    protected View mView;

    //如果是从backStack 重新启动，onDestoryView->onCreateView,不回调onCreate
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsOnCreateExcute = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        if (mView == null)
            mView = onChildCreateView(inflater, container, savedInstanceState);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mIsOnCreateExcute)
            initView(mView);
    }


    protected abstract View onChildCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initView(View view);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (getView() == null) return;
        ViewGroup parent = (ViewGroup) getView().getParent();
        parent.removeView(getView());
        mIsOnCreateExcute = false;
    }

    protected void goToFragment(BaseFragment fragment) {
        if (getActivity() == null) return;
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right);
        transaction.addToBackStack(null).replace(R.id.fragmnet_container, fragment, null).commit();
    }

    protected void goToFragmentWithoutBackStack(BaseFragment fragment) {
        if (getActivity() == null) return;
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right);
        transaction.replace(R.id.fragmnet_container, fragment, null).commit();
    }


    protected void clearAllFragmentTransaction() {
        if (getActivity() == null) return;
        for (int i = 0; i < getActivity().getSupportFragmentManager().getBackStackEntryCount(); i++) {
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }
}
