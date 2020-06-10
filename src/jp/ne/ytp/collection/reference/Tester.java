package jp.ne.ytp.collection.reference;

import java.util.Calendar;

import jp.ne.ytp.collection.bean.FlowerSales;

/**
 *  各テストクラスの基底クラス
 */
public abstract class Tester {
	/**
	 *  「すみれ」の売上データ
	 */
	protected FlowerSales sumire;

	/**
	 *  「バラ」の売上データ
	 */
	protected FlowerSales bara;

	/**
	 *  「桃」の売上データ
	 */
	protected FlowerSales momo;

	/**
	 *  「紫陽花」の売上データ
	 */
	protected FlowerSales ajisai;

	/**
	 *  サブクラスごとのテスト用メソッド
	 *  @param args コマンドパラメータ
	 */
	public abstract void test(String[] args);

	/**
	 *  テスト用データを準備する
	 */
	public void prepare() {
		Calendar date = getCalendar(2004, 8, 4);

		sumire = new FlowerSales("すみれ", getCalendar(2004, 12, 16), 30, 60);
		bara = new FlowerSales("バラ", getCalendar(2004, 12, 12), 45, 80);
		momo = new FlowerSales("桃", getCalendar(2004, 12, 18), 10, 140);
		ajisai = new FlowerSales("紫陽花", getCalendar(2004, 12, 10), 12, 200);
	}

	/**
	 *  指定された年月日を保持するカレンダーを返す
	 *  @param year 年
	 *  @param month 月
	 *  @param day 日
	 *  @return カレンダー
	 */
	protected Calendar getCalendar(int year, int month, int day) {
		Calendar today = Calendar.getInstance();
		today.set(year, month - 1, day);
		return today;
	}
}