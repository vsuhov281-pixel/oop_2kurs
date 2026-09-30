промпт:
Сгенерируй корректные equals() и hashCode() для класса Book на Java 17.
Поля: id (long), title (String), author (String), year (int).
Используй Objects.hash() и Objects.equals(). Добавь Javadoc.

ответ:
import java.util.Objects;

public class Book {
    
    private long id;
    private String title;
    private String author;
    private int year;

    // Конструкторы, геттеры и сеттеры опущены для краткости

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * Two {@code Book} instances are considered equal if they have the same 
     * {@code id}, {@code title}, {@code author}, and {@code year}.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; 
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // 1. Проверка на ссылочное равенство (оптимизация)
        if (this == o) {
            return true;
        }
        
        // 2. Проверка на null и тип объекта (с использованием pattern matching из Java 16+)
        if (!(o instanceof Book other)) {
            return false;
        }
        
        // 3. Сравнение примитивных типов через ==, объектов через Objects.equals()
        return id == other.id &&
               year == other.year &&
               Objects.equals(title, other.title) &&
               Objects.equals(author, other.author);
    }

    /**
     * Returns a hash code value for the object.
     * <p>
     * This method is implemented using {@link Objects#hash(Object...)} to generate 
     * a hash code based on all fields used in the {@link #equals(Object)} method, 
     * ensuring the general contract for {@code hashCode} is maintained.
     *
     * @return a hash code value for this {@code Book}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, year);
    }
}