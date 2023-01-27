import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import util.BlackJackUtil;

/**
 * ブラックジャック実行クラス(いつか短くする…)
 * @author S.Ota
 */
public class BlackJack {
    /**
     * ブラックジャックをプレイ
     */
    public static void playBJ() {
        // =============== インスタンス化 ========================================== //
        CardGameRoots blackJack = new CardGameRoots("ブラックジャック");
        BJTrumpCard trump = new BJTrumpCard();
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);
        
        
        // =============== Hello "Black Jack" ====================================== //
        blackJack.introduce();
        System.out.println();
        BlackJackUtil.speakManager("ようこそ！ここでは簡易版のブラックジャックを遊べるよ！");
        BlackJackUtil.speakManager("さっそくルールを説明しよう！");
        BlackJackUtil.yokosen("-", 80);
        System.out.println();
        System.out.println("ブラックジャックとはディーラーとプレイヤーによる対戦型ゲームです。");
        System.out.println("プレイヤーはディーラーよりもカードの合計が「21点」に近ければ勝利になります。");
        System.out.println("ただしプレイヤーのカードの合計が「21点」を超えてしまうとその時点で負けになります。");
        System.out.println();
        System.out.println("< カードの数え方 >");
        System.out.println("「2~9」はそのまま、「10,11,12,13」は「10点」、「1」は「1点or11点」のどちらかの数字に数えます。");
        System.out.println();
        System.out.println("< 特別な役 > ");
        System.out.println("最初に配られた2枚のカードが「1と10点札」で21点が完成していた場合を『ブラックジャック』といい、");
        System.out.println("その時点で勝ちになります。ただし、ディーラーもブラックジャックだった場合は引き分けになります。");
        System.out.println();
        System.out.println("※ また、これは簡易版のためプレイヤーは<HIT:カードを追加する>を一回しかできません。");
        System.out.println("　それに伴い、ディーラーも一回のみカードをめくります。その一回にすべてを賭けてください。");
        System.out.println();
        BlackJackUtil.yokosen("-", 80);
        
        
        // =============== GAME ==================================================== //        
        // 進行確認
        BlackJackUtil.speakManager("ルールは理解しましたか？");
        BlackJackUtil.speakManager("順番は「NPC」→「プレイヤー」の順です！");
        BlackJackUtil.speakManager("進めてもよければ何か打ち込んで！");
        String conf = stdIn.nextLine();
        
        System.out.println();
        BlackJackUtil.speakManager("よし、それでは始めよう！");
        BlackJackUtil.yokosen("-", 55);
        System.out.println();
        System.out.println("'ブラックジャック' >>> 開始します。");
        System.out.println();
        System.out.println("あなたは「プレイヤー」です。");
        BlackJackUtil.yokosen("-", 55);
        System.out.println();
        
