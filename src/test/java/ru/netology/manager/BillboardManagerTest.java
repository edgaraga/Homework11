package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.ViewingItem;

public class BillboardManagerTest {
    ViewingItem first = new ViewingItem("Бладшот");
    ViewingItem second = new ViewingItem("Вперед");
    ViewingItem third = new ViewingItem("Отель 'Бельград'");
    ViewingItem fourth = new ViewingItem("Джентльмены");
    ViewingItem fifth = new ViewingItem("Человек - невидика");
    ViewingItem sixth = new ViewingItem("Тролли.Мировой тур");
    ViewingItem seventh = new ViewingItem("Номер один");
    ViewingItem eighth = new ViewingItem("Своя война");
    ViewingItem ninth = new ViewingItem("Мой папа - вождь");
    ViewingItem tenth = new ViewingItem("Аманат");


    @Test

    public void testManagerSaveFilmName() {
        BillboardManager manager = new BillboardManager();

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(seventh);

        ViewingItem[] actual = manager.findAll();
        ViewingItem[] expected = {first, second, third, seventh};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testManagerArrayDefaultMirror() {
        BillboardManager manager = new BillboardManager();

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);

        ViewingItem[] actual = manager.findLast();
        ViewingItem[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testManagerArrayLimitMirror() {
        BillboardManager manager = new BillboardManager(5);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);


        ViewingItem[] actual = manager.findLast();
        ViewingItem[] expected = {tenth, ninth, eighth, seventh, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }

}
