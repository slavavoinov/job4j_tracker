package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                count++;
                score += subject.score();
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            Label label = new Label(pupil.name(), score / pupil.subjects().size());
            result.add(label);
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), score + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = entry.getValue() / pupils.size();
            result.add(new Label(entry.getKey(), score));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            label.add(new Label(pupil.name(), score));
            score = 0;
        }
        return Collections.max(label);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(),
                        map.getOrDefault(subject.name(), 0)
                                + subject.score());
            }
        }
        List<Label> label = new ArrayList<>();
        for (String key : map.keySet()) {
            label.add(new Label(key, (double) map.get(key)));
        }
        return Collections.max(label);
    }
}
