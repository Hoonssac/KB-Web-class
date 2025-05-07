package ch16.practice.p01;

import ch16.practice.p01.framework.Ticket;
import ch16.practice.p01.framework.TicketFactory;
import ch16.practice.p01.metamong.MetaMonTicketFactory;

public class Main {
    public static void main(String[] args) {
        TicketFactory factory = new MetaMonTicketFactory();
        Ticket jiwoo = factory.create("지우");
        Ticket isul = factory.create("이슬이");

        System.out.println();

        jiwoo.enter();
        isul.enter();
    }
}
