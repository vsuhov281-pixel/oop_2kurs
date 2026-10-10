package lab5;

public class Main {
    public static void main(String[] args){
        Converter<String,Integer> converter = new Converter<>(s -> Integer.parseInt(s));
        String str = "1488";
        Integer num = converter.convert(str);
        System.out.println("Converted value: " + num);
        System.out.println("Тип выведенной переменной: " + num.getClass());

        Converter<Double,String> converter2 = new Converter<>(d -> String.valueOf(d));
        Double d = 3.14;
        String str2 = converter2.convert(d);       
        System.out.println();
        System.out.println("Converted value: " + str2);
        System.out.println("Тип выведенной переменной: " + str2.getClass());

        Converter<Double,Integer> converter3 = new Converter<>(d1 -> d1.intValue());
        Double d2 = 3.1111;
        Integer num2 = converter3.convert(d2);
        System.out.println();
        System.out.println("Converted value: " + num2);
        System.out.println("Тип выведенной переменной: " + num2.getClass());
    }
}