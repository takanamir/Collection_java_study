package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import jp.ne.ytp.collection.bean.FlowerSales;
import jp.ne.ytp.collection.reference.Tester;

/**
 *  Listの複製方法を確認するクラス
 */
public class CollectionsCopyTester extends Tester {
	Object[] data = new Object[] {
		ajisai,
		momo,
		sumire,
		bara
	};
	
	List list = null;

	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		// 初期処理
		if(args.length != 0 && args[0].equals("array")) {
			list = new ArrayList();
		} else {
			list = new LinkedList();
		}
		
		for(int i=0 ; i<data.length ; i++) {
			list.add(data[i]);
		}
		
		// clone()メソッドによるコピー
		List clonedList = null;
		
		if(list instanceof ArrayList) {
			clonedList = (List) ((ArrayList)list).clone();
		} else {
			clonedList = (List) ((LinkedList)list).clone();
		}
		
		System.out.print("clone ... ");
		for(int i=0 ; i<data.length ; i++) {
			System.out.print("["+i+"]"+(data[i]==list.get(i))+" ");
		}
		System.out.println("");
		
		// コンストラクタによるコピー
		List copiedList = null;
		
		if(list instanceof ArrayList) {
			copiedList = new ArrayList(list);
		} else {
			copiedList = new LinkedList(list);
		}
		
		System.out.print("new "+ copiedList.getClass().getName()+"(list) ... ");
		for(int i=0 ; i<data.length ; i++) {
			System.out.print("["+i+"]"+(data[i]==copiedList.get(i))+" ");
		}
		System.out.println("");
		
		// Collections.copy()メソッドによるコピー
		doCopy();
	}
	
	// Collections.copy()メソッドによるコピーを確認するメソッド
	private void doCopy() {
		System.out.println("Collections.copy ... ");

		List destList = null;
		
		if(list instanceof ArrayList) {
			/*
			 * この方法はArrayListへ容量を確保するだけなので、
			 * destList.size()の値は0となる
			 */
			destList = new ArrayList(list.size());
		} else {
			/*
			 * LinkedListでは初期容量の確保という概念自体が
			 * ない
			 */
			destList = new LinkedList();
		}
		
		/*
		 * あらかじめ要素を追加してdestList.size()メソッドの
		 * 値をlist.size()メソッドの値以上となるようにしておく。
		 * この処理を行っておかないと、copy()メソッドは
		 * java.lang.IndexOutOfBoundsExceptionを発生させて終了
		 * する
		 */
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			destList.add(new FlowerSales());
			iterator.next();
		}

		// コピー
		Collections.copy(destList, list);

		// コピーの確認
		System.out.print("  copied:list.get(i)==destList.get(i)\n    ");
		for(int i=0 ; i<data.length ; i++) {
			System.out.print("["+i+"]"+(list.get(i)==destList.get(i))+" ");
		}
		System.out.println("");
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		Tester tester = new CollectionsCopyTester();
		tester.test(args);
	}
}