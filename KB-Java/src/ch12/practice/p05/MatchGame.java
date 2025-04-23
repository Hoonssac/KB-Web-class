package ch12.practice.p05;


public abstract class MatchGame {
    protected Celebrity[] candidates;

    public abstract void initializeCandidateds(Celebrity[] candidates);
    public abstract Celebrity playGame();

    public void printCandidates() {}

    public void shuffle() throws InvalidNameException {

    }
}
