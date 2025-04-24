package ch12.practice.p06;

public class FemaleMatchGame extends MatchGame {
    private Celebrity[] inputCandidates;

    public FemaleMatchGame(Celebrity[] inputCandidates) {
        this.inputCandidates = inputCandidates;
        initializeCandidates();
    }

    @Override
    public void initializeCandidates() {
        this.candidates = new Celebrity[inputCandidates.length];
        for (int i = 0; i < inputCandidates.length; i++) {
            this.candidates[i] = inputCandidates[i];
        }
    }

    @Override
    public void printCandidates() {
        System.out.println("[여자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
    }

    @Override
    public Celebrity playGame() {
        return super.playGame();
    }

}
