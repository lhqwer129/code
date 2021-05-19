package com.pattern.pattern.iterator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/14 3:37 下午
 */
public class BookShelf implements Aggregate {
    Book[] books;
    int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public int getLength() {
        return last;
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last ++;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }


}
