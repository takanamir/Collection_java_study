package jp.ne.ytp.collection.practice;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  複数階層のキーを持つことが可能なマップ
 *  @author YTP
 */
public class MultiKeyMap {
	/**
	 *  キーの階層数
	 */
	private final int layer_;

	/**
	 *  最上位階層(ルート)のMap
	 */
	private Map root_ = new HashMap();

	/**
	 *  layerで指定された階層数をキーとして持つインスタンスを生成する
	 *  インスタンス生成後は、この階層数を変更できない
	 */
	public MultiKeyMap(int layer) {
		layer_ = layer;
	}

	/**
	 *  keysをキーとして、valueを格納する
	 *  @param keys 格納対象データのキーを格納した配列
	 *  @param value 格納対象データ
	 *  @exception IllegalArgumentException keysの要素数が階層数と異なる場合
	 */
	public void put(List keys, Object value) {
		// キーの階層数が異なる場合
		if(keys.size() != layer_) {
			throw new IllegalArgumentException();
		}

		Map current = root_;
		int i = 0;

		// キーの数-1 だけ
		for(; i < keys.size() - 1; i++) {
			Object lower = current.get(keys.get(i));

			// 新規キーの場合
			if(lower == null) {
				Map newMap = new HashMap();

				// 次のレベルのマップを定義する
				current.put(keys.get(i), newMap);
				// カレントのマップを次のレベルに下げる
				current = newMap;
			} else {
				current = (Map) lower;
			}
		}

		// データの格納
		current.put(keys.get(i), value);
	}

	/**
	 *  データを検索する。見つからない場合はnullを返す。
	 *  keys(keys.size() - 1)配下のデータを検索するが、
	 *  最下層まで検索してもキーが見つからなかった場合は、
	 *  その時点で検索をやめnullを返す。
	 *  また、キーの階層数を超えたキーの数がkeysで指定された場合もnullを返す
	 *  @param keys 検索対象のキーを格納した配列
	 *  @return 検索したデータ
	 */
	public Object get(List keys) {
		// 階層数が最下層を超えた場合
		if(keys.size() > layer_) {
			return null;
		}

		Map current = root_;
		int i = 0;

		// キーの数-1 だけ
		for(; i < keys.size() - 1; i++) {
			Object lower = current.get(keys.get(i));

			// キーが見つからない場合
			if(lower == null) {
				return null;
			} else {
				current = (Map) lower;
			}
		}

		return current.get(keys.get(i));
	}

	/**
	 *  keysで指定されたキー配下(1階層下)のMapが保持するキーの一覧を返す。
	 *  返すセットは当クラス内のマップと連動するので、
	 *  セットに対する変更はマップに反映される。
	 *  セットに対する反復の処理中にマップが変更された場合、反復の結果は保証されない。
	 *  指定のキーが見つからなかった場合はnullを返す。
	 *  また、キーの階層数-1を超えたキーの数がkeysで指定された場合もnullを返す
	 *  @param keys 検索対象のキーを格納した配列
	 *  @return キーの一覧
	 *  @see java.util.Map#keySet()
	 */
	public Set keySet(List keys) {
		// 階層数が最下層-1を超えた場合
		if(keys.size() > layer_ - 1) {
			return null;
		}

		Map target = (Map) this.get(keys);

		// 対象が見つかった場合
		if(target != null) {
			return target.keySet();
		} else {
			return null;
		}
	}

	/**
	 *  keysで指定されたキー配下(1階層下)のMapが保持する値の一覧を返す。
	 *  返すコレクションは当クラス内のマップと連動するので、
	 *  コレクションに対する変更はマップに反映される。
	 *  コレクションに対する反復の処理中にマップが変更された場合、反復の結果は保証されない。
	 *  指定のキーが見つからなかった場合はnullを返す。
	 *  また、キーの階層数-1を超えたキーの数がkeysで指定された場合もnullを返す
	 *  @param keys 検索対象のキーを格納した配列
	 *  @return 値の一覧
	 *  @see java.util.Map#values()
	 */
	public Collection values(List keys) {
		// 階層数が最下層-1を超えた場合
		if(keys.size() > layer_ - 1) {
			return null;
		}

		Map target = (Map) this.get(keys);

		// 対象が見つかった場合
		if(target != null) {
			return target.values();
		} else {
			return null;
		}
	}
}