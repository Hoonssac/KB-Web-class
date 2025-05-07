package ch16.practice.p01.metamong;
import ch16.practice.p01.framework.Ticket;

public class MetaMonTicket extends Ticket {
    private String owner;

    public MetaMonTicket(String name) {
        System.out.println(name + "님의 메타몽 티켓을 발급합니다.");
        this.owner = name;
    }

    @Override
    public void enter() {
        System.out.println("[MetaMonTicket:" + this.owner + "]님이 입장하였습니다.");
    }

    @Override
    public String toString() {
        return "티켓 [MetaMonTicket:" + this.owner + "] 등록 완료";
    }
}
