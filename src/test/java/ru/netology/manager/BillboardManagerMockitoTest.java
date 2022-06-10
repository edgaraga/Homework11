package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class BillboardManagerMockitoTest {

    private BillboardRepository repository = Mockito.mock(BillboardRepository.class);

    private BillboardManager manager = new BillboardManager(repository);

    ViewingItem first = new ViewingItem(101, "Бладшот");
    ViewingItem second = new ViewingItem(202, "Вперед");
    ViewingItem third = new ViewingItem(303, "Отель 'Бельград'");
    ViewingItem fourth = new ViewingItem(404, "Джентльмены");
    ViewingItem fifth = new ViewingItem(505, "Человек - невидика");
    ViewingItem sixth = new ViewingItem(606, "Тролли.Мировой тур");
    ViewingItem seventh = new ViewingItem(707, "Номер один");
    ViewingItem eighth = new ViewingItem(808, "Своя война");
    ViewingItem ninth = new ViewingItem(909, "Мой папа - вождь");
    ViewingItem tenth = new ViewingItem(1010, "Аманат");

    // ViewingItem seventh = new ViewingItem(707,"Номер один");
/*
@Test
public void mustGetAll() {
    BillboardRepository repo = new BillboardRepository();
    BillboardManager manager = new BillboardManager(repo); //передаем менеджеру

    ViewingItem[] actual = manager.getAll();
    ViewingItem[] expected = {sixth, fifth, fourth, third, second, first};

    Assertions.assertArrayEquals(expected, actual);
}
*/
    @Test
    public void mustShowSixFilm() {


        ViewingItem[] returned = new ViewingItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();


        ViewingItem[] actual = manager.findLast();
        ViewingItem[] expected = new ViewingItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void addFilm() {


        ViewingItem[] returned = new ViewingItem[]{fifth};
        doReturn(returned).when(repository).findAll();

        manager.add(fifth);

        ViewingItem[] expected = new ViewingItem[]{fifth};
        ViewingItem[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
