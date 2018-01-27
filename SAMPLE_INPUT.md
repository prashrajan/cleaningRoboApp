Sample input json string for the Robo's world :-

'O' :- means the grid cell is free
'X' :- means the grid cell is blocked and robo can not go there.

initialPosition:- is the initial position of the robo for example if the initial position is 0,0 then it means that robo is on the topleft corner

finalPosition:- is the target position of the robo to which robo has to reach for example if the final position position is 7,7 then it means that robo is on the Bottom right corner

initialDirection:- is the initial direction the robo is facing too for example if the initial direction is 'N' then it means robo is looking towards north. 

{  
  "finalPosition": [
	7,7
  ],
  "initialDirection": "N",
  "initialPosition": [
	0,0
  ],
  "matrix": [
	["O","X","O","O","O","O","O","O"],
	["O","O","O","X","X","X","X","O"],
	["X","X","X","O","O","O","O","O"],
	["X","X","X","O","X","X","X","X"],
	["X","X","X","O","X","X","X","X"],
	["O","X","O","O","X","X","X","X"],
	["O","X","O","X","X","X","X","X"],
	["O","X","O","O","O","O","O","O"]
  ]
}

OutPut:- 

output will a sequence of commands which robo must follow to reach the final position. Robo can change the its direction and move forwad to proceed in the world.

[
  "SOUTH",
  "FORWARD",
  "EAST",
  "FORWARD",
  "FORWARD",
  "NORTH",
  "FORWARD",
  "EAST",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "SOUTH",
  "FORWARD",
  "FORWARD",
  "WEST",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "SOUTH",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "WEST",
  "FORWARD",
  "SOUTH",
  "FORWARD",
  "FORWARD",
  "EAST",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "FORWARD",
  "FORWARD"
]