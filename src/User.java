public class User extends Person implements Student, Sportsmen {
    private String login;
    private String password;
    private int age;

    public User(String login, String password, int age) {
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public int getAge() {
        return age;
    }

    static void infoUser() {
        System.out.println("Это класс User");
    }

     private void info(String str) {
        System.out.println( str+ " логин " + login);
    }

}
