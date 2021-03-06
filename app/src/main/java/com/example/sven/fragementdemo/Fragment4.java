
package com.example.sven.fragementdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment4 extends Fragment implements View.OnClickListener {

    private Fragment4ClickListener mListener;

    public void setmListener(Fragment4ClickListener mListener) {
        this.mListener = mListener;
    }

    public void printSth() {

    }

    public interface Fragment4ClickListener {
        void onFragment4Click();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment4, container, false);
        Button button = (Button) v.findViewById(R.id.jump2fragment3);
        button.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (getActivity() instanceof FragmentClickListener) {
            ((FragmentClickListener) getActivity()).onFragmentClick(this, v.getId(), "jump");
        }
        // mListener.onFragment4Click();
    }
}
