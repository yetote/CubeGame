package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.GameInfoForumModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * com.demo.yetote.cubegame.service
 * 请求游戏社区信息接口
 *
 * @author Swg
 * @date 2018/3/26 20:54
 */
public interface GameInfoForumService {
    /**
     * 请求游戏社区信息接口
     *
     * @return json数据
     */
    Observable<List<GameInfoForumModel>> getData();
}
