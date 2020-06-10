package jp.ne.ytp.collection.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *  自作クラスのソートを確認するクラス
 */
public class OwnSortTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		Set set = new TreeSet();

		/* Setに追加 */
		set.add(new Sales(600));
		set.add(new Sales(900));
		set.add(new Sales(200));
		set.add(new Sales(100));

		// イテレータで取り出す
		Iterator all = set.iterator();
		while (all.hasNext()) {
			Sales sales = (Sales) all.next();
			if(all.hasNext()) {
				System.out.print(sales.getAmount() + ", ");
			} else {
				System.out.print(sales.getAmount());
			}
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		OwnSortTester tester = new OwnSortTester();
		tester.test(args);
	}
}