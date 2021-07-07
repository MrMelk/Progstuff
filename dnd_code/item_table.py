import numpy as np
import pandas as pd

table = pd.read_CSV("Loot_Chance.csv")

def Individual_loot(APL, Type, Setting = 3, CR):
    #Different chances based on challenge rating
    if CR <= 8:
        new_Table = table.drop(columns = ["CR_10+", "CR_9"])
    elif CR == 9:
        new_Table = table.drop(columns = ["CR_0_to_8", "CR_10+"])
    elif 10 <= CR:
        new_Table = table.drop(columns = ["CR_0_to_8", "CR_9"])

    
    #decider for if there is loot or not rand <= new_Table CR value gives loot
    rand = np.random.uniform()
    #Gets the targets chance
    target = new_Table.loc[new_Table["Type"] == Type]
    name = target.columns[1]    #Gets the column name of the second column to get the value
    val = target[[name]].values[0][0]   #Must be a better way than this but for now it works


def d12(x):
    s = 0
    for i in range x:
        s += np.random.randint(1, 12)
    return s

def d10(x):
    s = 0
    for i in range x:
        s += np.random.randint(1, 10)
    return s

def d8(x):
    s = 0
    for i in range x:
        s += np.random.randint(1, 8)
    return s

def d6(x):
    s = 0
    for i in range x:
        s += np.random.randint(1, 6)
    return s

def d4(x):
    s = 0
    for i in range x:
        s += np.random.randint(1, 4)
    return s
"""
#Tossing current idea to try for more orderly solution, will return if needed


Monster_type = ["Abberation", "Beast", "Celestial", "Construct", "Dragon", "Elemental", 
"Fey", "Fiend", "Giant", "Humanoid", "Monstrosity", "Ooze", "Plant", "Undead"]






def Individual_Treasure(APL, type, setting, CR):
    if 0 <= CR >= 8:
        Treasure_chance = {"Abberation": 0.01, "Beast": 0.01, "Celestial": 0, "Construct":0.0, "Dragon": 0, "Elemental": 0,
        "Fey": 0.8,  "Fiend": 0.9, "Giant": 0.95, "Humanoid":0.95, "Monstrosity": 0.1, "Ooze": 0.8, "Plant":0.4, "Undead":0.2}
    elif CR == 9:
        Treasure_chance = {"Abberation": 0.4, "Beast": 0.01, "Celestial": 0, "Construct":0.0, "Dragon": 0, "Elemental": 0,
        "Fey": 0.8,  "Fiend": 0.9, "Giant": 0.95, "Humanoid":0.95, "Monstrosity": 0.1, "Ooze": 0.8, "Plant":0.4, "Undead":0.2}
    elif CR >= 10:
        Treasure_chance = {"Abberation": 0.4, "Beast": 0.01, "Celestial": 0.9, "Construct":0.0, "Dragon": 0, "Elemental": 0,
        "Fey": 0.8,  "Fiend": 0.9, "Giant": 0.95, "Humanoid":0.95, "Monstrosity": 0.1, "Ooze": 0.8, "Plant":0.4, "Undead":0.2}

    rand = np.random.uniform()
    Treasure_Amount = {"Abberation": np.random.randint(1,12)+ np.random.randint(1,12),
    "Beast": 1, "Celestial"}

"""