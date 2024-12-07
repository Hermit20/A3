package org.example;

import org.junit.jupiter.api.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    @Test
    @DisplayName("Check deck size is 117")
    void RESP_01_test_01(){
        Main game = new Main();
        game.InitializeDeck();

        //test: there should be 117 cards
        int TdeckSize = game.GetTotalDeckSize();
        assertEquals(117,TdeckSize);
    }

//    @Test
//    @DisplayName("Each player gets 12 adventure cards ")
//    void RESP_02_test_02(){
//        Main game = new Main();
//        game.InitializeDeck();
//        int size = game.ADdeck.size();
//        game.InitializePlayers();
//        ArrayList<Main.Player> players = game.getplayers();
//
//
//
//        //test: each player should have 12 cards
//        for(Main.Player player: players){
//            assertEquals(12,game.GetPlayerDeck(player).size());
//        }
//
//        int newsize = game.ADdeck.size();
//        assertNotEquals(size,newsize);
//    }
//
//    @Test
//    @DisplayName("determine if one or more players have 7 shield ")
//    void RESP_03_test_03(){
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//        game.GivePlayerShields(game.players.get(0),7);
//
//        assertEquals(7,game.GetPlayerShields(game.players.get(0)));
//    }
//
//    @Test
//    @DisplayName("Game displays the id of each winner ")
//    void RESP_04_test_04(){
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//        game.GivePlayerShields(game.players.get(0),7);
//
//
//        assertTrue(game.DisplayWinners().contains("P1"));
//    }
//
//    @Test
//    @DisplayName("The game displays the next event card ")
//    void RESP_05_test_01(){
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//        Main.EventCard event = game.EVdeck.get(0);
//
//        assertEquals(event , game.GameDraw(game.players.get(0)));
//
//    }
//
//    @Test
//    @DisplayName("The current player picks a Plague Card: current player loses 2 shields ")
//    void RESP_06_test_01(){
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//        game.GivePlayerShields(game.players.get(0),5);
//        Main.EventCard Plaguecard = new Main.EventCard();
//        Plaguecard.deck = "EV";
//        Plaguecard.type = "Plague";
//        Plaguecard.value = -2;
//        Plaguecard.name = Plaguecard.type;
//        game.EVdeck.set(0,Plaguecard);
//        game.DrawCard(game.EVdeck.get(0),game.players.get(0));
//        assertEquals(3,game.players.get(0).shields);
//    }
//
//    @Test
//    @DisplayName("The current player picks a Queen’s Favor Card: current player draws 2 adventure cards ")
//    void RESP_07_test_01(){
//        Random rand = new Random();
//        Main game = new Main();
//        game.InitializeDeck();
//        Main.Player P1 = new Main.Player();
//        P1.order = 1;
//        P1.name = "P"+1;
//        P1.shields = 0;
//        for(int i = 0; i < 10; i++){
//            int rand_index = rand.nextInt(game.ADdeck.size());
//            P1.deck.add(game.ADdeck.get(rand_index));
//            game.ADdeck.remove(rand_index);
//        }
//        Main.EventCard QueenCard = new Main.EventCard();
//        QueenCard.deck = "EV";
//        QueenCard.type = "Queen";
//        QueenCard.value = 2;
//        QueenCard.name = QueenCard.type;
//        game.EVdeck.set(0,QueenCard);
//        int currentad = P1.deck.size();
//        game.DrawCard(game.EVdeck.get(0),P1);
//        assertEquals((currentad + 2),P1.deck.size());
//    }
//
//    @Test
//    @DisplayName("The current player picks a Prosperity: All players draw 2 adventure cards")
//    void RESP_08_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        Random rand = new Random();
//        Main.Player P1 = new Main.Player();
//        Main.Player P2 = new Main.Player();
//        Main.Player P3 = new Main.Player();
//        Main.Player P4 = new Main.Player();
//
//        game.players.add(P1);
//        game.players.add(P2);
//        game.players.add(P3);
//        game.players.add(P4);
//        int j = 1;
//        for(Main.Player player : game.players){
//            player.order = j;
//            player.name = "P"+j;
//            player.shields = 0;
//            for(int i = 0; i < 10; i++){
//                int rand_index = rand.nextInt(game.ADdeck.size());
//                player.deck.add(game.ADdeck.get(rand_index));
//                game.ADdeck.remove(rand_index);
//            }
//            j++;
//        }
//        Main.EventCard Prosperity = new Main.EventCard();
//        Prosperity.deck = "EV";
//        Prosperity.type = "Prosperity";
//        Prosperity.value = 2;
//        Prosperity.name = Prosperity.type;
//        game.EVdeck.set(0, Prosperity);
//
//        game.DrawCard(game.EVdeck.get(0), game.players.get(0));
//        for (int i = 0; i < game.players.size(); i++) {
//            assertEquals(12, game.players.get(i).deck.size());
//        }
//    }
//
//    @Test
//    @DisplayName("The game displays the hand of the player ")
//    void RESP_09_test_01(){
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//        assertTrue(game.Display_Hand(game.players.get(0)).contains("Current Hand"));
//    }
//
//    @Test
//    @DisplayName("prompts the player for the position of the next card to delete ")
//    void RESP_09_test_02(){
//        Main game = new Main();
//        String input = "0";
//        StringWriter output =  new StringWriter();
//        game.InitializeDeck();
//        game.InitializePlayers();
//        game.PromptInput(game.players.get(0), new Scanner(input),new PrintWriter(output));
//        assertTrue(output.toString().contains("index:"));
//    }
//
//    @Test
//    @DisplayName("The game deletes the card from the player’s hand and displays the trimmed hand ")
//    void RESP_10_test_01(){
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//        Main.EventCard QueenCard = new Main.EventCard();
//        QueenCard.deck = "EV";
//        QueenCard.type = "Queen";
//        QueenCard.value = 2;
//        QueenCard.name = QueenCard.type;
//        game.EVdeck.set(0,QueenCard);
//
//        Main.Player P1 = game.players.get(0);
//
//        game.DrawCard(game.EVdeck.get(0), P1);
//        while (P1.deck.size() - 12 > 0){
//            game.Trim(P1,P1.deck.get(0));
//        }
//        assertEquals(12, P1.deck.size());
//    }
//
//    @Test
//    @DisplayName("The game prompts a player as to whether or not that player sponsors the current quest. ")
//    void RESP_11_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//        String input = "Yes";
//        Main.Player player = game.PromptSponser(game.players.get(0),input);
//        assertNotNull(player);
//
//    }
//
//    @Test
//    @DisplayName("The game determines eligible participants. ")
//    void RESP_12_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//        HashMap<Main.Player,String> response = new HashMap<>();
//
//        response.put(game.players.get(0), "Yes");
//        response.put(game.players.get(1), "Yes");
//        response.put(game.players.get(2), "Yes");
//        response.put(game.players.get(3), "Yes");
//
//
//        ArrayList<Main.Player> participants = game.GetParticipants(response);
//
//        assertEquals(4,participants.size());
//
//    }
//
//    @Test
//    @DisplayName("The game prompts in turn each eligible participant as to whether they withdraw from the quest or tackle the current stage of the quest. ")
//    void RESP_13_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//       ArrayList<Main.Player> participants = new ArrayList<>();
//       participants.addAll(game.players);
//
//        List<String> inputs = List.of("No", "No", "No", "No");
//        InputStream sysInBackup = System.in;
//        for (String input : inputs) {
//            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//            System.setIn(in); // Set System.in to the current input
//            game.StillParticipate(participants); // Run with the current input
//        }
//        System.setIn(sysInBackup);
//        assertEquals(0,participants.size());
//
//
//    }
//
//    @Test
//    @DisplayName("The game prompts in turn each eligible participant as to whether they withdraw from the quest or tackle the current stage of the quest. ")
//    void RESP_14_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.CreatePlayers();
//
//        Random rand = new Random();
//        ArrayList<Main.Player> participants = new ArrayList<>();
//        for(Main.Player player: game.players) {
//            for (int i = 0; i < 10; i++) {
//                int rand_index = rand.nextInt(game.ADdeck.size());
//                player.deck.add(game.ADdeck.get(rand_index));
//                game.ADdeck.remove(rand_index);
//            }
//            participants.add(player);
//
//        }
//
//
//        game.ParticipantsDraw(participants);
//
//        for(Main.Player player: participants){
//            assertEquals(11,player.deck.size());
//        }
//
//
//
//    }
//
//    @Test
//    @DisplayName("Prompts the sponsor for the position of the next card to include in that stage or ‘Quit’ ")
//    void RESP_15_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//        ArrayList<Integer> expected = new ArrayList<>();
//        expected.add(1);
//        expected.add(-1);
//
//        ArrayList<Integer> actual = new ArrayList<>();
//
//        Main.Player sponser = game.players.get(0);
//
//        InputStream sysInBackup = System.in;
//        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
//        System.setIn(in);
//        actual.add(game.Card_or_Quit(sponser,""));
//        System.setIn(sysInBackup);
//
//        sysInBackup = System.in;
//        in = new ByteArrayInputStream("Quit".getBytes());
//        System.setIn(in);
//        actual.add(game.Card_or_Quit(sponser,""));
//        System.setIn(sysInBackup);
//
//        assertEquals(actual,expected);
//
//
//    }
//
//    @Test
//    @DisplayName("The sponsor enters a necessarily valid position of a card: Test for singular Foe Card ")
//    void RESP_16_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//
//
//        Main.Player P1 = new Main.Player();
//        P1.order = 1;
//        P1.name = "P"+1;
//        P1.shields = 0;
//        for(int i = 0; i < 4; i++){
//            for(Main.AdventureCard card : game.ADdeck){
//                if(card.type.equalsIgnoreCase("F")){
//                    P1.deck.add(card);
//                    game.ADdeck.remove(card);
//                    break;
//                }
//            }
//        }
//
//        ArrayList<String> stage = new ArrayList<>();
//        stage.add("F5");
//
//
//
//        boolean bool = game.input_isValid(P1,0,stage);
//
//        assertFalse(bool);
//    }
//
//    @Test
//    @DisplayName("The sponsor enters a necessarily valid position of a card: Test for singular duplicate cards ")
//    void RESP_16_test_02() {
//        Main game = new Main();
//        game.InitializeDeck();
//
//        Main.Player P1 = new Main.Player();
//        P1.order = 1;
//        P1.name = "P" + 1;
//        P1.shields = 0;
//        for(Main.Card card: game.ADdeck){
//            if(!card.type.equalsIgnoreCase("F")){
//                for(int i = 0; i < 4; i++) {
//                    P1.deck.add(card);
//                }
//                break;
//            }
//        }
//
//        ArrayList<String> stage = new ArrayList<>();
//        stage.add(P1.deck.get(0).name);
//
//
//
//
//        boolean bool = game.input_isValid(P1, 0, stage);
//
//        assertFalse(bool);
//    }
//
//    @Test
//    @DisplayName("the stage has no card associated with it, in which case the game displays ‘A stage cannot be empty’")
//    void RESP_17_test_01() {
//        Main game = new Main();
//
//
//
//        ArrayList<ArrayList<String>> Quest = new ArrayList<>();
//
//
//        ArrayList< String > stage = new ArrayList<>();
//        boolean bool = game.is_StageValid(Quest,stage);
//
//        assertFalse(bool);
//
//    }
//
//    @Test
//    @DisplayName("The stage is of insufficient value compared to the previous one, in which case the game displays ‘Insufficient value for this stage")
//    void RESP_18_test_01() {
//        Main game = new Main();
//
//
//
//        ArrayList<ArrayList<String>> Quest = new ArrayList<>();
//        ArrayList< String > stagetest = new ArrayList<>();
//        stagetest.add("F50");
//        Quest.add(stagetest);
//
//
//        ArrayList< String > stage = new ArrayList<>();
//        stage.add("F5");
//
//        boolean bool = game.is_StageValid(Quest,stage);
//
//        assertFalse(bool);
//
//    }
//
//    @Test
//    @DisplayName("The stage is valid in which case the cards used for this stage are displayed")
//    void RESP_19_test_01() {
////        Main game = new Main();
////        game.InitializeDeck();
////        game.InitializePlayers();
////
////        ArrayList<ArrayList<Main.AdventureCard>> Quest = new ArrayList<>();
////        ArrayList<String> inputs = new ArrayList<>();
////        inputs.add("0");
////        inputs.add("1");
////        inputs.add("2");
////        inputs.add("3");
////        Main.Player sponser = game.players.getFirst();
////        ArrayList< Main.AdventureCard > stage = game.CreateStage(sponser,inputs);
////
////        StringWriter output =  new StringWriter();
////        boolean bool = game.is_StageValid(Quest,stage,new PrintWriter(output));
////
////        assertTrue(output.toString().contains("Current Stage: "));
//
//    }
//
//    @Test
//    @DisplayName("Prompts the participant for the position of the next card to include in the attack or ‘quit’ (to end building this attack)")
//    void RESP_20_test_01() {
////        Main game = new Main();
////        game.InitializeDeck();
////        game.InitializePlayers();
////
////
////        ArrayList<String> inputs = new ArrayList<>();
////        inputs.add("0");
////        inputs.add("3");
////        inputs.add("4");
////
////
////        Main.Player player = game.players.getFirst();
////
////        ArrayList< Main.AdventureCard > stage = game.CreateAttack(player,inputs);
////
////        assertNotNull(stage);
//    }
//
//    @Test
//    @DisplayName("The sponsor enters a necessarily valid position of a card: Test to make sure only adding weapon cards ")
//    void RESP_21_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//
//
//        Main.Player P1 = new Main.Player();
//        P1.order = 1;
//        P1.name = "P"+1;
//        P1.shields = 0;
//        for(int i = 0; i < 4; i++){
//            for(Main.AdventureCard card : game.ADdeck){
//                if(card.type.equalsIgnoreCase("F")){
//                    P1.deck.add(card);
//                    game.ADdeck.remove(card);
//                    break;
//                }
//            }
//        }
//
//        ArrayList<String> attack = new ArrayList<>();
//        assertFalse(game.attackinput_isValid(P1,attack,"0"));
//
//
//
//    }
//
//    @Test
//    @DisplayName("The sponsor enters a necessarily valid position of a card: No dupiclate weapons")
//    void RESP_21_test_02() {
//        Main game = new Main();
//        game.InitializeDeck();
//
//
//        Main.Player P1 = new Main.Player();
//        P1.order = 1;
//        P1.name = "P"+1;
//        P1.shields = 0;
//        for(Main.Card card: game.ADdeck){
//            if(!card.type.equalsIgnoreCase("F")){
//                for(int i = 0; i < 4; i++) {
//                    P1.deck.add(card);
//                }
//                break;
//            }
//        }
//
//
//        ArrayList<String> attack = new ArrayList<>();
//        attack.add(P1.deck.get(0).name);
//        assertFalse(game.attackinput_isValid(P1,attack,"0"));
//
//    }
//
//    @Test
//    @DisplayName("Cards (if any) used for this attack are displayed")
//    void RESP_22_test_01() {
////        Main game = new Main();
////        game.InitializeDeck();
////        game.InitializePlayers();
////
////        Main.Player P1 = new Main.Player();
////        P1.order = 1;
////        P1.name = "P"+1;
////        P1.shields = 0;
////        for(int i = 0; i < 4; i++){
////            for(Main.AdventureCard card : game.ADdeck){
////                if(!card.type.equalsIgnoreCase("F")){
////                    P1.deck.add(card);
////                    game.ADdeck.remove(card);
////                    break;
////                }
////            }
////        }
////
////
////        ArrayList<String> inputs = new ArrayList<>();
////        inputs.add("0");
////        inputs.add("1");
////        inputs.add("2");
////
////
////        Main.Player player = game.players.getFirst();
////        ArrayList<Main.Card> deck = P1.deck;
////        ArrayList< Main.AdventureCard > attack = game.CreateAttack(player,inputs);
////        StringWriter output = new StringWriter();
////        game.Display_Attack(attack,new PrintWriter(output));
////        assertTrue(output.toString().contains("Attack Hand: "));
//    }
//
//    @Test
//    @DisplayName("The game resolves the attack(s) against the current stage: Paticipant loses ")
//    void RESP_23_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//        ArrayList<Main.Player> partcipants = new ArrayList<>();
//        partcipants.add(game.players.get(0));
//
//
//        ArrayList<Main.AdventureCard> stage = new ArrayList<>();
//        stage.add(new Main.AdventureCard("AD","F",50,"F50"));
//
//        ArrayList<Main.AdventureCard> attack = new ArrayList<>();
//        attack.add(new Main.AdventureCard("AD","B",15,"B15"));
//        attack.add(new Main.AdventureCard("AD","E",30,"E30"));
//        assertFalse(game.playerattacksstage(game.players.get(0),stage,attack,partcipants));
//
//
//    }
//
//    @Test
//    @DisplayName("The game resolves the attack(s) against the current stage: Paticipant wins ")
//    void RESP_23_test_02() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//        ArrayList<Main.Player> partcipants = new ArrayList<>();
//        partcipants.add(game.players.get(0));
//
//        ArrayList<Main.AdventureCard> stage = new ArrayList<>();
//        stage.add(new Main.AdventureCard("AD","F",50,"F50"));
//
//        ArrayList<Main.AdventureCard> attack = new ArrayList<>();
//        attack.add(new Main.AdventureCard("AD","B",15,"B15"));
//        attack.add(new Main.AdventureCard("AD","H",10,"H10"));
//        attack.add(new Main.AdventureCard("AD","E",30,"E30"));
//
//        assertTrue(game.playerattacksstage(game.players.get(0),stage,attack,partcipants));
//    }
//
//    @Test
//    @DisplayName("All participants of the current stage have all the cards they used for their attack of the current stage discarded by the game. ")
//    void RESP_24_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//
//
//        Main.Player player = game.players.get(1);
//
//        ArrayList<Main.AdventureCard> attack = new ArrayList<>();
//        attack.add((Main.AdventureCard) player.deck.get(0));
//        attack.add((Main.AdventureCard) player.deck.get(1));
//        attack.add((Main.AdventureCard) player.deck.get(2));
//        game.DiscardPlayersHand(player,attack);
//
//        assertEquals(9,player.deck.size());
//    }
//
//    @Test
//    @DisplayName("Sponser draws the same number of cards + the number of stages, ")
//    void RESP_25_test_01() {
//        Main game = new Main();
//        game.InitializeDeck();
//        game.InitializePlayers();
//        Main.Player sponser = game.players.get(0);
//
//        ArrayList<ArrayList<Main.AdventureCard>> Quest = new ArrayList<>();
//        ArrayList<Main.AdventureCard> stagetest1 = new ArrayList<>();
//        stagetest1.add((Main.AdventureCard) sponser.deck.get(0));
//        stagetest1.add((Main.AdventureCard) sponser.deck.get(1));
//        stagetest1.add((Main.AdventureCard) sponser.deck.get(2));
//        ArrayList<Main.AdventureCard> stagetest2 = new ArrayList<>();
//        stagetest2.add((Main.AdventureCard) sponser.deck.get(3));
//        stagetest2.add((Main.AdventureCard) sponser.deck.get(4));
//        stagetest2.add((Main.AdventureCard) sponser.deck.get(5));
//        ArrayList<Main.AdventureCard> stagetest3 = new ArrayList<>();
//        stagetest3.add((Main.AdventureCard) sponser.deck.get(6));
//        stagetest3.add((Main.AdventureCard) sponser.deck.get(7));
//        stagetest3.add((Main.AdventureCard) sponser.deck.get(8));
//
//        Quest.add(stagetest1);
//        Quest.add(stagetest2);
//        Quest.add(stagetest3);
//
//        game.DiscardSponsor(sponser,Quest);
//        game.DrawSponsor(sponser,Quest);
//
//
//
//        assertEquals(15,sponser.deck.size());
//    }

}

