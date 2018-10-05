package pl.superjaba.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String addres;

    @OneToOne(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Book book;

    public Publisher() {
    }

    public Publisher(String name, String addres) {
        this.name = name;
        this.addres = addres;
    }

    public Publisher(String name, String addres, Book book) {
        this.name = name;
        this.addres = addres;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                ", book=" + book +
                '}';
    }
}
