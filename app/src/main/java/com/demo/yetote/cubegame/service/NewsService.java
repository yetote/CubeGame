package com.demo.yetote.cubegame.service;

import com.demo.yetote.cubegame.model.NewsModel;

import java.util.List;

import io.reactivex.Observable;


/**
 * com.demo.yetote.cubegame.service
 * 请求资讯信息接口
 *
 * @author Swg
 * @date 2018/3/26 21:00
 */
public interface NewsService {
    /**
     * 请求资讯信息接口
     *
     * @return json数据
     */
    Observable<List<NewsModel>> getData();
}
