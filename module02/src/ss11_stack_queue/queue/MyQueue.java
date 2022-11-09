package ss11_stack_queue.queue;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head;
    private int tail;
    private int currentSize;

    public MyQueue() {
    }

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue ! ");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow !hông thể xóa phần tử khỏi hàng đợi");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Hoạt động pop xong! loại bỏ: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Hoạt động pop xong! loại bỏ: " + queueArr[head - 1]);
            }
           currentSize--;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue =new MyQueue(4);
        myQueue.enqueue(4);
        myQueue.dequeue();
        myQueue.enqueue(56);
        myQueue.enqueue(2);
        myQueue.enqueue(67);
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.enqueue(24);
        myQueue.dequeue();
        myQueue.enqueue(98);
        myQueue.enqueue(45);
        myQueue.enqueue(23);
        myQueue.enqueue(435);
    }
}
