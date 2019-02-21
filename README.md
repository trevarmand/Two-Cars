A recreation of Ketchapp's game "Two Cars", built in Java on MVC design pattern.

RULES:
The screen consists of four lanes, with two cars that occupy two lanes on each half of the screen. Using the arrow keys, the user can toggle the position of the car to switch between its respective lanes. The objective of the game is to score as many points as possible by hitting every circle, and hitting no squares. Collision with any square or failure to collect any circle will end the game.

Replaced former Two-Cars repository.


As of 1/30/2019:
The game has reached a playable state - supporting a randomized and valid spawning algorithm, user control with lane switching and play/pause, as well as score display. Game over functionality was removed while working on the spawning algorithm so I could play the game without starting over constantly. The game's performance, however, was mediocre, and I have decided to use my experience to refactor the model. This involves steps such as unifying the data structure containing circles and squares, and imposing an event-driven relationship between the model and its movers.
