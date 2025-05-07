package ch16.practice.p01.framework;

public abstract class TicketFactory {
    public final Ticket create(String owner) {
        Ticket ticket = createTicket(owner);
        registerTicket(ticket);

        return ticket;
    }
    protected abstract Ticket createTicket(String owner);
    protected abstract void registerTicket(Ticket ticket);
}
