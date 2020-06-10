package jp.ne.ytp.collection.practice;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jp.ne.ytp.collection.bean.FlowerSales;

/**
 *  マップの内容をbeanに移送することを確認するクラス
 */
public class MapToBeanTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		// マップに値を設定する
		Map map = new HashMap();
		map.put("name", "すみれ");
		map.put("date", Calendar.getInstance());
		map.put("quantity", new Integer(10));
		map.put("price", new Integer(60));

		// beanインスタンス
		Object bean = new FlowerSales();

		try {
			Object[] methodargs = new Object[1];
			Iterator all = map.entrySet().iterator();

			// マップの要素の数だけ
			while(all.hasNext()) {
				Map.Entry entry = (Map.Entry) all.next();
				// プロパティ名としてキーの文字列表現を使う
				String propertyName = entry.getKey().toString();
				// プロパティディスクリプタを生成する
				PropertyDescriptor pd = new PropertyDescriptor(
						propertyName, bean.getClass());
				// 該当プロパティのセッタメソッドの情報を取得する
				Method setter = pd.getWriteMethod();
				// メソッドのパラメータとしてマップの値を設定する
				methodargs[0] = entry.getValue();
				// セッタを呼び出す
				setter.invoke(bean, methodargs);
			}

			// beanに設定した内容を表示する
			System.out.println(bean);
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch(IntrospectionException e) {
			e.printStackTrace();
		} catch(InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		MapToBeanTester tester = new MapToBeanTester();
		tester.test(args);
	}
}