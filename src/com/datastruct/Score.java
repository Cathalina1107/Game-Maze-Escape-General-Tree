package com.datastruct;

public class Score {
    int score = 0;
    int time = 0;

    void tambahCoin() {
        score += 10;
    }

    void kenaEnemy() {
        score -= 5;
    }

    void waktuBerjalan() {
        score--;
        time++;
    }
}