package util;

/**
 * ブラックジャックユーティリティクラス
 * @author S.Ota
 * @see CardGameWorldUtil
 */
public class BlackJackUtil extends CardGameWorldUtil {
    /**
     * 最初に配られたカードの数字を合計する(A:1 絵札:10)
     * @param firstNum 1枚目
     * @param secondNum 2枚目
     * @return
     */
    public static int bjFirstTotal(int firstNum, int secondNum) {   
        int total = (firstNum > 10 ? 10 : firstNum) + (secondNum > 10 ? 10 : secondNum);

        return total;
    }

    /**
     * 最初に配られたカードの中に"A"が含まれていた場合の合計(A:1or11 絵札:10)
     * @param firstNum 1枚目
     * @param secondNum 2枚目
     * @return
     */
    public static int bjFirstTotalA(int firstNum, int secondNum) {
        int total = 0;
        firstNum = (firstNum > 10) ? 10 : firstNum;
        secondNum = (secondNum > 10) ? 10 : secondNum;

        if (firstNum == 1 || secondNum == 1) {
            total = (firstNum == 1 && secondNum ==1) ? 0 : (firstNum == 1) ? (11 + secondNum) : (firstNum + 11);
        }

        return total;
    }
    
    /**
     * 二回目以降に配られたカードの数字を合計する(A:1 絵札:10)
     * @param firstNum 手持ちのカード
     * @param secondNum 配られたカード
     * @return
     */
    public static int bjSecondTotal(int firstNum, int secondNum) {   
        int total = firstNum + (secondNum > 10 ? 10 :secondNum);

        return total;
    }

    /**
     * 二回目以降に配られたカード及び手持ちの中に"A"が含まれていた場合の合計(A:1or11 絵札:10)
     * @param firstNum 手持ちのカード
     * @param secondNum 配られたカード
     * @return
     */
    public static int bjSecondTotalA(int firstNum, int secondNum) {
        int total = 0;
        secondNum = (secondNum > 10) ? 10 : secondNum;

        if (secondNum == 1 && firstNum != 0) {
            total = (firstNum + 11) <= 21 ? (firstNum + 11) : 0;
        } else if (firstNum != 0) {
            total = (firstNum + secondNum) <= 21 ? (firstNum + secondNum) : 0;
        }

        return total;
    }
    
    /**
     * 配られた三枚のカードの中に"A"が複数枚含まれていた場合の合計(A:1or11 絵札:10)
     * @param firstNum
     * @param secondNum
     * @param thirdNum
     * @return
     */
    public static int bjTreeCardTotalA(int firstNum, int secondNum, int thirdNum) {
        int total = 0;
        firstNum = (firstNum > 10) ? 10 : firstNum;
        secondNum = (secondNum > 10) ? 10 : secondNum;
        thirdNum = (thirdNum > 10) ? 10 : thirdNum;

        Boolean FirstNumFlg= (firstNum == 1) ? true : false;
        Boolean SecondNumFlg = (secondNum == 1) ? true : false;
        Boolean ThirdNumFlg = (thirdNum == 1) ? true : false;

        if (FirstNumFlg && SecondNumFlg && ThirdNumFlg) {
            total = 13;
        } else if (FirstNumFlg && SecondNumFlg) {
            total = (12 + thirdNum) <= 21 ? (12 + thirdNum) : (2 + thirdNum);
        } else if (FirstNumFlg && ThirdNumFlg) {
            total = (12 + secondNum) <= 21 ? (12 + secondNum) : (2 + secondNum);
        } else if (SecondNumFlg && ThirdNumFlg) {
            total = (12 + firstNum) <= 21 ? (12 + firstNum) : (2 + firstNum);
        }

        return total;
    }

}
