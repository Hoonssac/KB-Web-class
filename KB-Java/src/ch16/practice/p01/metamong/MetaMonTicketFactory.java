package ch16.practice.p01.metamong;

import ch16.practice.p01.framework.Ticket;
import ch16.practice.p01.framework.TicketFactory;

public class MetaMonTicketFactory extends TicketFactory {

    @Override
    protected Ticket createTicket(String owner) {
        return new MetaMonTicket(owner);
    }

    @Override
    protected void registerTicket(Ticket ticket) {
        System.out.println(ticket);
    }
}
