package junit.exercises.ch19.ex05;

import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * リスト19.5 
 * 消費税を表すConsumptionTaxクラスを作成し、
 * 金額を引数に与えると消費税込みの金額を返すメソッドのテストを行う
 */
@RunWith(Theories.class)
public class ConsumptionTaxTest {
    @DataPoints
    public static Fixture[] FIXTURES = new Fixture[] {
        new Fixture(5, 100, 105),
        new Fixture(5, 3000, 3150),
        new Fixture(10, 50, 55),
        new Fixture(5, 50, 52),
        new Fixture(3, 50, 51),
    };

    @Theory
    public void applyで消費税が加算された価格が取得できる(Fixture fixture) throws Exception {
        ConsumptionTax sut = new ConsumptionTax(fixture.taxRate);
        String desc = "when rate=" + fixture.taxRate + ", price=" + fixture.price;
        assertEquals(desc, sut.apply(fixture.price), fixture.expected);
    }
}

// 生成メソッドでのセットアップ
class Fixture {
    final int taxRate;
    final int price;
    final int expected;
    Fixture(int taxRate, int price, int expected) {
        this.taxRate = taxRate;
        this.price = price;
        this.expected = expected;
    }
}