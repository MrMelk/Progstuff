import numpy as np
#from numpy import numpy.random.randint

Monster_type = ["Abberation", "Beast", "Celestials", "Construct", "Dragon", "Elemental", 
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
    Treasure_Amount = {"Abberation": np.random.randint(1,12)}
