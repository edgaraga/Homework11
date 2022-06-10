package ru.netology.manager;

public class BillboardRepository {

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

    public ViewingItem findById(int id) {
        for (ViewingItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        ViewingItem[] tmp = new ViewingItem[length];
        int index = 0;
        for (ViewingItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        items = new ViewingItem[0];
    }
}
