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

    /**
     * @param src - принимает заданный массив
     * @return возвращает значение максимального элемента из массива
     */
    static int maximumElementValue(int[] src) {
        int maximum = src[0];
        for (int i = 0; i < src.length; i++) {
            int value = src[i];
            if (maximum < value) {
                maximum = value;
            }
        }
        return maximum;
    }

    static void task2() {
        int[] array = {16, 23, 5, 61, 8, 97, 13, 3, 44, 18};
        int maximumValue = maximumElementValue(array);
        System.out.println("Значение максимального элемента: " + maximumValue);
    }

    /**
     * @param src - принимает заданный массив
     * @return возвращает индекс максимального элемента из массива
     */
    static int indexOfMaximumElement(int[] src) {
        int maximum = src[0];
        int indexOfMaximum = 0;
        for (int i = 0; i < src.length; i++) {
            int value = src[i];
            if (maximum < value) {
                maximum = value;
                indexOfMaximum = i;
            }
        }
        return indexOfMaximum;
    }

    static void task3() {
        int[] array = {16, 23, 5, 61, 8, 97, 13, 3, 44, 18};
        int indexOfMaximumElement = indexOfMaximumElement(array);
        System.out.println("Индекс максимального значения: " + indexOfMaximumElement);
    }

    /**
     * @param src - принимает массив который необходимо отсортировать
     * @return возвращает отсортированный массив
     */
    public static int[] selectiveArraySort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            int minimalValue = src[i];
            int indexOfMinimalValue = i;
            for (int j = i + 1; j < src.length; j++) {
                if (src[j] < minimalValue) {
                    minimalValue = src[j];
                    indexOfMinimalValue = j;
                }
            }
            int tmp = src[i];
            src[i] = minimalValue;
            src[indexOfMinimalValue] = tmp;
        }
        return src;
    }

    static void task4() {
        int[] array = {16, 23, 5, 61, 8, 97, 13, 3, 44, 18};
        int[] sortArray = selectiveArraySort(array);
        System.out.println(Arrays.toString(sortArray));
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }
}