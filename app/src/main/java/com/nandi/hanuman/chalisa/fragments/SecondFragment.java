package com.nandi.hanuman.chalisa.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nandi.hanuman.chalisa.R;


public class SecondFragment extends Fragment {

    private TextView textView;

    private static final String MANTRA = "MANTRA";

    public static SecondFragment newInstance(String text) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(MANTRA, text);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        String mantra = getArguments().getString(MANTRA);
        if (mantra != null) {
            textView.setText(mantra);
        }
        return view;
    }
}
