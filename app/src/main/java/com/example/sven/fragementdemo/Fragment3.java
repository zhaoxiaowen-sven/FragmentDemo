
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment3 extends Fragment implements View.OnClickListener {

    private static final String TAG = "Fragment3";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment3, container, false);
        Button button = (Button) v.findViewById(R.id.jump2fragment4);
        button.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {

        Log.i(TAG, "onClick");
        if (getActivity() instanceof FragmentClickListener) {
            ((FragmentClickListener) getActivity()).onFragmentClick(this);
        }
    }
}
