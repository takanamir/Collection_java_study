package jp.ne.ytp.collection.practice;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XML形式で作成されたiniファイルを読み込み、
 * その値を保持するクラス
 * @author YTP
 */
public class IniFile extends DefaultHandler {
	/**
	 * iniファイルのパス
	 */
	private String iniPath_;

	/**
	 * iniファイル内の全セクション要素を保持する
	 */
	private Map root_ = new HashMap();

	// 以下はワーク
	private String current_;
	private String entryName_;
	private Map section_;
	private StringBuffer entryValue_;

	/**
	 * iniPathで指定されたiniファイルの値を持つインスタンスを生成する
	 * @param iniPath iniファイルへの絶対パス
	 */
	public IniFile(String iniPath) throws IOException, ParserConfigurationException, SAXException {
		init(iniPath);
	}

	/**
	 * iniPathで指定されたini XMLファイルを読み込み、
	 * このインスタンスを初期化する
	 * @param iniPath iniファイルへの絶対パス
	 * @exception IOException XMLファイルのIOエラーが発生した場合
	 * @exception ParserConfigurationException パーサーの生成に失敗した場合
	 * @exception SAXException XMLファイルのパースでエラーが発生した場合
	 */
	public void init(String iniPath) throws IOException, ParserConfigurationException, SAXException {
		iniPath_ = iniPath;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		XMLReader reader = factory.newSAXParser().getXMLReader();
		reader.setContentHandler(this);
		// XMLファイルの読み込みを開始する
		reader.parse(new File(iniPath_).toURL().toExternalForm());
	}

	/**
	 * 指定されたセクション内のエントリ値を返す。
	 * 指定されたエントリが見つからない場合はnullを返す
	 * @param sectionName セクション名
	 * @param entryName エントリ名
	 * @return エントリの値
	 */
	public String getEntry(String sectionName, String entryName) {
		Map section = (Map) root_.get(sectionName);

		// セクションが存在する
		if (section != null) {
			// エントリの値を返す
			return (String) section.get(entryName);
		} else {
			return null;
		}
	}

	////////////// 以下はSAX2インタフェースの実装 //////////////

	/**
	 * 要素の開始通知を受け取るSAX2インタフェースの実装。
	 * section要素ごとにMapを生成する
	 * @param uri XMLファイルのURI
	 * @param localName 前置修飾子を含まないローカル要素名
	 * (名前空間処理が行われない場合は空文字列)
	 * @param qName 前置修飾子を持つ要素修飾名
	 * @param attributes この要素が持つ属性
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		current_ = qName;

		// section要素が現れた場合
		if ("section".equals(current_)) {
			section_ = new HashMap();
			// name属性をキーにしてsection用のマップを保存する
			// 属性はnameしかないので[0]で決め打ち
			root_.put(attributes.getValue(0), section_);
		} else if ("entry".equals(current_)) {
			// entry名を保存
			entryName_ = attributes.getValue(0);
			entryValue_ = new StringBuffer();
		}
	}

	/**
	 * 要素内の文字データの通知を受け取るSAX2インタフェースの実装
	 * entryのテキストをバッファリングする
	 * @param ch テキスト文字配列
	 * @param start 文字配列内の開始位置
	 * @param length 文字配列から使用される文字数
	 */
	public void characters(char[] ch, int start, int length) {
		if ("entry".equals(current_)) {
			entryValue_.append(ch, start, length);
		}
	}

	/**
	 * 要素の終了通知を受け取るSAX2インタフェースの実装
	 * entryの値をマップに設定する
	 * @param uri XMLファイルのURI
	 * @param localName 前置修飾子を含まないローカル要素名
	 * (名前空間処理が行われない場合は空文字列)
	 * @param qName 前置修飾子を持つ要素修飾名
	 * @param attributes この要素が持つ属性
	 */
	public void endElement(String uri, String localName, String qName) {
		if ("entry".equals(qName)) {
			// entryの格納
			section_.put(entryName_, new String(entryValue_));
		}
	}
}