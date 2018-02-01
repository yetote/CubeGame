package com.demo.yetote.cubegame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;

/**
 * com.demo.yetote.cubegame.adapter
 * 短信验证码登录
 *
 * @author Swg
 * @date 2018/1/1 9:31
 */
public class VerifyCodeLoginActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private CardView cardView;
    private EditText tel, verifyCode;
    private Button getVerifyCode, sure;
    private static final String TAG = "VerifyCodeLoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifycodelogin);
        initViews();

        // TODO: 2018/2/1 重复方法待抽取 与PwdLoginActivity中的方法重复

        startAnimation();

    }

    private void initViews() {
        fab = findViewById(R.id.verifyCodeLogin_fab);
        cardView = findViewById(R.id.verifyCodeLogin_cardView);
        tel = findViewById(R.id.verifyCodeLogin_tel_et);
        verifyCode = findViewById(R.id.verifyCodeLogin_verifyCode_et);
        getVerifyCode = findViewById(R.id.verifyCodeLogin_getVerifyCode_btn);
        sure = findViewById(R.id.verifyCodeLogin_sure);
    }

    private void startAnimation() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);
        getWindow().setSharedElementEnterTransition(transition);
        Log.e(TAG, "startAnimation: " + "ccc");
        transition.addListener(new Transition.TransitionListener() {
            /**
             * 动画开始
             * @param transition 动画
             */
            @Override
            public void onTransitionStart(Transition transition) {
                cardView.setVisibility(View.GONE);
                Log.e(TAG, "onTransitionStart: " + "bbb");
            }

            /** 动画结束
             * @param transition 动画
             */
            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                animateRevelShow();
            }

            /**
             * 中途取消动画
             * @param transition 动画
             */
            @Override
            public void onTransitionCancel(Transition transition) {

            }

            /**
             * 动画暂停  无
             * @param transition 动画
             */
            @Override
            public void onTransitionPause(Transition transition) {

            }

            /**
             * 动画重启 无
             * @param transition 动画
             */
            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }

    /**
     * 开启水波纹动画
     */
    private void animateRevelShow() {
        int centerY = fab.getBottom() - fab.getHeight() / 2 - cardView.getTop();
        int centerX = fab.getLeft() + fab.getWidth() / 2;
        float endRadius = (float) Math.sqrt((cardView.getHeight() - centerY) * (cardView.getHeight() - centerY) + cardView.getWidth() * cardView.getWidth());
        Animator animation = ViewAnimationUtils.createCircularReveal(cardView, centerX, centerY, 0, endRadius);
        animation.setDuration(500);
        //AccelerateInterpolator插值器为线性加速
        animation.setInterpolator(new AccelerateInterpolator());
        animation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                cardView.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);
            }
        });
        Log.e(TAG, "animateRevelShow: " + "aaa");
        animation.start();
    }

    /**
     * 关闭水波纹动画
     */
    private void animationRevelClose() {
        int centerY = fab.getBottom() - fab.getHeight() / 2 - cardView.getTop();
        int centerX = fab.getLeft() + fab.getWidth() / 2;
        float startRadius = (float) Math.sqrt((cardView.getHeight() - centerY) * (cardView.getHeight() - centerY) + cardView.getWidth() * cardView.getWidth());
        Animator animator = ViewAnimationUtils.createCircularReveal(cardView, centerX, centerY, startRadius, fab.getWidth() / 2);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cardView.setVisibility(View.GONE);
                super.onAnimationEnd(animation);
                VerifyCodeLoginActivity.super.onBackPressed();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(500);
        animator.start();
    }

    @Override
    public void onBackPressed() {
        animationRevelClose();
    }
}
