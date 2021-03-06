import numpy as np
import pandas as pd

table = pd.read_csv("Loot_Chance.csv")

def Individual_loot(APL, Type, CR, Setting = "High"):
    #Different chances based on challenge rating
    if CR <= 8:
        new_Table = table.drop(columns = ["CR_10+", "CR_9"])
    elif CR == 9:
        new_Table = table.drop(columns = ["CR_0_to_8", "CR_10+"])
    elif 10 <= CR:
        new_Table = table.drop(columns = ["CR_0_to_8", "CR_9"])

    Setting = Setting.lower()

    if Setting == "high":
        mul = 3
    elif Setting == "mid":
        mul = 2
    elif Setting == "low":
        mul = 1
    

    #decider for if there is loot or not rand <= new_Table CR value gives loot
    rand = np.random.uniform()
    #Gets the targets chance
    target = new_Table.loc[new_Table["Type"] == Type]
    name = target.columns[1]    #Gets the column name of the second column to get the value
    val = target[[name]].values[0][0]   #Must be a better way than this but for now it works
    
    #Create a roller for dice
    r = Dice()

    if rand <= val:
        if Type == "Aberration":
            return r.d12(2) * mul
        elif Type == "Beast":
            return 1 * min1(mul - 1)
        elif Type == "Celestial":
            return r.d10(2) * APL * min1(mul - 1)
        elif Type == "Construct":
            return 1 * min1(mul - 1)
        elif Type == "Dragon":
            return 0
        elif Type == "Elemental":
            return 0
        elif Type == "Fey":
            return r.d4(1) * APL * mul
        elif Type == "Fiend":
            return r.d8(2) * APL * mul
        elif Type == "Giant":
            return r.d4(2) * APL * mul
        elif Type == "Humanoid":
            return r.d6(2) * APL * min1(mul - 1)  #Need a fix for low setting to be 0.5 instead of 1. Not priority atm
        elif Type == "Monstrosity":
            return r.d4(1) * (mul - 1)
        elif Type == "Ooze":
            return r.d12(2) * APL * min1(mul - 1)
        elif Type == "Plant":
            return r.d10(2) * min1(mul - 1)
        elif Type == "Undead":
            return r.d4(2) * APL * min1(mul - 1)


        
    else:
        return 0

#Does not allow a value to be smaller than 1.
def min1(x):
    if x <=1:
        return 1
    else:
        return x



#Creates an instance of Dice
class Dice():
    #12 sided die
    def d12(self, x):
        s = 0
        for i in range(x):
            s += np.random.randint(1, 12)
        return s

    #Ten sided die
    def d10(self, x):
        s = 0
        for i in range(x):
            s += np.random.randint(1, 10)
        return s

    #Eight sided die
    def d8(self, x):
        s = 0
        for i in range(x):
            s += np.random.randint(1, 8)
        return s

    #Six sided die
    def d6(self, x):
        s = 0
        for i in range(x):
            s += np.random.randint(1, 6)
        return s

    #Four sided die
    def d4(self, x):
        s = 0
        for i in range(x):
            s += np.random.randint(1, 4)
        return s



if __name__ == "__main__":

    roll = Dice()

    print(roll.d4(2))
    print(Individual_loot(5, "Aberration", 10))

