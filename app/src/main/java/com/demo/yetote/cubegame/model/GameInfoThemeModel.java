package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 游戏信息官方主题贴
 *
 * @author Swg
 * @date 2018/2/8 14:05
 */
public class GameInfoThemeModel {
    private String title, content, time, discussNum;
    private int id;

    public GameInfoThemeModel(String title, String content, String time, String discussNum, int id) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.discussNum = discussNum;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(String discussNum) {
        this.discussNum = discussNum;
    }

    @Override
    public String toString() {
        return "GameInfoThemeModel{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", discussNum='" + discussNum + '\'' +
                ", id=" + id +
                '}';
    }
}
