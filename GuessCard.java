import util.GuessCardUtil;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

/**
 * トランプ当て実行クラス
 * @author S.Ota
 */
public class GuessCard {
    /**
     *  トランプ当てをプレイ
     */
    public static void playGC() {
        // =============== インスタンス化 =================================== //
        CardGameRoots guessCard = new CardGameRoots("トランプ当て");
        TrumpCard trump = new TrumpCard();
        Random rand = new Random();
        Scanner stdIn= new Scanner(System.in);


        // =============== 変数・フラグ ===================================== //
        String selectMark = "";
        int selectNum;


        // =============== Hello "Guess Card" =============================== //
        guessCard.introduce();
        System.out.println();
        GuessCardUtil.speakManager("ようこそ！ここのルールは至って簡単。裏側のトランプが何かを当てるだけ！");


        // =============== GAME ============================================== //
        while (true) {
            int randMark = rand.nextInt(4);
            int randNum = rand.nextInt(13);
            String cardMark = trump.getTrumpJkMark(randMark);
            String cardNumSt = trump.getTrumpJkNum(randNum);
            int cardNum = Integer.parseInt(cardNumSt);
            int count = 0;

            GuessCardUtil.speakManager("さあ、このトランプのマークと数字はなんでしょう！");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                // e1.printStackTrace();
            }
            trump.dspOneBackTrump();
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                // e1.printStackTrace();
            }
            
            while (true) {
                try {
                    while (true) {
                        count += 1;
                        trump.dspTrumpNoJkAllMark();
                        trump.dspTrumpNoJkAllNum();
                        GuessCardUtil.yokosen("~ ", 15);

                        System.out.print("マーク：");
                        int selectMarkNum = stdIn.nextInt();
                        if (selectMarkNum < 1 || 4 < selectMarkNum) {
                            GuessCardUtil.NotChoice();
                            continue;
                        }

                        System.out.print("数　字：");
                        selectNum = stdIn.nextInt();
                        if (selectNum < 1 || 13 < selectNum) {
                            GuessCardUtil.NotChoice();
                            continue;
                        }

                        GuessCardUtil.yokosen("-", 55);
                        
                        switch (selectMarkNum) {
                            case 1 : selectMark = trump.getTrumpNoJkMark(0);    break;
                            case 2 : selectMark = trump.getTrumpNoJkMark(1);    break;
                            case 3 : selectMark = trump.getTrumpNoJkMark(2);    break;
                            case 4 : selectMark = trump.getTrumpNoJkMark(3);    break;
                        }

                        break;
                    }
                    
                    if (selectMark == cardMark && selectNum == cardNum) {
                        // VSCのターミナル用
                        System.out.println();
                        System.out.println("　◆　　◆　　　　　　　　　　　◆　  ◆　　　　　　　 ");
                        System.out.println("◆ ◆ ◆ ◆ ◆ ◆　　◆　　　◆　　◆ ◆ ◆ ◆　◆　　 ◆　　　◆");
                        System.out.println("　◆　　◆　　　◆　　　　◆　　 ◆　  ◆  ◆ 　◆　　　　◆");
                        System.out.println("　◆　　　　　　◆　◆　　◆　  ◆　   ◆　　 　◆　◆　　◆");
                        System.out.println("　◆ ◆ ◆ ◆ 　　　 ◆　　　　　　　◆　　　　　 ◆　");
                        System.out.println();
                        // CMD用？
                        // System.out.println();
                        // System.out.println("　◆　　◆　　　　　　　　　　　◆　 ◆　　　　　　　 ");
                        // System.out.println("◆◆◆◆◆◆　◆　　　◆　　◆◆◆◆　◆　◆　　　◆　");
                        // System.out.println("　◆　　◆　　◆　　　　◆　　◆　 ◆  ◆ ◆　　　　◆");
                        // System.out.println("　◆　　　　　◆　◆　　◆　 ◆　  ◆　　 ◆　◆　　◆");
                        // System.out.println("　◆◆◆◆　　　◆　　　　　　　　◆　　　　◆　　　　");
                        // System.out.println();
                        GuessCardUtil.speakManager("お見事です！");
                        GuessCardUtil.speakManager("正解は…");
                        System.out.println();
                        trump.dspOneTrump(cardMark, cardNum);
                        System.out.println("マーク：" + cardMark);
                        System.out.println("数　字：" + cardNum);
                        System.out.println();
                        GuessCardUtil.speakManager("でした！");
                        GuessCardUtil.speakManager("すばらしい！");

                    } else if (count == 3) {
                        GuessCardUtil.speakManager("残念！");
                        GuessCardUtil.speakManager("正解は…");
                        trump.dspOneTrump(cardMark, cardNum);
                        System.out.println("マーク：" + cardMark);
                        System.out.println("数　字：" + cardNum);
                        System.out.println();
                        GuessCardUtil.speakManager("でした！");

                    } else if (selectMark != cardMark && selectNum > cardNum) {
                        System.out.println();
                        System.out.println("マークが違います。");
                        System.out.println("数字は" + selectNum + "より小さいです。");
                        GuessCardUtil.yokosen("-", 55);
                        continue;

                    } else if (selectMark != cardMark && selectNum < cardNum) {
                        System.out.println();
                        System.out.println("マークが違います。");
                        System.out.println("数字は" + selectNum + "より大きいです。");
                        GuessCardUtil.yokosen("-", 55);
                        continue;

                    } else if (selectMark != cardMark && selectNum == cardNum) {
                        System.out.println();
                        System.out.println("マークが違います。");
                        System.out.println("数字は合っています。");
                        GuessCardUtil.yokosen("-", 55);
                        continue;

                    } else if (selectMark == cardMark && selectNum < cardNum) {
                        System.out.println();
                        System.out.println("マークは合っています。");
                        System.out.println("数字は" + selectNum + "より小さいです。");
                        GuessCardUtil.yokosen("-", 55);
                        continue;

                    } else if (selectMark == cardMark && selectNum < cardNum) {
                        System.out.println();
                        System.out.println("マークは合っています。");
                        System.out.println("数字は" + selectNum + "より大きいです。");
                        GuessCardUtil.yokosen("-", 55);
                        continue;

                    } else {
                        GuessCardUtil.speakManager("残念！");
                        GuessCardUtil.speakManager("正解は…");
                        trump.dspOneTrump(cardMark, cardNum);
                        System.out.println("マーク：" + cardMark);
                        System.out.println("数　字：" + cardNum);
                        System.out.println();
                        GuessCardUtil.speakManager("でした！");
                        
                    }

                    break;
                    
                } catch (InputMismatchException e) {
                    GuessCardUtil.wordIME();
                    String selectMiss = stdIn.next();
                    count -= 1;

                } catch (Exception e) {
                    GuessCardUtil.wordE(e);
                }
            }

            try {
                GuessCardUtil.yokosen("-", 55);
                System.out.println();
                GuessCardUtil.speakManager("もう一度やりますか？");
                String action = GuessCardUtil.twoAction("YES", "NO");
                
                if (action.equals("F") || action.equals("f")) {
                    GuessCardUtil.yokosen("-", 55);
                    System.out.println();
                    continue;
                    
                } else if (action.equals("J") || action.equals("j")) {
                    GuessCardUtil.changeScreen();
                    break;
                }

            } catch (Exception e) {
                GuessCardUtil.wordE(e);
            }
            
        }
    }
}
