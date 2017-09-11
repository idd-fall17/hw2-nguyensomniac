# Assignment 2: Pong text entry

![The completed device](http://i.imgur.com/nAv4QgK.jpg)

I wanted to create something as user-unfriendly as possible without the interface being completely unusable, so I created a Pong text entry device. It works like a single-player game of Pong, but instead of keeping score, it builds a string of letters. There are three buttons: one to move the Pong paddle up, another to move the paddle down, and a third button that adds a space character to the end of the string. Every time the ball hits the paddle, the last character of the string changes, i.e. a space character becomes an ‘a’, an ‘a’ becomes a ‘b’, and so on. Although (in theory) feasible, it takes over 10 minutes to enter the words “hello world.” It’s like watching paint dry.

Demo video: https://youtu.be/CWN5RtkdvbE

![Circuit diagram](http://i.imgur.com/MqdsLzp.png)

To construct the physical controller, I placed three switches on a breadboard. Each switch has one end that connects to a GPIO port (GPIO_10, GPIO_39, and GPIO_128) and another end that connects to ground. When the button is pressed, the circuit connects to ground and the GPIO pin reads back a low value; when it is released, the GPIO pin reads a high value again. I placed the switches in an orientation such that I could hold the breadboard and control the Pong paddle with just my left thumb; because of this, the buttons further up are also closer to the left side of the board. I also taped a piece of paper detailing the control set to the breadboard.
