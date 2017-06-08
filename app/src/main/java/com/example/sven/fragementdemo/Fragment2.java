
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SVEN on 2017/6/6.
 */

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        // return inflater.inflate(R.layout.fragment2, container, false);
        View view = inflater.inflate(R.layout.fragment2, container, false);
        view.findViewById(R.id.back2fragment1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getfragment1text();
            }
        });
        return view;
    }

    public void getfragment1text() {
        TextView textView = (TextView) getActivity().findViewById(R.id.fragment1_text);
        Toast.makeText(getActivity(), textView.getText(), Toast.LENGTH_SHORT).show();
    }
}
