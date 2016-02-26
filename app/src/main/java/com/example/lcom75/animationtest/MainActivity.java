package com.example.lcom75.animationtest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv1.setImageResource(R.drawable.image_lavel);
        ObjectAnimator imageViewObjectAnimator = ObjectAnimator.ofFloat(iv1,
                "rotation", 0f, 360f);
        imageViewObjectAnimator.setInterpolator(new DecelerateInterpolator());
        imageViewObjectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        imageViewObjectAnimator.setDuration(3000);
//        imageViewObjectAnimator.start();
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(iv1, "alpha", 1f, 0.5f);
        alphaAnimator.setInterpolator(new AccelerateInterpolator(4f));
        alphaAnimator.setRepeatCount(ValueAnimator.INFINITE);
        alphaAnimator.setDuration(3000);
        alphaAnimator.setStartDelay(2000);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue("alpha");
                Log.e(TAG, "Alpha :" + alpha);
            }
        });

//        alphaAnimator.start();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(imageViewObjectAnimator).with(alphaAnimator);
        animatorSet.start();
//        AnimationSet animationSet = new AnimationSet(true);
//        final Animation animator1 = AnimationUtils.loadAnimation(this, R.anim.rotate_1);
//        final Animation animator2 = AnimationUtils.loadAnimation(this, R.anim.rotate_1);
//        final Animation animator3 = AnimationUtils.loadAnimation(this, R.anim.rotate_1);
//        final Animation animator4 = AnimationUtils.loadAnimation(this, R.anim.rotate_1);
//        animator1.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
////                iv1.setImageResource(R.drawable.image2);
////                iv1.startAnimation(animator2);
//                ImageViewAnimatedChange(MainActivity.this, iv1, R.drawable.image2, animator2, 1);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        animator2.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
////                iv1.setImageResource(R.drawable.image3);
////                iv1.startAnimation(animator3);
//                ImageViewAnimatedChange(MainActivity.this, iv1, R.drawable.image3, animator3, 2);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        animator3.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
////                iv1.setImageResource(R.drawable.image4);
////                iv1.startAnimation(animator4);
//                ImageViewAnimatedChange(MainActivity.this, iv1, R.drawable.image4, animator4, 3);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        animator4.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
////                iv1.setImageResource(R.drawable.image1);
////                iv1.startAnimation(animator1);
//                ImageViewAnimatedChange(MainActivity.this, iv1, R.drawable.image1, animator1, 0);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        iv1.setAnimation(animator1);
//        animationSet.start();
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    void ImageViewAnimatedChange(Context c, final ImageView v, final int new_image, final Animation manimation, final int Level) {
////        final Animation anim_out = AnimationUtils.loadAnimation(c, android.R.anim.fade_out);
////        final Animation anim_in = AnimationUtils.loadAnimation(c, android.R.anim.fade_in);
////        anim_out.setAnimationListener(new Animation.AnimationListener() {
////            @Override
////            public void onAnimationStart(Animation animation) {
////            }
////
////            @Override
////            public void onAnimationRepeat(Animation animation) {
////            }
////
////            @Override
////            public void onAnimationEnd(Animation animation) {
//                iv1.setImageLevel(Level);
////                anim_in.setAnimationListener(new Animation.AnimationListener() {
////                    @Override
////                    public void onAnimationStart(Animation animation) {
////                    }
////
////                    @Override
////                    public void onAnimationRepeat(Animation animation) {
////                    }
////
////                    @Override
////                    public void onAnimationEnd(Animation animation) {
//                        v.startAnimation(manimation);
////                    }
////                });
////                v.startAnimation(anim_in);
////            }
////        });
////        v.startAnimation(anim_out);
    }
}