class MainATest {
    @Test
    @DisplayName("A-TEST-01")
    void A_TEST_01(){
        // Initialize the game and the players
        Main game = new Main();
        game.InitializeDeck();
        game.CreatePlayers();

        // Setup the players
        Main.Player P1 = game.getplayers().get(0);
        Main.Player P2 = game.getplayers().get(1);
        Main.Player P3 = game.getplayers().get(2);
        Main.Player P4 = game.getplayers().get(3);

        // Populate players' hands with predefined cards for testing
        P1.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P1.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P1.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P1.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P1.deck.add(new Main.AdventureCard("AD", "D", 5, "D5"));
        P1.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P1.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P1.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P1.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P1.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        P1.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        P1.deck.add(new Main.AdventureCard("AD", "L", 20, "L20"));
        Main.sortPlayerDeck(P1);
        System.out.println(game.Display_Hand(P1));


        P2.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P2.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));

        P2.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P2.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));

        P2.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P2.deck.add(new Main.AdventureCard("AD", "D", 5, "D5"));
        P2.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));

        P2.deck.add(new Main.AdventureCard("AD", "F", 40, "F40"));
        P2.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));

        P2.deck.add(new Main.AdventureCard("AD", "E", 30, "E30"));
        P2.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P2.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        Main.sortPlayerDeck(P2);
        System.out.println(game.Display_Hand(P2));


        P3.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P3.deck.add(new Main.AdventureCard("AD", "D", 5, "D5"));
        P3.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P3.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P3.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P3.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P3.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P3.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        P3.deck.add(new Main.AdventureCard("AD", "L", 20, "L20"));
        Main.sortPlayerDeck(P3);
        System.out.println(game.Display_Hand(P3));

        P4.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P4.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P4.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P4.deck.add(new Main.AdventureCard("AD", "F", 40, "F40"));
        P4.deck.add(new Main.AdventureCard("AD", "D", 5, "D5"));
        P4.deck.add(new Main.AdventureCard("AD", "D", 5, "D5"));
        P4.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P4.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P4.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P4.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        P4.deck.add(new Main.AdventureCard("AD", "L", 20, "L20"));
        P4.deck.add(new Main.AdventureCard("AD", "E", 30, "E30"));
        Main.sortPlayerDeck(P4);
        System.out.println(game.Display_Hand(P4));


        // P1 draws a quest of 4 stages
        game.EVdeck.set(0,new Main.EventCard("EV","Q",4,"Q4"));
        Main.EventCard card = game.GameDraw(P1);

        //Prompt Sponsor
        game.PromptSponser(P1,"No");
        Main.Player sponsor = game.PromptSponser(P2,"Yes");


        //P2 Creates Quest
        ArrayList<ArrayList<String>> QuestInput = new ArrayList<>();
        ArrayList<String> stage =  new ArrayList<>();
        stage.add("F5");
        stage.add("H10");
        stage.add("Quit");
        QuestInput.add(stage);

        stage =  new ArrayList<>();
        stage.add("F15");
        stage.add("S10");
        stage.add("Quit");
        QuestInput.add(stage);

        stage =  new ArrayList<>();
        stage.add("F15");
        stage.add("D5");
        stage.add("B15");
        stage.add("Quit");
        QuestInput.add(stage);

        stage =  new ArrayList<>();
        stage.add("F40");
        stage.add("B15");
        stage.add("Quit");
        QuestInput.add(stage);

        ArrayList<ArrayList<Main.AdventureCard>> Quest = game.CreateQuestFromInput(sponsor, QuestInput);
        System.out.println(game.DisplayQuest(Quest));

