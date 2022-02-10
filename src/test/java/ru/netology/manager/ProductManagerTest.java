package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book first = new Book(1, "Мастер и Маргарита", 600, "Михаил Булгаков");
    private Book second = new Book(2, "Мёртвые души", 520, "Николай Гоголь");
    private Book third = new Book(3, "Мцыри", 350, "Михаил Лермонтов");
    private Book fourth = new Book(4, "Преступление и наказание", 440, "Федор Достоевский");
    private Book fifth = new Book(5, "Отцы и дети", 330, "Иван Тургенев");
    private Smartphone sixth = new Smartphone(6, "Reno 6 Pro+", 29000, "Oppo");
    private Smartphone seventh = new Smartphone(7, "M3", 10000, "Poco");
    private Smartphone eighth = new Smartphone(8, "Redmi K40", 16000, "Xiaomi");
    private Smartphone ninth = new Smartphone(9, "Galaxy S20", 30000, "Samsung");
    private Smartphone tenth = new Smartphone(10, "Xr", 32000, "Apple");
    private Smartphone eleventh = new Smartphone(11, "Galaxy S10", 15000, "Samsung");
    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void shouldSearchBookByNameFromList() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Мастер и Маргарита");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchBookByNameNotFromList() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Золотой теленок");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthorFromList() {
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Михаил Лермонтов");
    }

    @Test
    public void shouldSearchBookByAuthorNotFromList() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Носов");
    }

    @Test
    public void shouldSearchSmartphoneFromList() {
        Product[] expected = new Product[]{seventh};
        Product[] actual = manager.searchBy("Poco");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSmartphoneNotFromList() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Nan");
        assertArrayEquals(expected, actual);
    }
//несколько товаров подходящих под один поисковый запрос
    @Test
    public void shouldSearchSmartphoneFromList1() {
        Product[] expected = new Product[]{ninth, eleventh};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

}