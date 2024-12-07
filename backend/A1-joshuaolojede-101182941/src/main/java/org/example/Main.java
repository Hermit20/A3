package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081")
public class Main {
    public static void main(String[] args) {
        Main game = new Main();
        game.InitializeDeck();
        game.InitializePlayers();
        game.Playerloop();
    }

    static class Player{
        int order;
        String name;
        ArrayList<AdventureCard> deck = new ArrayList<>();
        int shields;

        public Player(){}
        public Player(Player p){
            order = p.order;
            name = p.name;
            deck.addAll(p.deck);
            shields = p.shields;
        }

        // Getters and setters
        public int getOrder() {
            return order;
        }
        public void setOrder(int order) {
            this.order = order;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<AdventureCard> getDeck() {
            return deck;
        }
        public void setDeck(ArrayList<AdventureCard> deck) {
            this.deck = deck;
        }

        public int getShields() {
            return shields;
        }
        public void setShields(int shields) {
            this.shields = shields;
        }
    }
    static class Card{
        String deck;  // AD = Adventure , EV = Event
        String type;
        int value;
        String name;

        public Card() {}
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDeck() {
            return deck;
        }

        public void setDeck(String deck) {
            this.deck = deck;
        }

    }
    static class AdventureCard extends Card {
        public AdventureCard(){
            super();
        }
        public AdventureCard(String d, String t, int v, String n){
            deck = d;
            type = t;
            value = v;
            name = n;
        }

        // Getters and setters

    }

    static class EventCard extends Card {
        public EventCard(){
            super();
        }

        public EventCard(String d, String t, int v, String n){
            deck = d;
            type = t;
            value = v;
            name = n;
        }
        // Getters and setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDeck() {
            return deck;
        }
        public void setDeck(String deck) {
            this.deck = deck;
        }

    }

    ArrayList<AdventureCard> ADdeck = new ArrayList<>();
    ArrayList<EventCard> EVdeck = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<AdventureCard> ADdeck_dicard = new ArrayList<>();
    ArrayList<EventCard> EVdeck_dicard = new ArrayList<>();

    @GetMapping("/initial")
    public void InitializeDeck(){
        ADdeck.clear();
        EVdeck.clear();
        ADdeck_dicard.clear();
        EVdeck_dicard.clear();
        ADInitializeDeck();
        EVInitializeDeck();
        System.out.println("Initial AD:" + ADdeck.size());
        System.out.println("Initial EV:" + EVdeck.size());
        Collections.shuffle(ADdeck);
        Collections.shuffle(EVdeck);

    }
    public void EVInitializeDeck(){
        for(int i = 0; i < 12; i++){
            EventCard card = new EventCard();
            card.deck = "EV";
            card.type = "Q";
            if(i < 3){
                card.value = 2;
            }
            else if(i < 7){
                card.value = 3;
            }
            else if(i < 10){
                card.value = 4;
            }
            else {
                card.value = 5;
            }
            card.name = card.type + card.value;
            EVdeck.add(card);

        }

        EventCard Plaguecard = new EventCard();
        Plaguecard.deck = "EV";
        Plaguecard.type = "Plague";
        Plaguecard.value = -2;
        Plaguecard.name = Plaguecard.type;
        EVdeck.add(Plaguecard);

        for(int i = 0; i < 2; i++){
            EventCard QueenCard = new EventCard();
            QueenCard.deck = "EV";
            QueenCard.type = "Queen";
            QueenCard.value = 2;
            QueenCard.name = QueenCard.type;
            EVdeck.add(QueenCard);
        }

        for(int i = 0; i < 2; i++){
            EventCard Prosperity = new EventCard();
            Prosperity.deck = "EV";
            Prosperity.type = "Prosperity";
            Prosperity.value = 2;
            Prosperity.name = Prosperity.type;
            EVdeck.add(Prosperity);
        }




    }
    public void ADInitializeDeck(){
        //Foe
        for(int i = 0; i < 50; i++){
            AdventureCard card = new AdventureCard();
            card.deck = "AD";
            card.type = "F";
            if(i < 8){
                card.value = 5;
            }
            else if(i < 15){
                card.value = 10;
            }
            else if(i < 23){
                card.type = "F";
                card.value = 15;
            }
            else if(i < 30){
                card.value = 20;
            }
            else if(i < 37){
                card.value = 25;
            }
            else if(i < 41){
                card.value = 30;
            }
            else if(i < 45){
                card.value = 35;
            }
            else if(i < 47){
                card.value = 40;
            }
            else if(i < 49){
                card.value = 50;
            }
            else {
                card.value = 70;
            }
            card.name = card.type + card.value;
            ADdeck.add(card);
        }

        //Weapons
        for(int i = 0; i < 50; i++) {
            AdventureCard card = new AdventureCard();
            card.deck = "AD";
            if(i < 6){
                card.type = "D";
                card.value = 5;
            }
            else if(i < 18){
                card.type = "H";
                card.value = 10;
            }
            else if(i < 34){
                card.type = "S";
                card.value = 10;
            }
            else if(i < 42){
                card.type = "B";
                card.value = 15;
            }
            else if(i < 48){
                card.type = "L";
                card.value = 20;
            }
            else {
                card.type = "E";
                card.value = 30;
            }
            card.name = card.type + card.value;
            ADdeck.add(card);
        }
    }

    @GetMapping("/decksize")
    public int GetTotalDeckSize(){
        return ADdeck.size() + EVdeck.size();
    }

    @GetMapping("/adventuredeck")
    public List<AdventureCard> getAdventureDeck() {
        return ADdeck;
    }

    @GetMapping("/players")
    public ArrayList<Player> getplayers() {
        return players;
    }

    //Create Players
    public void CreatePlayers(){
        Main.Player P1 = new Main.Player();
        Main.Player P2 = new Main.Player();
        Main.Player P3 = new Main.Player();
        Main.Player P4 = new Main.Player();

        players.add(P1);
        players.add(P2);
        players.add(P3);
        players.add(P4);
        int j=1;
        for(Player player : players){
            player.order = j;
            player.name = "P"+j;
            player.shields = 0;
            j++;
        }
    }

