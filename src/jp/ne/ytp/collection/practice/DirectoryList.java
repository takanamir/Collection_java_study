package jp.ne.ytp.collection.practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  あるディレクトリ内のファイルとディレクトリの一覧を
 *  保存するクラス
 *  @author YTP
 */
public class DirectoryList {
	/**
	 * ディレクトリ中のファイル名一覧を格納するマップ
	 */
	protected Map dirList;

	/**
	 * ルートディレクトリ中のファイル名一覧を
	 * マップに格納する
	 */
	public DirectoryList() throws IOException {
		this(new File("\\"));
	}

	/**
	 * dirで指定されたディレクトリ中のファイル名一覧を
	 * マップに格納する
	 * @param dir 対象のディレクトリ
	 */
	public DirectoryList(File dir) throws IOException {
		if (dir.isDirectory()) {
			dirList = put(dir);
		} else {
			// ディレクトリ以外が指定されたらエラー
			throw new IllegalArgumentException();
		}
	}

	/**
	 * ファイル名一覧を表示する
	 */
	public void show() {
		// トップディレクトリを引数に渡す
		show(dirList);
	}

	/**
	 * ディレクトリ内のファイル名一覧をマップに格納する
	 * @param dir 格納対象のディレクトリ
	 */
	protected Map put(File dir) throws IOException {
		Map dirList = getMap();
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			System.out.println(files[i].getCanonicalPath());
			
			if(files[i].isDirectory()) {
				// サブディレクトリの内容を保存する
				Map sub = put(files[i]);
				dirList.put(files[i].getCanonicalPath(), sub);
			} else {
				// ファイル名を保存する
				dirList.put(files[i].getCanonicalPath(), null);
			}
		}

		return dirList;
	}

	/**
	 * ファイル名格納用のマップを返す
	 * @return LinkedHashMapインスタンス
	 */
	protected Map getMap() {
		return new LinkedHashMap();
	}

	/**
	 * ファイル名一覧を表示する
	 * @param dir 表示対象のディレクトリ情報を持つマップ
	 */
	protected void show(Map dir) {
		// マップ内のエントリ一覧を取得する
		Iterator files = dir.entrySet().iterator();
		while(files.hasNext()) {
			Map.Entry file = (Map.Entry) files.next();
			Object sub = file.getValue();
			
			// サブディレクトリの場合
			if(sub instanceof Map) {
				// ディレクトリ名を表示する
				System.out.println(file.getKey() + " *");
				// サブディレクトリの表示を再帰的に呼び出す
				show((Map) sub);
			} else {
				// ファイル名を表示する
				System.out.println(file.getKey());
			}
		}
	}
}