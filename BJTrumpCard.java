/**
 * ブラックジャック用トランプカードクラス
 * @author S.Ota
 */
public class BJTrumpCard extends DspTrump {
    /**
     * トランプ束 全52枚（1000~:Spade,1~13/ 2000~:Heart,1~13/ 3000~:Diamond,1~13/ 4000~:Club,1~13）
     */
    // private int[] trump = {
    //     1001, 4002, 3003, 2004, 1005, 4006, 3007, 2008, 1009, 4010, 3011, 2012, 1013,
    //     2001, 1002, 4003, 3004, 2005, 1006, 4007, 3008, 2009, 1010, 4011, 3012, 2013,
    //     3001, 2002, 1003, 4004, 3005, 2006, 1007, 4008, 3009, 2010, 1011, 4012, 3013,
    //     4001, 3002, 2003, 1004, 4005, 3006, 2007, 1008, 4009, 3010, 2011, 1012, 4013,
    // };
    private int[] trump = {
        1001, 4002, 3003, 2004, 1005, 4006, 3007, 2008, 1009, 4010, 3011, 2012, 1013,
        2001, 1002, 4003, 3004, 2005, 1006, 4007, 3008, 2009, 1010, 4011, 3012, 2013,
        3001, 2002, 1003, 4004, 3005, 2006, 1007, 4008, 3009, 2010, 1011, 4012, 3013,
        4001, 3002, 2003, 1004, 4005, 3006, 2007, 1008, 4009, 3010, 2011, 1012, 4013,
    };

    /**
     * コンストラクタ
     */
    BJTrumpCard() {

    }

    /**
     * 全要素のゲッター
     * @return
     */
    public int[] getBJtrump() {
        return trump;
    }

    /**
     * 指定した要素のゲッター
     * @return
     */
    public int getBJtrumpCard(int idx) {
        return trump[idx];
    }

    /**
     * マークを返す（1000~:<Spade>/ 2000~:<Heart>/ 3000~:<Diamond>/ 4000~:<Club>）
     * @param num トランプ束から取得した数字
     * @return
     */
    public String getBJTCMark(int num) {
        String mark = "<NoMark>";

        if (1000 <= num & num < 2000) {
            mark = "<Spade>";

        } else if (2000 <= num & num < 3000) {
            mark = "<Heart>";

        } else if (3000 <= num & num < 4000) {
            mark = "<Diamond>";

        } else if (4000 <= num & num < 5000) {
            mark = "<Club>";

        }

        return mark;
    }

    /**
     * 数字を返す
     * @param num トランプ束から取得した数字
     * @return
     */
    public int getBJTCNum(int num) {
        int number = 0;

        if (1000 <= num & num < 2000) {
            number = num - 1000;

        } else if (2000 <= num & num < 3000) {
            number = num - 2000;

        } else if (3000 <= num & num < 4000) {
            number = num - 3000;

        } else if (4000 <= num & num < 5000) {
            number = num - 4000;

        }

        return number;
    }

    /**
     * 裏側のトランプを1枚と表側のトランプを1枚表示
     * @param mark
     * @param num
     */
    public void dspOneBackOneTrump(String mark, int num) {     
        System.out.println(" ________    ________ ");
        System.out.printf("%-9s|  %-8s||\n", mark, "<?MARK?>");
        System.out.println("|        |  ||      ||");
        System.out.println("|        |  ||      ||");
        System.out.println("|        |  ||      ||");
        System.out.printf("|      %2s|  ||%8s\n", num, "?NUMBER?");
        System.out.println(" --------    -------- ");
    }

}