package com.demo.yetote.cubegame.service;

import io.reactivex.Observable;
import okhttp3.Response;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * com.demo.yetote.cubegame.service
 * retrofit接口，向服务器发送用户信息
 *
 * @author Swg
 * @date 2018/2/2 11:52
 */
public interface LoginService {
    /**
     * 向服务器发送用户信息
     *
     * @param name 用户昵称
     * @param pic  用户头像
     * @param way  登录方式
     * @return 服务器返回信息
     */
    @POST("otherLogin.php")
    Observable<Response> sendUserInfo(@Field("name") String name,
                                      @Field("pic") String pic,
                                      @Field("way") String way);
}
