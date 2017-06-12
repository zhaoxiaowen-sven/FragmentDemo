
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements FragmentClickListener {
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private android.app.FragmentManager mFragmentManager;
    private FragmentTransaction mFt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragment3 = new Fragment3();
        mFragmentManager = getFragmentManager();
        mFt = mFragmentManager.beginTransaction();
        mFt.add(R.id.fragment_container2, fragment3, "fragment3");
        mFt.commit();
    }

    @Override
    public void onFragmentClick(Fragment fragment) {
        if (fragment instanceof Fragment3) {
            if (fragment4 == null) {
                fragment4 = new Fragment4();
            }

            mFt = mFragmentManager.beginTransaction();
            mFt.hide(fragment3);
            mFt.show(fragment4);
            // mFt.replace(R.id.fragment_container2,fragment4,"fragment4");
            mFt.commit();
        } else if (fragment instanceof Fragment4) {
            if (fragment3 == null) {
                fragment3 = new Fragment3();
            }
            mFt = mFragmentManager.beginTransaction();
            mFt.replace(R.id.fragment_container2, fragment3, "fragment3");
            mFt.commit();
        } else {

        }
    }
}
