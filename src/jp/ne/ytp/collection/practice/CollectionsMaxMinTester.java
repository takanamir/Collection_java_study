package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.ne.ytp.collection.bean.FlowerSales;
import jp.ne.ytp.collection.reference.Tester;

/**
 * Collections.max()メソッドとCollections.min()メソッドの
 * 動きを確認するクラス
 */
public class CollectionsMaxMinTester extends Tester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		List list = new ArrayList();
		Set set = new HashSet();
		
		initCollection(list);
		initCollection(set);

		System.out.println("List ----");
		System.out.println("  Max(Name)    :" + Collections.max(list));
		System.out.println("  Min(Name)    :" + Collections.min(list));

		Comparator comparator = new QuantityComparator();
		System.out.println(
				"  Max(Quantity):" + Collections.max(list, comparator));
		System.out.println(
				"  Min(Quantity):" + Collections.min(list, comparator));

		System.out.println("Set  ----");
		System.out.println("  Max(Name)    :" + Collections.max(set));
		System.out.println("  Min(Name)    :" + Collections.min(set));
	}

	// 初期データの登録
	private void initCollection(Collection c) {
		c.add(sumire);
		c.add(bara);
		c.add(momo);
	}

	// 独自のコンパレータクラス
	class QuantityComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			FlowerSales fs1 = (FlowerSales) o1;
			FlowerSales fs2 = (FlowerSales) o2;
			
			if(fs1.getQuantity() == fs2.getQuantity()) {
				return 0;
			}
			return fs1.getQuantity() < fs2.getQuantity() ? -1 : 1;
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		Tester tester = new CollectionsMaxMinTester();
		tester.prepare();
		tester.test(args);
	}
}