package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.GameInfoThemeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * com.demo.yetote.cubegame.service
 * 请求游戏信息评论主题帖接口
 *
 * @author Swg
 * @date 2018/3/26 20:57
 */
public interface GameInfoThemeService {
    /**
     * 请求游戏信息评论主题帖接口
     *
     * @return json数据
     */
    Observable<List<GameInfoThemeModel>> getData();
}
