package jp.ne.ytp.collection.practice;

import java.util.Comparator;

/**
 *  辞書順ではなく数値順でソートする動きを確認するクラス
 */
public class NumberSortComparator implements Comparator {
	/**
	 *  o1とo2を数値順で比較する
	 *  o1の数値表現がo2よりも大きい場合は正の数、
	 *  小さい場合は負の数、
	 *  両方が等しい場合は0を返す
	 */
	public int compare(Object o1, Object o2) {
		int i1 = Integer.parseInt(o1.toString());
		int i2 = Integer.parseInt(o2.toString());

		return i1 - i2;
	}
}