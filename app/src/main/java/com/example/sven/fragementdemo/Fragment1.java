
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by SVEN on 2017/6/6.
 */

public class Fragment1 extends Fragment {

    private static final String TAG = "FragmentLife";

    public void printSth() {
        Log.i(TAG, "fragment3 printSth");
    }
    @Override
    public void onAttach(Context context) {
        printLog("onAttach...");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLog("onCreate...");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        printLog("onCreateView...");
        // return inflater.inflate(R.layout.fragment1, container, false);
        View v = inflater.inflate(R.layout.fragment1, container, false);
        Button button = (Button) v.findViewById(R.id.jump2fragment2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump2fragment2();
            }
        });
        return v;
    }

    public void jump2fragment2() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        // fragment之间跳转时
        // 1.只采用replace 实例会被销毁 back键一次退出当前ctivity
        // fragmentTransaction.replace(R.id.fragment_container,new Fragment2());
        // fragmentTransaction.addToBackStack(null);
        //
        // 2.把当前事务的变化情况添加到回退栈,视图会被销毁但是实例还在(back 2次)
        // fragmentTransaction.replace(R.id.fragment_container,new Fragment2());
        // fragmentTransaction.addToBackStack(null);
        //
        // 3.采用hide方式 实例不会被销毁,视图也不会被销毁(back 2次)
        fragmentTransaction.hide(this);
        fragmentTransaction.add(R.id.fragment_container, new Fragment2());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        printLog("onActivityCreated...");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        printLog("onStart...");
        super.onStart();
    }

    @Override
    public void onResume() {
        printLog("onResume...");
        super.onResume();
    }

    @Override
    public void onPause() {
        printLog("onPause...");
        super.onPause();
    }

    @Override
    public void onStop() {
        printLog("onStop...");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        printLog("onDestroyView...");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        printLog("onDestroy...");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        printLog("onDetach...");
        super.onDetach();
    }

    private void printLog(String msg) {
        Log.i(TAG, msg);
    }
}
