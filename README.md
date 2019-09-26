# Weaving Pattern Simulation
This project is used to simulate the weaving patterns described in [this paper](http://github.com).

## Installation
To run this program, simply clone or download it and then import it as a Java project to Eclipse or Intellij Idea.

## How To Run
To execute the program, simply run the Main.java file. It will ask you to first enter the starting row and then enter the crossing rule.

#### Starting Row
The character representation of each cell is shown in the table below. There should be no space between two cells.

| Left strand on top  | Right strand on top | Left unpaired strand | Right unpaired strand | Empty cell |
| :---: | :---: | :---: | :---: | :---: |
| "1" | "0" | "/" | "\\" | " " |

#### Crossing Rule
The crossing rule is shown in the table below. You can either enter the decimal value or the **9-bit** binary value.

| Bit | 8th | 7th | 6th | 5th | 4th | 3rd | 2nd | 1st | 0th |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| **Neighboring Cells** | 


## Output Explanation
The output of the program consists of 3 parts. The red box is the generated pattern to the row that the pattern starts to repeat, with the 0th row(starting row) is at bottom. The yellow box is a plain string representation of each row, which is convenient to read and analyze. The green box contains the information of generated pattern, which includes the pattern width, the repeat length, and the total length from the starting row to the row that the pattern starts to repeat.
