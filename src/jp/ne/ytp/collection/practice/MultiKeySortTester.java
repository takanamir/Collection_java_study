package jp.ne.ytp.collection.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import jp.ne.ytp.collection.bean.FlowerSales;
import jp.ne.ytp.collection.reference.Tester;

/**
 *  複数キーソートの動きを確認するクラス
 */
public class MultiKeySortTester extends Tester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		Set set = new TreeSet();

		/* Setに追加 */
		set.add(sumire);
		set.add(bara);
		set.add(momo);
		set.add(ajisai);
		set.add(new FlowerSales("すみれ", getCalendar(2004, 12, 12), 50, 100));
		set.add(new FlowerSales("バラ", getCalendar(2004, 12, 18), 90, 160));

		// 全件を表示
		show(set.iterator());
	}

	/**
	 * コレクションの全要素の名前を表示する
	 * @param all コレクションのイテレータ(反復子)
	 */
	private void show(Iterator all) {
		// 反復子の要素数分
		while(all.hasNext()) {
			FlowerSales work = (FlowerSales) all.next();
			System.out.println(work);
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		Tester tester = new MultiKeySortTester();
		tester.prepare();
		tester.test(args);
	}
}