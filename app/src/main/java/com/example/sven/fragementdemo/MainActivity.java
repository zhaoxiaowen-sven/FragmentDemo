
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLife";
    private Fragment fragment = new Fragment1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLog("onCreate...");
        setContentView(R.layout.activity_main);

        // 1.获取fragmentManager
        FragmentManager fragmentManager = getFragmentManager();
        // 2.获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 3.创建需要的Fragment
        // Fragment fragment = new Fragment1();
        // 4.动态添加fragment
        // 将创建的fragment添加到Activity布局文件中定义的占位符中（FrameLayout）
        fragmentTransaction.add(R.id.fragment_container, fragment, "fragment1").commit();
    }

    public void getFragmentMessage(View view) {

        printLog(fragment.getTag());
        // Fragment fragment = getFragmentManager().findFragmentByTag("fragment1");
        // printLog(fragment.toString());
        // fragment.onResume();
    }

    public void fragment1(View view) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new Fragment1())
                .commit();
    }
    //
    public void fragment2(View view) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new Fragment2())
                .commit();
    }

    @Override
    protected void onStart() {
        printLog("onStart...");
        super.onStart();
    }

    @Override
    protected void onStop() {
        printLog("onStop...");
        super.onStop();
    }

    @Override
    protected void onResume() {
        printLog("onResume...");
        super.onResume();
    }

    @Override
    protected void onPause() {
        printLog("onPause...");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        printLog("onDestroy...");
        super.onDestroy();
    }

    private void printLog(String msg) {
        // printLog("onCreate...");
        Log.i(TAG, msg);
    }
}
