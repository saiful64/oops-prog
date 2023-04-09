
public class ThreadState {

    public static State currentState = State.ONE;
    public static Object lockObject = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(State.ONE));
        Thread t2 = new Thread(new MyRunnable(State.TWO));
        Thread t3 = new Thread(new MyRunnable(State.THREE));
        t1.start();
        t2.start();
        t3.start();

    }

}

class MyRunnable implements Runnable {

    State allowedState;

    public MyRunnable(State allowedState) {
        this.allowedState = allowedState;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (ThreadState.lockObject) {

                while (allowedState != ThreadState.currentState) {
                    try {
                        ThreadState.lockObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(allowedState.getVal());
                ThreadState.currentState = ThreadState.currentState.nextState();
                ThreadState.lockObject.notifyAll();
            }
        }

    }

}

enum State {
    ONE(10) {
        @Override
        public State nextState() {
            return TWO;
        }

    },
    TWO(100) {
        @Override
        public State nextState() {
            return THREE;
        }
    },
    THREE(200) {
        @Override
        public State nextState() {
            return ONE;
        }
    };

    private int val;

    State(int val) {
        this.val = val;
    }

    public abstract State nextState();

    public int getVal() {
        return val;
    }
}