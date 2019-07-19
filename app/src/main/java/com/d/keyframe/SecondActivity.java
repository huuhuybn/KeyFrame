package com.d.keyframe;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.ChangeBounds;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateInterpolator;

public class SecondActivity extends AppCompatActivity {



    // tham chiếu ConstraintLayout ở frame_one.xml
    private ConstraintLayout cl1;

    // biến boolen để kiểm tra xem đã thực hiện animation chưa
    private boolean isChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_one);
        cl1 = findViewById(R.id.cl1);

        // set sự kiện click vào text tap to start
        findViewById(R.id.tvStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChanged) animateToKeyframeOne();
                else animateToKeyframeTwo();

            }
        });
    }

    public void animateToKeyframeTwo() {

        isChanged = true;

        // copy vị trí của view trên frame_two
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.frame_two);


        // khởi tạo transition là changeBounds
        ChangeBounds transition = new ChangeBounds();
        // tốc độ
        transition.setInterpolator(new AnticipateInterpolator(1.0f));

        // thời gian
        transition.setDuration(1200);


        // bắt đầu chạy animation 
        TransitionManager.beginDelayedTransition(cl1, transition);
        constraintSet.applyTo(cl1);

    }

    public void animateToKeyframeOne() {

        isChanged = false;

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.frame_one);


        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateInterpolator(1.0f));
        transition.setDuration(1200);


        TransitionManager.beginDelayedTransition(cl1, transition);
        constraintSet.applyTo(cl1);

    }
}
