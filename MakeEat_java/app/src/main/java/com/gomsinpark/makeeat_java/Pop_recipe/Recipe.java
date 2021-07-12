package com.gomsinpark.makeeat_java.Pop_recipe;

public class Recipe {
    private String 과자;
    private String views; //조회수
    private String title; //제목
    private String subtitle; //부제목
    private String cooking_difficulty; //요리난이도
    private String chef; //작성자명
    private String servings; //인분
    private String material; //재료
    private String tag; //태그
    private String tip; //팁
    private String Cook_Step; //태그
    private String filename; //이미지
    private String cooking_time; //조리시간
    private int rank; // 순위

    private int like;//좋아요

    public Recipe() {
    }

    public String get과자() {
        return 과자;
    }

    public void set과자(String 과자) {
        this.과자 = 과자;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCooking_difficulty() {
        return cooking_difficulty;
    }

    public void setCooking_difficulty(String cooking_difficulty) {
        this.cooking_difficulty = cooking_difficulty;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getCook_Step() {
        return Cook_Step;
    }

    public void setCook_Step(String cook_Step) {
        Cook_Step = cook_Step;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(String cooking_time) {
        this.cooking_time = cooking_time;
    }

    public int getRank() { return rank; }

    public void setRank(int rank) { this.rank = rank; }
}
