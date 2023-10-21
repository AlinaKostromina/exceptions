import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {
    ShopRepository repository = new ShopRepository();

    Product first = new Book(1, "ski-fi", 500, "King", 230, 1983);
    Product second = new Book(2, "novel", 340, "Bronte", 230, 1847);
    Product third = new Tshirt(3, "befree", 1500, "grey", "l");
    Product fourth = new Tshirt(4, "sela", 3000, "red", "xl");

//    @BeforeEach
//    public void setUp() {
//        repository.save(first);
//        repository.save(second);
//        repository.save(third);
//        repository.save(fourth);
//    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 2;
        repository.remove(idToRemove);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{ first, third, fourth };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowIfIdNotExist () {
        assertThrows(NotFoundException.class, ()-> repository.remove(5));
    }
}