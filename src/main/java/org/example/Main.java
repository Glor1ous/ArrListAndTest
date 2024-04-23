package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayListImplementation list = new ArrayListImplementation();

        System.out.println("Список пуст? " + list.isEmpty());

        list.add("Яблоко");
        list.add("Банан");
        list.add("Вишня");
        list.add("Груша");

        System.out.println("Размер списка: " + list.size());
        System.out.println("Элементы в списке: " + Arrays.toString(list.toArray()));

        list.add(2, "черника");
        System.out.println("Элементы в списке после добавления 'черники' с индексом 2: " + Arrays.toString(list.toArray()));

        String replacedElement = list.set(1, "ежевика");
        System.out.println("Замененный элемент: " + replacedElement);
        System.out.println("Элементы в списке после замены 'Банана' на 'Ежевику': " + Arrays.toString(list.toArray()));

        String removedElement = list.remove("Вишня");
        System.out.println("Удаленный элемент: " + removedElement);
        System.out.println("Элементы в списке после удаления 'Вишни':  " + Arrays.toString(list.toArray()));

        removedElement = list.remove(2);
        System.out.println("Удаленный элемент: " + removedElement);
        System.out.println("Элементы в списке после удаления элемента с индексом 2: " + Arrays.toString(list.toArray()));

        System.out.println("Содержит ли список слово 'Грушу'? " + list.contains("Груша"));
        System.out.println("Есть ли в списке слово 'Ананас'? " + list.contains("Ананас"));

        System.out.println("Индекс 'Яблока': " + list.indexOf("Яблоко"));
        System.out.println("Последний индекс 'Груша': " + list.lastIndexOf("Груша"));

        list.clear();
        System.out.println("Пуст ли список после очистки?" + list.isEmpty());
    }
}