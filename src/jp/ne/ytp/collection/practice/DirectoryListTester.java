package jp.ne.ytp.collection.practice;

import java.io.File;
import java.io.IOException;

/**
 *  ディレクトリの一覧表示を確認するクラス
 */
public class DirectoryListTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		File test = new File("C:\\test");
		try {
			DirectoryList top = new DirectoryList(test);
			top.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		DirectoryListTester tester = new DirectoryListTester();
		tester.test(args);
	}
}