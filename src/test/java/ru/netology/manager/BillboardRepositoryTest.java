package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BillboardRepositoryTest {

    ViewingItem first = new ViewingItem(101, "Бладшот");
    ViewingItem second = new ViewingItem(202, "Вперед");
    ViewingItem third = new ViewingItem(303, "Отель 'Бельград'");
    ViewingItem fourth = new ViewingItem(404, "Джентльмены");
    ViewingItem fifth = new ViewingItem(505, "Человек - невидика");
    ViewingItem sixth = new ViewingItem(606, "Тролли.Мировой тур");
    ViewingItem seventh = new ViewingItem(707, "Номер один");

    @Test
    public void mustFindAll() {
        BillboardRepository repo = new BillboardRepository();

        ViewingItem[] actual = repo.findAll();
        ViewingItem[] expected = {first, second, third, fourth, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void mustSave() {
        BillboardRepository repo = new BillboardRepository();

        repo.save(seventh);

        ViewingItem[] actual = repo.findAll();
        ViewingItem[] expected = {first, second, third, fourth, fifth, sixth, seventh};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        BillboardRepository repo = new BillboardRepository();

        repo.removeById(202); //просим удалить

        ViewingItem[] actual = repo.findAll();
        ViewingItem[] expected = {first, third, fourth, fifth, sixth,};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        BillboardRepository repo = new BillboardRepository();

        ViewingItem actual = repo.findById(202);
        ViewingItem expected = new ViewingItem(202, "Вперед");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindInvalidId() {
        BillboardRepository repo = new BillboardRepository();

        ViewingItem actual = repo.findById(100);
        //ViewingItem expected = null;

        Assertions.assertNull(actual);
    }

    @Test
    public void shouldRemoveAll() {
        BillboardRepository repo = new BillboardRepository();

        repo.removeAll();

        ViewingItem[] actual = repo.findAll();
        ViewingItem[] expected = new ViewingItem[]{};

        Assertions.assertArrayEquals(expected, actual);
    }
}
