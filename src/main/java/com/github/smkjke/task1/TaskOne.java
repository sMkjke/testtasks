package com.github.smkjke.task1;

import java.util.Arrays;
import java.util.Scanner;

public class TaskOne {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        TaskOne taskOne = new TaskOne();
        System.out.println(taskOne.rebuildWall(line));
    }

    public boolean validateData(String line) {
        if (line == null || line.equals("")) {
            System.out.print(("Данные не введены"));
            return false;
        }
        try {
            int[] wall = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (Integer i : wall) {
                if (i <= 0 || i > 10) {
                    System.out.print("Введенные данные некорректны");
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите натуральные числа (каждое из них от 1 до 10)");
            return false;
        }
        return true;
    }


    public int rebuildWall(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        if (validateData(line)) {
            int[] wall = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            long wallMedian = findMedian(wall);
            stringBuilder.append(Arrays.toString(wall).replaceAll(",", " "));
            for (int x = 0; x <= wall.length - 1; x++) {
                while (wall[x] != wallMedian) {
                    count++;
                    if (wall[x] > wallMedian) {
                        wall[x]--;
                    } else {
                        wall[x]++;
                    }
                    if (count > 0) {
                        stringBuilder.append(" => ");
                    }
                    stringBuilder.append(Arrays.toString(wall).replaceAll(",", " "));
                }
            }
            stringBuilder.append("\n" + "Минимальное количество ходов: ").append(count);
        }
        System.out.print(stringBuilder.toString());
        return count;
    }

    private long findMedian(int[] wall) {
        int[] values = Arrays.copyOf(wall, wall.length);
        Arrays.sort(values);
        double median;
        int totalElements = values.length;

        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = values[totalElements / 2] +
                    values[totalElements / 2 - 1];
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            median = values[values.length / 2];
        }
        return Math.round(median);
    }
}