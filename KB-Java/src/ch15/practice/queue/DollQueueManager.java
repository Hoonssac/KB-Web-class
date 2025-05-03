package ch15.practice.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static ch15.practice.Main.*;

// 대기열 관리 기능 제공 (등록/제거/조회)
public class DollQueueManager {
    Queue<String> queue = new LinkedList<>();

    public void registerCustomer(String name)       // 고객 등록
    {
        queue.add(name);
        System.out.println("👉 " + name + " 님이 대기열에 등록되었습니다.");
    }

    public String getNextCustomer()               // 첫 고객 뽑기 실행
    {
        if (!queue.isEmpty()) {
            String customer = queue.poll();
            System.out.println("🎉 " + customer + " 님! 인형 뽑기 하러 오세요!");
            String doll = dollStackManager.storeRandomdoll();
            dollHistoryManager.addHistory(customer, doll);
            dollPopularityManager.addDoll(doll);
            Scanner sc = new Scanner(System.in);
            System.out.print("👉 " + customer + " 님, 한 번 더 뽑으시겠습니까? (y/n): ");
            String input = sc.nextLine();
            if (input.equals("y")) {
                registerCustomer(customer);
                System.out.println("🔁 " + customer + " 님이 다시 대기열에 등록되었습니다.");
            }
            return customer;
        } else {
            System.out.println("⛔️ 대기 중인 고객이 없습니다.");
            return null;
        }
    }

    public void showWaitingList()                   // 현재 대기열 출력
    {
        System.out.print("📋 현재 대기열: ");
        System.out.println(queue);
    }
}
