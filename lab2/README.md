BookCW:

/**
 * Класс, описывающий книгу.
 * <p>
 * Поддерживает автоматическую нумерацию экземпляров через статический
 * счётчик {@link #counter}, имеет несколько конструкторов, статический
 * фабричный метод и перегруженный {@code getDescription}.
 * </p>
 *
 * @author  Опытный Java-разработчик
 * @version 2.0
 * @since   17
 */
public class BookCW {

    /**
     * Статический счётчик созданных объектов {@code BookCW}.
     * Используется для генерации уникального {@link #id}.
     */
    private static long counter = 0;

    /** Уникальный идентификатор книги. */
    private final long id;

    /** Название книги. */
    private String title;

    /** Автор книги. */
    private String author;

    /** Год издания. */
    private int year;

    /**
     * Основной конструктор.
     * <p>
     * Автоматически присваивает уникальный {@code id} через
     * инкремент {@link #counter} и валидирует входные данные
     * через соответствующие сеттеры.
     * </p>
     *
     * @param title  название книги (не {@code null} и не пустое)
     * @param author автор книги (не {@code null} и не пустое)
     * @param year   год издания (от {@code 0} до {@code 2026})
     * @throws IllegalArgumentException если данные не проходят валидацию
     */
    public BookCW(String title, String author, int year) {
        this.id = ++counter;
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    /**
     * Конструктор без года издания.
     * Делегирует работу основному конструктору, подставляя {@code year = 0}.
     *
     * @param title  название книги
     * @param author автор книги
     */
    public BookCW(String title, String author) {
        this(title, author, 0);
    }

    /**
     * Конструктор только с названием.
     * Автор и год подставляются по умолчанию.
     *
     * @param title название книги
     */
    public BookCW(String title) {
        this(title, "Неизвестен", 0);
    }

    /**
     * Пустой конструктор — заглушка для фреймворков/сериализации.
     */
    public BookCW() {
        this("Без названия", "Неизвестен", 0);
    }

    /**
     * Статический фабричный метод для создания книги.
     * Альтернатива прямому вызову конструктора.
     *
     * @param title  название книги
     * @param author автор книги
     * @param year   год издания
     * @return новый экземпляр {@code BookCW}
     */
    public static BookCW createBook(String title, String author, int year) {
        return new BookCW(title, author, year);
    }

    /**
     * Возвращает уникальный идентификатор книги.
     *
     * @return id книги
     */
    public long getId() {
        return id;
    }

    /**
     * Возвращает название книги.
     *
     * @return название
     */
    public String getTitle() {
        return title;
    }

    /**
     * Устанавливает название книги.
     *
     * @param title название (не {@code null} и не пустое)
     * @throws IllegalArgumentException если название пустое
     */
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.title = title;
    }

    /**
     * Возвращает автора книги.
     *
     * @return автор
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Устанавливает автора книги.
     *
     * @param author автор (не {@code null} и не пустое)
     * @throws IllegalArgumentException если автор пустой
     */
    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Атора не может не быть");
        }
        this.author = author;
    }

    /**
     * Возвращает год издания.
     *
     * @return год издания
     */
    public int getYear() {
        return year;
    }

    /**
     * Устанавливает год издания.
     *
     * @param year год издания (от {@code 0} до {@code 2026})
     * @throws IllegalArgumentException если год вне допустимого диапазона
     */
    public void setYear(int year) {
        if (year < 0 || year > 2026) {
            throw new IllegalArgumentException("Шо ты пишешь");
        }
        this.year = year;
    }

    /**
     * Возвращает описание книги.
     * <p>
     * Базовый (полный) формат: {@code "Название" - Автор (Год)}.
     * </p>
     *
     * @return полное описание книги
     */
    public String getDescription() {
        return "\"" + title + "\" - " + author + " (" + year + ")";
    }

    /**
     * Возвращает описание книги в выбранном формате.
     * <p>
     * Если {@code shortFormat == true} — только название и автор.
     * Если {@code false} — полное описание (см. {@link #getDescription()}).
     * </p>
     *
     * @param shortFormat {@code true} для краткого формата,
     *                    {@code false} для полного
     * @return описание книги
     */
    public String getDescription(boolean shortFormat) {
        if (shortFormat) {
            return "\"" + title + "\" - " + author;
        }
        return getDescription();
    }

    /**
     * Возвращает текущее значение счётчика созданных книг.
     *
     * @return количество созданных объектов
     */
    public static long getCounter() {
        return counter;
    }

    /**
     * Сбрасывает счётчик созданных книг.
     * Полезно в юнит-тестах.
     */
    static void resetCounter() {
        counter = 0;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}

Main:

public class Demo {
    public static void main(String[] args) {
        BookCW b1 = new BookCW("Мастер и Маргарита", "Булгаков", 1967);
        BookCW b2 = new BookCW("Идиот", "Достоевский");
        BookCW b3 = new BookCW("Анна Каренина");
        BookCW b4 = BookCW.createBook("1984", "Оруэлл", 1949);

        System.out.println(b1.getId() + " -> " + b1.getDescription(true));
        // 1 -> "Мастер и Маргарита" - Булгаков
        System.out.println(b1.getId() + " -> " + b1.getDescription(false));
        // 1 -> "Мастер и Маргарита" - Булгаков (1967)
        System.out.println(b2);  // "Идиот" - Достоевский (0)
        System.out.println(b3);  // "Анна Каренина" - Неизвестен (0)
        System.out.println(b4);  // "1984" - Оруэлл (1949)

        System.out.println("Всего книг: " + BookCW.getCounter()); // 4
    }
}