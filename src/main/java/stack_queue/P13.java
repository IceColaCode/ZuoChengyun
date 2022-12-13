package stack_queue;

public class P13 {
    public static void main(String[] args) {
        P13 instance = new P13();
        System.out.println(instance.hanoi(3,"left","mid","right"));
    }
    public int hanoi(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, right, mid);
    }

    public int process(int num, String from, String to, String other) {
        if (num == 1) {
            if (from.equals("mid") || to.equals("mid")) {
                System.out.println("move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("move 1 from " + from + " to mid");
                System.out.println("move 1 from mid to " + to);
                return 2;
            }
        }
        if (from.equals("mid") || to.equals("mid")) {
            int res = process(num - 1, from, other, to);
            System.out.println("move " + num + " from " + from + " to " + to);
            res += process(num - 1, other, to, from);
            return res + 1;
        } else {
            int res = process(num-1, from, to, other);
            System.out.println("move " + num + " from " + from + " to " + other);
            res += process(num-1, to, from, other);
            System.out.println("move " + num + " from " + other + " to " + to);
            res += process(num-1, from, to, other);
            return res + 2;
        }
    }
}