//      // Stage 1: P1, P3, and P4 participate
        HashMap<Main.Player,String> participantsresponses = new HashMap<>();
        participantsresponses.put(P1,"Yes");
        participantsresponses.put(P3,"Yes");
        participantsresponses.put(P4,"Yes");
        ArrayList<Main.Player> participants = game.GetParticipants(participantsresponses);


        for(int i = 0; i < Quest.size(); i++){
            HashMap<Main.Player,ArrayList<Main.AdventureCard>> playertoattack = new HashMap<>();
            if(i == 0){
                game.ADdeck.set(0,new Main.AdventureCard("AD","F",30,"F30"));
                game.ADdeck.set(1,new Main.AdventureCard("AD","S",10,"S10"));
                game.ADdeck.set(2,new Main.AdventureCard("AD","B",15,"B15"));
            }
            if(i == 1){
                game.ADdeck.set(0,new Main.AdventureCard("AD","F",10,"F10"));
                game.ADdeck.set(1,new Main.AdventureCard("AD","L",20,"L20"));
                game.ADdeck.set(2,new Main.AdventureCard("AD","L",20,"L20"));
            }
            if(i == 2){
                game.ADdeck.set(0,new Main.AdventureCard("AD","B",15,"B15"));
                game.ADdeck.set(1,new Main.AdventureCard("AD","S",10,"S10"));
            }
            if(i == 3){
                game.ADdeck.set(0,new Main.AdventureCard("AD","F",30,"F30"));
                game.ADdeck.set(1,new Main.AdventureCard("AD","L",20,"L20"));
            }
            game.ParticipantsDraw(participants);
            if(i == 0){
                game.Trim(P1,new Main.AdventureCard("AD","F",5,"F5"));
                game.Trim(P3,new Main.AdventureCard("AD","F",5,"F5"));
                game.Trim(P4,new Main.AdventureCard("AD","F",5,"F5"));

                playertoattack = new HashMap<>();
                ArrayList<String> attack = new ArrayList<>();
                attack.add("D5");
                attack.add("S10");
                playertoattack.put(P1,game.CreateAttack(attack,P1));

                attack = new ArrayList<>();
                attack.add("S10");
                attack.add("D5");
                playertoattack.put(P3,game.CreateAttack(attack,P3));

                attack = new ArrayList<>();
                attack.add("D5");
                attack.add("H10");
                playertoattack.put(P4,game.CreateAttack(attack,P4));
            }
            if(i == 1){
                playertoattack = new HashMap<>();
                ArrayList<String> attack = new ArrayList<>();
                attack.add("H10");
                attack.add("S10");
                playertoattack.put(P1,game.CreateAttack(attack,P1));

                attack = new ArrayList<>();
                attack.add("B15");
                attack.add("S10");
                playertoattack.put(P3,game.CreateAttack(attack,P3));

                attack = new ArrayList<>();
                attack.add("H10");
                attack.add("B15");
                playertoattack.put(P4,game.CreateAttack(attack,P4));
            }
            if(i == 2){
                playertoattack = new HashMap<>();
                ArrayList<String> attack = new ArrayList<>();

                attack.add("L20");
                attack.add("H10");
                attack.add("S10");
                playertoattack.put(P3,game.CreateAttack(attack,P3));

                attack = new ArrayList<>();
                attack.add("B15");
                attack.add("S10");
                attack.add("L20");
                playertoattack.put(P4,game.CreateAttack(attack,P4));
            }
            if( i == 3){
                playertoattack = new HashMap<>();
                ArrayList<String> attack = new ArrayList<>();

                attack.add("B15");
                attack.add("H10");
                attack.add("L20");
                playertoattack.put(P3,game.CreateAttack(attack,P3));

                attack = new ArrayList<>();
                attack.add("D5");
                attack.add("S10");
                attack.add("L20");
                attack.add("E30");
                playertoattack.put(P4,game.CreateAttack(attack,P4));
            }

            game.playerattacksstage(P1,Quest.get(i),playertoattack.get(P1),participants);
            game.playerattacksstage(P3,Quest.get(i),playertoattack.get(P3),participants);
            if(game.playerattacksstage(P4,Quest.get(i),playertoattack.get(P4),participants) && i == Quest.size() - 1){
                game.giveShields(P4,card);
            }
            game.DiscardPlayersHand(P1,playertoattack.get(P1));
            game.DiscardPlayersHand(P3,playertoattack.get(P3));
            game.DiscardPlayersHand(P4,playertoattack.get(P4));

        }

        game.DiscardSponsor(sponsor,Quest);
        game.DrawSponsor(sponsor,Quest);
        while(sponsor.deck.size() > 12){
            game.Trim(sponsor,sponsor.deck.get(0));
        }

        assertEquals(0,P1.shields);
        ArrayList<String> expectedorder = new ArrayList<>();
        expectedorder.add("F5");
        expectedorder.add("F10");
        expectedorder.add("F15");
        expectedorder.add("F15");
        expectedorder.add("F30");
        expectedorder.add("H10");
        expectedorder.add("B15");
        expectedorder.add("B15");
        expectedorder.add("L20");

        for(int j = 0; j < P1.deck.size(); j++){
            assertEquals(expectedorder.get(j), P1.deck.get(j).name);
        }


        assertEquals(0,P3.shields);
        expectedorder = new ArrayList<>();
        expectedorder.add("F5");
        expectedorder.add("F5");
        expectedorder.add("F15");
        expectedorder.add("F30");
        expectedorder.add("S10");
        for(int j = 0; j < P3.deck.size(); j++){
            assertEquals(expectedorder.get(j), P3.deck.get(j).name);
        }

        assertEquals(4,P4.shields);
        expectedorder = new ArrayList<>();
        expectedorder.add("F15");
        expectedorder.add("F15");
        expectedorder.add("F40");
        expectedorder.add("L20");
        for(int j = 0; j < P4.deck.size(); j++){
            assertEquals(expectedorder.get(j), P4.deck.get(j).name);
        }

        assertEquals(12,sponsor.deck.size());

    }
}

