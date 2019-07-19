package com.d.keyframe;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeImageTransform;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateInterpolator;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout cc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyframe_1);

        cc1 = findViewById(R.id.cc1);


        findViewById(R.id.tap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateToKeyframeTwo();
            }
        });

    }

    public void animateToKeyframeTwo() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.keyframe_2);


        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateInterpolator(1.0f));
        transition.setDuration(1200);
        

        TransitionManager.beginDelayedTransition(cc1, transition);
        constraintSet.applyTo(cc1);


    }
}
