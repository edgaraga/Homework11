package ru.netology.manager;

import ru.netology.domain.ViewingItem;

public class BillboardManager {

    private int limitManager = 10;

    private ViewingItem[] items = new ViewingItem[0];

    public void save(ViewingItem item) {

        int length = items.length + 1;
        ViewingItem[] tmp = new ViewingItem[length];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public ViewingItem[] findAll() {
        return items;
    }

    public ViewingItem[] findLast() {

        int resultLength;
        if (limitManager == 10) {
            resultLength = 10;
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

    public BillboardManager(int limitManager) {
        this.limitManager = limitManager;
    }

    public BillboardManager() {
    }

}
