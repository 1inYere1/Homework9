package com.Homework9;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * @param src         - принимает выбранный массив
     * @param deleteIndex - принимает индекс элемента который нужно удалить
     * @return возвращает массив удалив при этом выбранный элемент по индексу
     */
    public static String[] deleteItemByIndex(String[] src, int deleteIndex) {
        String[] result = new String[src.length - 1];
        for (int i = 0; i < src.length - 1; i++) {
            if (i < deleteIndex) {
                result[i] = src[i];
            }
            if (i >= deleteIndex) {
                result[i] = src[i + 1];
            }
        }
        return result;
    }

    /**
     * @param src принимает массив из задач
     */
    static void taskList(String[] src) {
        System.out.println("Список задач: ");
        for (int i = 0; i < src.length; i++) {
            System.out.println(i + 1 + " - " + src[i]);
        }
    }

    /**
     * @param src - принимает массив из вариантов ответа
     */
    static void choiceYesOrNo(String[] src) {
        for (int i = 0; i < src.length; i++) {
            System.out.println(i + 1 + " - " + src[i]);

        }
    }

    static void task1() {
        Scanner sc = new Scanner(System.in);

        String[] tasks = {"Посмотреть видео", "Решить домашнее задание", "Получить оценку"};
        String[] yesNo = {"Да", "Нет"};

        taskList(tasks);

        System.out.println("Хотите добавить задачу? ");
        choiceYesOrNo(yesNo);

        int answer = sc.nextInt();
        boolean addTask = answer == 1;

        if (addTask) {
            tasks = Arrays.copyOf(tasks, tasks.length + 1);
            System.out.println("Введите Вашу задачу: ");
            sc.nextLine();
            tasks[tasks.length - 1] = sc.nextLine();
            taskList(tasks);
        }

        System.out.println("Хотите удалить задачу? ");
        choiceYesOrNo(yesNo);

        answer = sc.nextInt();
        boolean removeTask = answer == 1;

        if (removeTask) {
            System.out.println("Введите номер пункта который необходимо удалить: ");
            int indexOfItem = sc.nextInt() - 1;
            tasks = deleteItemByIndex(tasks, indexOfItem);
        }
        taskList(tasks);
    }

    public static void main(String[] args) {
        task1();
    }
}