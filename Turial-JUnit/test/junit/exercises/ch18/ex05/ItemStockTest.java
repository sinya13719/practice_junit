package junit.exercises.ch18.ex05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 【リスト18.5】
 *  商品を表すItemクラスがあり、商品を追加 / 商品の削除が出来るItemStockクラスを作成しました。
 *  商品を（追加・削除）する（add・delete）メソッドのテスト
 */
@RunWith(Enclosed.class)
public class ItemStockTest {
    public static class 初期状態の場合 {
        ItemStock sut;
        Item book;

        @Before
        public void setUp() throws Exception {
            book = new Item("book", 3800);
            sut = new ItemStock();
        }

        @Test
        public void getNumはbookで0を返す() throws Exception {
        	assertEquals(sut.getNum(book), 0);
        }

        @Test
        public void addでbookを追加するとgetNumで1を返す() throws Exception {
            sut.add(book);
            assertEquals(sut.getNum(book), 1);
        }
        
        @Test
        public void addでbookを追加するとgetNumで0を返す() throws Exception {
            sut.add(book);
            sut.delete(book);
            assertEquals(sut.getNum(book), 0);
        }
    }

    public static class bookが1回追加されている場合 {
        ItemStock sut;
        Item book;

        @Before
        public void setUp() throws Exception {
            book = new Item("book", 3800);
            sut = new ItemStock();
            sut.add(book);
        }

        @Test
        public void getNumは1を返す() throws Exception {
        	assertEquals(sut.getNum(book), 1);
        }

        @Test
        public void addでbookを追加するとgetNumで2を返す() throws Exception {
            sut.add(book);
            assertEquals(sut.getNum(book), 2);
        }

        @Test
        public void addでbikeを追加するとgetNumでbookとbikeは1を返す() throws Exception {
            Item bike = new Item("bike", 57000);
            sut.add(bike);
            assertEquals(sut.getNum(book), 1);
            assertEquals(sut.getNum(bike), 1);
        }

    }
}