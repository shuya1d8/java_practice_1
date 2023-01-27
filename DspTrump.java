/**
 * トランプを表示させるクラス
 */
public class DspTrump {
    /**
     * トランプを1枚表示
     * @param mark
     * @param num
     */
    public void dspOneTrump(String mark, int num) {     
        System.out.println(" ________ ");
        System.out.printf("%-9s|\n", mark);
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.printf("|      %2s|\n", num);
        System.out.println(" -------- ");
    }

    /**
     * 裏側のトランプを1枚表示
     */
    public void dspOneBackTrump() {     
        System.out.println(" ________ ");
        System.out.printf("%-8s||\n", "<?MARK?>");
        System.out.println("||      ||");
        System.out.println("||      ||");
        System.out.println("||      ||");
        System.out.printf("||%8s\n", "?NUMBER?");
        System.out.println(" -------- ");
    }

    /**
     * トランプを2枚表示
     * @param mark
     * @param num
     */
    public void dspTwoTrump(String mark1, String mark2, int num1, int num2) {     
        System.out.println(" ________    ________ ");
        System.out.printf("%-9s|  %-9s|\n", mark1, mark2);
        System.out.println("|        |  |        |");
        System.out.println("|        |  |        |");
        System.out.println("|        |  |        |");
        System.out.printf("|      %2s|  |      %2s|\n", num1, num2);
        System.out.println(" --------    -------- ");
    }

    /**
     * 裏側のトランプを2枚表示
     */
    public void dspTwoBackTrump() {     
        System.out.println(" ________    ________ ");
        System.out.printf("%-8s||  %-8s||\n", "<?MARK?>", "<?MARK?>");
        System.out.println("||      ||  ||      ||");
        System.out.println("||      ||  ||      ||");
        System.out.println("||      ||  ||      ||");
        System.out.printf("||%8s  ||%8s\n", "?NUMBER?", "?NUMBER?");
        System.out.println(" --------    -------- ");
    }

    /**
     * トランプを3枚表示
     * @param mark
     * @param num
     */
    public void dspThreeTrump(String mark1, String mark2, String mark3, int num1, int num2, int num3) {     
        System.out.println(" ________    ________    ________ ");
        System.out.printf("%-9s|  %-9s|  %-9s|\n", mark1, mark2, mark3);
        System.out.println("|        |  |        |  |        |");
        System.out.println("|        |  |        |  |        |");
        System.out.println("|        |  |        |  |        |");
        System.out.printf("|      %2s|  |      %2s|  |      %2s|\n", num1, num2, num3);
        System.out.println(" --------    --------    -------- ");
    }

    /**
     * 裏側のトランプを3枚表示
     */
    public void dspThreeBackTrump() {     
        System.out.println(" ________    ________    ________ ");
        System.out.printf("%-8s||  %-8s||  %-8s||\n", "<?MARK?>", "<?MARK?>", "<?MARK?>");
        System.out.println("||      ||  ||      ||  ||      ||");
        System.out.println("||      ||  ||      ||  ||      ||");
        System.out.println("||      ||  ||      ||  ||      ||");
        System.out.printf("||%8s  ||%8s  ||%8s\n", "?NUMBER?", "?NUMBER?", "?NUMBER?");
        System.out.println(" --------    --------    -------- ");
    }
}
