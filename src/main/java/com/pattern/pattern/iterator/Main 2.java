package com.pattern.pattern.iterator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/14 3:49 下午
 */
public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(2);
        bookShelf.appendBook(new Book("图解涉及模式"));
        bookShelf.appendBook(new Book("Around the world in 80 Days"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
