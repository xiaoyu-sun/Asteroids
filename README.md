# Asteroids
Java Programming Final Project
Xiaoyu Sun
December 5, 2019

For this final project, I extended the Asteroids base code and created my own version of Asteroids. My version mainly added the following features.

(To launch the game, run `controller/Game.java`)

## Debris
When a small asteroid is hit (by a friend), it is shattered into several pieces of debris. Debris does not interact with anything else; it is simply a Movable displayed on the screen for a very short time.

## NewShipFloater
When the Falcon collides with a NewShipFloater, the number of falcons remaining would be incremented. In other words, the player gets an extra life.

## Nuissance
This is a foe which is generated every given amount of time, at a random location on the screen. It approaches the falcon quickly, so I restrict its initial location to be at least 500 units away from the falcon, so that the player has enough time to react.

## Score
The player gets points for hitting different kinds of foes. The total score is displayed in the upper-left corner.

## Ghost
This kind of foe is randomly generated on the screen, and can fire a weapon called HeatSeekingMissile.

## HeatSeekingMissile
This weapon is fired by the Ghost. It is directly aimed at and always oriented towards the Falcon. It has a pink color.

## Shield
When the player presses the A key, a shield (if available) will be activated for the Falcon. When the Falcon is protected by a shield, it would be displayed in cyan, rather than white. The shield will protect the Falcon when the Falcon crashes into a Foe next time, and then the shield would be destroyed. Shields cannot be "inherited" when the current falcon is killed. In other words, whenever a new falcon is spawned, the player has to collect shields from scratch.

## ShieldFloater
When the Falcon hits this floater of cyan color, a new shield will be available for use. The total number of shields remaining is displayed in the upper-left corner, right under the score.
