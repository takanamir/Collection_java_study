package jp.ne.ytp.collection.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *  RDBレコードのコレクションへの格納を確認するクラス
 */
public class RdbToCollectionTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		try {
			// データベース接続
			Class.forName("org.gjt.mm.mysql.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/TEST?useUnicode=true&characterEncoding=MS932", "root", "root");
			Statement stmt = con.createStatement();
			// SELECT発行
			ResultSet result = stmt.executeQuery("select * from flowersales;");
			// SELECTした列の定義情報
			ResultSetMetaData metaData = result.getMetaData();
			// SELECTした列の数
			int columnSize = metaData.getColumnCount();
			// 全レコードを格納するためのリスト
			List records = new ArrayList();

			// 取得できたレコード数分
			while(result.next()) {
				// 1レコード分をマップに格納する
				Map record = new HashMap();
				// 列の数だけ
				for (int i = 1; i <= columnSize; i++) {
					String key = metaData.getColumnName(i);
					String value = result.getString(i);
					// 列名をキーとする
					record.put(key, value);
				}
				// リストに追加する
				records.add(record);
			}
			// データベース切断
			con.close();

			// 全レコードの内容(マップ)を画面に表示する
			Iterator all = records.iterator();
			while(all.hasNext()) {
				Map record = (Map) all.next();
				System.out.println(record);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		RdbToCollectionTester tester = new RdbToCollectionTester();
		tester.test(args);
	}
}