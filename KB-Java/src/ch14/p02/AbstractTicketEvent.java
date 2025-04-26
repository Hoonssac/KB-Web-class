package ch14.p02;

public abstract class AbstractTicketEvent {
    protected int ticketCount;

    public AbstractTicketEvent(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public final void startEvent() {
        openAnnouncement();
        fanEntry();
        closingAnnouncement();
    }

    private void openAnnouncement() {
        System.out.println("이벤트 시작! 남은 티켓: " + ticketCount + "장");
    }

    private void closingAnnouncement() {
        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
    }

    protected abstract void fanEntry();
}
