package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 游戏信息图片Bean
 *
 * @author Swg
 * @date 2018/2/8 14:03
 */
public class GameInfoPicModel {
    private String img;

    public GameInfoPicModel(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "GameInfoPicModel{" +
                "img='" + img + '\'' +
                '}';
    }
}
