package jp.ne.ytp.collection.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import jp.ne.ytp.collection.bean.FlowerSales;
import jp.ne.ytp.collection.reference.Tester;

/**
 *  配列をリストに入れるまたはソートする動きを確認するクラス
 */
public class ArrayToListTester extends Tester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		// 配列を用意する
		FlowerSales[] array = { sumire, bara, momo, ajisai };

		// 配列をリストに変換する
		List list = Arrays.asList(array);
		show(list.iterator());

		// 配列をソートする
		Arrays.sort(array);
		// 配列をリストに変換する
		list = Arrays.asList(array);
		System.out.println("---- ソート後 ----");
		show(list.iterator());
	}

	/**
	 * 全要素の名前を先頭または末尾から表示する
	 * @param all 要素が格納されたイテレータ
	 */
	private void show(Iterator all) {
		// 要素全部を表示する
		while(all.hasNext()) {
			System.out.println(all.next());
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		Tester tester = new ArrayToListTester();
		tester.prepare();
		tester.test(args);
	}
}