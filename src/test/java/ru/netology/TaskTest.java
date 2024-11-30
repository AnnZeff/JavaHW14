package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void shouldTitleMatch() {

        SimpleTask simpleTask = new SimpleTask(15, "Написать ответ на запрос");

        simpleTask.matches("Написать ответ на запрос");

        boolean expected = true;
        boolean actual = simpleTask.equals(simpleTask);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotTitleMatch() {
        SimpleTask simpleTask = new SimpleTask(15, "Написать ответ на запрос");

        simpleTask.matches("Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.equals(simpleTask);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSubtasksMatch() {
        String[] subtsaks = { "тетради", "карандаши", "ручки", "пенал" };
        Epic epic = new Epic(5, subtsaks);

        epic.matches("пенал");

        boolean expected = true;
        boolean actual = epic.equals(epic);

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldNotSubtasksMatch() {
        String[] subtsaks = { "тетради", "карандаши", "ручки", "пенал" };
        Epic epic = new Epic(5, subtsaks);

        epic.matches("линейка");


        boolean expected = false;
        boolean actual = epic.equals(epic);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldOnlyTopicMatch() {
        Meeting meeting = new Meeting(
                70,
                "Устранение багов счетчика шагов",
                "Шагомер версия 2.5",
                "В четверг после обеда"
        );

        meeting.matches("Устранение багов счетчика шагов");

        boolean expected = true;
        boolean actual = meeting.equals(meeting);

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldOnlyProjectMatch() {
        Meeting meeting = new Meeting(
                70,
                "Устранение багов счетчика шагов",
                "Шагомер версия 2.5",
                "В четверг после обеда"
        );

        meeting.matches("Шагомер версия 2.5");

        boolean expected = true;
        boolean actual = meeting.equals(meeting);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTopicAndProjectMatch() {
        Meeting meeting = new Meeting(
                70,
                "Устранение багов счетчика шагов",
                "Шагомер версия 2.5",
                "В четверг после обеда"
        );

        meeting.matches("Устранение багов счетчика шагов");
        meeting.matches("Шагомер версия 2.5");

        boolean expected = true;
        boolean actual = meeting.equals(meeting);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testTopicAndProjectNotMatch() {
        Meeting meeting = new Meeting(
                70,
                "Устранение багов счетчика шагов",
                "Шагомер версия 2.5",
                "В четверг после обеда"
        );

        meeting.matches("Кривая веса");
        meeting.matches("Худеем на 20 кг версия 3.0");


        boolean expected = false;
        boolean actual = meeting.equals(meeting);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchTopicNotProject() {
        Meeting meeting = new Meeting(
                70,
                "Устранение багов счетчика шагов",
                "Шагомер версия 2.5",
                "В четверг после обеда"
        );

        meeting.matches("Устранение багов счетчика шагов");
        meeting.matches("Худеем на 20 кг версия 3.0");

        boolean expected = true;
        boolean actual = meeting.equals(meeting);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void sholdMatchProjectNotTopic() {
        Meeting meeting = new Meeting(
                70,
                "Устранение багов счетчика шагов",
                "Шагомер версия 2.5",
                "В четверг после обеда"
        );

        meeting.matches("Кривая веса");
        meeting.matches("Шагомер версия 2.5");

        boolean expected = true;
        boolean actual = meeting.equals(meeting);

        Assertions.assertEquals(expected, actual);

    }

}