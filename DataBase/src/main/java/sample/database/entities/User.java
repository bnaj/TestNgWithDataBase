package sample.database.entities;

public class User {
/**
 * In this is stored data model.
 * */

    private int userId;
    private String login;
    private String name;
    private int age;

    public User(){
    }

    public User(int userId, String login, String name, int age){
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.age = age;
    }

    public long getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
