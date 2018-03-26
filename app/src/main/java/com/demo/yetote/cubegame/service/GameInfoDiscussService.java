package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.GameInfoDiscussModel;

import java.util.List;
import java.util.Observer;

import io.reactivex.Observable;

/**
 * com.demo.yetote.cubegame.service
 *请求游戏评论接口
 * @author Swg
 * @date 2018/3/26 20:52
 */
public interface GameInfoDiscussService {
    /**
     * 请求游戏评论接口
     *
     * @return json字符串
     */
    Observable<List<GameInfoDiscussModel>> getData();
}
