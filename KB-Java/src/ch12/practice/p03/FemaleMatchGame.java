package ch12.practice.p03;

public class FemaleMatchGame extends MatchGame {
    private Celebrity[] candidates;

    public FemaleMatchGame(Celebrity[] candidates) {
        initializeCandidateds(candidates);
    }

    @Override
    public void initializeCandidateds(Celebrity[] candidates) {
        this.candidates = candidates;
    }

    @Override
    public Celebrity playGame() {
        return null;
    }

    @Override
    public void printCandidates() {
        System.out.println("[여자 연예인 월드컵 참가자 명단]");
        for (Celebrity candidate : candidates) {
            System.out.println("여자 연예인: " + candidate.getName().toString());
        }
    }
}
