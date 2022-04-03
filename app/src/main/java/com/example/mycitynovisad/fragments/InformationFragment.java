package com.example.mycitynovisad.fragments;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mycitynovisad.R;

import java.util.Objects;

public class InformationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_info, container, false );

        Objects.requireNonNull(getActivity()).setTitle( getString( R.string.app_name ) );

        TextView textView = rootView.findViewById( R.id.ns_des );
        Spannable span = new SpannableString( textView.getText() );
        span.setSpan( new RelativeSizeSpan( 1.8f ), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE );
        textView.setText( span );
        return rootView;
    }
}
