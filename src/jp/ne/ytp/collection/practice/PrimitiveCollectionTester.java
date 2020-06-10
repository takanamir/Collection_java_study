package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  プリミティブ型の要素をコレクションに格納する動きを
 *  確認するクラス
 */
public class PrimitiveCollectionTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		int i = 10;
		long l = 20L;
		float f = 45.6F;
		double d = 12.3D;
		char c = 'A';
		byte b = 32;
		List list = new ArrayList();

		// ラッパクラスを利用してリストに入れる
		list.add(new Integer(i));
		list.add(new Long(l));
		list.add(new Float(f));
		list.add(new Double(d));
		list.add(new Character(c));
		list.add(new Byte(b));
		
		// 要素全部を表示する
		Iterator all = list.iterator();
		while (all.hasNext()) {
			System.out.println(all.next());
		}

		// 配列を利用してリストに入れる
		int[] i1 = { 10 };
		int[] i2 = { 20 };
		int[] i3 = { 30 };
		list = new ArrayList();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		
		// 要素全部を表示する
		System.out.println("---- int[] ----");
		all = list.iterator();
		while (all.hasNext()) {
			int[] ii = (int[]) all.next();
			System.out.println(ii[0]);
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		PrimitiveCollectionTester tester = new PrimitiveCollectionTester();
		tester.test(args);
	}
}