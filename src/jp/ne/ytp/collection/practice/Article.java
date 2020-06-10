package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  掲示板投稿記事のクラス
 */
public class Article {
	/**
	 *  記事の番号
	 */
	private int articleNo_;

	/**
	 *  返信記事の場合の親記事の番号
	 */
	private int sourceNo_;

	/**
	 *  返信記事の場合のスレッド元記事の番号
	 */
	private int rootNo_;

	/**
	 *  記事の投稿者名
	 */
	private String author_;

	/**
	 *  記事の本文
	 */
	private String text_;

	/**
	 *  この記事に対する返信記事
	 */
	private List responses_ = new ArrayList();

	/**
	 *  引数で指定された値を持つ記事インスタンスを生成する
	 *  @param articleNo 記事番号
	 *  @param author 投稿者名
	 *  @param text 本文
	 */
	public Article(int articleNo, String author, String text) {
		this(articleNo, author, text, articleNo, 0);
	}

	/**
	 *  引数で指定された値を持つ返信記事インスタンスを生成する
	 *  @param articleNo 記事番号
	 *  @param author 投稿者名
	 *  @param text 本文
	 *  @param rootNo スレッド元記事番号
	 *  @param sourceNo 親記事番号
	 */
	public Article(int articleNo, String author, String text, int rootNo, int sourceNo) {
		articleNo_ = articleNo;
		author_ = author;
		text_ = text;
		rootNo_ = rootNo;
		sourceNo_ = sourceNo;
	}

	/**
	 *  記事番号を返す
	 *  @return 記事番号
	 */
	public int getArticleNo() {
		return articleNo_;
	}

	/**
	 *  親の記事番号を返す
	 *  @return 親の記事番号
	 */
	public int getSourceNo() {
		return sourceNo_;
	}

	/**
	 *  スレッド元の記事番号を返す
	 *  @return スレッド元の記事番号
	 */
	public int getRootNo() {
		return rootNo_;
	}

	/**
	 *  記事の投稿者名を返す
	 *  @return 記事の投稿者名
	 */
	public String getAuthor() {
		return author_;
	}

	/**
	 *  記事の本文を返す
	 *  @return 記事の本文
	 */
	public String getText() {
		return text_;
	}

	/**
	 *  この記事の返信記事を設定する
	 *  @return 返信記事
	 */
	public void reply(Article response) {
		responses_.add(response);
	}

	/**
	 *  targetで指定された記事番号を持つ記事を返す
	 *  @param target 検索する記事番号
	 *  @return 記事
	 */
	public Article find(int target) {
		// 自分自身が対象であった
		if (target == articleNo_) {
			return this;
		}

		Article source = null;
		Iterator children = responses_.iterator();

		// 配下の記事を検索する
		while (children.hasNext()) {
			Article child = (Article) children.next();
			source = child.find(target);
			// 対象の記事が見つかった
			if (source != null) {
				break;
			}
		}

		return source;
	}

	/**
	 *  記事の文字列表現を返す
	 *  @return 記事の文字列表現
	 */
	public String toString() {
		return articleNo_ + ". " + text_ + " 投稿者[" + author_ + "]";
	}

	/**
	 *  この記事と配下の返信記事をすべて表示する
	 *  @param layer 記事の階層
	 */
	public void show(int layer) {
		System.out.println(indent(layer) + toString());
		Iterator children = responses_.iterator();

		// 自身が持つ返信記事をすべて表示する
		while (children.hasNext()) {
			Article child = (Article) children.next();
			child.show(layer + 1);
		}
	}

	/**
	 *  layerで指定された階層のインデント用空白を返す
	 *  @param layer インデントの階層
	 *  @return インデント用空白文字列
	 */
	private String indent(int layer) {
		StringBuffer indent = new StringBuffer();
		for (int i = 0; i < layer; i++) {
			indent.append("    ");
		}

		return new String(indent);
	}
}