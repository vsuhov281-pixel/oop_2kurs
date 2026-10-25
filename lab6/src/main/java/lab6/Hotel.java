package lab6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hotel {
    private long id;
    private String name;
    private String city;
    private int stars;
    private int roomsCount;
    private double rating;

    private static final Logger logger =
            LoggerFactory.getLogger(Hotel.class);

    public Hotel() {
        this(0, "Без названия", "Неизвестен", 1, 1, 0.0);
    }

    public Hotel(long id, String name, String city,
                 int stars, int roomsCount, double rating) {
        this.id = id;
        setName(name);
        this.city = city;
        setStars(stars);
        setRoomsCount(roomsCount);
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            logger.error("Название отеля не может быть пустым");
            throw new InvalidHotelDataException(
                    "Название отеля не может быть пустым"
            );
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        if (stars < 1 || stars > 5) {
            logger.error(
                    "Некорректное количество звёзд: {}", stars
            );
            throw new InvalidHotelDataException(
                    "Количество звёзд должно быть от 1 до 5"
            );
        }
        this.stars = stars;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        if (roomsCount <= 0) {
            logger.error(
                    "Некорректное количество номеров: {}", roomsCount
            );
            throw new InvalidHotelDataException(
                    "Количество номеров должно быть больше нуля"
            );
        }
        this.roomsCount = roomsCount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
        public static Hotel findHotelById(Hotel h1, Hotel h2, Hotel h3, Hotel h4, long id) 
            throws HotelNotFoundException {
        
        if (h1.getId() == id) return h1;
        if (h2.getId() == id) return h2;
        if (h3.getId() == id) return h3;
        if (h4.getId() == id) return h4;
        
        throw new HotelNotFoundException("Отель с ID " + id + " не найден");
    }
    
    public String getDescription() {
        return "Отель \"" + name + "\", город: " + city
                + ", звёзд: " + stars
                + ", номеров: " + roomsCount
                + ", рейтинг: " + rating;
    }
}
