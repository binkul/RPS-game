package com.rps.logic;

import com.rps.rps.RpsElements;
import com.rps.rps.RpsRules;

import java.util.Random;

public class ComputerMove implements Movable{
    private static final Random random = new Random();
    private final RpsElements gamerMove;
    private final CheatLevels cheatLevels;

    public ComputerMove(RpsElements gamerMove, CheatLevels cheatLevels) {
        this.gamerMove = gamerMove;
        this.cheatLevels = cheatLevels;
    }

    @Override
    public RpsElements getMove() {
        if (cheatLevels == CheatLevels.RANDOM) {
            return randomMove();
        } else {
            return cheatMove();
        }
    }

    private RpsElements randomMove() {
        return RpsElements.getElement(String.valueOf(random.nextInt(5) + 1));
    }

    private RpsElements cheatMove() {
        RpsRules rpsRules = RpsRules.getElement(gamerMove);
        RpsElements enemy = rpsRules.getDefeatFirst();
        RpsElements computerMove;

        while (true) {
            computerMove = randomMove();
            if (computerMove != enemy) {
                return computerMove;
            }
        }
    }
}
