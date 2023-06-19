import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    SimpleTask sim1 = new SimpleTask(2, "купить хлеб");
    SimpleTask sim2 = new SimpleTask(29, "поставить будильник");
    Meeting meet1 = new Meeting(13, "ремонт", "кран", "завтра");
    Meeting meet2 = new Meeting(25, "сделать допуск", "диспансер", "конец недели");
    String[] subtasks1 = {"позвонить мастеру", "купить батарейки", "включить таймер"};
    Epic ep1 = new Epic(16, subtasks1);
    String[] subtasks2 = {"заехать на шиномонтаж", "позвонить на работу", "подать заявку"};
    Epic ep2 = new Epic(19, subtasks2);

    @Test
    public void shouldFindMeeting() {

        boolean expected = true;
        boolean actual = meet1.matches("ремонт");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeeting() {

        boolean expected = false;
        boolean actual = meet2.matches("дом");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTask() {

        boolean expected = true;
        boolean actual = sim1.matches("купить хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSimpleTask() {

        boolean expected = false;
        boolean actual = sim2.matches("соревнования");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicTask() {

        boolean expected = true;
        boolean actual = ep1.matches("включить таймер");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpicTask() {

        boolean expected = false;
        boolean actual = ep2.matches("купить билеты");
        Assertions.assertEquals(expected, actual);
    }
}
