import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        User user = new User("login1", "pass123", 35);
        //получить объект класса из класса
        Class<?> userClass = User.class;

        String nameClass = userClass.getName();
        System.out.println(nameClass);

        String superClass = userClass.getSuperclass().getName();
        System.out.println(superClass);

        int modif = userClass.getModifiers();
        System.out.println(modif);

        System.out.println(Modifier.PRIVATE);
        System.out.println(Modifier.PRIVATE == modif);


        //вывести интерфейсы класса

        Class<?>[] interfaceUserClass = userClass.getInterfaces();
        for (Class<?> aClass : interfaceUserClass) {
            System.out.println(aClass.getName());
        }

        //изменить св-ва полей(приватных)
        Field fieldPass = userClass.getDeclaredField("password");
        fieldPass.setAccessible(true);
        fieldPass.set(user, "12345");


        //вывести свойства полей
        System.out.println("field-------");
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.print("модификатор " + field.getModifiers());
            System.out.print(" , тип свойства " + field.getType());
            System.out.print(" , название " + field.getName());
            field.setAccessible(true);
            System.out.println("содержимое  " + field.get(user));

        }


        //инф-ия о методах класса
        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(method.getModifiers() + " ");
            System.out.print(method.getName() + " ");
            System.out.print(Arrays.toString(method.getParameterTypes()) + " ");
            System.out.print(method.getParameterCount() + " - count ");
            System.out.println(method.getReturnType() + " -  return");
        }

        //запуск метода
        Method methodInfo = userClass.getDeclaredMethod("info", String.class);
        methodInfo.setAccessible(true);
        try {
            Object result = methodInfo.invoke(user, "Hello");
            System.out.println(result);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //создание объекта с помощью рефлексии
        Constructor<?> constructor = userClass.getConstructor(String.class, String.class, int.class);
        try {
            constructor.setAccessible(true);
            Object obj = constructor.newInstance("Tom", "qwerty123", 20);
            System.out.println(((User) obj).getPassword());
        } catch (InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}