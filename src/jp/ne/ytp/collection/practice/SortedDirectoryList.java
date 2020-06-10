package jp.ne.ytp.collection.practice;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *  ディレクトリのファイル一覧保存するクラス
 *  @author YTP
 */
public class SortedDirectoryList extends DirectoryList {
	public SortedDirectoryList() throws IOException {
		System.exit(0);
	}

	/**
	 * ファイル名の一覧をマップに格納する
	 * @param dir 対象のディレクトリ
	 */
	public SortedDirectoryList(File dir) throws IOException {
		System.out.println(dir.getCanonicalPath());
		if (dir.isDirectory()) {
			dirList = put(dir);
		} else {
			// ディレクトリ以外が指定されたらエラー
			throw new IllegalArgumentException();
		}
	}

	/**
	 * ファイル名格納用のマップを返す
	 * @return TreeMapインスタンス
	 */
	protected Map getMap() {
		return new TreeMap();
	}
}