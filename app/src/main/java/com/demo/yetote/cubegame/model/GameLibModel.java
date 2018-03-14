package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 游戏库Model
 *
 * @author Swg
 * @date 2018/3/14 20:40
 */
public class GameLibModel {
    private String title, tag, img, score;
    private int id;

    @Override
    public String toString() {
        return "GameLibModel{" +
                "title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", img='" + img + '\'' +
                ", score='" + score + '\'' +
                ", id=" + id +
                '}';
    }

    public GameLibModel(String title, String tag, String img, String score, int id) {
        this.title = title;
        this.tag = tag;
        this.img = img;
        this.score = score;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
