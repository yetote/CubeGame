package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 *
 * @author Swg
 * @date 2018/3/13 20:33
 */
public class BoonModel {
    private String title,tag, img, content, percentage, originalCost, discountCost;
    private int id, time;

    @Override
    public String toString() {
        return "BoonModel{" +
                "title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", img='" + img + '\'' +
                ", content='" + content + '\'' +
                ", percentage='" + percentage + '\'' +
                ", originalCost='" + originalCost + '\'' +
                ", discountCost='" + discountCost + '\'' +
                ", id=" + id +
                ", time=" + time +
                '}';
    }

    public BoonModel(String title, String tag, String img, String content, String percentage, String originalCost, String discountCost, int id, int time) {
        this.title = title;
        this.tag = tag;
        this.img = img;
        this.content = content;
        this.percentage = percentage;
        this.originalCost = originalCost;
        this.discountCost = discountCost;
        this.id = id;
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(String originalCost) {
        this.originalCost = originalCost;
    }

    public String getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(String discountCost) {
        this.discountCost = discountCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
