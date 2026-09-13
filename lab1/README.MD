промпт для классной задачи:

Ты — опытный Java-разработчик. Создай класс BookCW на Java 17 со следующими
требованиями:
- Поля: id (long), title (String), author (String), year (int). Все private.
- Для каждого поля — getter и setter.
- В setter'ах реализуй валидацию: title и author не могут быть null или пустыми,
  year должен быть от 0 до текущего года. При нарушении — IllegalArgumentException.
- Метод getDescription(), возвращающий строку вида:
  "Название" — Автор (год)
- Переопредели toString() для вывода через System.out.println.
Код должен быть чистым, с Javadoc-комментариями.

ответ ИИ:

файл Book

import java.time.Year;

/**
 * Класс, представляющий книгу.
 * <p>
 * Содержит основные сведения о книге: уникальный идентификатор, название,
 * автора и год издания. Для изменяемых полей реализована валидация значений.
 * </p>
 *
 * @author  Java Developer
 * @version 1.0
 */
public class BookCW {

    /** Уникальный идентификатор книги. */
    private long id;

    /** Название книги. Не может быть {@code null} или пустым. */
    private String title;

    /** Автор книги. Не может быть {@code null} или пустым. */
    private String author;

    /** Год издания книги. Допустимый диапазон: от 0 до текущего года. */
    private int year;

    /**
     * Создаёт новый экземпляр книги.
     *
     * @param id     уникальный идентификатор
     * @param title  название книги (не {@code null} и не пустое)
     * @param author автор книги (не {@code null} и не пустой)
     * @param year   год издания (от 0 до текущего года)
     * @throws IllegalArgumentException если переданы некорректные значения
     */
    public BookCW(long id, String title, String author, int year) {
        this.id = id;
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    /**
     * Возвращает идентификатор книги.
     *
     * @return уникальный идентификатор
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор книги.
     *
     * @param id новый идентификатор
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Возвращает название книги.
     *
     * @return название книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Устанавливает название книги.
     *
     * @param title название книги
     * @throws IllegalArgumentException если {@code title} равен {@code null} или пустой
     */
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть null или пустым");
        }
        this.title = title;
    }

    /**
     * Возвращает автора книги.
     *
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Устанавливает автора книги.
     *
     * @param author автор книги
     * @throws IllegalArgumentException если {@code author} равен {@code null} или пустой
     */
    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор книги не может быть null или пустым");
        }
        this.author = author;
    }

    /**
     * Возвращает год издания книги.
     *
     * @return год издания
     */
    public int getYear() {
        return year;
    }

    /**
     * Устанавливает год издания книги.
     *
     * @param year год издания
     * @throws IllegalArgumentException если {@code year} меньше 0 или больше текущего года
     */
    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 0 || year > currentYear) {
            throw new IllegalArgumentException(
                    "Год должен быть в диапазоне от 0 до " + currentYear);
        }
        this.year = year;
    }

    /**
     * Возвращает краткое описание книги в формате:
     * {@code "Название" — Автор (год)}.
     *
     * @return строка-описание книги
     */
    public String getDescription() {
        return String.format("\"%s\" — %s (%d)", title, author, year);
    }

    /**
     * Возвращает строковое представление книги.
     * Удобно для вывода через {@link System#out#println(Object)}.
     *
     * @return строковое представление книги
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}

файл Main

public class Main {
    public static void main(String[] args) {
        BookCW book = new BookCW(1L, "Мастер и Маргарита", "М. Булгаков", 1967);
        System.out.println(book);                 // toString()
        System.out.println(book.getDescription()); // "Мастер и Маргарита" — М. Булгаков (1967)
    }
}

ОТЧЕТ: код дипсика отличается от моего по большому счету только наличием конструктора и он использовал библиотеку для выявления текущего года




промпт для домашней задачи:

Ты — опытный Java-разработчик. Создай класс GameHW на Java 17 со следующими
требованиями:
Поля: id (long), title (String), genre (String), rating (double), price (double). Валидация: title и genre не пусты; rating от 0.0 до 10.0; price ≥ 0. Формат: «Игра "The Witcher 3" (жанр: RPG, рейтинг 9.5) — 999.00 руб.». Для каждого поля сетер и гетер. В main создать 3 объяекта, вывести их с помощью getDescription
Код должен быть чистым, с Javadoc-комментариями.

ответ ИИ:

файл GameHW

import java.util.Locale;

/**
 * Класс, представляющий игру.
 * <p>
 * Содержит сведения об игре: уникальный идентификатор, название, жанр,
 * рейтинг и цену. Для изменяемых полей реализована валидация значений
 * в соответствующих сеттерах.
 * </p>
 *
 * @author  Java Developer
 * @version 1.0
 */
