package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void shouldTitleMatch() {

        SimpleTask simpleTask = new SimpleTask(15, "Написать ответ на письмо");


        boolean expected = true;
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotTitleMatch() {
        SimpleTask simpleTask = new SimpleTask(15, "Написать ответ на письмо");


        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSubtasksMatch() {
        String[] subtsaks = {"Тетради", "Карандаши", "Ручки"};
        Epic epic = new Epic(35, subtsaks);


        boolean expected = true;
        boolean actual = epic.matches("Карандаши");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldNotSubtasksMatch() {
        String[] subtsaks = {"Тетради", "Карандаши", "Ручки"};
        Epic epic = new Epic(35, subtsaks);


        boolean expected = false;
        boolean actual = epic.matches("Линейка");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldOnlyTopicMatch() {
        Meeting meeting = new Meeting(
                55,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldOnlyProjectMatch() {
        Meeting meeting = new Meeting(
                55,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testTopicAndProjectNotMatch() {
        Meeting meeting = new Meeting(
                55,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean expected = false;
        boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(expected, actual);

    }

}