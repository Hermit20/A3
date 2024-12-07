Feature: A2_Scenarios

  Scenario: A1_Scenario
    Given a new game starts
    And decks are created
    And players are set up with rigged hands Player 1: "F5 F5 F15 F15 D5 S10 S10 H10 H10 B15 B15 L20" Player 2: "F5 H10 F15 S10 F15 D5 B15 F40 B15 F40 B15 E30 F5 H10" Player 3: "F5 F5 F5 F15 D5 S10 S10 S10 H10 H10 B15 L20" Player 4: "F5 F15 F15 F40 D5 D5 S10 H10 H10 B15 L20 E30"
    When Player 1 Draws a Q4 card
    And Player 1 is asked to sponsor and says "No"
    And Player 2 is asked to sponsor and says "Yes"
    And Sponsor builds a 4 stage quest with the following stages "F5 H10" "F15 S10" "F15 D5 B15" "F40 B15"
    And Players 1, 3, and 4 say "Yes", "Yes", and "Yes" to participating
    And Cards are rigged for next stage with Cards "F30", "S10", and "B15"
    And current_participants_draw_cards
    And Players 1 3 4 trim cards "F5" "F5" "F5"
    And Player 1 builds attack "D5 S10"
    And Player 3 builds attack "S10 D5"
    And Player 4 builds attack "D5 H10"
    And participants attack stage1
    And players_discard_cards
    And Players 1, 3, and 4 say "Yes", "Yes", and "Yes" to participating
    And Cards are rigged for next stage with Cards "F10", "L20", and "L20"
    And current_participants_draw_cards
    And Player 1 builds attack "H10 S10"
    And Player 3 builds attack "B15 S10"
    And Player 4 builds attack "H10 B15"
    And participants attack stage2
    And players_discard_cards
    And Cards are rigged for next stage with Cards "B15", "S10", and "D5"
    And current_participants_draw_cards
    And Player 3 builds attack "L20 H10 S10"
    And Player 4 builds attack "B15 S10 L20"
    And participants attack stage3
    And players_discard_cards
    And Cards are rigged for next stage with Cards "F30", "L20", and "D5"
    And current_participants_draw_cards
    And Player 3 builds attack "B15 H10 L20"
    And Player 4 builds attack "D5 S10 L20 E30"
    And participants attack stage4
    And players_discard_cards
    And remaining_participants_are_given_shields
    And sponsor discards cards used in quest
    And sponsor draws random cards
    Then Player 1 shields should be 0
    And Player 3 shields should be 0
    And Player 4 shields should be 4
    And Player 2 deck size should be 12
    And Player 1 hand in following order "F5 F10 F15 F15 F30 H10 B15 B15 L20"
    And Player 3 hand in following order "F5 F5 F15 F30 S10"
    And Player 4 hand in following order "F15 F15 F40 L20"


  Scenario: 2winner_game_2winner_quest
    Given a new game starts
    And decks are created
    And players are set up with rigged hands Player 1: "F5 F5 F10 F15 F30 D5 S10 S10 H10 H10 B15 B15" Player 2: "F5 F10 F15 F15 F20 F30 S10 S10 B15 B15 L20 E30" Player 3: "F5 F10 F15 F15 F20 F30 D5 S10 H10 B15 L20 L20" Player 4: "F5 F10 F15 F15 F20 F30 D5 H10 H10 B15 B15 L20"
    When Player 1 Draws a Q4 card
    And Player 1 is asked to sponsor and says "Yes"
    And Sponsor builds a 4 stage quest with the following stages "F10" "F10 D5" "F15 S10" "F30"
    And Players 2, 3, and 4 say "Yes", "Yes", and "Yes" to participating
    And Cards are rigged for next stage with Cards "H10", "F5", and "H10"
    And current_participants_draw_cards
    And Players 2 3 4 trim cards "F5" "F30" "F5"
    And Player 2 builds attack "S10"
    And Player 3 builds attack "D5"
    And Player 4 builds attack "H10"
    And participants attack stage1
    And players_discard_cards
    And Cards are rigged for next stage with Cards "B15", "D5", and "D5"
    And current_participants_draw_cards
    And Player 2 builds attack "B15"
    And Player 4 builds attack "L20"
    And participants attack stage2
    And players_discard_cards
    And Cards are rigged for next stage with Cards "D5", "L20", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "S10 B15"
    And Player 4 builds attack "H10 B15"
    And participants attack stage3
    And players_discard_cards
    And Cards are rigged for next stage with Cards "S10", "B15", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "E30"
    And Player 4 builds attack "B15 D5 H10"
    And players_discard_cards
    And remaining_participants_are_given_shields
    And sponsor discards cards used in quest
    And sponsor draws random cards
    And Player 2 Draws a Q3 card
    And Player 2 is asked to sponsor and says "No"
    And Player 3 is asked to sponsor and says "Yes"
    And Sponsor builds a 3 stage quest with the following stages "F5" "F10" "F15"
    And Players 1, 2, and 4 say "No", "Yes", and "Yes" to participating
    And Cards are rigged for next stage with Cards "F5", "H10", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "H10"
    And Player 4 builds attack "D5"
    And participants attack stage1
    And players_discard_cards
    And Cards are rigged for next stage with Cards "F15", "F5", and "D5"
    And current_participants_draw_cards
    And Player 2 builds attack "B15"
    And Player 4 builds attack "L20"
    And participants attack stage2
    And players_discard_cards
    And Cards are rigged for next stage with Cards "F15", "F5", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "L20"
    And Player 4 builds attack "B15 H10"
    And participants attack stage3
    And players_discard_cards
    And remaining_participants_are_given_shields
    And sponsor discards cards used in quest
    And sponsor draws random cards
    And Winners are declared
    Then Player 2 shields should be 7
    And Player 4 shields should be 7
    And Player 3 shields should be 0
    And Player 1 shields should be 0
    And Player 1 deck size should be 12
    And Player 3 deck size should be 12
    And Winners should be Player 2 and Player 4

  Scenario: 1winner_game_with_events
    Given a new game starts
    And decks are created
    And players are set up with rigged hands Player 1: "F5 F10 F15 F15 F20 F25 F30 F40 D5 H10 B15 L20" Player 2: "F5 F10 F15 F20 S10 H10 B15 B15 L20 L20 L20 E30" Player 3: "F5 F10 F15 F20 D5 D5 D5 B15 B15 L20 L20 E30" Player 4: "F5 F10 F15 D5 H10 H10 H10 S10 S10 B15 B15 L20"
    And Player 1 Draws a Q4 card
    And Player 1 is asked to sponsor and says "Yes"
    And Sponsor builds a 4 stage quest with the following stages "F5 D5" "F10 H10" "F15 B15" "F40"
    And Players 2, 3, and 4 say "Yes", "Yes", and "Yes" to participating
    And Cards are rigged for next stage with Cards "H10", "B15", and "D5"
    And current_participants_draw_cards
    And Players 2 3 4 trim cards "F5" "F5" "F5"
    And Player 2 builds attack "S10"
    And Player 3 builds attack "B15"
    And Player 4 builds attack "H10"
    And participants attack stage1
    And players_discard_cards
    And Cards are rigged for next stage with Cards "B15", "L20", and "D5"
    And current_participants_draw_cards
    And Player 2 builds attack "L20"
    And Player 3 builds attack "L20 D5"
    And Player 4 builds attack "H10 S10"
    And participants attack stage2
    And players_discard_cards
    And Cards are rigged for next stage with Cards "D5", "D5", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "E30"
    And Player 3 builds attack "E30 D5"
    And Player 4 builds attack "B15 H10 D5"
    And participants attack stage3
    And players_discard_cards
    And Cards are rigged for next stage with Cards "F5", "B15", and "F10"
    And current_participants_draw_cards
    And Player 2 builds attack "L20 B15 H10"
    And Player 3 builds attack "B15 L20 D5"
    And Player 4 builds attack "L20 B15 S10"
    And participants attack stage4
    And players_discard_cards
    And remaining_participants_are_given_shields
    And sponsor discards cards used in quest
    And sponsor draws random cards
    And Player 2 Draws Event "Plague"
    And Player 3 Draws Event "Prosperity"
    And Player 4 Draws Event "Queen"
    Then Player 2 deck size should be 11
    And Player 3 deck size should be 9
    And Player 4 deck size should be 10
    And Player 1 Draws a Q3 card
    And Player 1 is asked to sponsor and says "Yes"
    And Sponsor builds a 3 stage quest with the following stages "F15" "F20" "F25"
    And Players 2, 3, and 4 say "Yes", "Yes", and "Yes" to participating
    And Cards are rigged for next stage with Cards "D5", "H10", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "B15"
    And Player 3 builds attack "B15"
    And Player 4 builds attack "D5"
    And participants attack stage1
    And players_discard_cards
    And Cards are rigged for next stage with Cards "F5", "F5", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "L20"
    And Player 3 builds attack "L20"
    And participants attack stage2
    And players_discard_cards
    And Cards are rigged for next stage with Cards "F5", "F5", and "F5"
    And current_participants_draw_cards
    And Player 2 builds attack "H10 B15"
    And Player 3 builds attack "B15 H10"
    And participants attack stage2
    And players_discard_cards
    And remaining_participants_are_given_shields
    And sponsor discards cards used in quest
    And sponsor draws random cards
    And Winners are declared
    And Player 3 shields should be 7
    And Player 2 shields should be 5
    And Player 4 shields should be 4
    And Winner should be Player 3

  Scenario: 0_winner_quest
    Given a new game starts
    And decks are created
    And players are set up with rigged hands Player 1: "F5 F10 F15 F15 F20 F25 F30 F40 D5 H10 B15 L20" Player 2: "F5 F10 F15 F20 S10 H10 B15 B15 L20 L20 L20 E30" Player 3: "F5 F10 F15 F20 D5 D5 D5 B15 B15 L20 L20 E30" Player 4: "F5 F10 F15 D5 H10 H10 H10 S10 S10 B15 B15 L20"
    And Player 1 Draws a Q2 card
    And Player 1 is asked to sponsor and says "Yes"
    And Sponsor builds a 2 stage quest with the following stages "F30" "F40"
    And Players 2, 3, and 4 say "Yes", "Yes", and "Yes" to participating
    And Cards are rigged for next stage with Cards "H10", "B15", and "D5"
    And current_participants_draw_cards
    And Players 2 3 4 trim cards "F5" "F5" "F5"
    And Player 2 builds attack "S10"
    And Player 3 builds attack "D5"
    And Player 4 builds attack "D5"
    And participants attack stage1
    And players_discard_cards
    And remaining_participants_are_given_shields
    And sponsor discards cards used in quest
    And sponsor draws random cards
    Then Player 1 shields should be 0
    And Player 2 shields should be 0
    And Player 3 shields should be 0
    And Player 4 shields should be 0
    And Player 1 deck size should be 12
