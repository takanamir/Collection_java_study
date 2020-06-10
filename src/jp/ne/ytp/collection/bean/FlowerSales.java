package jp.ne.ytp.collection.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 花の売上げ情報
 * @author ytp
 */
public class FlowerSales implements Comparable {
	/**
	 * 花の名前
	 */
	private String name_;

	/**
	 * 売上日
	 */
	private Calendar date_;

	/**
	 * 売上数量
	 */
	private int quantity_;

	/**
	 * 売上単価
	 */
	private int price_;

	/**
	 * デフォルトコンストラクタ
	 */
	public FlowerSales() {
	}

	/**
	 * 指定された属性を持つインスタンスを生成する
	 * @name 花の名前
	 * @date 売上日
	 * @quantity 売上数量
	 * @price 売上単価
	 */
	public FlowerSales(String name, Calendar date, int quantity, int price) {
		setName(name);
		setDate(date);
		setQuantity(quantity);
		setPrice(price);
	}

	/**
	 * 花の名前を設定する
	 * @param name 花の名前
	 */
	public void setName(String name) {
		name_ = name;
	}

	/**
	 * 花の名前を返す
	 * @return 花の名前
	 */
	public String getName() {
		return name_;
	}

	/**
	 * 売上日を設定する
	 * @param date 売上日
	 */
	public void setDate(Calendar date) {
		date_ = date;
	}

	/**
	 * 売上日を返す
	 * @return 売上日
	 */
	public Calendar getDate() {
		return date_;
	}

	/**
	 * 売上数量を設定する
	 * @param quantity 売上数量
	 */
	public void setQuantity(int quantity) {
		quantity_ = quantity;
	}

	/**
	 * 売上単価を返す
	 * @return 売上単価
	 */
	public int getQuantity() {
		return quantity_;
	}

	/**
	 * 売上単価を設定する
	 * @param price 売上単価
	 */
	public void setPrice(int price) {
		price_ = price;
	}

	/**
	 * 売上単価を返す
	 * @return 売上単価
	 */
	public int getPrice() {
		return price_;
	}

	/**
	 * 売上金額を返す（数量と単価を乗じたもの）
	 * @return 売上金額
	 */
	public int getAmount() {
		return quantity_ * price_;
	}

	/**
	 * このオブジェクトの花の名前と売上日(年月日)を
	 * otherで指定されたオブジェクトと比較し、
	 * その結果（同じ内容かどうか）を返す
	 * @other 比較対象のオブジェクト
	 * @return true:同じ false:異なる
	 */
	public boolean equals(Object other) {
		// 対象がFlowerSalesインスタンスの場合
		if (other instanceof FlowerSales) {
			FlowerSales target = (FlowerSales) other;
			Calendar me = getDate();
			Calendar you = target.getDate();
			return (getName().equals(target.getName())
					&& me.get(Calendar.YEAR) == you.get(Calendar.YEAR)
					&& me.get(Calendar.MONTH) == you.get(Calendar.MONTH)
					&& me.get(Calendar.DATE) == you.get(Calendar.DATE));
		} else {
			return false;
		}
	}

	/**
	 * このオブジェクトの花の名前と売上日(年月日)を
	 * otherで指定されたオブジェクトと比較し、
	 * このオブジェクトが指定されたオブジェクトより小さい場合は負の整数、
	 * 等しい場合はゼロ、大きい場合は正の整数を返す
	 * @other 比較対象のオブジェクト
	 * @return このオブジェクトが指定されたオブジェクトより小さい場合は負の整数、
	 *         等しい場合はゼロ、大きい場合は正の整数
	 */
	public int compareTo(Object other) {
		FlowerSales target = (FlowerSales) other;
		Calendar you = target.getDate();
		Calendar me = getDate();
		// 年が等しい場合
		if (me.get(Calendar.YEAR) == you.get(Calendar.YEAR)) {
			// 月が等しい場合
			if (me.get(Calendar.MONTH) == you.get(Calendar.MONTH)) {
				// 日が等しい場合
				if (me.get(Calendar.DATE) == you.get(Calendar.DATE)) {
					// 年～日までが等しいので、花の名前の比較結果をそのまま返す
					return getName().compareTo(target.getName());
				} else {
					return me.get(Calendar.DATE) - you.get(Calendar.DATE);
				}
			} else {
				return me.get(Calendar.MONTH) - you.get(Calendar.MONTH);
			}
		} else {
			return me.get(Calendar.YEAR) - you.get(Calendar.YEAR);
		}
	}

	/**
	 * equalsをオーバーライドしたので、hashCodeもオーバー
	 * ライドする
	 * @return ハッシュコード
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy/MM/dd");
		StringBuffer work = new StringBuffer();
		work.append(yyyymmdd.format(getDate().getTime()));
		work.append(" ").append(getName());
		return (work.toString().hashCode());
	}

	/**
	 * インスタンスの文字列表現を返す
	 * 売上日・花の名前・売上数量・売上単価を連結したもの
	 * @return インスタンスの文字列表現
	 */
	public String toString() {
		SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy/MM/dd");
		StringBuffer work = new StringBuffer();
		work.append(yyyymmdd.format(getDate().getTime()));
		work.append(" ").append(getName());
		work.append(" ").append(getQuantity()).append("本");
		work.append(" ").append(getPrice()).append("円");

		return new String(work);
	}
}