    //Give players cards
    @GetMapping("/initialplayers")
    public void InitializePlayers(){
        players.clear();
        Random rand = new Random();
        CreatePlayers();
        int j = 1;
        for(Player player : players){
            player.order = j;
            player.name = "P"+j;
            player.shields = 0;
            for(int i = 0; i < 12; i++){
                int rand_index = rand.nextInt(ADdeck.size());
                player.deck.add(ADdeck.get(rand_index));
                ADdeck.remove(rand_index);
            }
            sortPlayerDeck(player);
            j++;
        }

        System.out.println("Players AD:" + ADdeck.size());
        System.out.println("Players EV:" + ADdeck.size());
    }
    @PostMapping("/playerdecksize")
    public int GetPlayerDeckSize(@RequestBody Player p){
        return p.deck.size();
    }

    @PostMapping("/playershields")
    public int GetPlayerShields(Player p){
        return p.shields;
    }

    @PostMapping("/grantshield")
    public void GivePlayerShields(Player p, int n){
        p.shields += n;
    }

    //Goes through each players turn
    @PostMapping("/Playerloop")
    public void Playerloop(){
        String win = DisplayWinners();
        while(win.equalsIgnoreCase("No Winners")) {
            for (Player player : players) {
                System.out.println(player.name + " turn: ");
                String str = Display_Hand(player);
                System.out.println(str);
                EventCard card = GameDraw(player);
                DrawCard(card, player);
                TrimLoop();

                System.out.println(player.name + " your turn has ended");
                win = DisplayWinners();

                if (!win.equalsIgnoreCase("No Winners")) {
                    System.out.println(win);
                    break;
                }
                Reshuffledeck();
                sortPlayerDeck(player);
            }
        }
    }

    //Displays winners of the game
    @PostMapping("/Displaywinners")
    public String DisplayWinners(){
        StringBuilder out = new StringBuilder();
        for(Player player : players){
            if(player.shields >= 7){
                out.append("Winners Player id: ").append(player.name).append(" ");
            }
        }
        if(!out.isEmpty()){
            return out.toString();
        }
        return "No Winners";
    }

    //Should return an event card
    @PostMapping("/GameDraw")
    public EventCard GameDraw(@RequestBody Player player){
        EventCard event = EVdeck.get(0);
        EVdeck.remove(event);
        EVdeck_dicard.add(event);
        System.out.println("The next Event Card: "+event.name);
        System.out.println(player.name + " drew a " + event.name + " Card");
        return event;
    }


    //Call player draw create diffrent functions for Q and E card
    @PostMapping("/PlayerDraw")
    public void DrawCard(Card card,Player player){

        if(card.type.equalsIgnoreCase("Q")){
            QuestCard_Drawn(player,card);
        }
        else{
//            EventCard_Drawn(player,card);
        }
    }

