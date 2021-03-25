package fr.esiea.ex4A.entity;

public class User {

    private final String userEmail;
    private final String userName;
    private final String userTweeter;
    private final String userCountry;
    private final String userSex;
    private final String userSexPref;
    private final Integer userAge;

    public User(String userEmail, String userName, String userTweeter, String userCountry, String userSex, String userSexPref, Integer userAge) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserSexPref() {
        return userSexPref;
    }
    public Integer getUserAge() {
        return userAge;
    }
}
