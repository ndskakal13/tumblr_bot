# tumblr_bot
a Tumblr bot which will reply to users and learn from what they say to it. (this project is just in its infancy, and I also am new to machine learning.)

## Features
- Train: give text the bot to train it
- Post: create a post based on the input the bot has received
- Chat: write to the bot and receive a response (essentially a back and forth between train and post)

## How It Works
the bot accepts text input for training. for each word in that input, it creates or updates that word in its database. each word stores a list of words which came before it and came after it and frequency modifiers for selecting the next word in the sequence. when training, the bot takes the input and, for every word in the input, adds or updates that word in its database. when creating a post, the bot chooses a random word from words it has seen start sentences. then, it generates a random number. for each word in that word's afterWords list, it will subtract that afterWord's frequency modifier until the random number reaches zero, meaning that current word will be selected and added to the post. this continues until the random number reaches zero at a word's "<finish>" word, meaning it will end the post. 

## Things to Keep in Mind
- the bot does not currently have persistent storage of word data
- all interactions currently take place in the console. it is NOT currently configured to run with the Java Client (though the class is preliminarily coded, it is untested)
- you must have the Tumblr Java API to use this bot; you can find its documentation and download the .jar file [here](https://tumblr.github.io/jumblr/)
- if you use this bot yourself, you will have to add the tokens and keys provided by Tumblr for your bot to your system environment variables. these are unique to each bot as well as private, so as such they do not appear in my code and I have used the system environment variable approach

*I realize the algorithm used here will not implement a traditional method of AI learning and typical response bots. I will be creating a bot which uses these methods but for my own personal learning I wanted to try this method. As I develop it, I will document it here.*
