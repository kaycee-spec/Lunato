def find_last_alphabetically():
    word1 = input("Enter the first word: ")
    word2 = input("Enter the second word: ")
    word3 = input("Enter the third word: ")
    
    last_word = max(word1, word2, word3)
    
    print(f"The word that comes last alphabetically is: {last_word}")

find_last_alphabetically()