    private Player findPlayerByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                return player;
            }
        }
        return null;
    }
    // For when the event card is drawn
    @PostMapping("/event")
    public void EventCard_Drawn(@RequestBody Map<String, Object> payload){
        ObjectMapper objectMapper = new ObjectMapper();
        Player player = objectMapper.convertValue(payload.get("player"), Player.class);
        Card card = objectMapper.convertValue(payload.get("card"), Card.class);
        Player globalPlayer = findPlayerByName(player.name);
        if (globalPlayer == null) {
            throw new RuntimeException("Player not found: " + player.name);
        }
        if(Objects.equals(card.name, "Plague")){

            globalPlayer.shields += card.value;
            if(globalPlayer.shields < 0){
                globalPlayer.shields = 0;
            }
        }

        if(Objects.equals(card.name, "Queen")){
            for(int i = 0 ; i < 2; i++) {
                AdventureCard card1 = ADdeck.get(0);
                globalPlayer.deck.add(card1);
                ADdeck.remove(card1);
            }



        }

        if(Objects.equals(card.name, "Prosperity")){
            for(Player p : players){
                for(int i = 0 ; i < 2; i++) {
                    AdventureCard card1 = ADdeck.get(0);
                    p.deck.add(card1);
                    ADdeck.remove(card1);
                }

            }

        }

//        for(Player a : players){
//            System.out.println(a.deck.size());
//            System.out.println(Display_Hand(a));
//        }
    }

    //Displays the Quest
    @PostMapping("/quest")
    public String DisplayQuest(@RequestBody ArrayList<ArrayList<AdventureCard>> Quest){
        StringBuilder out = new StringBuilder();
        out.append("Quest: { ");
        for(ArrayList<AdventureCard> stage: Quest){
            int index = Quest.indexOf(stage) + 1;
            out.append("Stage ").append(index).append(": { ");
            for (AdventureCard card : stage){
                out.append(card.name).append(" ");
            }
            out.append(" } ");
        }
        out.append(" }");

        return out.toString();
    }

    @PostMapping("/quest_drawn")
    public void QuestCard_Drawn(Player player, Card card){
        Player sponsor = PromptSponser(player,"");
        if(sponsor == null){
            return ;
        }
        ArrayList<ArrayList<String>> QuestString = PromptQuestInput(sponsor, (EventCard) card);
        ArrayList<ArrayList<AdventureCard>> Quest = CreateQuestFromInput(sponsor,QuestString);
        String str = DisplayQuest(Quest);
        System.out.println(str);

        HashMap<Player, String> participantresponces = GetPartipantPrompt(sponsor);
        ArrayList<Player> participants =  GetParticipants(participantresponces);

        for(int i = 0; i < Quest.size(); i++){
            if(i > 0){
                StillParticipate(participants);
            }
            ParticipantsDraw(participants);
            TrimLoop();
            if(participants.isEmpty()){
                DiscardSponsor(sponsor,Quest);
                DrawSponsor(sponsor,Quest);
                TrimLoop();
                break;
            }
            HashMap<Player, ArrayList<AdventureCard>> playettoattack = ParticipantsCreateAttack(participants);
            for(Player participant: playettoattack.keySet()){
                if(playerattacksstage(participant, Quest.get(i), playettoattack.get(participant),participants)){
                    if(i == Quest.size() - 1){
                        System.out.println("Last stage of the Quest " + participant.name + " will be given " + card.value + " shields" );
                        DiscardPlayersHand(participant,playettoattack.get(participant));
                    }
                }
                else{
                    DiscardPlayersHand(participant,playettoattack.get(participant));
//                    participants.remove(participant);
                }

            }
            if(i == Quest.size() - 1){
                giveShieldstoParticipants(participants,card);
            }
            if(!participants.isEmpty() && i == Quest.size() -1){
                DiscardSponsor(sponsor,Quest);
                DrawSponsor(sponsor,Quest);
                TrimLoop();
            }

        }


    }
    public void giveShields(Player player, Card card){
        player.shields += card.value;
    }


    public void giveShieldstoParticipants(ArrayList<Player> participants, Card card){
        for(Player participant: participants){
            giveShields(participant,card);
        }
    }

    @PostMapping("/giveshieldstoparticipants")
    public void giveShieldsToParticipants(@RequestBody Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Player> participants = objectMapper.convertValue(
                payload.get("participants"),
                new TypeReference<ArrayList<Player>>() {}
        );
        Card card = objectMapper.convertValue(payload.get("card"), Card.class);

        // Validate input
        if (participants == null || card == null) {
            throw new IllegalArgumentException("Participants and card must not be null");
        }

        // Update shields for each participant
        for (Player participant : participants) {
            participant.setShields(participant.getShields() + card.getValue());
        }

        // Update the global players list
        for (Player globalPlayer : players) {
            for (Player participant : participants) {
                if (globalPlayer.getName().equalsIgnoreCase(participant.getName())) {
                    globalPlayer.setShields(participant.getShields());
                    break;
                }
            }
        }
    }


    @PostMapping("/stillparticipate")
    public void StillParticipate(ArrayList<Player> participants){

        for(int i =0; i < participants.size(); i++){
            Player player = participants.get(i);
            System.out.println(player.name + " do you wish to participate in the Quest Yes/No");
            Scanner input = new Scanner(System.in);
            if(input.hasNextLine()){
                String inputStr = input.nextLine();
                if(inputStr.equalsIgnoreCase("No")){
                    i--;
                    participants.remove(player);
                }
            }

        }
        participants.sort(Comparator.comparing(player -> player.name));
    }


    public void DiscardPlayersHand(Player player, ArrayList<AdventureCard> attack){
        if(attack == null){
            return;
        }
        for(AdventureCard card: attack){
            ADdeck_dicard.add(card);
            player.deck.remove(card);
        }
    }

    @PostMapping("/discardhand")
    public void DiscardPlayersHand(@RequestBody Map<String, Object> payload) {
        // Deserialize the JSON payload
        ObjectMapper objectMapper = new ObjectMapper();
        Player player = objectMapper.convertValue(payload.get("player"), Player.class);
        ArrayList<AdventureCard> attack = objectMapper.convertValue(
                payload.get("attack"),
                new TypeReference<ArrayList<AdventureCard>>() {}
        );

        // Validate input
        if (player == null || attack == null) {
            throw new IllegalArgumentException("Player and attack must not be null");
        }

        // Discard the attack cards
        for (AdventureCard card : attack) {
            ADdeck_dicard.add(card);
            player.getDeck().remove(card);
        }

        // Update the global players list
        for (Player globalPlayer : players) {
            if (globalPlayer.getName().equalsIgnoreCase(player.getName())) {
                globalPlayer.setDeck(player.getDeck());
                break;
            }
        }
    }

    public boolean playerattacksstage(Player player, ArrayList<AdventureCard> stage, ArrayList<AdventureCard> attack,ArrayList<Player> participants){
        if(attack == null){
            return false;
        }

        int stage_value = 0;
        int attack_value = 0;

        for(AdventureCard card: stage){
            stage_value += card.value;
        }

        for(AdventureCard card: attack){
            attack_value += card.value;
        }

        if(attack_value >= stage_value){
            System.out.println(player.name + " won and is eligible to further participate in this quest");
            return true;
        }

        System.out.println(player.name + " lost and is ineligible to further participate in this quest");
        participants.remove(player);
        return false;
    }

    @PostMapping("/playersattackstage")
    public boolean playerAttacksStage(@RequestBody Map<String, Object> payload) {
        // Deserialize the JSON payload
        ObjectMapper objectMapper = new ObjectMapper();
        Player player = objectMapper.convertValue(payload.get("player"), Player.class);
        ArrayList<AdventureCard> stage = objectMapper.convertValue(
                payload.get("stage"),
                new TypeReference<ArrayList<AdventureCard>>() {}
        );
        ArrayList<AdventureCard> attack = objectMapper.convertValue(
                payload.get("attack"),
                new TypeReference<ArrayList<AdventureCard>>() {}
        );
        ArrayList<Player> participants = objectMapper.convertValue(
                payload.get("participants"),
                new TypeReference<ArrayList<Player>>() {}
        );

        // Validate input
        if (player == null || stage == null || attack == null || participants == null) {
            throw new IllegalArgumentException("Player, stage, attack, and participants must not be null");
        }

        // Calculate stage and attack values
        int stageValue = stage.stream().mapToInt(card -> card.getValue()).sum();
        int attackValue = attack.stream().mapToInt(card -> card.getValue()).sum();

        if (attackValue >= stageValue) {
            System.out.println(player.getName() + " won and is eligible to further participate in this quest");
            return true;
        }

        System.out.println(player.getName() + " lost and is ineligible to further participate in this quest");
        participants.remove(player); // Remove player from participants
        return false;
    }



    public HashMap<Player, ArrayList<AdventureCard>> ParticipantsCreateAttack(ArrayList<Player> participants){
        HashMap<Player, ArrayList<AdventureCard>> playettoattack = new HashMap<>();
        for(Player player: participants){
            ArrayList<String> attackresp = ParticipantAttackPrompt(player);
            ArrayList<AdventureCard> attack = CreateAttack(attackresp,player);
            playettoattack.put(player ,attack);
        }

        return playettoattack;
    }

    @PostMapping("/participantattackprompt")
    public ArrayList<String> ParticipantAttackPrompt(Player player){
        ArrayList<String> attack = new ArrayList<>();
        Player dummyplayer = new Player(player);
        while(true){
            String str = Display_Hand(dummyplayer);
            System.out.println(str);
            System.out.println(dummyplayer.name + " Choose a card to build your attack/Quit ");
            Scanner input = new Scanner(System.in);
            String inputstr = input.nextLine();
            if(inputstr.equalsIgnoreCase("Quit")){
                break;
            }
            if(!attackinput_isValid(dummyplayer,attack,inputstr)){
                continue;
            }
            AdventureCard card = (AdventureCard) dummyplayer.deck.get(Integer.parseInt(inputstr));
            attack.add(card.name);
            Display_Attack(attack,dummyplayer);
        }

        return attack;
    }


    public ArrayList<AdventureCard> CreateAttack(ArrayList<String>  attackresp, Player player){
        ArrayList<AdventureCard> attack = new ArrayList<>();
        for(String card: attackresp){
           AdventureCard card1 = FindCard(player,card);
           attack.add(card1);
        }

        return attack;
    }

    @PostMapping("/createattack")
    public ArrayList<AdventureCard> CreateAttack(@RequestBody Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> attackResp = objectMapper.convertValue(payload.get("attackResp"), new TypeReference<ArrayList<String>>() {});
        Player player = objectMapper.convertValue(payload.get("player"), Player.class);

        if (attackResp == null || player == null) {
            throw new IllegalArgumentException("Attack responses and player must not be null");
        }

        ArrayList<AdventureCard> attack = new ArrayList<>();
        for (String cardName : attackResp) {
            AdventureCard card = FindCard(player, cardName);
            if (card != null) {
                attack.add(card);
            } else {
                throw new IllegalArgumentException("Card not found in player's deck: " + cardName);
            }
        }

        return attack;
    }



    public boolean attackinput_isValid(Player player, ArrayList<String> attack,String input ){
        if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > player.deck.size()){
            System.out.println("Invalid: Index out of bounds");
            return false;
        }
        if(player.deck.get(Integer.parseInt(input)).type.equalsIgnoreCase("F")){
            System.out.println("Invalid: Not a Weapon Card");
            return false;
        }

        AdventureCard currcard = (AdventureCard) player.deck.get(Integer.parseInt(input));
        if(attack.contains(currcard.name)){
            System.out.println("Invalid: Duplicate Card");
            return false;
        }
        return true;
    }

    @PostMapping("/attackinput_isvalid")
    public boolean attackinput_isValid(@RequestBody Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        Player player = objectMapper.convertValue(payload.get("player"), Player.class);
        ArrayList<String> attack = objectMapper.convertValue(payload.get("attack"), new TypeReference<ArrayList<String>>() {});
        String input = objectMapper.convertValue(payload.get("input"), String.class);

        if (player == null || attack == null || input == null) {
            throw new IllegalArgumentException("Player, attack, and input must not be null");
        }

        int inputIndex;
        try {
            inputIndex = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid: Input is not a number");
            return false;
        }

        if (inputIndex < 0 || inputIndex >= player.getDeck().size()) {
            System.out.println("Invalid: Index out of bounds");
            return false;
        }

        Card selectedCard = player.getDeck().get(inputIndex);

        if (selectedCard.getType().equalsIgnoreCase("F")) { // Assuming "W" stands for Weapon card
            System.out.println("New---------");
            Display_Hand(player);
            System.out.println(selectedCard.name);
            System.out.println(selectedCard.type);
            System.out.println(inputIndex);
            System.out.println("Invalid: Not a Weapon Card");
            System.out.println("---------");
            System.out.println("\n");
            return false;
        }

        if (attack.contains(selectedCard.getName())) {
            System.out.println("New---------");
            Display_Hand(player);
            System.out.println(selectedCard.name);
            System.out.println(selectedCard.type);
            System.out.println(inputIndex);
            System.out.println("Invalid: Duplicate Card");
            System.out.println("---------");
            System.out.println("\n");

            return false;
        }

        return true;
    }


    @PostMapping("/display_attack")
    public void Display_Attack(ArrayList< String > attack, Player player){
        System.out.println(player.name+ " Current Attack:");
        for(String card: attack){
            System.out.println(card);
        }
    }


    public void DiscardSponsor(Player sponsor, ArrayList<ArrayList<AdventureCard>> Quest){
        for(ArrayList<AdventureCard> stage : Quest){
            for(AdventureCard card : stage){
                if(sponsor.deck.contains(card)){
                    sponsor.deck.remove(card);
                }
            }
        }
    }

    @PostMapping("/discardsponsor")
    public void DiscardSponsor(@RequestBody Map<String, Object> payload) {
        // Deserialize the sponsor and quest from the payload
        ObjectMapper objectMapper = new ObjectMapper();
        Player sponsor = objectMapper.convertValue(payload.get("sponsor"), Player.class);
        ArrayList<ArrayList<AdventureCard>> quest = objectMapper.convertValue(
                payload.get("quest"),
                new TypeReference<ArrayList<ArrayList<AdventureCard>>>() {}
        );

        if (sponsor == null || quest == null) {
            throw new IllegalArgumentException("Sponsor and quest cannot be null");
        }

        for (ArrayList<AdventureCard> stage : quest) {
            for (AdventureCard card : stage) {
                sponsor.deck.remove(card);
            }
        }

        // Update the global players list
        for (Player globalPlayer : players) {
            if (globalPlayer.getName().equalsIgnoreCase(sponsor.getName())) {
                globalPlayer.setDeck(sponsor.getDeck());
                break;
            }
        }
    }


    public void DrawSponsor(Player sponsor, ArrayList<ArrayList<AdventureCard>> Quest){
        int n = Quest.size();
        for(ArrayList<AdventureCard> stage : Quest){
            n += stage.size();
        }
        for(int i = 0; i < n; i++){
            AdventureCard card = ADdeck.get(0);
            sponsor.deck.add(card);
            ADdeck.remove(card);
            ADdeck_dicard.add(card);
        }
    }

    @PostMapping("/drawsponsor")
    public void DrawSponsor(@RequestBody Map<String, Object> payload) {
        // Deserialize the sponsor and quest from the payload
        ObjectMapper objectMapper = new ObjectMapper();
        Player sponsor = objectMapper.convertValue(payload.get("sponsor"), Player.class);
        ArrayList<ArrayList<AdventureCard>> quest = objectMapper.convertValue(
                payload.get("quest"),
                new TypeReference<ArrayList<ArrayList<AdventureCard>>>() {}
        );

        if (sponsor == null || quest == null) {
            throw new IllegalArgumentException("Sponsor and quest cannot be null");
        }

        // Calculate the total number of cards to draw
        int n = quest.size();
        for (ArrayList<AdventureCard> stage : quest) {
            n += stage.size();
        }

        // Draw n cards for the sponsor
        for (int i = 0; i < n; i++) {
            if (ADdeck.isEmpty()) {
                throw new RuntimeException("Adventure deck is empty");
            }

            AdventureCard card = ADdeck.remove(0);
            sponsor.getDeck().add(card);
            ADdeck_dicard.add(card);
        }

        // Update the global players list
        for (Player globalPlayer : players) {
            if (globalPlayer.getName().equalsIgnoreCase(sponsor.getName())) {
                System.out.println("Sponsor Updated");
                globalPlayer.setDeck(sponsor.getDeck());
                break;
            }
        }
    }

    @PostMapping("/reshuffledeck")
    public void Reshuffledeck(){
        if(ADdeck.size() <= 10){
            ADdeck.addAll(ADdeck_dicard);
            ADdeck_dicard.clear();
        }
        if(EVdeck.size() <= 10){
            EVdeck.addAll(EVdeck_dicard);
            EVdeck_dicard.clear();
        }
    }

    public void ParticipantsDraw(ArrayList<Player> participants){
        for(Player player: participants){
            AdventureCard card = ADdeck.get(0);
            player.deck.add(card);
            ADdeck.remove(card);
            ADdeck_dicard.add(card);
            System.out.println(player.name + " Drew " + card.name);
            sortPlayerDeck(player);
        }
    }

    @PostMapping("/participantsdraw")
    public String ParticipantsDrawnew(@RequestBody ArrayList<Player> participants) {
        StringBuilder out = new StringBuilder();
        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("Participants list cannot be null or empty");
        }

        for (Player player : participants) {
            if (ADdeck.isEmpty()) {
                throw new RuntimeException("Adventure deck is empty");
            }

            // Draw a card from the Adventure Deck
            AdventureCard card = ADdeck.remove(0);
            System.out.println("Actual: " + card.name);
            player.getDeck().add(card);
            ADdeck_dicard.add(card);

            out.append(player.getName()).append(" drew ").append(card.getName()).append("\n");

            // Sort the player's deck
            sortPlayerDeck(player);

            // Update the global participants list
            for (Player globalPlayer : players) {
                if (globalPlayer.getName().equalsIgnoreCase(player.getName())) {
                    globalPlayer.setDeck(player.getDeck());
                    break;
                }
            }
        }
        return out.toString();
    }


    @PostMapping("/display_hand")
    public String Display_Hand(@RequestBody Player P){
        StringBuilder out = new StringBuilder();
        out.append(P.name+" Current Hand: { ");
        for(Card card: P.deck){
            out.append(" (" +P.deck.indexOf(card)).append(": ").append(card.name).append(") ");
        }
        out.append(" }");
        return out.toString();
    }

    @PostMapping("/promptinput")
    public void PromptInput(Player P, Scanner input, PrintWriter output){
        output.println("Enter card index: ");
        String inputStr = input.nextLine();

        int inputNum = Integer.parseInt(inputStr);
        output.println("index: " + inputNum ); output.flush();
    }


    public void Trim(Player P, Card card){
        AdventureCard card2 = new AdventureCard();
        for(Card card1: P.deck){
            if(compare(card1,card)){
                card2 = (AdventureCard) card1;
            }
        }
        ADdeck_dicard.add(card2);
        P.deck.remove(card2);

    }
    @PostMapping("/trim")
    public void Trim(@RequestBody Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        Player player = objectMapper.convertValue(payload.get("player"), Player.class);
        Card card = objectMapper.convertValue(payload.get("card"), Card.class);
        Player globalplayer = findPlayerByName(player.name);
        AdventureCard cardToDiscard = null;
        for (Card cardInDeck : globalplayer.getDeck()) {
            if (compare(cardInDeck, card)) {
                cardToDiscard = (AdventureCard) cardInDeck;
                break;
            }
        }
        System.out.println(cardToDiscard.name);
        if (cardToDiscard != null) {
            ADdeck_dicard.add(cardToDiscard);
            player.deck.remove(cardToDiscard);
            globalplayer.getDeck().remove(cardToDiscard);
        } else {
            throw new IllegalArgumentException("Card not found in player's deck");
        }
    }

    @PostMapping("/compare")
    public boolean compare(Card card1, Card card2){
            if(card1.name.equalsIgnoreCase(card2.name)){
                return true;
            }

            return false;
    }

    @PostMapping("/trimloop")
    public void TrimLoop(){
        for(Player player: players){
            int n = player.deck.size() - 12;
            while (n > 0){
                System.out.println(player.name+" you have too many Cards choose some to trim");
                String str = Display_Hand(player);
                System.out.println(str);

                Scanner input = new Scanner(System.in);
                String inputStr = input.nextLine();
                int index = Integer.parseInt(inputStr);
                boolean isInBounds = index >= 0 && index < player.deck.size();
                if(!isInBounds){
                    continue;
                }
                Card card =  player.deck.get(index);
                Trim(player, card);
                n = player.deck.size() - 12;
            }
        }
    }
    //Looks for a Sponsor for a Quest Card

    public Player PromptSponser(Player p, String input){
        int player_index = players.indexOf(p);
        System.out.println(players.get(player_index).name + " Do you wish to sponsor this quest");

        //Testing
        if (input.equalsIgnoreCase("Yes")){
            System.out.println(players.get(player_index).name + " is sponsoring the quest");
            return players.get(player_index);
        }
        if(input.equalsIgnoreCase("No")){
            System.out.println(players.get(player_index).name + " is not sponsoring the quest");
            return null;
        }

        Scanner player_input = new Scanner(System.in);
        String inputStr = player_input.nextLine();
        if(inputStr.toString().equalsIgnoreCase("Yes")){
            System.out.println(players.get(player_index).name + " is sponsoring the quest");
            return players.get(player_index);
        }
        else{
            System.out.println(players.get(player_index).name + " is not sponsoring the quest");
        }
        while(true){
            player_index++;
            if(player_index == 4){
                player_index = 0;
            }
            if(player_index == players.indexOf(p)){
                break;
            }
            System.out.println(players.get(player_index).name + " Do you wish to sponsor this quest");
            player_input = new Scanner(System.in);
            inputStr = player_input.nextLine();
            if(inputStr.toString().equalsIgnoreCase("Yes")){
                System.out.println(players.get(player_index).name + " is sponsoring the quest");
                return players.get(player_index);
            }
            System.out.println(players.get(player_index).name + " is not sponsoring the quest");
        }
        System.out.println("No one is sponsoring the quest");
        return null;
    }


    public ArrayList<Player> GetParticipants(HashMap<Player, String> responses){
        ArrayList<Player> participants = new ArrayList<>();
        for (Player player: responses.keySet()){
            if(responses.get(player).equalsIgnoreCase("Yes")){
                participants.add(player);
            }
        }
        participants.sort(Comparator.comparing(player -> player.name));
        return participants;
    }

    @PostMapping("/getparticipants")
    public ArrayList<Player> GetParticipants(@RequestBody Map<String, String> responses) {
        // Validate input
        if (responses == null || responses.isEmpty()) {
            throw new IllegalArgumentException("Responses must not be null or empty");
        }

        ArrayList<Player> participants = new ArrayList<>();

        // Iterate through the responses
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            String playerName = entry.getKey();
            String response = entry.getValue();

            // Add the player if their response is "Yes"
            if ("Yes".equalsIgnoreCase(response)) {
                Player player = players.stream()
                        .filter(p -> p.getName().equalsIgnoreCase(playerName))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Player not found: " + playerName));
                participants.add(player);
            }
        }

        // Sort participants alphabetically by name
        participants.sort(Comparator.comparing(Player::getName));

        return participants;
    }



    @PostMapping("/participantprompt")
    public HashMap<Player, String> GetPartipantPrompt(Player sponser){
        HashMap<Player, String> participantsresponces = new HashMap<>();
        for(Player player: players){
            if(sponser.name.equalsIgnoreCase(player.name)){
                continue;
            }
            System.out.println(player.name + " do you wish to participate in " + sponser.name + "'s Quest Yes/No");
            Scanner input = new Scanner(System.in);
            String input1Str = input.nextLine();
            participantsresponces.put(player,input1Str);
        }

        return participantsresponces;
    }



    public ArrayList<ArrayList<AdventureCard>> CreateQuestFromInput(Player sponsor, ArrayList<ArrayList<String>> inputs){
        ArrayList<ArrayList<AdventureCard>> Quest = new ArrayList<>();

        for(ArrayList<String> s: inputs){
            ArrayList<AdventureCard> stage = new ArrayList<>();
            for(String input: s) {
                if (input.equalsIgnoreCase("Quit")) {
                    continue;
                }
                AdventureCard card = FindCard(sponsor, input);
                stage.add(card);
            }
            Quest.add(stage);
        }

        return Quest;
    }

    @PostMapping("/questfrominput")
    public ArrayList<ArrayList<AdventureCard>> CreateQuestFromInput(@RequestBody Map<String, Object> payload) {
        // Deserialize the JSON payload
        ObjectMapper objectMapper = new ObjectMapper();
        Player sponsor = objectMapper.convertValue(payload.get("sponsor"), Player.class);
        ArrayList<ArrayList<String>> inputs = objectMapper.convertValue(
                payload.get("inputs"),
                new TypeReference<ArrayList<ArrayList<String>>>() {}
        );

        // Validate input
        if (sponsor == null || inputs == null) {
            throw new IllegalArgumentException("Sponsor and inputs must not be null");
        }

        ArrayList<ArrayList<AdventureCard>> quest = new ArrayList<>();

        // Process inputs to create the quest
        for (ArrayList<String> inputStage : inputs) {
            ArrayList<AdventureCard> stage = new ArrayList<>();
            for (String input : inputStage) {
                if (input.equalsIgnoreCase("Quit")) {
                    continue; // Skip "Quit" inputs
                }
                AdventureCard card = FindCard(sponsor, input);
                if (card != null) {
                    stage.add(card);
                } else {
                    throw new IllegalArgumentException("Card not found in sponsor's deck: " + input);
                }
            }
            quest.add(stage);
        }

        return quest;
    }



    public AdventureCard FindCard(Player sponsor,String input){
        Player globalsponsor = findPlayerByName(sponsor.name);
        System.out.println(sponsor.name);
        System.out.println(Display_Hand(globalsponsor));
        System.out.println(input);
        for(Card card : globalsponsor.deck){
            if(card.name.equalsIgnoreCase(input)){

                return (AdventureCard) card;
            }
        }

        return null;
    }

    @PostMapping("/promptquestinput")
    public ArrayList<ArrayList<String>> PromptQuestInput(Player sponsor, EventCard card){
        ArrayList<ArrayList<String>> Quest = new ArrayList<>();
        Player dummysponsor = new Player(sponsor);
        for(int i = 0; i < card.value; i++){
            int index = i +1;
            System.out.println("Stage " + index + ": ");
            while(true){
               ArrayList<String> stage = PromptStageInput(dummysponsor);
               if(is_StageValid(Quest,stage)){
                    Quest.add(stage);
                    break;
               }
            }
        }
        return Quest;
    }


    @PostMapping("/promptstageinput")
    public ArrayList<String> PromptStageInput(Player sponsor){
        ArrayList<String> stage = new ArrayList<>();


        while (true){
            int card_index = Card_or_Quit(sponsor,"");
            if(card_index != -1){
                if(!input_isValid(sponsor,card_index,stage)){
                    continue;
                }
                Card dummycard = sponsor.deck.get(card_index);
                stage.add(dummycard.name);
                sponsor.deck.remove(card_index);
                String str = Display_Stage(stage);
                System.out.println(str);
            }
            else{
                stage.add("Quit");
                break;
            }
        }

        return stage;
    }

    @PostMapping("/display_stage")
    public String Display_Stage(ArrayList<String> stage){
        StringBuilder out = new StringBuilder();
        out.append("Current Stage: {");
        for(String card: stage){
            out.append(card).append(" ");
        }
        out.append(" }");

        return out.toString();
    }

    @PostMapping("/card_or_quit")
    public int Card_or_Quit(Player sponsor, String input){
        String s = Display_Hand(sponsor);
        System.out.println(s);
        System.out.println(sponsor.name + " Choose a Card to Add to the Stage or Quit");
        if(!input.equalsIgnoreCase("")){
            return Integer.parseInt(input);
        }

        Scanner input_ = new Scanner(System.in);
        String inputStr = input_.nextLine();
        if(!inputStr.equalsIgnoreCase("Quit")){
            return Integer.parseInt(inputStr);
        }
        return -1;
    }


    public boolean input_isValid(Player player, int input, ArrayList<String> stage  ){
        if(input > player.deck.size()){
            System.out.println("Invalid input: index out of bounds");
            return false;
        }
        Card currcard = player.deck.get(input);
        //Foe
        if(currcard.type.equalsIgnoreCase("F")){
            for(String i: stage){
                if(i.contains("F")){
                    System.out.println("Invalid input: More than one foe");
                    return false;
                }
            }
        }

        if(stage.contains(currcard.name)){
            System.out.println("Invalid input: Duplicate weapon card");
            return false;
        }
        return true;
    }

    @PostMapping("/input_isValid")
    public boolean input_isValid(@RequestBody Map<String, Object> payload) {
        // Parse the payload and perform validation
        ObjectMapper objectMapper = new ObjectMapper();
        Player sponsor = objectMapper.convertValue(payload.get("sponsor"), Player.class);
        int input = (int) payload.get("cardIndex");
        ArrayList<String> stage = objectMapper.convertValue(payload.get("stage"), ArrayList.class);

        if (input >= sponsor.getDeck().size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        Card currCard = sponsor.getDeck().get(input);
        if (currCard.getType().equalsIgnoreCase("F")) {
            for (String s : stage) {
                if (s.contains("F")) {
                    throw new IllegalArgumentException("More than one foe not allowed");
                }
            }
        }
        if(stage.contains(currCard.name)){
            throw new IllegalArgumentException("Duplicate Weapon Card");
        }
        return true;
    }



    public boolean is_StageValid(ArrayList<ArrayList<String>> Quest, ArrayList<String> stage){
        if(stage.isEmpty()){
            System.out.println("Invalid Stage: A stage cannot be empty");
            return false;
        }

        if(!Quest.isEmpty()){
            ArrayList<String>  prev_stage = Quest.get(Quest.size() - 1);
            int prev_value = 0;
            for(String card: prev_stage){
                if(card.equalsIgnoreCase("Quit")){
                    continue;
                }
                int value = Integer.parseInt(card.substring(1));
                prev_value += value;
            }

            int curr_value = 0;
            for (String card: stage){
                if(card.equalsIgnoreCase("Quit")){
                    continue;
                }
                int value = Integer.parseInt(card.substring(1));
                curr_value += value;
            }

            if(curr_value <= prev_value){
                System.out.println("Invalid Stage: Insufficient value for this stage");
                return false;
            }

        }

        System.out.println("Current Stage: ");
        for (String card: stage){
            if(card.equalsIgnoreCase("Quit")){
                continue;
            }
            System.out.println(card);
        }
        return true;
    }





    @PostMapping("/is_StageValid")
    public boolean is_StageValid(@RequestBody Map<String, Object> payload) {
        ArrayList<ArrayList<String>> quest = (ArrayList<ArrayList<String>>) payload.get("quest");
        ArrayList<String> stage = (ArrayList<String>) payload.get("stage");

        if (stage == null || stage.isEmpty()) {
            throw new IllegalArgumentException("Invalid Stage: A stage cannot be empty");
        }

        if (!quest.isEmpty()) {
            ArrayList<String> prevStage = quest.get(quest.size() - 1);

            int prevValue = 0;
            for (String card : prevStage) {
                if (!card.equalsIgnoreCase("Quit")) {
                    prevValue += Integer.parseInt(card.replaceAll("[^0-9]", ""));
                }
            }

            int currValue = 0;
            for (String card : stage) {
                if (!card.equalsIgnoreCase("Quit")) {
                    currValue += Integer.parseInt(card.replaceAll("[^0-9]", ""));
                }
            }

            if (currValue <= prevValue) {
                throw new IllegalArgumentException("Invalid Stage: Insufficient value for this stage");
            }
        }

        return true;
    }




    @PostMapping("/sortdeck")
    public static void sortPlayerDeck(Player player) {
        Collections.sort(player.deck, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                // Define the order of types explicitly
                String order = "FDHSBLE";

                // Compare by type using the defined order
                int typeIndex1 = order.indexOf(c1.type);
                int typeIndex2 = order.indexOf(c2.type);

                if (typeIndex1 != typeIndex2) {
                    return Integer.compare(typeIndex1, typeIndex2);
                }

                // If the type is the same, compare by value
                return Integer.compare(c1.value, c2.value);
            }
        });
    }

    @PostMapping("/setupEVQcard")
    public void setupEvcard(@RequestBody int card){
        EVdeck.set(0,new Main.EventCard("EV","Q",card,"Q"+card));
    }

    @PostMapping("/riggADcards")
    public void cards_are_rigged_for_the_next_stage(@RequestBody Map<String, String> payload){
        ADdeck.set(0,new Main.AdventureCard("AD","F",30,"F30"));
        ADdeck.set(1,new Main.AdventureCard("AD","S",10,"S10"));
        ADdeck.set(2,new Main.AdventureCard("AD","B",15,"B15"));
        ADdeck.set(3,new Main.AdventureCard("AD","F",10,"F10"));
        ADdeck.set(4,new Main.AdventureCard("AD","L",20,"L20"));
        ADdeck.set(5,new Main.AdventureCard("AD","L",20,"L20"));
        ADdeck.set(6,new Main.AdventureCard("AD","B",15,"B15"));
        ADdeck.set(7,new Main.AdventureCard("AD","S",10,"S10"));
        ADdeck.set(8,new Main.AdventureCard("AD","F",30,"F30"));
        ADdeck.set(9,new Main.AdventureCard("AD","L",20,"L20"));


    }
    @PostMapping("/riggADcards2")
    public void cards_are_rigged_for_the_2_stage(){
        ADdeck.set(0,new Main.AdventureCard("AD","F",5,"F5"));
        ADdeck.set(1,new Main.AdventureCard("AD","F",40,"F40"));
        ADdeck.set(2,new Main.AdventureCard("AD","F",10,"F10"));
        ADdeck.set(3,new Main.AdventureCard("AD","F",10,"F10"));
        ADdeck.set(4,new Main.AdventureCard("AD","F",30,"F30"));
        ADdeck.set(5,new Main.AdventureCard("AD","F",30,"F30"));
        ADdeck.set(6,new Main.AdventureCard("AD","F",15,"F15"));
        ADdeck.set(7,new Main.AdventureCard("AD","F",15,"F15"));
        ADdeck.set(8,new Main.AdventureCard("AD","F",20,"F20"));
        ADdeck.set(9,new Main.AdventureCard("AD","F",5,"F5"));
        ADdeck.set(10,new Main.AdventureCard("AD","F",10,"F10"));
        ADdeck.set(11,new Main.AdventureCard("AD","F",15,"F15"));
        ADdeck.set(12,new Main.AdventureCard("AD","F",15,"F15"));
        ADdeck.set(13,new Main.AdventureCard("AD","F",20,"F20"));
        ADdeck.set(14,new Main.AdventureCard("AD","F",20,"F20"));
        ADdeck.set(15,new Main.AdventureCard("AD","F",20,"F20"));
        ADdeck.set(16,new Main.AdventureCard("AD","F",20,"F20"));
        ADdeck.set(17,new Main.AdventureCard("AD","F",25,"F25"));
        ADdeck.set(18,new Main.AdventureCard("AD","F",25,"F25"));
        ADdeck.set(19,new Main.AdventureCard("AD","F",30,"F30"));
        ADdeck.set(20,new Main.AdventureCard("AD","D",5,"D5"));
        ADdeck.set(21,new Main.AdventureCard("AD","D",5,"D5"));
        ADdeck.set(22,new Main.AdventureCard("AD","F",15,"F15"));
        ADdeck.set(23,new Main.AdventureCard("AD","F",15,"F15"));
        ADdeck.set(24,new Main.AdventureCard("AD","F",25,"F25"));
        ADdeck.set(25,new Main.AdventureCard("AD","F",25,"F25"));
        ADdeck.set(26,new Main.AdventureCard("AD","F",20,"F20"));
        ADdeck.set(27,new Main.AdventureCard("AD","F",20,"F20"));
        ADdeck.set(28,new Main.AdventureCard("AD","F",25,"F25"));
        ADdeck.set(29,new Main.AdventureCard("AD","F",30,"F30"));

        ADdeck.set(30,new Main.AdventureCard("AD","S",10,"S10"));
        ADdeck.set(31,new Main.AdventureCard("AD","B",15,"B15"));
        ADdeck.set(32,new Main.AdventureCard("AD","B",15,"B15"));
        ADdeck.set(33,new Main.AdventureCard("AD","L",20,"L20"));






    }


    @PostMapping("/setupRiggedHands")
    public ArrayList<Player> setupRiggedHands( @RequestBody Map<String, String> payload) {
        String player1 = payload.get("player1");
        String player2 = payload.get("player2");
        String player3 = payload.get("player3");
        String player4 = payload.get("player4");
        playersSetUpWithRiggedHands(player1, player2, player3, player4);

        ArrayList<Player> players1 = new ArrayList<>();
        players1.add(players.get(0));
        players1.add(players.get(1));
        players1.add(players.get(2));
        players1.add(players.get(3));


        return players1;
    }

    public void playersSetUpWithRiggedHands(String player1, String player2, String player3, String player4) {
        Player P1 = players.get(0);
        Player P2 = players.get(1);
        Player P3 = players.get(2);
        Player P4 = players.get(3);

        P1.deck.clear();
        P2.deck.clear();
        P3.deck.clear();
        P4.deck.clear();

        setupPlayerDeck(P1, player1);
        setupPlayerDeck(P2, player2);
        setupPlayerDeck(P3, player3);
        setupPlayerDeck(P4, player4);
    }

    private void setupPlayerDeck(Player player, String playerHand) {
        ArrayList<String> cards = new ArrayList<>(Arrays.asList(playerHand.split(" ")));
        for (String card : cards) {
            player.deck.add(new AdventureCard(
                    "AD",
                    card.replaceAll("\\d", ""),
                    Integer.parseInt(card.replaceAll("\\D", "")),
                    card
            ));
        }
        sortPlayerDeck(player);
    }











}