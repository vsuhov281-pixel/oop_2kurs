
package lab7;

public class Hotel {

    private int id;
    private String name;
    private String city;
    private int stars;
    private int roomsCount;
    private double rating;

    // Полноценный конструктор
    public Hotel(int id, String name, String city,
                 int stars, int roomsCount, double rating) {
        this.id = id;
        setName(name);
        this.city = city;
        setStars(stars);
        setRoomsCount(roomsCount);
        this.rating = rating;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public double getRating() {
        return rating;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название отеля не может быть пустым");
        }
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStars(int stars) {
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Количество звёзд должно быть от 1 до 5");
        }
        this.stars = stars;
    }

    public void setRoomsCount(int roomsCount) {
        if (roomsCount <= 0) {
            throw new IllegalArgumentException("Количество номеров должно быть больше 0");
        }
        this.roomsCount = roomsCount;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", stars=" + stars +
                ", roomsCount=" + roomsCount +
                ", rating=" + rating +
                '}';
    }
}
