package GameLogic.RandomGenerator.Formulas;

import GameLogic.RandomGenerator.Formulas.ChanceFormula;

public class SteeperFormula implements ChanceFormula {

    public double formula(int i) {
        int qualifier = 10;
        return  (i+1)*qualifier;
    }
}