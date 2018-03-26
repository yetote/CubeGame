package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.HomePagerModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * com.demo.yetote.cubegame.service
 * 请求首页信息接口
 *
 * @author Swg
 * @date 2018/3/26 20:59
 */
public interface HomePagerService {
    /**
     * 请求首页信息接口
     *
     * @return json数据
     */
    Observable<List<HomePagerModel>> getData();
}
