import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
interface MyFuncionalInterface {
    public String doSomeThing(String param);
}

class Tux implements MyFuncionalInterface {

    @Override
    public String doSomeThing(String param) {
        return "Tux: Hola " + param;
    }
}

class Pickachu {
    String pika(String param) {
        return "Pickachu: pika " + param;
    }
    String impactrueno(String param) {
        return "Pickachu: impactrueno " + param;
    }
}

class Main {
    public static void print(MyFuncionalInterface functionParam) {
        System.out.println(functionParam.doSomeThing("Cristian"));
    }
    public static void main(String[] args) {
        var tux = new Tux();
        var greeting = tux.doSomeThing("zuza");
        System.out.println(greeting);

        //Clase anonima
        var duke = new MyFuncionalInterface() {
            @Override
            public String doSomeThing(String param) {
                return "Duke: Hola " + param;
            }
        };
        var greeting2 = duke.doSomeThing("zuza");
        System.out.println(greeting2);

        //Expresion lambda
        MyFuncionalInterface clippy = (param) -> {
            return "Clippy: Hola " + param;
        };
        var greeting3 = clippy.doSomeThing("zuza");
        System.out.println(greeting3);

        //Funcion como parametro
        print(clippy);
        print(x -> "Hola " + "Juancho");
        print(tux::doSomeThing);
        //La firma tiene que coincidir, solo eso
        var pika = new Pickachu();
        print(pika::pika);
        print(pika::impactrueno);

        var arrayJedis = new ArrayList();
        arrayJedis.add("Yoda");
        arrayJedis.add("Windu");
        arrayJedis.add("Anakin");
        arrayJedis.add("Luke");
        arrayJedis.add("Rey");
        arrayJedis.forEach(param -> System.out.println(param));
        arrayJedis.forEach(System.out::println);
        arrayJedis.removeIf(s -> !s.equals("Rey"));
        System.out.println(arrayJedis);

        //Stream Map-Reduce
        var newStreamJedis = arrayJedis.stream()
                .filter(s -> s.equals("Rey")) // Map
                .map(j -> j.toString().toUpperCase()) // Map
                .findFirst(); // Reduce
        System.out.println(newStreamJedis);

        //Puedo tener una variable almacenar una función?
        Predicate func = s -> s.equals("Rey");
    }
}