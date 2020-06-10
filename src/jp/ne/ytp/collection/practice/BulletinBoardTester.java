package jp.ne.ytp.collection.practice;

/**
 *  文字列の前方一致検索を確認するクラス
 */
public class BulletinBoardTester {
	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		BulletinBoard bbs = new BulletinBoard();

		Article article = new Article(1, "木村", "1番の記事です");
		bbs.post(article);
		article = new Article(2, "仲根", "1番の記事への返信です", 1, 1);
		bbs.reply(article);
		article = new Article(3, "矢田", "3番の記事です");
		bbs.post(article);
		article = new Article(4, "木村", "2番の記事への返信です", 1, 2);
		bbs.reply(article);
		article = new Article(5, "長谷川", "2番の記事への返信です", 1, 2);
		bbs.reply(article);
		article = new Article(6, "木村", "3番の記事への返信です", 3, 3);
		bbs.reply(article);
		article = new Article(7, "藤原", "7番の記事です");
		bbs.post(article);

		bbs.show();
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		BulletinBoardTester tester = new BulletinBoardTester();
		tester.test(args);
	}
}