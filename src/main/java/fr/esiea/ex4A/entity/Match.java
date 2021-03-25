package fr.esiea.ex4A.entity;

public class Match {
    private final String name;
    private final String twitter;

    public Match(String name, String twitter) {
        this.name = name;
        this.twitter = twitter;
    }

    public String getName() {
        return name;
    }

    public String getTwitter() {
        return twitter;
    }
}
