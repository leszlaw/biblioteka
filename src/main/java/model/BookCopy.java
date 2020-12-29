package main.java.model;

public class BookCopy {

    public int publisherBookId;
    public int stateId;
    public String description;
    public Integer signature;

    @Override
    public String toString() {
        return "BookCopy{" +
                "publisherBookId=" + publisherBookId +
                ", stateId=" + stateId +
                ", description='" + description + '\'' +
                ", signature=" + signature +
                '}';
    }
}
