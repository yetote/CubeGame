package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 游戏信息社区model
 *
 * @author Swg
 * @date 2018/2/28 14:10
 */
public class GameInfoForumModel {
    private String headImg, name, date, title, contentImg, content;
    private int seeNum, excellentNum, discussNum, id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "GameInfoForumModel{" +
                "headImg='" + headImg + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", contentImg='" + contentImg + '\'' +
                ", content='" + content + '\'' +
                ", seeNum=" + seeNum +
                ", excellentNum=" + excellentNum +
                ", discussNum=" + discussNum +
                ", id=" + id +
                '}';
    }

    public GameInfoForumModel(String headImg, String name, String date, String title, String contentImg, String content, int seeNum, int excellentNum, int discussNum, int id) {
        this.headImg = headImg;
        this.name = name;
        this.date = date;
        this.title = title;
        this.contentImg = contentImg;
        this.content = content;
        this.seeNum = seeNum;
        this.excellentNum = excellentNum;
        this.discussNum = discussNum;
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentImg() {
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    public int getSeeNum() {
        return seeNum;
    }

    public void setSeeNum(int seeNum) {
        this.seeNum = seeNum;
    }

    public int getExcellentNum() {
        return excellentNum;
    }

    public void setExcellentNum(int excellentNum) {
        this.excellentNum = excellentNum;
    }

    public int getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(int discussNum) {
        this.discussNum = discussNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
