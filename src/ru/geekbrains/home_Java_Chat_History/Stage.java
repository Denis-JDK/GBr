package ru.geekbrains.home_Java_Chat_History;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c, int stagePos, int stageCount, long startTime);
}
