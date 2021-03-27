package com.pashin.app.strategy;

public class Subject {

    private String title;

    private int mark;

    public Subject() { }

    public Subject(String title, int mark) {
        this.title = title;
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) throws Exception {
        if (mark > 6 || mark < 0) {
            throw new Exception("Оценка должна находится в диапазоне от 1 до 5.");
        } else {
            this.mark = mark;
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", mark=" + mark +
                '}';
    }
}
