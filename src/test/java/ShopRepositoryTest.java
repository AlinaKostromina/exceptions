import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {
    ShopRepository repository = new ShopRepository();

    Product first = new Book(1, "ski-fi", 500, "King", 230, 1983);
    Product second = new Book(2, "novel", 340, "Bronte", 230, 1847);
    Product third = new Tshirt(3, "befree", 1500, "grey", "l");
    Product fourth = new Tshirt(4, "sela", 3000, "red", "xl");

    @Test
    void shouldRemoveById() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        int idToRemove = 2;
        repository.remove(idToRemove);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{ first, third, fourth };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowIfIdNotExist () {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        Assertions.assertThrows(NotFoundException.class, ()-> repository.remove(5));
    }
}