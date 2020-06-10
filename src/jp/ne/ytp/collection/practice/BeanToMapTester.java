package jp.ne.ytp.collection.practice;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jp.ne.ytp.collection.bean.FlowerSales;

/**
 *  beanの内容をマップに移送することを確認するクラス
 */
public class BeanToMapTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		// beanインスタンス
		Object bean = new FlowerSales("すみれ", Calendar.getInstance(), 10, 60);

		// 空のマップ
		Map map = new HashMap();

		try {
			// beanのクラス情報を基にBeanInfoを取得する
			BeanInfo info = Introspector.getBeanInfo(bean.getClass());
			// beanが持つすべてのプロパティディスクリプタを取得する
			PropertyDescriptor[] pds = info.getPropertyDescriptors();

			// プロパティの数だけ
			for(int i = 0; i < pds.length; i++) {
				// 該当プロパティのゲッタメソッドの情報を取得する
				Method getter = pds[i].getReadMethod();
				
				// プロパティ名が"class"以外の場合のみマップに格納する
				if(!"class".equals(pds[i].getName())) {
					map.put(pds[i].getName(), getter.invoke(bean, null));
				}
			}

			// マップに設定した内容を表示する
			System.out.println("要素数=" + map.size());
			Iterator all = map.entrySet().iterator();
			
			// マップの要素の数だけ
			while(all.hasNext()) {
				Map.Entry entry = (Map.Entry) all.next();
				// プロパティ名としてキーの文字列表現を使う
				String propertyName = entry.getKey().toString();
				System.out.println(propertyName + "=" + entry.getValue());
			}
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
		BeanToMapTester tester = new BeanToMapTester();
		tester.test(args);
	}
}