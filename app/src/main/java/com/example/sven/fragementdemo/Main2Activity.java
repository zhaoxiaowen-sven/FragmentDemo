
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity
        implements FragmentClickListener, Fragment4.Fragment4ClickListener {

    private static final String TAG = "Main2Activity";
    private Fragment3 mFragment3;
    private Fragment4 mFragment4;
    private android.app.FragmentManager mFragmentManager;
    private FragmentTransaction mFt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (savedInstanceState == null) {
            mFragment3 = new Fragment3();
            // mFragment4 = new Fragment4();
            // mFragment4.setmListener(this);
            mFragmentManager = getFragmentManager();
            mFt = mFragmentManager.beginTransaction();
            Log.i(TAG, "add");
            mFt.add(R.id.fragment_container2, mFragment3, "fragment3");
            // mFt.add(R.id.fragment_container2,mFragment4, "fragment4");
            // mFt.detach(mFragment4);
            // mFt.hide(mFragment4);
            mFt.commit();
        }
    }

    @Override
    public void onFragmentClick(Fragment fragment, int id, String tag) {
        Log.i(TAG, "onFragmentClick");

        if (fragment instanceof Fragment3) {
            if (tag.equals("jump") && id == R.id.jump2fragment4) {
                // 每次操作都必须开一次事务，commit一次
                mFt = mFragmentManager.beginTransaction();

                if (mFragment4 == null) {

                    // getFragmentManager().findFragmentByTag()
                    mFragment4 = new Fragment4();
                    mFragment4.setmListener(this);
                    // mFt.hide(mFragment3);
                    // mFt.addToBackStack("fragment3");
                    mFt.add(R.id.fragment_container2, mFragment4, "fragment4");
                    // mFt.show(mFragment4);
                    // mFt.remove(mFragment3);
                    mFt.detach(mFragment3);
                    // mFt.replace(R.id.fragment_container2, mFragment4, "fragment4");
                    // mFt.addToBackStack(null);
                    // mFt.add(R.id.fragment_container2, mFragment4, "fragment4");
                } else {
                    // mFt.hide(mFragment3);
                    // mFt.show(mFragment4);

                    // mFt.remove(mFragment3);
                    // mFt.addToBackStack(null);

                    mFt.detach(mFragment3);
                    mFt.attach(mFragment4);
                    //
                    // mFt.addToBackStack(null);

                    // mFt.replace(R.id.fragment_container2,mFragment4,"fragment4");
                    // mFragment3 = null;
                    // mFt.hide(mFragment3);
                    // mFt.show(mFragment4);

                }
                mFt.commit();
            } else if (tag.equals("other")) {
                Log.i(TAG, "other click");
            } else {
                Log.i(TAG, "nothing clicked");
            }

        } else if (fragment instanceof Fragment4) {
            Log.i(TAG, "f4");
            mFt = mFragmentManager.beginTransaction();
            if (mFragment3 == null) {
                Log.i(TAG, "Fragment3 is null");
                // mFragment3 = new Fragment3();
                mFt.replace(R.id.fragment_container2, mFragment3, "fragment3");
            } else {
                Log.i(TAG, "Fragment3 is not null");
                Log.i(TAG, mFragment3.toString());
                mFt.detach(mFragment4);
                mFt.attach(mFragment3);

                // mFt.hide(mFragment4);
                // mFt.show(mFragment3);
                // mFt.replace(R.id.fragment_container2, mFragment3, "fragment3");
                // mFt.replace(R.id.fragment_container2, mFragment3, "fragment3");
                //
                // mFt.attach(mFragment3);
            }
            // mFt.show(mFragment3);
            // mFt.replace(R.id.fragment_container2, mFragment3, "fragment3");
            mFt.commit();
        } else {

        }

    }

    @Override
    public void onFragment4Click() {
        Log.i(TAG, "onFragment4Click");
        mFt = mFragmentManager.beginTransaction();
        if (mFragment3 == null) {
            mFragment3 = new Fragment3();

        }

        mFt.detach(mFragment4);
        // mFt.show(mFragment3);
        // mFt.detach(mFragment4);
        mFt.attach(mFragment3);
        // mFt.add(R.id.fragment_container2, mFragment3, "fragment3");
        // mFt.replace(R.id.fragment_container2, mFragment3, "fragment3");
        mFt.commit();
        // mFragment4 = null;
    }

    // 测试replace时加到事务回退栈是否会保存视图界面
    public void fragment3(View v) {
        // mFt = mFragmentManager.beginTransaction();
        // mFt.replace(R.id.fragment_container2, new Fragment3());
        // mFt.addToBackStack(null);
        // mFt.commit();
        // 2.先通过按钮repalce掉fragment3，再执行下面的方法，fragment实例还能查找到
        // 但是去寻找fragment的视图元素会报错，原因是视图会直接被销毁而实例不会？
        Fragment fragment = mFragmentManager.findFragmentByTag("fragment3");
        View v2 = this.findViewById(R.id.jump2fragment4);
        Log.i(TAG, "fragment3 is " + fragment + "view = " + v2.toString());
    }

    public void fragment4(View view) {
        mFt = mFragmentManager.beginTransaction();
        mFt.replace(R.id.fragment_container2, new Fragment4());
        mFt.addToBackStack(null);
        mFt.commit();
    }
}
