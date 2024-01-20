# Pool Table Game

## Introduction

This source code is implementation for 2022 SOFT2201 A3.
We are recommended you to use ```Java 17```, ```Gradle 7.4```.
## Features

- Pockets and More Coloured Balls

    - The pool table now has pockets whose positions and radius are configurable and specified in the sample JSON configuration files (Note that: sample JSON files could be found in the 'Difficulty Level' part). 

    - At this stage, we consider more configurable coloured balls including red, blue, black, yellow, purple, orange, green and brown. After falling into the pocket, an orange ball and a yellow ball behave the same as a red ball (i.e., disappear immediately), a green ball and a purple ball behave the same as a blue ball (i.e., back to its initial position after the first falling whereas disappear after the second time falling into the pocket), whereas a black ball and a brown ball will be back to its initial position after the first two fallings, while disappearing after the third time falling into the pocket.
    - There is also now a visible player-controlled cue stick which can hit the cue ball with variable velocity.

- Difficulty Level 
    - There are now three difficulty levels in your game including easy, normal and hard, which correspond to configuration files config_easy.json Download config_easy.json, config_normal.json Download config_normal.jsonand config_hard.json Download config_hard.json, respectively.
    - The player can choose a level either by clicking on a button or by selecting from a menu or by clicking on a keyboard key (i.e., you ONLY need to implement this feature through one of these three ways). 
    - You can set the easy level as the default level displayed to the player OR you can ask the player to choose a level before the start of a game.

    - **Attention Please**: you are free to change the values in the sample JSON files whereas you are not allowed to change the structure of the JSON files (i.e., no added, no deleted).

- Time and Score 
    - Duration of the game is clocked until all balls (except the cue ball) are in the pockets (i.e., game wins) or the cue ball falls into a pocket (i.e., game loses). The game must display on the screen a continually updating time (initially at 0:00).
    - The score is calculated when a ball falls into a pocket. The game must display on the screen an updating score (initially at 0) when a ball falls into a pocket during the level. 
    - The ball and its corresponding score after each falling into the pocket can be found in the table:
    _____________

    | Colour | red | yellow	| green	| brown	| blue | purple	| black	| orange |
    |-----|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
    |Score|1|2|3|4|5|6|7|8|




- Undo and Cheat
    - The player can reset the game to an earlier state (including score, time, ball positions) so that a shot can be undo.
    - This undo functionality can be triggered by button, menu or keyboard action (i.e., you ONLY need to implement this feature through one of these three ways).
    - This must be a single state that is not written to disk, and the state reaching by the subsequent undo function overwrites the existing saved state.
    - The player can do a cheating operation to remove all same coloured ball immediately.
        - This functionality can be triggered by button, menu or keyboard action (i.e., you ONLY need to implement this feature through one of these three ways).
        - Take keyboard action as an example only: pressing the key 'b' on the keyboard will immediately remove all blue balls on the table at the cheating moment and add corresponding scores (i.e., 5 score X the number of blue balls on the table at the cheating moment). 
        - Attention Please: the balls will be removed immediately rather than coming back to the table which is different from falling into a pocket (e.g., if a blue ball falls into a pocket at the first time, it will come back to the table, as what we specified in the requirement of A2). 


## Implementations 

**Note 1:** All the difficulty json file placed in resources directory. That easy one will be named as `config_easy.json`. Normal one will be named as `config_normal.json`. Hard one will be named as `config_hard.json`.

**Note 2:** Score updated once ball is disabled.

**Note 3:** For undo section, `z` need to be pressed before all balls are stopped.

**Note 4** Playable zone is now centred on first pocket location
## Commands

* Run: `gradle run` to load default config from resources folder.
* Press ```z``` to roll back. But it has to be pressed by all balls are stopped
* Press `r` to remove all red balls
* Press `y` to remove all yellow balls
* Press `g` to remove all green balls
* Press `b` to remove all brown balls
* Press `e` to remove all blue balls
* Press `p` to remove all purple balls
* Press `l` to remove all black balls
* Press `o` to remove all orange balls
* Generate documentation:`gradle javadoc`