package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.GameLibModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * com.demo.yetote.cubegame.service
 * 请求游戏库信息接口
 *
 * @author Swg
 * @date 2018/3/26 20:58
 */
public interface GameLibService {
    /**
     * 请求游戏库信息接口
     *
     * @return json数据
     */
    Observable<List<GameLibModel>> getData();
}
