package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 *
 * @author Swg
 * @date 2018/1/17 14:40
 */
public class HomePgaerModel {
    private String img, title, content, tag, date;
    private int discuss;

    @Override
    public String toString() {
        return "HomePgaerModel{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", date='" + date + '\'' +
                ", discuss=" + discuss +
                '}';
    }

    public HomePgaerModel(String img, String title, String content, String tag, String date, int discuss) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.date = date;
        this.discuss = discuss;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDiscuss() {
        return discuss;
    }

    public void setDiscuss(int discuss) {
        this.discuss = discuss;
    }
}
