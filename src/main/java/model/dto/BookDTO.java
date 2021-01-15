package main.java.model.dto;

public class BookDTO {

    public String title;
    public String description;
    public String img;
    public String author;

    public BookDTO(String title, String description, String img, String author) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.author = author;
    }

    public BookDTO(){}

}
