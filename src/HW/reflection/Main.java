package HW.reflection;

import java.lang.reflect.*;
import java.util.function.ObjLongConsumer;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        //Создать в маине объект  Player   вывести названия и модификаторы его полей
        //после присвоить ему новое имя
        //вывести список его методов
        //запустить метод через рефлексию так же передам число в качестве параметра
        //создать объект с использованием констурктора

        Player player = new Player("vladimir", 40, 100, 2);
        player.play(4);
        int ourBalance = player.getBalance();
        System.out.println(ourBalance);

        // рефлексия.вывести названия и модификаторы его полей

        Class<?> classPlayer = Player.class;
        String nameClass = classPlayer.getName();
        System.out.println(nameClass);

        int modification = classPlayer.getModifiers();
        System.out.println(modification);

        System.out.println(Modifier.PRIVATE);
        //после присвоить ему новое имя-name
        Field fieldName = classPlayer.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(player, "Ilya");

        //вывести список его методов
        Method[] methods = classPlayer.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name : " + method.getName());
        }

        //запустить метод через рефлексию так же передам число в качестве параметра

        Method runMethod = classPlayer.getDeclaredMethod("method", int.class);
        runMethod.setAccessible(true);
        try {
            runMethod.invoke(player, 100);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
        //    создать объект с использованием констурктора
        Constructor<?> constructorPlayer = classPlayer.getConstructor(String.class, int.class, int.class, int.class);
        constructorPlayer.setAccessible(true);
        try {
            Object objPlayer = constructorPlayer.newInstance("Ilya", 23, 121, 1);
            System.out.println(((Player) objPlayer).getName());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }


}
