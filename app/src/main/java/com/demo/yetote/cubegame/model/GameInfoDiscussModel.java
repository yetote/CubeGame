package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 游戏信息评论bean
 *
 * @author Swg
 * @date 2018/2/27 16:42
 */
public class GameInfoDiscussModel {
    private String img, date, name, content, discussPeople, discussContent, phone,discussPeople2, discussContent2;
    private int id, discussNum, excellentNum, badNum;

    public String getDiscussPeople2() {
        return discussPeople2;
    }

    public void setDiscussPeople2(String discussPeople2) {
        this.discussPeople2 = discussPeople2;
    }

    public String getDiscussContent2() {
        return discussContent2;
    }

    public void setDiscussContent2(String discussContent2) {
        this.discussContent2 = discussContent2;
    }

    @Override
    public String toString() {
        return "GameInfoDiscussModel{" +
                "img='" + img + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", discussPeople='" + discussPeople + '\'' +
                ", discussContent='" + discussContent + '\'' +
                ", phone='" + phone + '\'' +
                ", discussPeople2='" + discussPeople2 + '\'' +
                ", discussContent2='" + discussContent2 + '\'' +
                ", id=" + id +
                ", discussNum=" + discussNum +
                ", excellentNum=" + excellentNum +
                ", badNum=" + badNum +
                '}';
    }

    public GameInfoDiscussModel(String img, String date, String name, String content, String discussPeople, String discussContent, String phone, String discussPeople2, String discussContent2, int id, int discussNum, int excellentNum, int badNum) {
        this.img = img;
        this.date = date;
        this.name = name;
        this.content = content;
        this.discussPeople = discussPeople;
        this.discussContent = discussContent;
        this.phone = phone;
        this.discussPeople2 = discussPeople2;
        this.discussContent2 = discussContent2;
        this.id = id;
        this.discussNum = discussNum;
        this.excellentNum = excellentNum;
        this.badNum = badNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDiscussPeople() {
        return discussPeople;
    }

    public void setDiscussPeople(String discussPeople) {
        this.discussPeople = discussPeople;
    }

    public String getDiscussContent() {
        return discussContent;
    }

    public void setDiscussContent(String discussContent) {
        this.discussContent = discussContent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(int discussNum) {
        this.discussNum = discussNum;
    }

    public int getExcellentNum() {
        return excellentNum;
    }

    public void setExcellentNum(int excellentNum) {
        this.excellentNum = excellentNum;
    }

    public int getBadNum() {
        return badNum;
    }

    public void setBadNum(int badNum) {
        this.badNum = badNum;
    }
}
