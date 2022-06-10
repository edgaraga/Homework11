package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BillboardRepositoryTest {

    ViewingItem first = new ViewingItem(101,"Бладшот");
    ViewingItem second = new ViewingItem(202,"Вперед");
    ViewingItem third = new ViewingItem(303,"Отель 'Бельград'");
    ViewingItem fourth = new ViewingItem(404,"Джентльмены");
    ViewingItem fifth = new ViewingItem(505,"Человек - невидика");
    ViewingItem sixth = new ViewingItem(606,"Тролли.Мировой тур");
    ViewingItem seventh = new ViewingItem(707,"Номер один");
    ViewingItem eighth = new ViewingItem(808,"Своя война");
    ViewingItem ninth = new ViewingItem(909,"Мой папа - вождь");
    ViewingItem tenth = new ViewingItem(1010,"Аманат");

    @Test
    public void mustSaveAndFindAll() {
        BillboardRepository repo = new BillboardRepository();
        BillboardManager manager = new BillboardManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        ViewingItem[] actual = repo.findAll();
        ViewingItem[] expected = {first, second, third, fourth, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        BillboardRepository repo = new BillboardRepository();
        BillboardManager manager = new BillboardManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        repo.removeById(202); //просим удалить

        ViewingItem[] actual = repo.findAll();
        ViewingItem[] expected = {first, third, fourth, fifth, sixth,};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        BillboardRepository repo = new BillboardRepository();
        BillboardManager manager = new BillboardManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        ViewingItem actual = repo.findById(202);
        ViewingItem expected = new ViewingItem(202,"Вперед");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindInvalidId() {
        BillboardRepository repo = new BillboardRepository();
        BillboardManager manager = new BillboardManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        ViewingItem actual = repo.findById(100);
        //ViewingItem expected = null;

        Assertions.assertNull(actual);
    }

    @Test
    public void shouldRemoveAll() {
        BillboardRepository repo = new BillboardRepository();
        BillboardManager manager = new BillboardManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        repo.removeAll();

        ViewingItem[] actual = repo.findAll();
        ViewingItem[] expected = new ViewingItem[]{};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testManagerArrayDefaultMirror() {
        BillboardRepository repo = new BillboardRepository();
        BillboardManager manager = new BillboardManager(repo);

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

        ViewingItem[] actual = manager.findLast();
        ViewingItem[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testManagerArrayLimitMirror() {
        BillboardRepository repo = new BillboardRepository();
        BillboardManager manager = new BillboardManager(repo, 5);

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


        ViewingItem[] actual = manager.findLast();
        ViewingItem[] expected = {tenth, ninth, eighth, seventh, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }
}

