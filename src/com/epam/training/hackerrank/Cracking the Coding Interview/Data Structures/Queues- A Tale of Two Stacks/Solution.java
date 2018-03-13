import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) {
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) {
                queue.dequeue();
            } else if (operation == 3) {
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        Queue<T> queue = new PriorityQueue<T>();

        public void enqueue(T item) {
            stackNewestOnTop.push(item);
        }

        public T dequeue() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.empty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }

            return stackOldestOnTop.pop();
        }

        public T peek() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.empty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.peek();
        }
    }
}
