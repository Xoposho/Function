import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    //TASK 5

    public static <Object, String> Function<Object, String> ternaryOperator(
            Predicate<? super Object> condition,
            Function<? super Object, ? extends String> ifTrue,
            Function<? super Object, ? extends String> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {

        String word = "Hello!";
        int countWord = word.length();
        int maxLength = 7;

        Predicate<Object> x = aLong -> countWord > maxLength;
        Function<Object, String> isTrue =  o -> "Poka!";
        Function<Object, String> isFalse = o -> "Privet!";
        Function<String, String> safeStringLength = ternaryOperator(x, isTrue, isFalse);
        System.out.println(safeStringLength);



        //TASK 1

        int a = -5;

        Predicate<Integer> pred = new Predicate() {

            @Override
            public boolean test(Object o) {
                if ((Integer) o >= 0) {
                    System.out.println("Число положительное (Anon class predicate)");
                    return true;
                } else {
                    System.out.println("Число отрицательное (Anon class predicate)");
                    return false;
                }

            }

        };

        System.out.println("-----------------------------------------------------------------------------------");

        Predicate<Integer> predLambda = o -> {
            if (o >= 0) {
                System.out.println("Число положительное (Lambda predicate)");
                return true;
            } else {
                System.out.println("Число отрицательное (Lambda predicate)");
                return false;
            }
        };

        predLambda.test(a);
        pred.test(a);

        //TASK 2

        People lyuda = new People("Людмила", 36, "Привет, меня зовут Людмила! Я люблю пирожки!");
        People sergay = new People("Сергей", 19, "Привет, меня зовут Сергей! Я люблю игры!");
        People igor = new People("Игорь", 25, "Привет, меня зовут Игорь! Я люблю возвращаться к проекту с гонками!");
        People vanya = new People("Ваня", 45, "Привет, меня зовут Ваня! Я люблю своих детей!");
        People dima = new People("Дмитрий", 78, "Привет, меня зовут Дмитрий! Я люблю природу!");


        System.out.println("-----------------------------------------------------------------------------------");


        Consumer<People> cons = new Consumer() {

            @Override
            public void accept(Object o) {
                People pep = (People) o;
                System.out.println(pep.getHelloWorld() + " (Anon class consumer)");
            }

            @Override
            public Consumer<People> andThen(Consumer after) {
                return Consumer.super.andThen(after);
            }


        };

        cons.accept(lyuda);
        cons.accept(vanya);

        System.out.println("-----------------------------------------------------------------------------------");

        Consumer<People> peopleConsumer = people -> System.out.println(people.getHelloWorld() + " (Lambda consumer)");

        peopleConsumer.accept(sergay);
        peopleConsumer.accept(dima);
        peopleConsumer.accept(igor);
        System.out.println("-----------------------------------------------------------------------------------");


        //TASK 3

        Double dobbyNum = 4.9999999999;

        Function<Double, Long> funk = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double, Long> doubleFunction = Math::round;

        System.out.println(funk.apply(dobbyNum) + " Function anon class");
        System.out.println(doubleFunction.apply(dobbyNum) + " Function lambda");


        System.out.println("-----------------------------------------------------------------------------------");

        //TASK 4

        Supplier<Integer> randNum = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random rndNum = new Random();
                return rndNum.nextInt(100);
            }
        };

        Supplier<Integer> integerSupplier = () -> {
            Random rndNum = new Random();
            return rndNum.nextInt(100);
        };

        System.out.println(randNum.get() + " Supplier anon class");
        System.out.println(integerSupplier.get() + " Supplier lambda");


    }



}