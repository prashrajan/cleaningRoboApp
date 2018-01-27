# cleaningRoboApp
This is a fun application web application for finding the shortest and correct path for a robo in a maze :)

You can start the application after importing the as a maven project in any IDE.
There is a swagger endpoint which can be very hand for calling the rest end points and http://localhost:8080/swagger-ui.html
but all the rest points can be called easily with some pulgins like POSTMAN as well

The inputs can be given to robo with a POST Request on http://localhost:8080/robo/bot/input

Rules :-

A household robot wants to transport objects in a room from a point A to a point B. The rooms are always
square and are divided into a grid for the sake of simplicity. The difficulty for the robot now is
to move around in the room without going against a piece of furniture, because that would make him unable to act. The goal is to make the robo reach from source to destination. The robo has a sensor to find out if the next grid cell next to him is block or not in all directions. It also have the possibility to turn 90° in any direction, as well as to move a field in his line of sight. The robot knows its start and finish point, but has
no knowledge of the conditions in a room and must explore this with his sensors. The grid world can vary in size but not so much that increase the computation complexity.

Have a look on SAMPLE_INPUT.md for input and output examples. Input will be in JSON string and output can be list of robo's step to reach the destination.
