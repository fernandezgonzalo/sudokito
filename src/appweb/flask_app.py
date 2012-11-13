from flask import Flask
app = Flask(__name__)

from Sudoku import Sudoku
import random

@app.route('/')
def getRandom():
    return getSudoku(random.choice(['Easy','Medium','Hard']))

@app.route('/<level>')
def getSudoku(level):
   s = Sudoku(level)
   return s.toSudokubumSemilla()

@app.route('/<level>/solve')
def sudokuMasSolve(level):
    s = Sudoku(level)
    return s.asd()


if __name__ == '__main__':
    app.run(debug=True)