public class GameHW {

    /** Уникальный идентификатор игры. */
    private long id;

    /** Название игры. Не может быть {@code null} или пустым. */
    private String title;

    /** Жанр игры. Не может быть {@code null} или пустым. */
    private String genre;

    /** Рейтинг игры. Допустимый диапазон: от 0.0 до 10.0. */
    private double rating;

    /** Цена игры. Не может быть отрицательной. */
    private double price;

    /**
     * Создаёт новый экземпляр игры.
     *
     * @param id     уникальный идентификатор
     * @param title  название (не {@code null} и не пустое)
     * @param genre  жанр (не {@code null} и не пустой)
     * @param rating рейтинг (от 0.0 до 10.0)
     * @param price  цена (не отрицательная)
     * @throws IllegalArgumentException если переданы некорректные значения
     */
    public GameHW(long id, String title, String genre, double rating, double price) {
        this.id = id;
        setTitle(title);
        setGenre(genre);
        setRating(rating);
        setPrice(price);
    }

    /**
     * Возвращает идентификатор игры.
     *
     * @return уникальный идентификатор
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор игры.
     *
     * @param id новый идентификатор
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Возвращает название игры.
     *
     * @return название
     */
    public String getTitle() {
        return title;
    }

    /**
     * Устанавливает название игры.
     *
     * @param title название
     * @throws IllegalArgumentException если {@code title} равен {@code null} или пустой
     */
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название игры не может быть null или пустым");
        }
        this.title = title;
    }

    /**
     * Возвращает жанр игры.
     *
     * @return жанр
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Устанавливает жанр игры.
     *
     * @param genre жанр
     * @throws IllegalArgumentException если {@code genre} равен {@code null} или пустой
     */
    public void setGenre(String genre) {
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Жанр игры не может быть null или пустым");
        }
        this.genre = genre;
    }

    /**
     * Возвращает рейтинг игры.
     *
     * @return рейтинг
     */
    public double getRating() {
        return rating;
    }

    /**
     * Устанавливает рейтинг игры.
     *
     * @param rating рейтинг
     * @throws IllegalArgumentException если {@code rating} вне диапазона [0.0; 10.0]
     */
    public void setRating(double rating) {
        if (rating < 0.0 || rating > 10.0) {
            throw new IllegalArgumentException("Рейтинг должен быть в диапазоне от 0.0 до 10.0");
        }
        this.rating = rating;
    }

    /**
     * Возвращает цену игры.
     *
     * @return цена
     */
    public double getPrice() {
        return price;
    }

    /**
     * Устанавливает цену игры.
     *
     * @param price цена
     * @throws IllegalArgumentException если {@code price} отрицательная
     */
    public void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.price = price;
    }

    /**
     * Возвращает описание игры в формате:
     * {@code Игра "Название" (жанр: ЖАНР, рейтинг X.Y) — Z.ZZ руб.}.
     *
     * @return строка-описание игры
     */
    public String getDescription() {
        return String.format(
                Locale.ROOT,
                "Игра \"%s\" (жанр: %s, рейтинг %.1f) — %.2f руб.",
                title, genre, rating, price);
    }

    /**
     * Возвращает строковое представление объекта.
     *
     * @return строковое представление игры
     */
    @Override
    public String toString() {
        return "GameHW{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}

файл Main

/**
 * Демонстрационный класс с точкой входа.
 * Создаёт три объекта {@link GameHW} и выводит их описания.
 */
public class Main {

    /**
     * Точка входа программы.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        GameHW witcher    = new GameHW(1L, "The Witcher 3",   "RPG",        9.5, 999.00);
        GameHW cyberpunk  = new GameHW(2L, "Cyberpunk 2077",  "Action RPG", 8.0, 1499.99);
        GameHW minecraft  = new GameHW(3L, "Minecraft",       "Sandbox",    9.0, 599.50);

        System.out.println(witcher.getDescription());
        System.out.println(cyberpunk.getDescription());
        System.out.println(minecraft.getDescription());
    }
}

ОТЧЕТ: тот же код, что и у меня, но добавлен конструктор, который менее гибок, чем базовый