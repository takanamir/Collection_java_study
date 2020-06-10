package jp.ne.ytp.collection.practice;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 *  XMLファイルを扱うIniFileクラスの動作を確認するクラス
 */
public class IniFileTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		try {
			// IniFileインスタンスを生成
			IniFile ini = new IniFile("C:\\testini.xml");
			String target = null;

			System.out.println("language");
			target = ini.getEntry("language", "country");
			System.out.println("  country=" + target);
			target = ini.getEntry("language", "encoding");
			System.out.println("  encoding=" + target);

			System.out.println("system");
			target = ini.getEntry("system", "os");
			System.out.println("  os=" + target);
			target = ini.getEntry("system", "distribution");
			System.out.println("  distribution=" + target);
			target = ini.getEntry("system", "version");
			System.out.println("  version=" + target);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		IniFileTester tester = new IniFileTester();
		tester.test(args);
	}
}