import pandas as pd
import numpy as np
from item_table.py import Dice



#First make it do amount, then make a function or class that handles tables
#and rolls on them.
def Treasure_Hoard(APL, Type, n):
    """
    APL = Average party level
    Type = Monster type/race
    n = amount of party members
    """
    #Dictionary of Treasure Items(TI)
    TI = {}

    roll = Dice()

    if Type == "Aberration":
        TI["Gold Pieces"] = roll.d4(2) * 50 * APL
        TI["Gemstones, 50gp"] =  APL
        TI["Art Objects, 25gp"] =  roll.d4(1)
        TI["Magic Items"] = n
    elif Type == "Beast":
        TI["Gold Pieces"] = 5
        TI["Gemstones, 10gp"] = APL/2
        TI["Art Objects"] = None
        TI["Magic items"] = 1
    elif Type == "Celestial":
        TI["Gold Pieces"] = roll.d4(2)*10*APL
        TI["Gemstones"] = None
        TI["Art Objects, 750gp"] = 1
        TI["Magic items"] = roll.d4(1)
    elif Type == "Construct":
        TI["Gold Pieces"] = roll.d4(2)
        TI["Gemstones, 50gp"] = 1
        TI["Art Objects"] = None
        TI["Magic items"] = roll.d4(1)
    elif Type == "Dragon":
        TI["Gold Pieces"] = roll.d6(4) * 100 * APL
        TI["Gemstones, 100gp"] = roll.d10(2)
        TI["Art Objects, 250gp"] = roll.d6(2)
        TI["Magic items"] = 2 * n
    elif Type == "Elemental":
        TI["Gold Pieces"] = 5
        TI["Gemstones, 10gp"] = APL/2
        TI["Art Objects, 100gp"] = APL
        TI["Magic items"] = 1
    elif Type == "Fey":
        TI["Gold Pieces"] = roll.d4(2) * 100 * APL
        TI["Gemstones, 50gp"] =  APL/2
        TI["Art Objects, 100gp"] = APL
        TI["Magic items"] = roll.d8(1)
    elif Type == "Fiend":
        TI["Gold Pieces"] = roll.d6(2) * 100 * APL
        TI["Gemstones, 100gp"] = APL
        TI["Art Objects, 2500gp"] = 1
        TI["Magic items"] = n
    elif Type == "Giant":
        TI["Gold Pieces"] = roll.d4(2) * 10 * APL
        TI["Gemstones"] = None
        TI["Art Objects, Giants Value"] = APL
        TI["Magic items"] = roll.d8(1)
    elif Type == "Humanoid":
        TI["Gold Pieces"] = roll.d6(1) * 100 * APL
        TI["Gemstones, 500gp"] =  roll.d4(1)
        TI["Art Objects, < 7500gp"] = 1
        TI["Magic items"] = roll.d8(1)
    elif Type == "Monstrosity":
        TI["Gold Pieces"] = 5
        TI["Gemstones, 10gp"] = APL/2
        TI["Art Objects"] = None
        TI["Magic items"] = 1
    elif Type == "Ooze":
        TI["Gold Pieces"] = roll.d4(2)
        TI["Gemstones, 50gp"] = 1
        TI["Art Objects"] = None
        TI["Magic items"] = 1
    elif Type == "Plant":
        TI["Gold Pieces"] = roll.d4(2)
        TI["Gemstones, 50gp"] = 1
        TI["Art Objects"] = None
        TI["Magic items"] = roll.d4(1)
    elif Type == "Undead":
        TI["Gold Pieces"] = roll.d4(2) * 50 * APL
        TI["Gemstones, 750gp"] =  APL/2
        TI["Art Objects, 25gp"] = roll.d4(1)
        TI["Magic items"] = n

    return TI


def find_items(APL, n, tables):
    cursed = 1
    gc = 2
    intense = 3
    normal = 0
