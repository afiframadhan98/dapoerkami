package android.dapoerkami.com.dapoerkami;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RemindToCook extends Fragment {

    private static final String TAG = "Tab1Fragment";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remind_to_cook,container,false);

        return view;
    }

}
