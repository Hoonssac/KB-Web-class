package ch14.practice.p01;

public class TicketingRound1 {
    public static void main(String[] args) {
        Runnable buyer = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        };

        Thread fan1 = new Thread(buyer);
        Thread fan2 = new Thread(buyer);

        fan1.setName("팬1");
        fan2.setName("팬2");

        fan1.start();
        fan2.start();

        System.out.println("=== run() 직접 호출 테스트 ===");
        fan1.run();
    }
}
