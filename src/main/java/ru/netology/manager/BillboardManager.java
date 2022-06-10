package ru.netology.manager;

public class BillboardManager {
    private BillboardRepository repository;

    public BillboardManager(BillboardRepository repository) {
        this.repository = repository;
    }

    public void add(ViewingItem item) {
        repository.save(item);
    }


    public ViewingItem[] getAll() {
        ViewingItem[] items = repository.findAll();
        ViewingItem[] result = new ViewingItem[items.length];
        for (int i = 0; i < items.length; i++) {

    public ViewingItem[] findLast() {

        int resultLength;
        if (limitManager == items.length) {
            resultLength = items.length;
        } else {
            resultLength = limitManager;
        }
        ViewingItem[] result = new ViewingItem[resultLength];
        for (int i = 0; i < resultLength; i++) {

            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
