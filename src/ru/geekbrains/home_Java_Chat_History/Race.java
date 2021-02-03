package ru.geekbrains.home_Java_Chat_History;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private ArrayList<Stage> stages;
    public List<Stage> getStages() { return stages; }

    public Race() {

    }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
