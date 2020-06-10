package jp.ne.ytp.collection.practice;

import java.io.File;
import java.io.IOException;

/**
 *  ソートされたディレクトリの一覧表示を確認するクラス
 */
public class SortedDirectoryListTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		File test = new File("C:\\test");
		
		try {
			System.out.println(test.getCanonicalPath());
			System.exit(0);
			SortedDirectoryList top = new SortedDirectoryList(test);
			top.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		SortedDirectoryListTester tester = new SortedDirectoryListTester();
		tester.test(args);
	}
}