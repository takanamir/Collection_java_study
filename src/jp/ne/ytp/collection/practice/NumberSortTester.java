package jp.ne.ytp.collection.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *  辞書順ではなく数値順でソートする動きを確認するクラス
 */
public class NumberSortTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		Set set = new TreeSet(new NumberSortComparator());

		set.add("20");
		set.add("1");
		set.add("999");
		set.add("748");

		// 要素全部を表示する
		Iterator all = set.iterator();
		while(all.hasNext()) {
			System.out.println(all.next());
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		NumberSortTester tester = new NumberSortTester();
		tester.test(args);
	}
}