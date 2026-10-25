package lab6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("=== Запуск программы ===");

        Hotel hotel1 = new Hotel(1, "Метрополь", "Москва", 5, 250, 9.2);
        Hotel hotel2 = new Hotel(2, "Астория", "СПб", 5, 169, 9.1);
        Hotel hotel3 = new Hotel(3, "Космос", "Москва", 3, 1777, 8.0);
        Hotel hotel4 = new Hotel(4, "Хилтон", "Сочи", 5, 300, 9.5);

        System.out.println("\n=== Проверка UNCHECKED исключений ===");
        
        try {
            logger.info("Проверка setName...");
            hotel1.setName("");
        } catch (InvalidHotelDataException e) {
            logger.error("InvalidHotelDataException: {}", e.getMessage());
        }

        try {
            logger.info("Проверка setStars...");
            hotel2.setStars(10);
        } catch (InvalidHotelDataException e) {
            logger.error("InvalidHotelDataException: {}", e.getMessage());
        }

        try {
            logger.info("Проверка setRoomsCount...");
            hotel3.setRoomsCount(-5);
        } catch (InvalidHotelDataException e) {
            logger.error("InvalidHotelDataException: {}", e.getMessage());
        }

        System.out.println("\n=== Проверка CHECKED исключения ===");
        
        try {
            logger.info("Поиск отеля с ID=2...");
            Hotel found = Hotel.findHotelById(hotel1, hotel2, hotel3, hotel4, 2);
            System.out.println("Найден: " + found.getName());
        } catch (HotelNotFoundException e) {
            logger.error("HotelNotFoundException: {}", e.getMessage());
        }

        try {
            logger.info("Поиск отеля с ID=6...");
            Hotel.findHotelById(hotel1, hotel2, hotel3, hotel4, 6);
        } catch (HotelNotFoundException e) {
            logger.error("HotelNotFoundException: {}", e.getMessage());
        }

        logger.info("=== Программа завершена ===");
    }
}