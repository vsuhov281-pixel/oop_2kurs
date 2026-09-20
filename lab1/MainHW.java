public class MainHW {
     public static void main(String[] args){
        GameHW game1 = new GameHW();
        game1.setTitle("gta5");
        game1.setGenre("открытый мир");
        game1.setRating(9.0);
        game1.setPrice(5000);
        System.out.println(game1.getDescription());

        GameHW game2 = new GameHW();
        game2.setTitle("CS2");
        game2.setGenre("RPG");
        game2.setRating(7.9);
        game2.setPrice(0);
        System.out.println(game2.getDescription());  

        GameHW game3 = new GameHW();
        game3.setTitle("Genshin_Impact");
        game3.setGenre("расслабиться");
        game3.setRating(10.0);
        game3.setPrice(0);
        System.out.println(game3.getDescription());
     }
}
