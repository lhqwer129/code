package com.pattern.pattern.iterator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/14 3:39 下午
 */
public class BookShelfIterator implements Iterator {
    BookShelf bookShelf;
    int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
