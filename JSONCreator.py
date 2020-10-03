###################################################################################################
#                                                                                                 #
# JSONCreator - Creates the most annoying thing in the world, JSON files of your blocks and items #
# Created by: udison999 - roque-100@hotmail.com - 2020-06-13                                      #
# Fell free to modify the code as much as you want                                                #
#                                                                                                 #
###################################################################################################

import os

### CREATES THE JSON FILES
def createFiles(action, modid, name):
    root = os.path.dirname(os.path.realpath(__file__)) + '\\src\\main\\resources\\assets\\' + modid

    # ITEMS LOGIC
    if action == 1:

        # Model
        filepath = root + '\\models\\item\\' + name + '.json'
        f = open(filepath, 'x')
        f.write('''{
    "parent": "item/handheld",
    "textures": {
        "layer0": "''' + modid + ':items/' + name + '''" 
    }
}''')
        f.close()

        # Lang
        os.system('cls')
        print('Files successfully created!\nHere\'s the statement for your lang file: "item.' + modid + '.' + name + '": ""')

    # BLOCKS LOGIC
    else:

        # Blockstate
        filepath = root + '\\blockstates\\' + name + '.json'
        f = open(filepath, 'x')
        f.write('''{
  "variants": {
    "": { "model": "''' + modid + ':block/' + name + '''" }
  }
}''')
        f.close()

        # Block Model
        filepath = root + '\\models\\block\\' + name + '.json'
        f = open(filepath, 'x')
        f.write('''{
  "parent": "block/cube_all",
  "textures": {
    "all": "''' + modid + ':blocks/' + name + '''"
  }
}''')
        f.close()

        # Block Item
        filepath = root + '\\models\\item\\' + name + '.json'
        f = open(filepath, 'x')
        f.write('''{
  "parent": "''' + modid + ':block/' + name + '''"
}''')
        f.close()

        # Lang
        os.system('cls')
        print('Files successfully created!\nHere\'s the statement for your lang file: "block.' + modid + '.' + name + '": ""')

    os.system('pause')
    os.system('cls')
    


### MAIN FUNCTION
def main():
    modid = input('Insert your modid: ')

    while True:    
        name   = input('Insert your block/item name: ')
        action = int(input('Choose your action (1 - Create ITEM files | 2 - Create BLOCK files | 0 - exit): '))

        if action == 0:
            break
        elif action <= 2:
            createFiles(action, modid, name)

main()