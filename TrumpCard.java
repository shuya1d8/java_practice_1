/**
 * トランプカードクラス
 * @author S.Ota
 */
public class TrumpCard extends DspTrump {
    /**
     * 「マーク (♠ / ♡ / ♢ / ♣)」と「1~13の数字」が格納された二次元配列 
     */
    private String[][] trumpNoJk = {
        {"<Spade>", "<Heart>", "<Diamond>", "<Club>"}, 
        {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"}
    };

    /**
     * 「マーク (♠ / ♡ / ♢ / ♣)」と「1~13の数字」と「ジョーカー」が格納された二次元配列
     */
    private String[][] trumpJk = {
        {"<Spade>", "<Heart>", "<Diamond>", "<Club>"}, 
        {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "JOKER"}
    };

    /**
     * コンストラクタ
     */
    TrumpCard() {

    }


    // ジョーカーなしトランプのゲッター
    /**
     * 全要素取得
     * @return
     */
    public String[][] getTrumpNoJk() {
        return trumpNoJk;
    }
    
    /**
     * 指定したマークを取得
     * @param mark (0:Spade 1:Heart 2:Diamond 3:Club)
     * @return
     */
    public String getTrumpNoJkMark(int mark) {
        return trumpNoJk[0][mark];
    }

    /**
     * 指定した数字を取得
     * @param number (0~12>>>1~13)
     * @return
     */
    public String getTrumpNoJkNum(int number) {
        return trumpNoJk[1][number];
    }

    
    // ジョーカーありトランプのゲッター
    /**
     * 全要素取得
     * @return
     */
    public String[][] getTrumpJk() {
        return trumpJk;
    }
    
    /**
     * 指定したマークを取得
     * @param mark (0:Spade 1:Heart 2:Diamond 3:Club)
     * @return
     */
    public String getTrumpJkMark(int mark) {
        return trumpNoJk[0][mark];
    }

    /**
     * 指定した数字+ジョーカーを取得
     * @param number (0~13>>>1~13, 14:JOKER)
     * @return
     */
    public String getTrumpJkNum(int number) {
        return trumpNoJk[1][number];
    }
    

    // ジョーカーなしトランプのセッター
    /**
     * 指定した数字を0に変更
     * @param number (0~12>>>1~13)
     */
    public void setTrumpNoJkNum(int number) {
        trumpNoJk[1][number] = "0";
    }
    

    // ジョーカーありトランプのセッター
    /**
     * 指定した数字+ジョーカーを0に変更
     * @param number (0~13>>>1~13, 14:JOKER)
     */
    public void setTrumpJkNum(int number) {
        trumpNoJk[1][number] = "0";
    }
    

    // ジョーカーなしメソッド
    /**
     * 全マークを表示（選択肢あり 1:Spade 2:Heart 3:Diamond 4:Club）
     */
    public void dspTrumpNoJkAllMark() {
        System.out.print("マーク");
        for (int i = 0; i < 4; i++) {
            System.out.printf(" | <%s> %s ", i + 1, getTrumpNoJkMark(i));
        }
        System.out.println();
    }

    /**
     * 全数字を表示（1~13）
     */
    public void dspTrumpNoJkAllNum() {
        System.out.print("数　字");
        for (int i = 0; i < 13; i++) {
            System.out.print(" | " + getTrumpNoJkNum(i));
        }
        System.out.println();
    }


    // ジョーカーありメソッド
    
    // public void dspTrumpJkAllMark() {
        
    // }


    // /**
    //  * トランプを表示
    //  * @param mark
    //  * @param num
    //  */
    // public void dspOneTrump(String mark, int num) {     
    //     System.out.println(" ________ ");
    //     System.out.printf("%-9s|\n", mark);
    //     System.out.println("|        |");
    //     System.out.println("|        |");
    //     System.out.println("|        |");
    //     System.out.printf("|      %2s|\n", num);
    //     System.out.println(" -------- ");
    // }

    // /**
    //  * 裏側のトランプを表示
    //  */
    // public void dspOneBackTrump() {     
    //     System.out.println(" ________ ");
    //     System.out.printf("%-9s|\n", "<?MARK?>");
    //     System.out.println("|        |");
    //     System.out.println("|        |");
    //     System.out.println("|        |");
    //     System.out.printf("|%9s\n", "?NUMBER?");
    //     System.out.println(" -------- ");
    // }

}
