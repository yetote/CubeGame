package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 首页Model
 *
 * @author Swg
 * @date 2018/3/12 21:10
 */
public class HomePagerModel {
    private String iv, title, content, score, discussNum, originate, tag, developerWords;
    private int id;
    public String getDeveloperWords() {
        return developerWords;
    }

    public void setDeveloperWords(String developerWords) {
        this.developerWords = developerWords;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "HomePagerModel{" +
                "iv='" + iv + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", score='" + score + '\'' +
                ", discussNum='" + discussNum + '\'' +
                ", originate='" + originate + '\'' +
                ", tag='" + tag + '\'' +
                ", developerWords='" + developerWords + '\'' +
                ", id=" + id +
                '}';
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(String discussNum) {
        this.discussNum = discussNum;
    }

    public String getOriginate() {
        return originate;
    }

    public void setOriginate(String originate) {
        this.originate = originate;
    }


    public HomePagerModel(String iv, String title, String content, String score, String discussNum, String originate, String tag, String developerWords, int id) {
        this.iv = iv;
        this.title = title;
        this.content = content;
        this.score = score;
        this.discussNum = discussNum;
        this.originate = originate;
        this.tag = tag;
        this.developerWords = developerWords;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
