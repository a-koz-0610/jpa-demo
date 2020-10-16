package com.example.jpademo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PaperPlate {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String reviewDescription;

    @ManyToOne
    private Category category;

    private String getBrand() {
        return brand;
    }

    private String reviewDescription() {
        return reviewDescription;
    }

    private Category getCategory() {
        return category;
    }

    protected PaperPlate() {
    }

    public PaperPlate(String brand, String reviewDescription, Category category) {
        this.brand = brand;
        this.reviewDescription = reviewDescription;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PaperPlate paperPlate = (PaperPlate) o;
        return Objects.equals(id, paperPlate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
