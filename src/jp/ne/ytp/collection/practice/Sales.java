package jp.ne.ytp.collection.practice;

/**
 *  売上金額を持つクラス
 */
public class Sales implements Comparable {
	/**
	 *  売上金額
	 */
	private int amount_;

	/**
	 *  引数で指定された値を売上金額として設定する
	 *  コンストラクタ
	 *  @param amount 売上金額
	 */
	public Sales(int amount) {
		amount_ = amount;
	}

	/**
	 *  売上金額を返す
	 *  @return 売上金額
	 */
	public int getAmount() {
		return amount_;
	}

	/**
	 *  このインスタンスの売上金額と、引数で渡されたoの売上金額を
	 *  比較した結果を返す
	 *  ・このインスタンスが大きい場合は正の数
	 *  ・両方が等しい場合は0
	 *  ・このインスタンスが小さい場合は負の数
	 *  をそれぞれ返す
	 *  @prama o 比較対照の売上金額クラスインスタンス
	 *  @return 比較結果
	 */
	public int compareTo(Object o) {
		return this.getAmount() - ((Sales) o).getAmount();
	}

	/**
	 * 一貫性を持たせるためにequalsをオーバーライドする
	 * @param o 比較対象の売上金額クラスインスタンス
	 * @return 比較結果
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Sales)) {
			return false;
		} else {
			return compareTo(o) == 0;
		}
	}

	/**
	 * equalsをオーバーライドしたので、
	 * hashCodeもオーバーライドする
	 * @return ハッシュコード
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return amount_;
	}
}