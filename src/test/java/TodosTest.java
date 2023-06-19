import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask sim1 = new SimpleTask(2, "купить хлеб");
    SimpleTask sim2 = new SimpleTask(29, "поставить будильник");
    Meeting meet1 = new Meeting(13, "ремонт", "кран", "завтра");
    Meeting meet2 = new Meeting(25, "сделать допуск", "диспансер", "конец недели");
    String[] subtasks1 = {"позвонить мастеру", "купить батарейки", "включить таймер"};
    Epic ep1 = new Epic(16, subtasks1);
    String[] subtasks2 = {"заехать на шиномонтаж", "позвонить на работу", "подать заявку"};
    Epic ep2 = new Epic(19, subtasks2);
    @Test
    public void shouldFindSimpleTaskAlarmClock() {
        Todos todos = new Todos();

        todos.add(sim1);
        todos.add(sim2);

        Task[] expected = {sim2};
        Task[] actual = todos.search("поставить будильник");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindSimpleTask() {
        Todos todos = new Todos();

        todos.add(sim1);
        todos.add(sim2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("ужин");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindMeetingRepair() {
        Todos todos = new Todos();

        todos.add(meet1);
        todos.add(meet2);

        Task[] expected = {meet1};
        Task[] actual = todos.search("ремонт");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindMeeting() {
        Todos todos = new Todos();

        todos.add(meet1);
        todos.add(meet2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("еда");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindWay() {
        Todos todos = new Todos();

        todos.add(ep1);
        todos.add(ep2);

        Task[] expected = {ep2};
        Task[] actual = todos.search("подать заявку");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindEpicTask() {
        Todos todos = new Todos();

        todos.add(ep1);
        todos.add(ep2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("игра");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindInDifferencesType() {
        Todos todos = new Todos();

        todos.add(meet1);
        todos.add(meet2);
        todos.add(ep1);
        todos.add(ep2);
        todos.add(sim1);
        todos.add(sim2);

        Task[] expected = {meet1};
        Task[] actual = todos.search("ремонт");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindInDifferencesType() {
        Todos todos = new Todos();

        todos.add(meet1);
        todos.add(meet2);
        todos.add(ep1);
        todos.add(ep2);
        todos.add(sim1);
        todos.add(sim2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("гулять");
        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindAllTasks() {
        Todos todos = new Todos();

        todos.add(meet1);
        todos.add(meet2);
        todos.add(ep1);
        todos.add(ep2);
        todos.add(sim1);
        todos.add(sim2);

        Task[] expected = {meet1, meet2, ep1, ep2, sim1, sim2};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
