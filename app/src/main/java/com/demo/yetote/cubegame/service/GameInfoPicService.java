package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.GameInfoPicModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * com.demo.yetote.cubegame.service
 * 请求游戏信息图片接口
 *
 * @author Swg
 * @date 2018/3/26 20:56
 */
public interface GameInfoPicService {
    /**
     * 请求游戏信息图片接口
     *
     * @return json数据
     */
    Observable<List<GameInfoPicModel>> getData();
}
