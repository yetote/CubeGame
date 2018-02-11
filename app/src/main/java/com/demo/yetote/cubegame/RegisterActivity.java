package com.demo.yetote.cubegame;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.demo.yetote.cubegame.utils.Config;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * com.demo.yetote.cubegame
 * 注册
 *
 * @author Swg
 * @date 2018/1/29 14:52
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fab;
    private RelativeLayout include;
    private Button qqLogin, weChatLogin, sinaLogin;
    private static final String TAG = "RegisterActivity";
    private IUiListener iuiListener;
    private Tencent mTencent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置进出Activity动画为null
        getWindow().setEnterTransition(null);
        getWindow().setExitTransition(null);

        setContentView(R.layout.activity_register);

        initData();
        initViews();
        onClick();

    }

    private void initData() {
        mTencent = Tencent.createInstance(Config.QQLOGIN_APPID, this);
    }

    private void onClick() {
        fab.setOnClickListener(this);
        qqLogin.setOnClickListener(this);
    }

    private void initViews() {
        fab = findViewById(R.id.register_fab);
        include = findViewById(R.id.register_other_login);
        qqLogin = include.findViewById(R.id.QQLogin);
        weChatLogin = include.findViewById(R.id.WeChatLogin);
        sinaLogin = include.findViewById(R.id.SinaLogin);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_fab:
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                startActivity(new Intent(this, PwdLoginActivity.class), options.toBundle());
                break;
            case R.id.QQLogin:
                // TODO: 2018/2/2 需要进行封装
                qqlogin();
                break;
            default:
                break;
        }
    }

    private void qqlogin() {
        iuiListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                Log.e(TAG, "onComplete: " + o);
                JSONObject jo = (JSONObject) o;
                try {
                    mTencent.setOpenId(jo.getString("openid"));
                    mTencent.setAccessToken(jo.getString("access_token"), jo.getString("expires_in"));
                    getuser(mTencent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(UiError uiError) {

            }

            /**
             * 取消登录
             */
            @Override
            public void onCancel() {

            }
        };
        mTencent.login(this, "all", iuiListener);
    }

    /**
     * 获取用户信息
     *
     * @param mTencent Tencent实例
     */
    private void getuser(Tencent mTencent) {
        UserInfo userInfo = new UserInfo(this, mTencent.getQQToken());
        userInfo.getUserInfo(new IUiListener() {
            @Override
            public void onComplete(Object o) {
                if (o == null)
                    Toast.makeText(RegisterActivity.this, "获取信息失败", Toast.LENGTH_SHORT).show();
                else {
                    Observable.create(e -> e.onNext(o))
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(s -> {
                                JSONObject jo = (JSONObject) s;
                                String name = jo.getString("nickname");
                                String pic = jo.getString("figureurl_qq_2");
                                updateUserInfo(name, pic, "QQ");
                            });
                }
            }


            @Override
            public void onError(UiError uiError) {

            }

            @Override
            public void onCancel() {

            }
        });
    }


    /**
     * 上传用户信息
     *
     * @param name 用户昵称
     * @param pic  用户头像
     * @param qq   登录方式
     */
    private void updateUserInfo(String name, String pic, String qq) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Constants.REQUEST_LOGIN:
                if (resultCode == RESULT_OK) Tencent.handleResultData(data, iuiListener);
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
