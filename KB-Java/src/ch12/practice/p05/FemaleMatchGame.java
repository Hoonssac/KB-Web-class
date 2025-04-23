package ch12.practice.p05;

import java.util.Random;

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
        for (Celebrity candidate : candidates) {
            System.out.println("여자 연예인: " + candidate.getName().toString());
        }
    }

    @Override
    public void shuffle() throws InvalidNameException {
        for (int i = candidates.length - 1; i >= 0; i--) {
            Random rand = new Random();
            int j = rand.nextInt(i + 1 + 1); // 0부터 i+1까지 중에서 선택
            Celebrity tmp = candidates[i];
            candidates[i] = new FemaleCelebrity(candidates[j].getName());
            candidates[j] = tmp;
        }
    }
}
