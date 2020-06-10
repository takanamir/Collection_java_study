package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *  複数階層のキーを持つマップの動きを確認するクラス
 */
public class MultiKeyMapTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		// 3階層のキー5つ作成してリストに追加していく
		List all = new ArrayList();
		List keys = new ArrayList();
		keys.add("A"); // 第1キー
		keys.add("B"); // 第2キー
		keys.add("C"); // 第3キー
		all.add(keys);

		keys = new ArrayList();
		keys.add("A"); // 第1キー
		keys.add("B"); // 第2キー
		keys.add("X"); // 第3キー
		all.add(keys);

		keys = new ArrayList();
		keys.add("A"); // 第1キー
		keys.add("B"); // 第2キー
		keys.add("4"); // 第3キー
		all.add(keys);

		keys = new ArrayList();
		keys.add("F"); // 第1キー
		keys.add("G"); // 第2キー
		keys.add("H"); // 第3キー
		all.add(keys);

		keys = new ArrayList();
		keys.add("F"); // 第1キー
		keys.add("J"); // 第2キー
		keys.add("H"); // 第3キー
		all.add(keys);

		// 複数キーマップに格納する
		MultiKeyMap multi = new MultiKeyMap(3);
		multi.put((List) all.get(0), "A-B-C");
		multi.put((List) all.get(1), "A-B-X");
		multi.put((List) all.get(2), "A-B-4");
		multi.put((List) all.get(3), "F-G-H");
		multi.put((List) all.get(4), "F-J-H");

		// A,B,Xで検索する
		String value = (String) multi.get((List) all.get(1));
		System.out.println("A,B,Xの値:" + value);

		// F,G,Hで検索する
		value = (String) multi.get((List) all.get(3));
		System.out.println("F,G,Hの値:" + value);

		keys = new ArrayList();
		keys.add("A"); // 第1キー
		keys.add("B"); // 第2キー
		System.out.println("A,B配下のキー " + multi.keySet(keys));
		System.out.println("A,B配下の値   " + multi.values(keys));

	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		MultiKeyMapTester tester = new MultiKeyMapTester();
		tester.test(args);
	}
}