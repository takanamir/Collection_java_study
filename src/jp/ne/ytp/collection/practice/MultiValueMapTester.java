package jp.ne.ytp.collection.practice;

import java.util.List;

/**
 *  同一キーの値を複数持てるマップの動作を
 *  確認するクラス
 */
public class MultiValueMapTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		// MultiValueMapに追加
		MultiValueMap mvm = new MultiValueMap();
		mvm.put("take", "取る");
		mvm.put("give", "与える");
		mvm.put("keep", "保存する");
		mvm.put("take", "乗る");
		mvm.put("give", "あげる");
		mvm.put("keep", "続ける");
		mvm.put("take", "連れて行く");

		// "take"を検索する
		System.out.print("take: ");
		show(mvm.get("take"));

		// "keep"を検索する
		System.out.print("keep: ");
		show(mvm.get("keep"));

		// キーの個数を表示する
		System.out.println("キー: " + mvm.size() + "個");

		// 値の個数を表示する
		System.out.println("値: " + mvm.sizeOfValue() + "個");
	}

	/**
	 * リストの内容を表示する
	 * @param values 表示したいリスト
	 */
	private void show(List values) {
		for(int i = 0; i < values.size(); i++) {
			System.out.print(values.get(i) + " ");
		}
		System.out.print("\n");
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		MultiValueMapTester tester = new MultiValueMapTester();
		tester.test(args);
	}
}