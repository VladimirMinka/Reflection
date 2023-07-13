package HW.reflection;

public class Player {
    //    Создать класс Player с конструктором принимающий все параметры
    //    cо свойствами приватныеми имя, возраст, баланс, уровень, с методом играть (который принимает число )
    //    если это число четное выводит сообщение вы выграли 1 балл и пополняется балл объекта иначе убавляется
    private String name;
    private int age;
    private int balance;
    private int level;

    public Player(String name, int age, int balance, int level) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void play(int number) {
        if (number % 2 == 0) {
            System.out.println("вы выиграли 1 балл");
            balance++;
        } else {
            balance--;
        }
    }

    public void method(int num) {
        System.out.println("Number: " + num);
    }
}
