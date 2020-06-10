package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  同一キーの値を複数持てるマップ
 *  @author YTP
 */
public class MultiValueMap {
	/**
	 * すべての要素を格納するマップ
	 */
	private Map map = new HashMap();

	/**
	 * すべての値の数
	 */
	private int valueSize;

	/**
	 * デフォルトコンストラクタ
	 */
	public MultiValueMap() {
	}

	/**
	 * keyをキーとしてvalueをマップに格納する。
	 * 同一のキーが既に存在しても、valueを追加できる
	 * @param key キー
	 * @param value 値
	 */
	public void put(Object key, Object value) {
		List multi = (List) map.get(key);
		
		// 新しいキーの場合
		if (multi == null) {
			// リストを生成する
			multi = new ArrayList();
			// リストに値を追加する
			multi.add(value);
			// マップにリストを追加する
			map.put(key, multi);
		} else {
			// リストに値を追加する
			multi.add(value);
		}
		
		// 値の数に加算する
		valueSize++;
	}

	/**
	 * 指定されたキーの値を保持するリストを返す
	 * @param key キー
	 * @return 値のリスト
	 */
	public List get(Object key) {
		return (List) map.get(key);
	}

	/**
	 * 保持するキーの数を返す
	 * @return キーの数
	 */
	public int size() {
		return map.size();
	}

	/**
	 * 保持する値の数を返す
	 * @return 値の数
	 */
	public int sizeOfValue() {
		return valueSize;
	}
}