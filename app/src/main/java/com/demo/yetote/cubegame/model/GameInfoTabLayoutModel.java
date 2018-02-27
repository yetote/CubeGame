package com.demo.yetote.cubegame.model;

/**
 * com.demo.yetote.cubegame.model
 * 游戏讯息tabLayout的bean
 *
 * @author Swg
 * @date 2018/2/27 10:58
 */
public class GameInfoTabLayoutModel {
    /**
     * 评价数
     */
    private int evaluateNum;

    /**
     * 论坛的帖子数
     */
    private int themeNum;

    @Override
    public String toString() {
        return "GameInfoTabLayoutModel{" +
                "evaluateNum='" + evaluateNum + '\'' +
                ", themeNum='" + themeNum + '\'' +
                '}';
    }

    public GameInfoTabLayoutModel(int evaluateNum, int themeNum) {
        this.evaluateNum = evaluateNum;
        this.themeNum = themeNum;
    }

    public int getEvaluateNum() {
        return evaluateNum;
    }

    public void setEvaluateNum(int evaluateNum) {
        this.evaluateNum = evaluateNum;
    }

    public int getThemeNum() {
        return themeNum;
    }

    public void setThemeNum(int themeNum) {
        this.themeNum = themeNum;
    }
}
