
package lab9;

public class Main {

    private static final int THREAD_COUNT = 5;
    private static final int PRODUCER_COUNT = 5;
    private static final int OPERATIONS_PER_PRODUCER = 1000;

    public static void main(String[] args) {

        System.out.println("=== Менеджер задач ===");

        // Создаём менеджер с пулом из пяти потоков
        TaskManager manager = new TaskManager(
            THREAD_COUNT,
            PRODUCER_COUNT
        );

        long startTime = System.currentTimeMillis();

        // Запускаем пять производителей
        for (int i = 1; i <= PRODUCER_COUNT; i++) {

            manager.startProducer(i, OPERATIONS_PER_PRODUCER);

        }

        // Ждём завершения всех задач
        manager.awaitCompletion();

        long endTime = System.currentTimeMillis();

        // Выводим результаты
        System.out.println("\n=== Результаты ===");

        System.out.println(
            "Количество производителей: " + PRODUCER_COUNT
        );

        System.out.println(
            "Рабочих потоков в пуле: " + THREAD_COUNT
        );

        System.out.println(
            "Добавлено задач: " + manager.getTasks()
        );

        System.out.println(
            "Выполнено задач: " + manager.getCompletedTasks()
        );

        System.out.println(
            "Итоговый результат: " + manager.getResult()
        );

        System.out.println(
            "Время выполнения: " + (endTime - startTime) + " мс"
        );

        System.out.println("\n=== Проверка ===");

        if (manager.getTasks() == 5000 &&
            manager.getCompletedTasks() == 5000 &&
            manager.getResult() == 5000) {

            System.out.println("Все задачи успешно выполнены!");

        } else {

            System.out.println("Обнаружена ошибка выполнения!");

        }
    }
}
