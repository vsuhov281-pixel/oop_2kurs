
package lab9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TaskManager {

    // Пул рабочих потоков
    private final ExecutorService executor;

    // Количество добавленных задач
    private final AtomicInteger tasks = new AtomicInteger(0);

    // Количество выполненных задач
    private final AtomicInteger completedTasks = new AtomicInteger(0);

    // Результат выполнения задач
    private final AtomicLong result = new AtomicLong(0);

    // Сколько производителей должны закончить добавление задач
    private final CountDownLatch producersLatch;

    public TaskManager(int threadCount, int producerCount) {
        executor = Executors.newFixedThreadPool(threadCount);
        producersLatch = new CountDownLatch(producerCount);
    }

    // Добавление задачи в пул
    public void addTask(Runnable task) {

        tasks.incrementAndGet();

        executor.submit(() -> {
            task.run();
            completedTasks.incrementAndGet();
        });
    }

    // Запуск производителя задач
    public void startProducer(int producerNumber, int operationsCount) {

        executor.submit(() -> {

            try {
                System.out.println(
                    "Производитель " + producerNumber + " начал работу"
                );

                for (int i = 0; i < operationsCount; i++) {

                    addTask(() -> result.incrementAndGet());

                }

                System.out.println(
                    "Производитель " + producerNumber +
                    " добавил " + operationsCount + " задач"
                );

            } finally {
                producersLatch.countDown();
            }
        });
    }

    // Ожидание завершения всех производителей и задач
    public void awaitCompletion() {

        try {

            producersLatch.await();

            executor.shutdown();

            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                throw new IllegalStateException(
                    "Не все задачи успели завершиться"
                );
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();
            Thread.currentThread().interrupt();

            throw new IllegalStateException(
                "Ожидание выполнения задач прервано", e
            );
        }
    }

    public int getTasks() {
        return tasks.get();
    }

    public int getCompletedTasks() {
        return completedTasks.get();
    }

    public long getResult() {
        return result.get();
    }
}
