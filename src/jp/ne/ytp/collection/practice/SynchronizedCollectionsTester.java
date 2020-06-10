package jp.ne.ytp.collection.practice;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

import jp.ne.ytp.collection.reference.Tester;

/**
 *  同期化されたコレクションの使い方を確認するクラス
 */
public class SynchronizedCollectionsTester extends Tester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		// 同期化されたコレクション
		Collection synchronizedCollection = Collections.synchronizedCollection(	new LinkedHashSet());

		// 要素の追加
		synchronizedCollection.add(sumire);
		synchronizedCollection.add(ajisai);
		synchronizedCollection.add(bara);
		synchronizedCollection.add(momo);

		// 反復子を使う場合はコレクションについて同期をとる
		synchronized (synchronizedCollection) {
			Iterator iterator = synchronizedCollection.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			System.out.println("");
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		Tester tester = new SynchronizedCollectionsTester();
		tester.prepare();
		tester.test(args);
	}
}