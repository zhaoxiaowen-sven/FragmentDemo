
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Main2Activity extends AppCompatActivity implements FragmentClickListener, Fragment4.Fragment4ClickListener {

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
//            mFragment4 = new Fragment4();
//            mFragment4.setmListener(this);
            mFragmentManager = getFragmentManager();
            mFt = mFragmentManager.beginTransaction();
            mFt.add(R.id.fragment_container2, mFragment3, "fragment3");
//            mFt.add(R.id.fragment_container2,mFragment4, "fragment4");
//            mFt.hide(mFragment4);
            mFt.commit();
        }
    }
    
    @Override
    public void onFragmentClick(Fragment fragment) {
        if (fragment instanceof Fragment3) {
            mFt = mFragmentManager.beginTransaction();
            mFt.detach(mFragment3);
            if (mFragment4 == null) {
                mFragment4 = new Fragment4();
                mFragment4.setmListener(this);
                mFt.add(R.id.fragment_container2, mFragment4, "fragment4");
            } else {
//            mFt.hide(mFragment3);
//            mFt.remove(mFragment3);
//            mFt.addToBackStack(null);

//            mFt.addToBackStack(null);
                mFt.attach(mFragment4);
//            mFt.replace(R.id.fragment_container2,mFragment4,"fragment4");
//            mFragment3 = null;
            }
            mFt.commit();

        } else if (fragment instanceof Fragment4) {
            if (mFragment3 == null) {
                mFragment3 = new Fragment3();
            }
            mFt = mFragmentManager.beginTransaction();
            mFt.show(mFragment3);
//            mFt.replace(R.id.fragment_container2, mFragment3, "fragment3");
            mFt.commit();
        } else {

        }

    }

    @Override
    public void onFragment4Click() {
        Log.i(TAG, "onFragment4Click");
        if (mFragment3 == null) {
            mFragment3 = new Fragment3();
        }
        mFt = mFragmentManager.beginTransaction();

        mFt.detach(mFragment4);
//        mFt.show(mFragment3);
//        mFt.detach(mFragment4);
        mFt.attach(mFragment3);
//        mFt.add(R.id.fragment_container2, mFragment3, "fragment3");
//        mFt.replace(R.id.fragment_container2, mFragment3, "fragment3");
        mFt.commit();
//        mFragment4 = null;
    }
}
