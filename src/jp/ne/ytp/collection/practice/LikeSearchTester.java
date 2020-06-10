package jp.ne.ytp.collection.practice;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *  文字列の前方一致検索を確認するクラス
 */
public class LikeSearchTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		/* SortedSetに追加 */
		SortedSet set = new TreeSet();
		set.add("A");
		set.add("AA");
		set.add("AAB");
		set.add("AAC");
		set.add("AB");
		set.add("ABC");
		set.add("ACA");

		/* SortedMapに追加 */
		SortedMap map = new TreeMap();
		map.put("A", "a");
		map.put("AA", "aa");
		map.put("AAB", "aab");
		map.put("AAC", "aac");
		map.put("AB", "ab");
		map.put("ABC", "abc");
		map.put("ACA", "aca");

		// "AA"で始まる文字列を検索する
		String aa = "AA";
		Set aaSet = likeSearchSet(set, aa);
		show(aaSet.iterator());
		Map aaMap = likeSearchMap(map, aa);
		show(aaMap.keySet().iterator());

		// "AB"で始まる文字列を検索する
		String ab = "AB";
		Set abSet = likeSearchSet(set, ab);
		show(abSet.iterator());
		Map abMap = likeSearchMap(map, ab);
		show(abMap.keySet().iterator());
	}

	/**
	 * likeで指定された文字列をセットから前方一致検索し、
	 * 合致する要素のセットを返す
	 * @param set 検索対象のセット
	 * @param like 前方一致検索対象の文字列
	 * @return 検索結果
	 */
	private Set likeSearchSet(SortedSet set, String like) {
		System.out.print(like + "のSet前方一致 ");

		// 範囲検索のための終端に当たる文字列を取得する
		String to = getToString(like);
		// likeとtoの間にある要素のマップを返す

		return set.subSet(like, to);
	}

	/**
	 * likeで指定された文字列をマップから前方一致検索し、
	 * 合致する要素のマップを返す
	 * @param map 検索対象のマップ
	 * @param like 前方一致検索対象の文字列
	 * @return 検索結果
	 */
	private Map likeSearchMap(SortedMap map, String like) {
		System.out.print(like + "のMap前方一致 ");

		// 範囲検索のための終端に当たる文字列を取得する
		String to = getToString(like);
		// likeとtoの間にある要素のマップを返す

		return map.subMap(like, to);
	}

	/**
	 * likeで指定された文字列で前方一致検索するための、
	 * 終端の次のコードを持つ文字列を取得する。
	 * たとえば、likeに"AB"が指定されると"AC"を返す
	 * @param like 前方一致検索対象の文字列
	 * @return likeの文字列の次のコードを持つ文字列
	 */
	private String getToString(String like) {
		// 先頭から最後の文字の1つ前までを切り出す
		String body = like.substring(0, like.length() - 1);
		// 最後の1文字を切り出す
		String lastStr = like.substring(like.length() - 1, like.length());
		// 最後の1文字の次のコードを求める
		char[] lastChar = new char[1];
		lastChar[0] = lastStr.charAt(0);
		lastChar[0]++;
		// 求めたコードから、範囲指定のTO文字列を作り出す
		String to = body + new String(lastChar);

		return to;
	}

	/**
	 * キーを一覧表示する
	 * @param Iterator キー一覧
	 */
	private void show(Iterator keys) {
		while(keys.hasNext()) {
			String key = (String) keys.next();
			System.out.print(key + " ");
		}
		System.out.println("");
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		LikeSearchTester tester = new LikeSearchTester();
		tester.test(args);
	}
}