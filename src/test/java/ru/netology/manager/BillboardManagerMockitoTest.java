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


        ViewingItem[] returned = new ViewingItem[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();


        ViewingItem[] actual = manager.getAll();
        ViewingItem[] expected = new ViewingItem[]{sixth, fifth, fourth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void addFilm() {


        ViewingItem[] returned = new ViewingItem[]{fifth};
        doReturn(returned).when(repository).findAll();

        manager.add(fifth);

        ViewingItem[] expected = new ViewingItem[]{fifth};
        ViewingItem[] actual = manager.getAll();

        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
