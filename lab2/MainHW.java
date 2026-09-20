package lab2;

public class MainHW {
    public static void main(String[] args){
        GameHW game1 = new GameHW("Гта 5", "open world");
        System.out.println("Игра в полном формате, без счетчика: " + game1.getDescription());
        GameHW game2 = new GameHW();
        System.out.println("Пустышка: " + game2.getDescription());
        GameHW game3 = new GameHW(0);
        System.out.println("В коротмком формате: " + game3.getDescription(true));
        GameHW game4 = new GameHW(0);
        System.out.println("Та же книга, но в полном формате: " + game4.getDescription());
        GameHW game5 = GameHW.createGame("cs2", "рпг", 100);
        System.out.println("Через фабричный метод: " + game5.getDescription());
        GameHW game6 = new GameHW(0, "Dota2", "экшен", 9.0 , 120.0);
        System.out.println("Игра, для которой будем выщитывать скидку: " + game6.getTitle() + " ,ее цена: " + game6.getPrice() + " $");
        System.out.println("Цена с базовой скидкой 10%: " +  game6.calculateDiscount());
        System.out.println("Цена со скидкой 50%: " + game6.calculateDiscount(50));
        System.out.println("количество игр со счетчиком: " + GameHW.getCounter());
    }
}
