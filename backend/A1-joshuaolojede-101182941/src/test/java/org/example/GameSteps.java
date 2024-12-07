package org.example;

import io.cucumber.java.en.*;
import org.example.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSteps {

    private Main game;
    private static Main.Player sponsor;
    private Main.Player P1;
    private Main.Player P2;
    private Main.Player P3;
    private Main.Player P4;
    private static ArrayList<ArrayList<Main.AdventureCard>> Quest;
    private static ArrayList<Main.Player> participants;
    private static Main.EventCard currentcard;
    private HashMap<Main.Player,ArrayList<Main.AdventureCard>> playertoattack = new HashMap<>();



    @Given("a new game starts")
    public void a_new_game_starts(){ game = new Main(); }

    @When("decks are created")
    public void decks_are_created(){ game.InitializeDeck(); }

    @When("players are set up with rigged hands Player 1: {string} Player 2: {string} Player 3: {string} Player 4: {string}")
    public void players_set_up_with_rigged_hands(String player1, String player2, String player3, String player4){
        game.InitializePlayers();

        P1 = game.getplayers().get(0);
        P2 = game.getplayers().get(1);
        P3 = game.getplayers().get(2);
        P4 = game.getplayers().get(3);

        P1.deck.clear();
        P2.deck.clear();
        P3.deck.clear();
        P4.deck.clear();

        ArrayList<String> playerhand = new ArrayList<>(Arrays.asList(player1.split(" ")));
        for(String card: playerhand){
            P1.deck.add(new Main.AdventureCard("AD",card.replaceAll("\\d", ""),Integer.parseInt(card.replaceAll("\\D", "")),card));
        }
        Main.sortPlayerDeck(P1);

        playerhand = new ArrayList<>(Arrays.asList(player2.split(" ")));
        for(String card: playerhand){
            P2.deck.add(new Main.AdventureCard("AD",card.replaceAll("\\d", ""),Integer.parseInt(card.replaceAll("\\D", "")),card));
        }
        Main.sortPlayerDeck(P2);

        playerhand = new ArrayList<>(Arrays.asList(player3.split(" ")));
        for(String card: playerhand){
            P3.deck.add(new Main.AdventureCard("AD",card.replaceAll("\\d", ""),Integer.parseInt(card.replaceAll("\\D", "")),card));
        }
        Main.sortPlayerDeck(P3);


        playerhand = new ArrayList<>(Arrays.asList(player4.split(" ")));
        for(String card: playerhand){
            P4.deck.add(new Main.AdventureCard("AD",card.replaceAll("\\d", ""),Integer.parseInt(card.replaceAll("\\D", "")),card));
        }
        Main.sortPlayerDeck(P4);
    }

    @When("players are set up with rigged hands for Scenario 2")
    public void players_set_up(){
        game.InitializePlayers();
        P1 = game.getplayers().get(0);
        P2 = game.getplayers().get(1);
        P3 = game.getplayers().get(2);
        P4 = game.getplayers().get(3);

        P1.deck.clear();

        P1.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P1.deck.add(new Main.AdventureCard("AD", "F", 10, "F5"));
        P1.deck.add(new Main.AdventureCard("AD", "F", 10, "F10"));
        P1.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P1.deck.add(new Main.AdventureCard("AD", "F", 30, "F30"));
        P1.deck.add(new Main.AdventureCard("AD", "D", 5, "D5"));
        P1.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P1.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P1.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P1.deck.add(new Main.AdventureCard("AD", "H", 10, "H10"));
        P1.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        P1.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        Main.sortPlayerDeck(P1);

        P2.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P2.deck.add(new Main.AdventureCard("AD", "F", 10, "F10"));
        P2.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P2.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P2.deck.add(new Main.AdventureCard("AD", "F", 20, "F20"));
        P2.deck.add(new Main.AdventureCard("AD", "F", 30, "F30"));
        P2.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P2.deck.add(new Main.AdventureCard("AD", "S", 10, "S10"));
        P2.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        P2.deck.add(new Main.AdventureCard("AD", "B", 15, "B15"));
        P2.deck.add(new Main.AdventureCard("AD", "L", 20, "L20"));
        P2.deck.add(new Main.AdventureCard("AD", "E", 30, "E30"));
        Main.sortPlayerDeck(P2);

        P3.deck.add(new Main.AdventureCard("AD", "F", 5, "F5"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 10, "F10"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 15, "F15"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 20, "F20"));
        P3.deck.add(new Main.AdventureCard("AD", "F", 30, "F30"));
        P3.deck.add(new Main.AdventureCard("AD", "D", 5, "D5"));
        Main.sortPlayerDeck(P3);

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

    }

    @When("Player {int} Draws a Q{int} card")
    public void p1_draws_a_QCard(int player, int card){
        Main.Player currentplayer = game.getplayers().get(player - 1);
        game.EVdeck.set(0,new Main.EventCard("EV","Q",card,"Q"+card));
        currentcard = game.GameDraw(currentplayer);
    }

    @When("Player {int} Draws Event {string}")
    public void player_draws_an_ECard(int player, String card){
        Main.Player currentplayer = game.getplayers().get(player - 1);
        int value = 2;
        if(card.equalsIgnoreCase("Plague")){
            value = -2;
        }
        game.EVdeck.set(0,new Main.EventCard("EV",card,value,card));
        currentcard = game.GameDraw(currentplayer);
        game.DrawCard(currentcard,currentplayer);
        System.out.println("Hello");
    }
    @When("Player {int} is asked to sponsor and says {string}")
    public void p1_is_asked_to_sponsor_but_declines(int player,String response){
        Main.Player currentplayer = game.getplayers().get(player - 1);
        sponsor = game.PromptSponser(currentplayer,response);
    }
    @When("Sponsor builds a 4 stage quest with the following stages {string} {string} {string} {string}")
    public void sponsor_builds_their_Quest(String stage1, String stage2, String stage3, String stage4){
        ArrayList<ArrayList<String>> QuestInput = new ArrayList<>();
        ArrayList<String> stage = new ArrayList<>(Arrays.asList(stage1.split(" ")));
        QuestInput.add(stage);

        stage =  new ArrayList<>(Arrays.asList(stage2.split(" ")));
        QuestInput.add(stage);

        stage =  new ArrayList<>(Arrays.asList(stage3.split(" ")));
        QuestInput.add(stage);

        stage =  new ArrayList<>(Arrays.asList(stage4.split(" ")));
        QuestInput.add(stage);

         Quest = game.CreateQuestFromInput(sponsor, QuestInput);
         System.out.println();
    }

    @When("Sponsor builds a 3 stage quest with the following stages {string} {string} {string}")
    public void sponsor_builds_their_Quest3(String stage1, String stage2, String stage3){
        ArrayList<ArrayList<String>> QuestInput = new ArrayList<>();
        ArrayList<String> stage = new ArrayList<>(Arrays.asList(stage1.split(" ")));
        QuestInput.add(stage);

        stage =  new ArrayList<>(Arrays.asList(stage2.split(" ")));
        QuestInput.add(stage);

        stage =  new ArrayList<>(Arrays.asList(stage3.split(" ")));
        QuestInput.add(stage);


        Quest = game.CreateQuestFromInput(sponsor, QuestInput);
        System.out.println();
    }

    @When("Sponsor builds a 2 stage quest with the following stages {string} {string}")
    public void sponsor_builds_their_Quest(String stage1, String stage2){
        ArrayList<ArrayList<String>> QuestInput = new ArrayList<>();
        ArrayList<String> stage = new ArrayList<>(Arrays.asList(stage1.split(" ")));
        QuestInput.add(stage);

        stage =  new ArrayList<>(Arrays.asList(stage2.split(" ")));
        QuestInput.add(stage);


        Quest = game.CreateQuestFromInput(sponsor, QuestInput);
        System.out.println();
    }

    @When("Players {int}, {int}, and {int} say {string}, {string}, and {string} to participating")
    public void p1_p3_p4_participate_in_a_Stage(int player1, int player2, int player3, String response1, String response2, String response3){
        HashMap<Main.Player,String> participantsresponses = new HashMap<>();
        Main.Player player_1 = game.getplayers().get(player1 - 1);
        Main.Player player_2 = game.getplayers().get(player2 - 1);
        Main.Player player_3 = game.getplayers().get(player3 - 1);
        participantsresponses.put(player_1,response1);
        participantsresponses.put(player_2,response2);
        participantsresponses.put(player_3,response3);
        participants = game.GetParticipants(participantsresponses);
    }

    @When ("Cards are rigged for next stage with Cards {string}, {string}, and {string}")
    public void cards_are_rigged_for_the_next_stage(String card1, String card2, String card3){
        game.ADdeck.set(0,new Main.AdventureCard("AD",card1.replaceAll("\\d", ""),Integer.parseInt(card1.replaceAll("\\D", "")),card1));
        game.ADdeck.set(1,new Main.AdventureCard("AD",card2.replaceAll("\\d", ""),Integer.parseInt(card2.replaceAll("\\D", "")),card2));
        game.ADdeck.set(2,new Main.AdventureCard("AD",card3.replaceAll("\\d", ""),Integer.parseInt(card3.replaceAll("\\D", "")),card3));
    }

    @When("current_participants_draw_cards")
    public void current_participants_draw_card(){
        game.ParticipantsDraw(participants);

    }

    @When("Players {int} {int} {int} trim cards {string} {string} {string}")
    public void p1_p3_p4_trim_rigged_cards(int player1, int player2, int player3, String card1, String card2, String card3){
        Main.Player P1 = game.players.get(player1 - 1);
        Main.Player P3 = game.players.get(player2 - 1);
        Main.Player P4 = game.players.get(player3 - 1);

        game.Trim(P1,new Main.AdventureCard("AD",card1.replaceAll("\\d", ""),Integer.parseInt(card1.replaceAll("\\D", "")),card1));
        game.Trim(P3,new Main.AdventureCard("AD",card2.replaceAll("\\d", ""),Integer.parseInt(card2.replaceAll("\\D", "")),card2));
        game.Trim(P4,new Main.AdventureCard("AD",card3.replaceAll("\\d", ""),Integer.parseInt(card3.replaceAll("\\D", "")),card3));
    }

    @When("Player {int} builds attack {string}")
    public void player_builds_attack(int player, String attackstring){
        ArrayList<String> attack = new ArrayList<>(Arrays.asList(attackstring.split(" ")));
        Main.Player currentplayer = game.players.get(player - 1);
        playertoattack.put(currentplayer,game.CreateAttack(attack,currentplayer));
    }


    @When("participants attack stage{int}")
    public void players_attack_stage(int value){
        int index = value - 1;
        game.playerattacksstage(P1,Quest.get(index),playertoattack.get(P1),participants);
        game.playerattacksstage(P2,Quest.get(index),playertoattack.get(P2),participants);
        game.playerattacksstage(P3,Quest.get(index),playertoattack.get(P3),participants);
        game.playerattacksstage(P4,Quest.get(index),playertoattack.get(P4),participants);
    }

    @When("players_discard_cards")
    public void players_discard_cards(){
        game.DiscardPlayersHand(P1,playertoattack.get(P1));
        game.DiscardPlayersHand(P2,playertoattack.get(P2));
        game.DiscardPlayersHand(P3,playertoattack.get(P3));
        game.DiscardPlayersHand(P4,playertoattack.get(P4));
    }

    @When("Winners are declared")
    public void declare_winners(){
        System.out.println(game.DisplayWinners());
    }

    @When("remaining_participants_are_given_shields")
    public void participants_given_shields(){
        game.giveShieldstoParticipants(participants,currentcard);
    }

    @When("sponsor discards cards used in quest")
    public void sponsor_discards_cards_used_in_quest(){
        game.DiscardSponsor(sponsor,Quest);
    }

    @When("sponsor draws random cards")
    public void sponsor_draws_random_cards(){
        game.DrawSponsor(sponsor,Quest);
        //Create a new Trim function for loops
        while(sponsor.deck.size() > 12){

            game.Trim(sponsor,sponsor.deck.get(sponsor.deck.size() -1));
        }
        System.out.println();
    }
    @Then("Player {int} shields should be {int}")
    public void player_shields_should_be(int player, int value){
        Main.Player currentplayer = game.players.get(player -1);
        assertEquals(value,currentplayer.shields);
    }

    @Then("Winners should be Player {int} and Player {int}")
    public void two_winners(int player, int player1){
        Main.Player p1 = game.players.get(player - 1);
        Main.Player p2 = game.players.get(player1 - 1);

        assertTrue(game.DisplayWinners().contains(p1.name) && game.DisplayWinners().contains(p2.name));
    }

    @Then("Winner should be Player {int}")
    public void one_winners(int player){
        Main.Player p1 = game.players.get(player - 1);

        assertTrue(game.DisplayWinners().contains(p1.name));
    }



    @Then("Player {int} deck size should be {int}")
    public void p2_should_have_cards(int player, int value){
        Main.Player currentplayer = game.players.get(player -1);
        assertEquals(value,currentplayer.deck.size());
    }

    @Then("Player {int} hand in following order {string}")
    public void p1_hand_in_correct_order(int player, String expectedorderstring){
        ArrayList<String> expectedorder = new ArrayList<>(Arrays.asList(expectedorderstring.split(" ")));
        Main.Player currentplayer = game.players.get(player -1);

        for(int j = 0; j < currentplayer.deck.size(); j++){
            assertEquals(expectedorder.get(j), currentplayer.deck.get(j).name);
        }
    }


}
