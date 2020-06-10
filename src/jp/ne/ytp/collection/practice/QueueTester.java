package jp.ne.ytp.collection.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jp.ne.ytp.collection.reference.Tester;

/**
 * キュークラスの実装例を確認するクラス
 */
public class QueueTester extends Tester {
	/**
	 * キュークラスの実装例
	 */
	private class Queue {
		private List queue;

		public Queue(List list) {
			queue = list;
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}

		public void enqueue(Object value) {
			queue.add(value);
		}

		public Object dequeue() {
			Object ret;
			
			if(queue.isEmpty()) {
				return null;
			}
			
			ret = queue.get(0);
			queue.remove(0);
			return ret;
		}
	}

	/**
	 *  テストを実行する
	 *  @param args コマンドラインパラメータ
	 */
	public void test(String[] args) {
		System.out.println("Queue(LinkedList):-------------------");
		Queue queue = new Queue(new LinkedList());
		testQueue(queue);
		System.out.println("Queue(ArrayList) :-------------------");
		queue = new Queue(new ArrayList());
		testQueue(queue);
	}

	// キューのテストメソッド
	private void testQueue(Queue queue) {
		queue.enqueue(sumire);
		queue.enqueue(bara);
		queue.enqueue(ajisai);
		
		System.out.println(queue.dequeue()); // sumire
		System.out.println(queue.dequeue()); // bara
		
		queue.enqueue(momo);
		
		System.out.println(queue.dequeue()); // ajisai
		System.out.println(queue.dequeue()); // momo
	}

	/**
	 * メインメソッド
	 * @param args コマンドラインパラメータ
	 */
	public static void main(String[] args) {
		Tester tester = new QueueTester();
		tester.prepare();
		tester.test(args);
	}
}