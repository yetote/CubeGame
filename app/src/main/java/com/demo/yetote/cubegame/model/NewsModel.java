package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 资讯Model
 *
 * @author Swg
 * @date 2018/1/17 14:40
 */
public class NewsModel {
    private String img, title, content, tag, date;
    private int discuss, id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", date='" + date + '\'' +
                ", discuss=" + discuss +
                ", id=" + id +
                '}';
    }

    public NewsModel(String img, String title, String content, String tag, String date, int discuss, int id) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.date = date;
        this.discuss = discuss;
        this.id = id;
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
