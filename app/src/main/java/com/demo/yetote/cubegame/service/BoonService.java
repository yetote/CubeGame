package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.BoonModel;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * com.demo.yetote.cubegame.service
 *请求福利游戏信息接口
 * @author Swg
 * @date 2018/3/26 20:31
 */
public interface BoonService {
    /**
     * 请求福利游戏信息接口
     * @return json字符串
     */
    Observable<ArrayList<BoonModel>> getData();
}
