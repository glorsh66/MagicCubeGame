package GameLogic.RandomGenerator.Formulas;

import GameLogic.RandomGenerator.Formulas.ChanceFormula;

public class IncrementFormula implements ChanceFormula {

    public double formula(int i) {
        int qualifier = 10;
        return  (i/2+1)*qualifier;
    }
}
