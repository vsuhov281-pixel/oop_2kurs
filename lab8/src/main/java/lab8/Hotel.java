
package lab8;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Hotel {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("city")
    private String city;

    @JsonProperty("stars")
    private int stars;

    @JsonProperty("roomsCount")
    private int roomsCount;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("establishedDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate establishedDate;

    @JsonIgnore
    private String managementInfo;

    public Hotel() {

    }
    
    // Полноценный конструктор
    public Hotel(
            long id,
            String name,
            String city,
            int stars,
            int roomsCount,
            double rating,
            LocalDate establishedDate
    ) {
        this.id = id;
        setName(name);
        this.city = city;
        setStars(stars);
        setRoomsCount(roomsCount);
        this.rating = rating;
        this.establishedDate = establishedDate;
    }

    // Геттеры

    public long getId() {
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

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public String getManagementInfo() {
        return managementInfo;
    }

    // Сеттеры

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Название отеля не может быть пустым"
            );
        }

        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStars(int stars) {
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException(
                    "Количество звёзд должно быть от 1 до 5"
            );
        }

        this.stars = stars;
    }

    public void setRoomsCount(int roomsCount) {
        if (roomsCount <= 0) {
            throw new IllegalArgumentException(
                    "Количество номеров должно быть больше нуля"
            );
        }

        this.roomsCount = roomsCount;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public void setManagementInfo(String managementInfo) {
        this.managementInfo = managementInfo;
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
                ", establishedDate=" + establishedDate +
                '}';
    }
}
