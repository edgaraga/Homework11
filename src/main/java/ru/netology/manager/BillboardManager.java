package ru.netology.manager;

public class BillboardManager {

    private int limitManager = 10;
    private BillboardRepository repository;

    public BillboardManager(BillboardRepository repository) {
        this.repository = repository;
    }
    public BillboardManager(BillboardRepository repository, int limitManager) {
        this.repository = repository;
        this.limitManager = limitManager;
    }

    public void add(ViewingItem item) {
        repository.save(item);
    }

    public ViewingItem[] findLast() {
        ViewingItem[] items = repository.findAll();
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
