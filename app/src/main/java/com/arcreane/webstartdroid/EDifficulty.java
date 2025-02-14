package com.arcreane.webstartdroid;

public enum EDifficulty {
    HARD(100),
    MEDIUM(50),
    EASY(10);

    private final int m_iDiff;

    EDifficulty(int diffValue) {
        m_iDiff = diffValue;
    }


    public int getValue()
    {
        return m_iDiff;
    }
}
