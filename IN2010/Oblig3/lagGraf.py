from matplotlib import pyplot as plt

input = input("Skriv inn filnavn: ")
fil = open(input)

tidInsertion = []
tidQuick = []
tidBubble = []
tidMerge = []
lines = fil.readlines()[1:]
for linje in lines:
    tall = linje.split(",")
    tidInsertion.append(int(tall[3]))
    tidQuick.append(int(tall[6]))
    tidBubble.append(int(tall[9]))
    tidMerge.append(int(tall[12]))

plt.plot(tidInsertion, label="Insertion")
plt.plot(tidQuick, label = "Quick")
plt.plot(tidBubble, label = "Merge")
plt.plot(tidMerge, label= "Selection")
plt.xlabel("antall elementer")
plt.ylabel("Kjøretid")
plt.legend()
plt.show()
