import random
with open("scores.txt") as f:
    scores = []
    for line in f:
        let = line[:1]
        num = int(line[2:])
        scores.append((let, num))


with open("tiles.txt") as f:
    tiles = []
    for line in f:
        tiles.append(line.strip())
random.shuffle(tiles)
tiles = tiles[:7]

with open("dictionary.txt") as f:
    dictionary = set()
    for line in f:
        newLine = line.strip()
        dictionary.add(newLine)


def onlyEnglishLetters(word):
    for letter in word:
        if not letter.isalpha():
            return False
    return True

def canBeMade(words,mytiles):
    mytiles_copy = mytiles.copy()
    word = words.upper()
    for letter in word:
        if letter not in mytiles:
            return False
        else:
            mytiles_copy.remove(letter)
    return True


def isValid(word,mytiles,dictionary):
        if not onlyEnglishLetters(word):
            print("Only use English letters...")
            return False
        elif not canBeMade(word,mytiles):
            print("word could not be made with given tiles")
            return False
        word=word.upper()
        if word not in dictionary:
            print("There is no such word in the dictionary")
            return False
        else:
            print("You got it right, this is a valid word")
            return True

def getWordScore(word):
    if isValid(word,mytiles,dictionary)is True:
        word = word.upper()
        word = list(word)
        numbers = []
        for char in word:
            for let, num in scores:
                if let == char:
                    numbers.append(num)
                    break
        total = sum(numbers)
        print("The score of this word",total)
        return total

mytiles = tiles
print("Generating Random Tiles...")
print("Your tiles:",mytiles)
while True:
    word = input("Enter a word (or '&&&' to quit): ")
    if word == "&&&":
        print("Thanks for using this application, better luck next time!!!")
        break
    elif getWordScore(word):
        break
    else:
        print("Please enter a valid word using the given tiles.")
        print(tiles)
