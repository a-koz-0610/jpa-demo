package com.example.jpademo;

import java.util.Optional;

import javax.annotation.Resource;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Resource
    private CategoryRepository categoryRepo;

    @Resource
    private PaperPlateRepository paperPlateRepo;

    @Test
    public void paperPlateCategoryShouldHaveAListOfPaperPlates() {
        Category coated = new Category("coated");
        categoryRepo.save(coated);

        PaperPlate plate1 = new PaperPlate("glad", "fantastic product", coated);
        PaperPlate plate2 = new PaperPlate("hefty", "hefty hefty hefty", coated);
        paperPlateRepo.save(plate1);
        paperPlateRepo.save(plate2);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOptional = categoryRepo.findById(coated.getId());
        Category retrievedCategory = retrievedCategoryOptional.get();

        assertThat(retrievedCategory.getPaperPlates()).contains(plate1, plate2);
    }

}