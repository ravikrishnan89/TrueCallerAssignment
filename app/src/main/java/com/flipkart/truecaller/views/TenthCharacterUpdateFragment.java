package com.flipkart.truecaller.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flipkart.truecaller.R;
import com.flipkart.truecaller.TrueCallerApplication;
import com.flipkart.truecaller.modules.TenthCharacterFragmentModule;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public class TenthCharacterUpdateFragment extends CommonFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = super.onCreateView(inflater,container,savedInstanceState);
        textView.setText(R.string.tenth_character_view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        TrueCallerApplication.getAppComponent().plus(new TenthCharacterFragmentModule(this)).
                inject(this);
    }

}
