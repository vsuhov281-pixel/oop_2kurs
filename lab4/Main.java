package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Main{
    public static void main(String[] args){
        GameHW game1 = new GameHW(0, "CS2", "Shuter", 9.0, 0);
        GameHW game2 = new GameHW(1, "GTA5", "Open world", 9.5, 6000);
        GameHW game3 = new GameHW(2, "Watch Dogs", "Open world", 7.0, 5600);
        GameHW game4 = new GameHW(3, "Need for Speed", "Cars", 10.0, 8000);
        GameHW game5 = new GameHW(4, "Angry Birds", "Mobile", 8.0, 0);
        GameHW game6 = new GameHW(5, "FIFA", "Setevaya", 8.5, 7000);
        GameHW game7 = new GameHW(6, "UFC3", "Setevaya", 8.3, 5000);
        GameHW game8 = new GameHW(7, "DarkSouls", "RPG", 9.0, 3000);
        GameHW game9 = new GameHW(8, "Dota2", "Setevaya", 9.6, 0);
        GameHW game10 = new GameHW(9, "WARCRAFT", "RPG", 10.0, 0);
        GameHW game11 = new GameHW(0, "CS2", "Shuter", 9.0, 0);
        
        List<GameHW> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
        games.add(game5);
        games.add(game6);
        games.add(game7);
        games.add(game8);
        games.add(game9);
        games.add(game10);
        games.sort(Comparator.comparing(GameHW::getGenre));
        System.out.println("Сортировка по жанру:");
        for (GameHW geners : games) 
            System.out.println(geners.getDescription());
        System.out.println();

        games.sort(Comparator.comparing(GameHW::getRating).reversed());
        System.out.println("Сортировка по рейтингу(убывание):");
        for (GameHW ratings : games) 
            System.out.println(ratings.getDescription());
        System.out.println();
        
        games.sort(Comparator.comparing(GameHW::getTitle));
        System.out.println("Сортировка по названию:");
        for (GameHW titles : games) 
            System.out.println(titles.getDescription());
        System.out.println();

        System.out.println("Множество различных объектов:");
        Set<GameHW> gameset = new HashSet<>();
        gameset.add(game1);
        gameset.add(game11);
        gameset.add(game10);
        for(GameHW game : gameset){
            System.out.println(game.getDescription());
        }
        System.out.println();

        System.out.println("Ключ-игры(берем по жанру):");
        Map<String, List<GameHW>> gamesByGenre = new TreeMap<>();
        for (GameHW game : games) {
            String genre = game.getGenre();
            gamesByGenre.computeIfAbsent(genre, g -> new ArrayList<>()).add(game);
        }
        for (Map.Entry<String, List<GameHW>> entry : gamesByGenre.entrySet()) {
            System.out.println("Жанр: " + entry.getKey());
            for (GameHW game : entry.getValue()) {
                System.out.println("   " + game.getDescription());
            }
        }    
        System.out.println();
        
        List<GameHW> filtered = games.stream()
        .filter(g -> g.getRating() >= 8)
        .sorted(Comparator.comparing(GameHW::getPrice))
        .collect(Collectors.toList());
        System.out.println("Отфильтрованный список по рейтингу больше 8 и по возрастающей цене:");
        for(GameHW game : filtered){
            System.out.println(game.getDescription());
        }
        System.out.println();

        Map<String, Double> avgPriceByGenre = games.stream()
        .collect(Collectors.groupingBy(GameHW::getGenre, Collectors.averagingDouble(GameHW::getPrice)));
        System.out.println("Средняя цена игр в каждом жанре:");
        for(Map.Entry<String,Double> entry : avgPriceByGenre.entrySet()){
            System.out.println("Жанр: " +  entry.getKey() + " ,средняя цена: " + entry.getValue());
        }
        System.out.println();

            System.out.println("=== 5. Замер производительности ArrayList vs HashSet ===");
        int elementsCount = 500_000;

        // 1. Замер времени добавления (Add)
        long startListAdd = System.nanoTime();
        List<GameHW> testList = new ArrayList<>();
        for (int i = 0; i < elementsCount; i++) {
            testList.add(new GameHW(i, "Game" + i, "TestGenre", 8.5, 1000));
        }
        long endListAdd = System.nanoTime();

        long startSetAdd = System.nanoTime();
        Set<GameHW> testSet = new HashSet<>();
        for (int i = 0; i < elementsCount; i++) {
            testSet.add(new GameHW(i, "Game" + i, "TestGenre", 8.5, 1000));
        }
        long endSetAdd = System.nanoTime();

        // 2. Замер времени поиска (Contains)
        // Ищем объект, который находится в самом конце коллекции (худший случай для ArrayList)
        GameHW target = new GameHW(elementsCount - 1, "Game" + (elementsCount - 1), "TestGenre", 8.5, 1000);

        long startListContains = System.nanoTime();
        testList.contains(target);
        long endListContains = System.nanoTime();

        long startSetContains = System.nanoTime();
        testSet.contains(target);
        long endSetContains = System.nanoTime();

        // Вывод результатов (переводим наносекунды в миллисекунды для удобства чтения)
        System.out.printf("Время добавления %,d элементов:%n", elementsCount);
        System.out.printf("ArrayList: %.2f мс%n", (endListAdd - startListAdd) / 1_000_000.0);
        System.out.printf("HashSet:   %.2f мс%n", (endSetAdd - startSetAdd) / 1_000_000.0);
        
        System.out.println("\nВремя поиска (contains) одного элемента:");
        System.out.printf("ArrayList: %.4f мс%n", (endListContains - startListContains) / 1_000_000.0);
        System.out.printf("HashSet:   %.4f мс%n", (endSetContains - startSetContains) / 1_000_000.0);
}
}