package com.flipkart.truecaller.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.flipkart.truecaller.R;
import com.flipkart.truecaller.listeners.RequestInfoListener;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity{


    @InjectView(R.id.requestInfoButton)
    Button requestInfoButton;
    List<RequestInfoListener> requestInfoListenerList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        requestInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(RequestInfoListener requestInfoListener: requestInfoListenerList) {
                    requestInfoListener.requestInfo();
                }
            }
        });
    }


    public void registerListener(RequestInfoListener requestInfoListener){
        requestInfoListenerList.add(requestInfoListener);
    }


    public void unregisterListener(RequestInfoListener requestInfoListener){
        requestInfoListenerList.remove(requestInfoListener);
    }

}