        while (true) {
            // =============== 変数・フラグ ==================================================== //
            int randCard;
            String card;
            String action = "S";
            int dealerLast = 0;
            Boolean dealerFulg = false;
            Boolean dealerBSFulg = false;
            Boolean dealerBJFulg = false;
            int npcLast = 0;
            Boolean npcFulg = false;
            Boolean npcBSFulg = false;
            Boolean npcBJFulg = false;
            int playerLast = 0;
            Boolean playerFulg = false;
            Boolean playerBSFulg = false;
            Boolean playerBJFulg = false;
            Boolean npcActionFlug = false;
            int uIdx = 6;
            int pIdx = 2;
            int nIdx = 2;
            int dIdx = 2;

            // =============== START ========================================================== //
            // 使用済みカードリスト・配列とディーラー・NPC・プレイヤー用手持ち配列
            List<String> usedCardList = new ArrayList<>();
            String[] usedCardMark = new String[33];
            int[] usedCardNum = new int[33];
            String[] dealer = new String[11];
            String[] dealerMark = new String[11];
            int[] dealerNum = new int[11];
            String[] npc = new String[11];
            String[] npcMark = new String[11];
            int[] npcNum = new int[11];
            String[] player = new String[11];
            String[] playerMark = new String[11];
            int[] playerNum = new int[11];
            
            // NPC>>プレイヤー>>ディーラーの順にカードを2枚ずつ配る
            for (int i = 0; i < 6; i++) {
                do {
                    randCard = rand.nextInt(52);
                    card = trump.getBJTCMark(trump.getBJtrumpCard(randCard)) + trump.getBJTCNum(trump.getBJtrumpCard(randCard));
                } while (usedCardList.contains(card));
                
                usedCardList.add(card);
                usedCardMark[i] = trump.getBJTCMark(trump.getBJtrumpCard(randCard));
                usedCardNum[i] = trump.getBJTCNum(trump.getBJtrumpCard(randCard));
            }
            
            for (int i = 0; i < 2; i++) {
                npc[i] = usedCardList.get(i);
                player[i] = usedCardList.get(i + 2);
                dealer[i] = usedCardList.get(i + 4);

                npcMark[i] = usedCardMark[i];
                playerMark[i] = usedCardMark[i + 2];
                dealerMark[i] = usedCardMark[i + 4];

                npcNum[i] = usedCardNum[i];
                playerNum[i] = usedCardNum[i + 2];
                dealerNum[i] = usedCardNum[i + 4];
            }

            int dealerTotal = BlackJackUtil.bjFirstTotal(dealerNum[0], dealerNum[1]);
            int dealerTotalA = BlackJackUtil.bjFirstTotalA(dealerNum[0], dealerNum[1]);
            int npcTotal = BlackJackUtil.bjFirstTotal(npcNum[0], npcNum[1]);
            int npcTotalA = BlackJackUtil.bjFirstTotalA(npcNum[0], npcNum[1]);
            int playerTotal = BlackJackUtil.bjFirstTotal(playerNum[0], playerNum[1]);
            int playerTotalA = BlackJackUtil.bjFirstTotalA(playerNum[0], playerNum[1]);
            // int dealerTotal = 21;
            // int dealerTotalA = 21;
            // int npcTotal = 21;
            // int npcTotalA = 21;
            // int playerTotal = 21;
            // int playerTotalA = 21;

            // 配られたカードを表示
            System.out.println("[ディーラー]");
            if (dealerTotalA == 21) {
                trump.dspTwoTrump(dealerMark[0], dealerMark[1],  dealerNum[0], dealerNum[1]);
                System.out.printf("『%s』 <BulackJack>\n", dealerTotalA);
                dealerBJFulg = true;

            } else {
                trump.dspOneBackOneTrump(dealerMark[0], dealerNum[0]);

            }
            System.out.println();
            System.out.println();

            System.out.println("[NPC]");
            if (npcTotalA == 21) {
                trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                System.out.printf("『%s』 <BulackJack>\n", npcTotalA);
                npcBJFulg = true;

            } else if (npcTotalA != 0) {
                trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                System.out.printf("『%s』or『%s』\n", npcTotal, npcTotalA);
                
            } else {
                trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                System.out.printf("『%s』\n", npcTotal);

            }
            System.out.println();

            System.out.println("[プレイヤー]");
            if (playerTotalA == 21) {
                trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                System.out.printf("『%s』 <BulackJack>\n", playerTotalA);
                playerBJFulg = true;

            } else if (playerTotalA != 0) {
                trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                System.out.printf((playerTotalA != 0) ? "『%s』or『%s』\n" : "『%s』\n", playerTotal, playerTotalA);
                
            } else {
                trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                System.out.printf("『%s』\n", playerTotal);
                
            }
            System.out.println();

            BlackJackUtil.yokosen("-", 55);
            System.out.println("確認ができたら何か打ち込んでください。");
            conf = stdIn.nextLine();
            // System.out.println();

            // =============== アクション開始 =============================================== //
            // 最初に配られたカードで'ブラックジャック'？
            if (!dealerBJFulg) { 
                if (!npcBJFulg) {
                    // NPCのアクション
                    if (npcTotalA < 17 && npcTotal < 17) {
                        do {
                            randCard = rand.nextInt(52);
                            card = trump.getBJTCMark(trump.getBJtrumpCard(randCard)) + trump.getBJTCNum(trump.getBJtrumpCard(randCard));
                        } while (usedCardList.contains(card));
                        
                        usedCardList.add(card);
                        usedCardMark[uIdx] = trump.getBJTCMark(trump.getBJtrumpCard(randCard));
                        usedCardNum[uIdx] = trump.getBJTCNum(trump.getBJtrumpCard(randCard));

                        npc[nIdx] = usedCardList.get(uIdx);
                        npcMark[nIdx] = usedCardMark[uIdx];
                        npcNum[nIdx] = usedCardNum[uIdx];
                        
                        npcTotal = BlackJackUtil.bjSecondTotal(npcTotal, npcNum[nIdx]);
                        npcTotalA = BlackJackUtil.bjTreeCardTotalA(npcNum[nIdx - 2], npcNum[nIdx - 1], npcNum[nIdx]) > BlackJackUtil.bjSecondTotalA(npcTotalA, npcNum[nIdx]) ? BlackJackUtil.bjTreeCardTotalA(npcNum[nIdx - 2], npcNum[nIdx - 1], npcNum[nIdx]) : BlackJackUtil.bjSecondTotalA(npcTotalA, npcNum[nIdx]);


                        uIdx += 1;
                        // nIdx += 1;

                        npcActionFlug = true;
                    }

                    BlackJackUtil.yokosen("-", 55);
                    System.out.println();
                    System.out.println("NPCのアクションが開始しました。");
                    BlackJackUtil.yokosen("-", 55);
                    System.out.println();

                    // 配られたカードを表示
                    System.out.println("[ディーラー]");
                    if (dealerTotalA == 21) {
                        trump.dspTwoTrump(dealerMark[0], dealerMark[0],  dealerNum[1], dealerNum[1]);
                        System.out.printf("『%s』 <BulackJack>\n", dealerTotalA);

                    } else {
                        trump.dspOneBackOneTrump(dealerMark[0], dealerNum[0]);

                    }
                    System.out.println();
                    System.out.println();

                    System.out.println("[NPC]");
                    if (npcNum[nIdx] != 0) {
                        if (npcTotal == 21 || npcTotalA == 21) {
                            trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                            System.out.printf("『%s』 \n", (npcTotal == 21) ? npcTotal : npcTotalA);
                            npcFulg = true;
            
                        } else if (npcTotalA != 0) {
                            trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                            System.out.printf("『%s』or『%s』\n", npcTotal, npcTotalA);

                        } else {
                            trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                            System.out.printf("『%s』", (npcTotal > npcTotalA) ? npcTotal : npcTotalA);
                            System.out.println((npcTotal > 21) || (npcTotalA > 21) ? " <BUST>" : "");
                            if (npcTotal > 21 || npcTotalA > 21) {
                                npcBSFulg = true;
                            }
            
                        }
                    } else {
                        if (npcTotalA == 21) {
                            trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                            System.out.printf("『%s』 <BulackJack>\n", npcTotalA);
                            npcBJFulg = true;
            
                        } else if (npcTotalA != 0) {
                            trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                            System.out.printf("『%s』or『%s』\n", npcTotal, npcTotalA);
                            
                        } else {
                            trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                            System.out.printf("『%s』\n", npcTotal);
            
                        }
                    }
                    System.out.println();

                    System.out.println("[プレイヤー]");
                    if (playerTotalA == 21) {
                        trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                        System.out.printf("『%s』 <BulackJack>\n", playerTotalA);
                        playerBJFulg = true;

                    } else if (playerTotalA != 0) {
                        trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                        System.out.printf((playerTotalA != 0) ? "『%s』or『%s』\n" : "『%s』\n", playerTotal, playerTotalA);
                        
                    } else {
                        trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                        System.out.printf("『%s』\n", playerTotal);
                        
                    }
                    System.out.println();
                    System.out.println(npcActionFlug ? "NPCのアクション<HIT>が終了しました。" : "NPCのアクション<STAND>が終了しました。");

                } else {
                    System.out.println();
                    System.out.println("NPCは'BlackJack'です。");
                }

                if (!playerBJFulg) {
                    System.out.println("次はあなたの番です。");

                    try {
                        // アクション
                        action = BlackJackUtil.twoAction("HIT", "STAND");
                    } catch (NumberFormatException e) {
                        BlackJackUtil.wordIME();
                        // String selectMiss = stdIn.next();
                    } catch (Exception e) {
                        BlackJackUtil.wordE(e);
                    }     

                    if (action.equals("F") || action.equals("f")) {
                        System.out.println();
                        System.out.println("<HIT>");
                        BlackJackUtil.yokosen("-", 55);
                        System.out.println();

                        // プレイヤーのアクション
                        do {
                            randCard = rand.nextInt(52);
                            card = trump.getBJTCMark(trump.getBJtrumpCard(randCard)) + trump.getBJTCNum(trump.getBJtrumpCard(randCard));
                        } while (usedCardList.contains(card));
                            
                        usedCardList.add(card);
                        usedCardMark[uIdx] = trump.getBJTCMark(trump.getBJtrumpCard(randCard));
                        usedCardNum[uIdx] = trump.getBJTCNum(trump.getBJtrumpCard(randCard));

                        player[pIdx] = usedCardList.get(uIdx);
                        playerMark[pIdx] = usedCardMark[uIdx];
                        playerNum[pIdx] = usedCardNum[uIdx];
                        
                        playerTotal = BlackJackUtil.bjSecondTotal(playerTotal, playerNum[pIdx]);
                        playerTotalA = BlackJackUtil.bjTreeCardTotalA(playerNum[pIdx - 2], playerNum[pIdx - 1], playerNum[pIdx]) > BlackJackUtil.bjSecondTotalA(playerTotalA, playerNum[pIdx]) ? BlackJackUtil.bjTreeCardTotalA(playerNum[pIdx - 2], playerNum[pIdx - 1], playerNum[pIdx]) : BlackJackUtil.bjSecondTotalA(playerTotalA, playerNum[pIdx]);

                        uIdx += 1;
                        
                    } else if (action.equals("J") || action.equals("j")) {
                        System.out.println();
                        System.out.println("<STAND>");
                        BlackJackUtil.yokosen("-", 55);

                    } else {
                        System.out.println("error");
                        break;
                    }

                    // 配られたカードを表示
                    System.out.println("[ディーラー]");
                    if (dealerTotalA == 21) {
                        trump.dspTwoTrump(dealerMark[0], dealerMark[0],  dealerNum[1], dealerNum[1]);
                        System.out.printf("『%s』 <BulackJack>\n", dealerTotalA);

                    } else {
                        trump.dspOneBackOneTrump(dealerMark[0], dealerNum[0]);

                    }
                    System.out.println();
                    System.out.println();

                    System.out.println("[NPC]");
                    if (npcNum[nIdx] != 0) {
                        if (npcTotal == 21 || npcTotalA == 21) {
                            trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                            System.out.printf("『%s』\n", (npcTotal == 21) ? npcTotal : npcTotalA);
            
                        } else if (npcTotalA != 0) {
                            trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                            System.out.printf("『%s』or『%s』", npcTotal, npcTotalA);

                        } else {
                            trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                            System.out.printf("『%s』", (npcTotal > npcTotalA) ? npcTotal : npcTotalA);
                            System.out.println((npcTotal > 21) || (npcTotalA > 21) ? " <BUST>" : "");
            
                        }
                    } else {
                        if (npcTotalA == 21) {
                            trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                            System.out.printf("『%s』 <BulackJack>\n", npcTotalA);
            
                        } else if (npcTotalA != 0) {
                            trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                            System.out.printf("『%s』or『%s』\n", npcTotal, npcTotalA);
                            
                        } else {
                            trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                            System.out.printf("『%s』\n", npcTotal);
            
                        }
                    }
                    System.out.println();

                    System.out.println("[プレイヤー]");
                    if (playerNum[pIdx] != 0) {
                        if (playerTotal == 21 || playerTotalA == 21) {
                            trump.dspThreeTrump(playerMark[0], playerMark[1], playerMark[2], playerNum[0], playerNum[1], playerNum[2]);
                            System.out.printf("『%s』\n", (playerTotal == 21) ? playerTotal : playerTotalA);
                            playerFulg = true;
            
                        } else if (playerTotalA != 0) {
                            trump.dspThreeTrump(playerMark[0], playerMark[1], playerMark[2], playerNum[0], playerNum[1], playerNum[2]);
                            System.out.printf("『%s』or『%s』\n", playerTotal, playerTotalA);
                            

                        } else {
                            trump.dspThreeTrump(playerMark[0], playerMark[1], playerMark[2], playerNum[0], playerNum[1], playerNum[2]);
                            System.out.printf("『%s』", (playerTotal > playerTotalA) ? playerTotal : playerTotalA);
                            System.out.println((playerTotal > 21) || (playerTotalA > 21) ? " <BUST>" : "");
                            if (playerTotal > 21 || playerTotalA > 21) {
                                playerBSFulg = true;
                            }
            
                        }
                    } else {
                        if (playerTotalA == 21) {
                            trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                            System.out.printf("『%s』 <BulackJack>\n", playerTotalA);
                            playerBJFulg = true;
            
                        } else if (playerTotalA != 0) {
                            trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                            System.out.printf((playerTotalA != 0) ? "『%s』or『%s』\n" : "『%s』\n", playerTotal, playerTotalA);
                            
                        } else {
                            trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                            System.out.printf("『%s』\n", playerTotal);
                            
                        }
                    }
                    System.out.println();
                    System.out.println(action.equals("F") || action.equals("f") ? "あなたは<HIT>しました。" : "あなたは<STAND>しました。");
                    System.out.println("全員のアクションが終了しました。");

                } else {
                    System.out.println();
                    System.out.println("あなたは'BlackJack'です。");
                }
                
                System.out.println("結果を表示します。");
                System.out.println("確認ができたら何か打ち込んでください。");
                conf = stdIn.nextLine();
                BlackJackUtil.yokosen("-", 55);
                
                if (!npcBSFulg || !playerBSFulg) {
                    // ディーラーのアクション
                    if (dealerTotalA < 17 && dealerTotal < 17) {
                        do {
                            randCard = rand.nextInt(52);
                            card = trump.getBJTCMark(trump.getBJtrumpCard(randCard)) + trump.getBJTCNum(trump.getBJtrumpCard(randCard));
                        } while (usedCardList.contains(card));
                        
                        usedCardList.add(card);
                        usedCardMark[uIdx] = trump.getBJTCMark(trump.getBJtrumpCard(randCard));
                        usedCardNum[uIdx] = trump.getBJTCNum(trump.getBJtrumpCard(randCard));
                        
                        dealer[dIdx] = usedCardList.get(uIdx);
                        dealerMark[dIdx] = usedCardMark[uIdx];
                        dealerNum[dIdx] = usedCardNum[uIdx];
                        
                        dealerTotal = BlackJackUtil.bjSecondTotal(dealerTotal, dealerNum[dIdx]);
                        dealerTotalA = BlackJackUtil.bjTreeCardTotalA(dealerNum[dIdx - 2], dealerNum[dIdx - 1], dealerNum[dIdx]) > BlackJackUtil.bjSecondTotalA(dealerTotalA, dealerNum[dIdx]) ? BlackJackUtil.bjTreeCardTotalA(dealerNum[dIdx - 2], dealerNum[dIdx - 1], dealerNum[dIdx]) : BlackJackUtil.bjSecondTotalA(dealerTotalA, dealerNum[dIdx]);
                        
                        uIdx += 1;
                        // nIdx += 1;
                    }
                }
            }
                
            // カードを表示
            System.out.println("[ディーラー]");
            if (dealerNum[dIdx] != 0) {
                if (dealerTotal == 21 || dealerTotalA == 21) {
                    trump.dspThreeTrump(dealerMark[0], dealerMark[1], dealerMark[2], dealerNum[0], dealerNum[1], dealerNum[2]);
                    System.out.printf("『%s』\n", (dealerTotal == 21) ? dealerTotal : dealerTotalA);
                    dealerFulg = true;
                    dealerLast = (dealerTotal == 21) ? dealerTotal : dealerTotalA;
    
                // } else if (dealerTotalA != 0) {
                //     trump.dspThreeTrump(dealerMark[0], dealerMark[1], dealerMark[2], dealerNum[0], dealerNum[1], dealerNum[2]);
                //     System.out.printf("『%s』or『%s』\n", dealerTotal, dealerTotalA);

                } else {
                    trump.dspThreeTrump(dealerMark[0], dealerMark[1], dealerMark[2], dealerNum[0], dealerNum[1], dealerNum[2]);
                    System.out.printf("『%s』", (dealerTotal > dealerTotalA) ? dealerTotal : dealerTotalA);
                    System.out.println((dealerTotal > 21) || (dealerTotalA > 21) ? " <BUST>" : "");
                    if (dealerTotal > 21 || dealerTotalA > 21) {
                        dealerBSFulg = true;
                    }
                    dealerLast = (dealerTotal > dealerTotalA) ? dealerTotal : dealerTotalA;
    
                }
            } else {
                if (dealerTotalA == 21) {
                    trump.dspTwoTrump(dealerMark[0], dealerMark[1], dealerNum[0], dealerNum[1]);
                    System.out.printf("『%s』 <BulackJack>\n", dealerTotalA);
                    dealerBJFulg = true;
                    dealerLast = dealerTotalA;
    
                // } else if (dealerTotalA != 0) {
                //     trump.dspTwoTrump(dealerMark[0], dealerMark[1], dealerNum[0], dealerNum[1]);
                //     System.out.printf("『%s』or『%s』\n", dealerTotal, dealerTotalA);
                    
                } else {
                    trump.dspTwoTrump(dealerMark[0], dealerMark[1], dealerNum[0], dealerNum[1]);
                    System.out.printf("『%s』\n", (dealerTotal > dealerTotalA) ? dealerTotal : dealerTotalA);
                    dealerLast = (dealerTotal > dealerTotalA) ? dealerTotal : dealerTotalA;
    
                }
            }
            System.out.println();
            System.out.println();

            System.out.println("[NPC]");
            if (npcNum[nIdx] != 0) {
                if (npcTotal == 21 || npcTotalA == 21) {
                    trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                    System.out.printf("『%s』\n", (npcTotal == 21) ? npcTotal : npcTotalA);
                    npcLast = (npcTotal == 21) ? npcTotal : npcTotalA;
    
                // } else if (npcTotalA != 0) {
                //     trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                //     System.out.printf("『%s』or『%s』\n", npcTotal, npcTotalA);

                } else {
                    trump.dspThreeTrump(npcMark[0], npcMark[1], npcMark[2], npcNum[0], npcNum[1], npcNum[2]);
                    System.out.printf("『%s』", (npcTotal > npcTotalA) ? npcTotal : npcTotalA);
                    System.out.println((npcTotal > 21) || (npcTotalA > 21) ? " <BUST>" : "");
                    npcLast = (npcTotal > npcTotalA) ? npcTotal : npcTotalA;
    
                }
            } else {
                if (npcTotalA == 21) {
                    trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                    System.out.printf("『%s』 <BulackJack>\n", npcTotalA);
                    npcLast = npcTotalA;
    
                // } else if (npcTotalA != 0) {
                //     trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                //     System.out.printf("『%s』or『%s』\n", npcTotal, npcTotalA);
                    
                } else {
                    trump.dspTwoTrump(npcMark[0], npcMark[1], npcNum[0], npcNum[1]);
                    System.out.printf("『%s』\n", (npcTotal > npcTotalA) ? npcTotal : npcTotalA);
                    npcLast = (npcTotal > npcTotalA) ? npcTotal : npcTotalA;
    
                }
            }
            System.out.println();

            System.out.println("[プレイヤー]");
            if (playerNum[pIdx] != 0) {
                if (playerTotal == 21 || playerTotalA == 21) {
                    trump.dspThreeTrump(playerMark[0], playerMark[1], playerMark[2], playerNum[0], playerNum[1], playerNum[2]);
                    System.out.printf("『%s』\n", (playerTotal == 21) ? playerTotal : playerTotalA);
                    playerLast = (playerTotal == 21) ? playerTotal : playerTotalA;
    
                // } else if (playerTotalA != 0) {
                //     trump.dspThreeTrump(playerMark[0], playerMark[1], playerMark[2], playerNum[0], playerNum[1], playerNum[2]);
                //     System.out.printf("『%s』or『%s』\n", playerTotal, playerTotalA);

                } else {
                    trump.dspThreeTrump(playerMark[0], playerMark[1], playerMark[2], playerNum[0], playerNum[1], playerNum[2]);
                    System.out.printf("『%s』", (playerTotal > playerTotalA) ? playerTotal : playerTotalA);
                    System.out.println((playerTotal > 21) || (playerTotalA > 21) ? " <BUST>" : "");
                    playerLast = (playerTotal > playerTotalA) ? playerTotal : playerTotalA;
    
                }
            } else {
                if (playerTotalA == 21) {
                    trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                    System.out.printf("『%s』 <BulackJack>\n", playerTotalA);
                    playerLast = playerTotalA;
    
                // } else if (playerTotalA != 0) {
                //     trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                //     System.out.printf((playerTotalA != 0) ? "『%s』or『%s』\n" : "『%s』\n", playerTotal, playerTotalA);
                    
                } else {
                    trump.dspTwoTrump(playerMark[0], playerMark[1], playerNum[0], playerNum[1]);
                    System.out.printf("『%s』\n", (playerTotal > playerTotalA) ? playerTotal : playerTotalA);
                    playerLast = (playerTotal > playerTotalA) ? playerTotal : playerTotalA;
                    
                }
            }
            System.out.println();

            // =============== 'BlackJack'がでた ======================================== //
            if (dealerBJFulg) {
                System.out.println("ディーラーの'ブラックジャック'です。");
            }

            if (npcBJFulg) {
                System.out.println("NPCの'ブラックジャック'です。");
            }
            
            if (playerBJFulg) {
                System.out.println("プレイヤーの'ブラックジャック'です。");
            }

            // =============== 'BlackJack'あり判定 ======================================= //
            if (dealerBJFulg && npcBJFulg && playerBJFulg) {
                System.out.println("引き分けです。");
            }

            else if (dealerBJFulg && !npcBJFulg && !playerBJFulg) {
                System.out.println("ディーラーの勝ちです。");
            }

            else if (dealerBJFulg && npcBJFulg && !playerBJFulg) {
                System.out.println("NPCの引き分け、プレイヤーの負けです。");
            }

            else if (dealerBJFulg && !npcBJFulg && playerBJFulg) {
                System.out.println("NPCの負け、プレイヤーの引き分けです。");
            }

            else if (!dealerBJFulg && npcBJFulg && playerBJFulg) {
                System.out.println("NPCとプレイヤーの勝ちです。");
            }

            else if (!dealerBJFulg && npcBJFulg && !playerBJFulg) {
                if (dealerBSFulg && playerBSFulg) {
                    System.out.println("NPCの勝ち、プレイヤーの負けです。");
                } else if (playerBSFulg || (dealerLast > playerLast)) {
                    System.out.println("NPCの勝ち、プレイヤーの負けです。");
                } else if (dealerBSFulg || (dealerLast < playerLast)) {
                    System.out.println("NPCとプレイヤーの勝ちです。");
                } else if (dealerLast == playerLast) {
                    System.out.println("NPCの勝ち、プレイヤーの引き分けです。");
                }
            }

            else if (!dealerBJFulg && !npcBJFulg && playerBJFulg) {
                if (dealerBSFulg && npcBSFulg) {
                    System.out.println("NPCの負け、プレイヤーの勝ちです。");
                } else if (npcBSFulg || (dealerLast > npcLast)) {
                    System.out.println("NPCの負け、プレイヤーの勝ちです。");
                } else if (dealerBSFulg || (dealerLast < npcLast)) {
                    System.out.println("NPCとプレイヤーの勝ちです。");
                } else if (dealerLast == npcLast) {
                    System.out.println("NPCの引き分け、プレイヤーの勝ちです。");
                }
            }

            // =============== BUSTあり判定 =========================================== //
            else if (!dealerBSFulg && npcBSFulg && playerBSFulg) {
                System.out.println("ディーラーの勝ちです。");
            }

            else if (dealerBSFulg && !npcBSFulg && !playerBSFulg) {
                System.out.println("NPCとプレイヤーの勝ちです。");
            }

            else if (dealerBSFulg && !npcBSFulg && playerBSFulg) {
                System.out.println("NPCの勝ち、プレイヤーの負けです。");
            }

            else if (dealerBSFulg && npcBSFulg && !playerBSFulg) {
                System.out.println("NPCの負け、プレイヤーの勝ちです。");
            }

            else if (!dealerBSFulg && !npcBSFulg && playerBSFulg) {
                if (dealerLast > npcLast) {
                    System.out.println("NPCとプレイヤーの負けです。");
                } else if (dealerLast < npcLast) {
                    System.out.println("NPCの勝ち、プレイヤーの負けです。");
                } else if (dealerLast == npcLast) {
                    System.out.println("NPCの引き分け、プレイヤーの負けです。");
                }
            }

            else if (!dealerBSFulg && npcBSFulg && !playerBSFulg) {
                if (dealerLast > playerLast) {
                    System.out.println("NPCとプレイヤーの負けです。");
                } else if (dealerLast < playerLast) {
                    System.out.println("NPCの負け、プレイヤーの勝ちです。");
                } else if (dealerLast == playerLast) {
                    System.out.println("NPCの負け、プレイヤーの引き分けです。");
                }
            }

            // =============== その他判定 ============================================= //
            else if ((dealerLast > npcLast) && (dealerLast > playerLast)) {
                System.out.println("ディーラーの勝ちです。");
            }
            
            else if ((dealerLast < npcLast) && (dealerLast < playerLast)) {
                System.out.println("NPCとプレイヤーの勝ちです。");
            }

            else if ((dealerLast > npcLast) && (dealerLast < playerLast)) {
                System.out.println("NPCの負け、プレイヤーの勝ちです。");
            }
            
            else if ((dealerLast < npcLast) && (dealerLast > playerLast)) {
                System.out.println("NPCの勝ち、プレイヤーの負けです。");
            }
            
            else if ((dealerLast == npcLast) && (dealerLast == playerLast)) {
                System.out.println("引き分けです。");
            }

            else if ((dealerLast > npcLast) && (dealerLast == playerLast)) {
                System.out.println("NPCの負け、プレイヤーの引き分けです。");
            }

            else if ((dealerLast < npcLast) && (dealerLast == playerLast)) {
                System.out.println("NPCの勝ち、プレイヤーの引き分けです。");
            }

            else if ((dealerLast == npcLast) && (dealerLast > playerLast)) {
                System.out.println("NPCの引き分け、プレイヤーの負けです。");
            }

            else if ((dealerLast == npcLast) && (dealerLast < playerLast)) {
                System.out.println("NPCの引き分け、プレイヤーの勝ちです。");
            }


            // =============== Are you OK? One more? ============================================ //
            try {
                // もう一度？
                BlackJackUtil.yokosen("-", 55);
                System.out.println();
                BlackJackUtil.speakManager("結果はどうでしたか？");
                System.out.println();
                BlackJackUtil.speakManager("もう一度やりますか？");
                String YNaction = BlackJackUtil.twoAction("YES", "NO");
                
                if (YNaction.equals("F") || YNaction.equals("f")) {
                    BlackJackUtil.yokosen("-", 55);
                    System.out.println();
                    continue;
                    
                } else if (YNaction.equals("J") || YNaction.equals("j")) {
                    BlackJackUtil.changeScreen();
                    break;
                }
            } catch (Exception e) {
                BlackJackUtil.wordE(e);
            }
        }
    }
}
    