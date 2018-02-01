package com.demo.yetote.cubegame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TextView;

/**
 * com.demo.yetote.cubegame.adapter
 * 密码登录
 *
 * @author Swg
 * @date 2018/1/25 10:06
 */
public class PwdLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fab;
    private CardView cardView;
    private EditText tel, pwd;
    private Button sure;
    private TextView toVerifyCodeLogin;
    private static final String TAG = "PwdLoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwdlogin);
        getWindow().setExitTransition(null);
        getWindow().setEnterTransition(null);
        initViews();

        // TODO: 2018/2/1 重复代码 待抽取
        startAnimation();

        onClick();
    }

    private void onClick() {
        fab.setOnClickListener(this);
    }

    private void initViews() {
        fab = findViewById(R.id.pwdlogin_fab);
        cardView = findViewById(R.id.pwdlogin_cardview);
        tel = findViewById(R.id.pwdlogin_tel_et);
        pwd = findViewById(R.id.pwdlogin_pwd_et);
        toVerifyCodeLogin = findViewById(R.id.pwdlogin_to_verifyCodeLogin);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pwdlogin_fab:
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                startActivity(new Intent(this, VerifyCodeLoginActivity.class), options.toBundle());
                break;
            default:
                break;
        }
    }

    /**
     * 开启Activity交互的动画，狭义可以理解为转场动画
     */
    private void startAnimation() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);
        getWindow().setSharedElementEnterTransition(transition);
        transition.addListener(new Transition.TransitionListener() {
            /**
             * 动画开始
             * @param transition 动画
             */
            @Override
            public void onTransitionStart(Transition transition) {
                cardView.setVisibility(View.GONE);
                Log.e(TAG, "onTransitionStart: " + "asa");

            }

            /** 动画结束
             * @param transition 动画
             */
            @Override
            public void onTransitionEnd(Transition transition) {
                animateRevelShow();
                transition.removeListener(this);
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
        int centerX = cardView.getWidth() / 2;
        int centerY = 0;
        float endRadius = (float) Math.sqrt(centerX * centerX + cardView.getHeight() * cardView.getHeight());
        Log.e(TAG, "animateRevelShow: " + endRadius);
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
        animation.start();
    }

    /**
     * 关闭水波纹动画
     */
    private void animationRevelClose() {
        int centerX = cardView.getWidth() / 2;
        int centerY = 0;
        float startRadius = (float) Math.sqrt(centerX * centerX + cardView.getHeight() * cardView.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(cardView, centerX, centerY, startRadius, fab.getWidth() / 2);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cardView.setVisibility(View.INVISIBLE);
                super.onAnimationEnd(animation);
                PwdLoginActivity.super.onBackPressed();
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
        //按下返回键调用关闭水波纹动画
        animationRevelClose();
    }
}
