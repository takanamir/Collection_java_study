package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import jp.ne.ytp.collection.reference.Tester;

/**
 * Collections.rotate()メソッドの動作を確認するクラス
 */
public class CollectionsRotateTester extends Tester {
    /**
     *  テストを実行する
     *  @param args コマンドラインパラメータ
     */
    public void test(String[] args) {
        String s = "Collections";
        List list = new ArrayList();
        
        for(int i=0 ; i<s.length() ; i++) {
            list.add(i, s.substring(i, i+1));
        }
        
        System.out.println("list");
        showList(list);
        
        Collections.rotate(list, 1);
        System.out.println("\nCollections.rotate(list, 1)");
        showList(list);
        
        Collections.rotate(list, -12);
        System.out.println("\nCollections.rotate(list, -12)");
        showList(list);

        System.out.println("\nブックマーク移動の例");
        System.out.println("  Collections.rotate(bookmarks.subList(4, 9), -1)");
        
        List bookmarks = Arrays.asList(new String[] {
            "http://www.ytp.ne.jp/",     // A
            "http://www.jajakarta.org/", // B
            "http://www.sssg.org/",      // C
            "http://www.sbpnet.jp/",     // D
            "http://www.goo.ne.jp/",     // E
            "http://www.google.co.jp/",  // F
            "http://www.amazon.co.jp/",  // G
            "http://www.yahoo.co.jp/",   // H
            "http://www.mapfan.com/",    // I
            "http://www.excite.co.jp/",  // J
            "http://weblogs.java.net/",  // K
        });
        
        List subList = bookmarks.subList(4, 9);
        
        System.out.println("移動前（全体）");
        showBookmarks(bookmarks);
        System.out.println("\n移動前（部分）");
        showBookmarks(subList);
        
        // 移動
        Collections.rotate(bookmarks.subList(4, 9), -1);
        
        System.out.println("\n移動後（部分）");
        showBookmarks(subList);
        System.out.println("\n移動後（全体）");
        showBookmarks(bookmarks);
        System.out.println("");
    }
    
    // 要素位置の表示
    private void showList(List list) {
        System.out.println("0 1 2 3 4 5 6 7 8 9 10");
        
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println("");
    }

    // ブックマークの表示
    private void showBookmarks(List list) {
        Iterator iterator = list.iterator();
        int i=0;
        
        while(iterator.hasNext()) {
            System.out.println("\t["+i+"]:"+iterator.next());
            i++;
        }
    }

    /**
     * メインメソッド
     * @param args コマンドラインパラメータ
     */
    public static void main(String[] args) {
        Tester tester = new CollectionsRotateTester();
        tester.prepare();
        tester.test(args);
    }
}