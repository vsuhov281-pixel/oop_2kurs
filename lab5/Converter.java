package lab5;
import java.util.function.Function;

public class Converter<S,T>{
    Function<S,T> convert;
    public Converter(Function<S,T> convert){
        this.convert = convert;
    }
    public T convert(S value){
        return convert.apply(value);
    }
    
}