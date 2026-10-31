package lab7;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Path INPUT_FILE =
            Path.of("lab7", "hotels.csv");

    private static final Path OUTPUT_FILE =
            Path.of("lab7", "hotels_clean.csv");

    public static void main(String[] args) {

        System.out.println("=== Чтение CSV-файла с отелями ===");

        List<Hotel> hotels = new ArrayList<>();

        int total = 0;
        int success = 0;
        int errors = 0;

        // Чтение файла
        try (BufferedReader reader = Files.newBufferedReader(
                INPUT_FILE, StandardCharsets.UTF_8)) {

            String line;

            // Пропускаем заголовок
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                total++;

                try {
                    // Разделяем строку на поля
                    List<String> fields = parseCsvLine(line);

                    // Проверяем количество полей
                    if (fields.size() != 6) {
                        throw new IllegalArgumentException(
                                "Ожидалось 6 полей"
                        );
                    }

                    // Получаем данные
                    int id = Integer.parseInt(fields.get(0).trim());                    
                    String name = fields.get(1).trim();
                    String city = fields.get(2).trim();
                    int stars = Integer.parseInt(fields.get(3).trim());
                    int roomsCount = Integer.parseInt(fields.get(4).trim());
                    double rating = Double.parseDouble(fields.get(5).trim());

                    // Проверяем данные
                    if (name.isBlank()) {
                        throw new IllegalArgumentException(
                                "Название отеля пустое"
                        );
                    }

                    if (stars < 1 || stars > 5) {
                        throw new IllegalArgumentException(
                                "Количество звёзд должно быть от 1 до 5"
                        );
                    }

                    if (roomsCount <= 0) {
                        throw new IllegalArgumentException(
                                "Количество номеров должно быть больше нуля"
                        );
                    }

                    // Создаём объект
                    Hotel hotel = new Hotel(
                            id, name, city, stars, roomsCount, rating
                    );

                    hotels.add(hotel);
                    success++;

                } catch (IllegalArgumentException e) {
                    errors++;
                    System.out.println(
                            "Строка пропущена: " + e.getMessage()
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Ошибка чтения файла: " + e.getMessage()
            );
            return;
        }

        // Статистика
        System.out.println("\n=== Статистика ===");
        System.out.println("Всего строк: " + total);
        System.out.println("Успешно прочитано: " + success);
        System.out.println("Пропущено с ошибками: " + errors);

        // Вывод всех отелей
        System.out.println("\n=== Все корректные отели ===");

        for (Hotel hotel : hotels) {
            System.out.println(hotel);        }

        // Выборка по городу
        String selectedCity = "Сочи";

        System.out.println(
                "\n=== Отели города " + selectedCity + " ==="
        );

        List<Hotel> filteredHotels = hotels.stream()
                .filter(hotel ->
                        hotel.getCity().equalsIgnoreCase(selectedCity))
                .toList();

        for (Hotel hotel : filteredHotels) {
            System.out.println(hotel);        }

        // Запись корректных отелей в новый файл
        try (BufferedWriter writer = Files.newBufferedWriter(
                OUTPUT_FILE, StandardCharsets.UTF_8)) {

            writer.write("id,name,city,stars,roomsCount,rating");
            writer.newLine();

            for (Hotel hotel : hotels) {
                writer.write(
                        hotel.getId() + "," +
                        escapeCsv(hotel.getName()) + "," +
                        escapeCsv(hotel.getCity()) + "," +
                        hotel.getStars() + "," +
                        hotel.getRoomsCount() + "," +
                        hotel.getRating()
                );

                writer.newLine();
            }

            System.out.println(
                    "\nРезультат сохранён в: " + OUTPUT_FILE
            );

        } catch (IOException e) {
            System.out.println(
                    "Ошибка записи файла: " + e.getMessage()
            );
        }

        System.out.println("\nПрограмма завершена.");
    }

    // Парсер CSV с поддержкой кавычек
    public static List<String> parseCsvLine(String line) {

        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();

        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            if (inQuotes) {

                if (c == '"') {

                    if (i + 1 < line.length()
                            && line.charAt(i + 1) == '"') {

                        field.append('"');
                        i++;

                    } else {
                        inQuotes = false;
                    }

                } else {
                    field.append(c);
                }

            } else {

                if (c == '"') {
                    inQuotes = true;

                } else if (c == ',') {

                    fields.add(field.toString());
                    field.setLength(0);

                } else {
                    field.append(c);
                }
            }
        }

        if (inQuotes) {
            throw new IllegalArgumentException(
                    "Незакрытая кавычка"
            );
        }

        fields.add(field.toString());

        return fields;
    }

    // Экранирование CSV при записи
    private static String escapeCsv(String value) {

        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}
