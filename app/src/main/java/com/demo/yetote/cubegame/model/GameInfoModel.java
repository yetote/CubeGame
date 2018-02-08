package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 游戏信息Bean
 *
 * @author Swg
 * @date 2018/2/8 14:02
 */
public class GameInfoModel {
    private String video, img;
    private String title, followNum, manufacturer;
    private Boolean isFollow;
    private String score;

    public GameInfoModel(String video, String img, String title, String followNum, String manufacturer, Boolean isFollow, String score) {
        this.video = video;
        this.img = img;
        this.title = title;
        this.followNum = followNum;
        this.manufacturer = manufacturer;
        this.isFollow = isFollow;
        this.score = score;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public String getFollowNum() {
        return followNum;
    }

    public void setFollowNum(String followNum) {
        this.followNum = followNum;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getFollow() {
        return isFollow;
    }

    public void setFollow(Boolean follow) {
        isFollow = follow;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GameInfoModel{" +
                "video='" + video + '\'' +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", followNum='" + followNum + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", isFollow=" + isFollow +
                ", score='" + score + '\'' +
                '}';
    }
}
