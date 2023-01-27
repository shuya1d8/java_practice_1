import util.CardGameWorldUtil;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * カードゲーム実行クラス
 * @author S.Ota
 */
public class CardGameWorld {
    /**
     * メインメソッド
     * @param args
     */
    public static void main(String[] args) {
        // =============== インスタンス化 ==================================== //
        Scanner stdIn = new Scanner(System.in);


        // =============== Hello "Card Game World" ========================== //
        System.out.println();
        CardGameWorldUtil.yokosen("◆ ◇ ", 25);
        System.out.println();
        CardGameWorldUtil.speakWorld("カードゲームワールドへようこそ");
        System.out.println();
        CardGameWorldUtil.yokosen("=", 55);
        System.out.println(" ■-----------------■ ");
        System.out.println(" | Card Game World |");
        System.out.println(" ■-----------------■");
        System.out.println();
        CardGameWorldUtil.speakManager("ここではさまざまなカードゲームを遊べるよ！");
        
        
        // =============== Select Game ====================================== //
        CardGameWorldUtil.speakManager("下の選択肢から遊びたいカードゲームを選んでね！");
        CardGameWorldUtil.yokosen("-", 55);
        
        while (true) {
            try {
                CardGameChoice.cardGameChoice();
                System.out.print("数字を入力してね：");
                int select = stdIn.nextInt();
                
                if (select == 0) {
                    if (Confirmation.confirm("世界を去る")) {
                        CardGameWorldUtil.yokosen("-", 55);
                        System.out.println();
                        CardGameWorldUtil.speakManager("また会えることを楽しみにしております！");
                        CardGameWorldUtil.yokosen("=", 55);
                        System.out.println();
                        CardGameWorldUtil.speakWorld("世界を去ります");
                        System.out.println();
                        CardGameWorldUtil.yokosen("◆ ◇ ", 25);
                        break;
                    } else {
                        System.out.println();
                        CardGameWorldUtil.yokosen("-", 55);
                    }
                    
                } else if (select == 1) {
                    if (Confirmation.confirm("トランプ当て")) {
                        CardGameWorldUtil.changeScreen();
                        GuessCard.playGC();
                    } else {
                        System.out.println();
                        CardGameWorldUtil.yokosen("-", 55);
                    }
                    
                } else if (select == 2) {
                    if (Confirmation.confirm("簡易版ブラックジャック")) {
                        CardGameWorldUtil.changeScreen();
                        BlackJack.playBJ();
                    } else {
                        System.out.println();
                        CardGameWorldUtil.yokosen("-", 55);
                    }
                    
                } else {
                    CardGameWorldUtil.NotChoice();
                    
                }
    
            } catch (InputMismatchException e) {
                CardGameWorldUtil.wordIME();
                String selectMiss = stdIn.next();
    
            } catch (Exception e) {
                CardGameWorldUtil.wordE(e);
            }
        }

        stdIn.close();
    }
}