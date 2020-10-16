package com.example.jpademo;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Collection<PaperPlate> paperPlates;

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Collection<PaperPlate> getPaperPlates() {
        return paperPlates;
    }

    protected Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
