package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  掲示板クラス
 */
public class BulletinBoard {
	/**
	 *  スレッド一覧
	 */
	private List threads_ = new ArrayList();

	/**
	 *  デフォルトコンストラクタ
	 */
	public BulletinBoard() {
	}

	/**
	 *  新規記事を投稿する
	 *  @pram newOne 新規記事
	 */
	public void post(Article newOne) {
		threads_.add(newOne);
	}

	/**
	 *  返信記事を投稿する
	 *  @pram response 返信記事
	 */
	public void reply(Article response) {
		Article source = null;
		// スレッド元の記事を検索する
		Iterator all = threads_.iterator();
		while (all.hasNext()) {
			Article article = (Article) all.next();
			// スレッド元が見つかった
			if (article.getRootNo() == response.getRootNo()) {
				// そのスレッド配下を検索して元の記事を見つける
				source = article.find(response.getSourceNo());
			}
		}
		if (source != null) {
			source.reply(response);
		}
	}

	/**
	 *  配下の記事をすべて表示する
	 */
	public void show() {
		// 配下の記事を表示する
		Iterator all = threads_.iterator();
		while (all.hasNext()) {
			Article article = (Article) all.next();
			article.show(0);
		}
	}
}