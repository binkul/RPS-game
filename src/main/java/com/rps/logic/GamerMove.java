package com.rps.logic;

import com.rps.game.Languages;
import com.rps.rps.RpsElements;
import com.rps.user.UserInterface;

public class GamerMove implements Movable{
    private Languages languages;

    public GamerMove(Languages languages) {
        this.languages = languages;
    }

    @Override
    public RpsElements getMove() {
        return UserInterface.getKeyValue(languages);
    }
}
