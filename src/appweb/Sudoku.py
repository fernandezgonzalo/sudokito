import random
from copy import deepcopy

class Sudoku(object):

    def __init__(self, dif):
        self.tablero = self.__cleanSudoku()
        self.semilla = self.__cleanSudoku()
        self.dificultad = dif
        self.__gen()

        # self.semilla, self.tablero = self.__gen()

    def __cleanSudoku(self):
        return [ ["0"]*9 for x in xrange(1,10) ]

    def sudokuCompleto(self):
        """Retorna true si el tablero esta completo"""
        for x in xrange(0, 9):
            for y in xrange(0, 9):
                if self.tablero[x][y] == "0":
                    return False
        return True

    def __gen(self):
        while not self.sudokuCompleto():
            listPosibles = []
            self.tablero = self.__cleanSudoku()


            for x in xrange(0, 9):
                for y in xrange(0, 9):
                    listPosibles = self.posibles(x,y)
                    # print "posibles:  ", listPosibles, " en " , x,y
                    if listPosibles != []:
                        self.tablero[x][y] = random.choice(listPosibles)

        # print self.tablero
        #semilla = self.__cleanSudoku()
        self.semilla = deepcopy(self.tablero)

        if self.dificultad == 'Easy':
            cantCellBlankEst = random.choice([40,41,42,43,44,45])
        elif self.dificultad == 'Medium':
            cantCellBlankEst = random.choice([46,47,48,49,50,51,52])
        elif self.dificultad == 'Hard':
            cantCellBlankEst = random.choice([53,54,55,56,57,58])

        print "Se eliminaran: ",cantCellBlankEst
        cantCellBlank = 0

        while cantCellBlank != cantCellBlankEst:
            x = random.choice(xrange(0, 9))
            y = random.choice(xrange(0, 9))

            if self.tablero[x][y] != '0':
                self.semilla[x][y] = '0'
                cantCellBlank += 1

        return self.semilla, self.tablero

    def __vertical(self, j):
        aux = []
        i = 0
        while (i < 9):
            aux.append(self.tablero[i][j])
            i += 1
        return aux

    def printTablero(self):
        for fila in self.tablero:
            print fila

    def toSudokubumSemilla(self):
        tmp = ""
        for fila in self.semilla:
            tmp += ''.join(fila)
        return tmp

    def toSudokubumTablero(self):
        tmp = ""
        for fila in self.tablero:
            tmp += ''.join(fila)
        return tmp

    def asd(self):
        return self.toSudokubumSemilla() + self.toSudokubumTablero()

    def __region(self, i, j):
        aux = []
        if 0<=i<=2:
            if 0<=j<=2:
                aux.append(self.tablero[0][:3])
                aux.append(self.tablero[1][:3])
                aux.append(self.tablero[2][:3])
            elif 3<=j<=5:
                aux.append(self.tablero[0][3:6])
                aux.append(self.tablero[1][3:6])
                aux.append(self.tablero[2][3:6])
            elif 6<=j<=8:
                aux.append(self.tablero[0][6:9])
                aux.append(self.tablero[1][6:9])
                aux.append(self.tablero[2][6:9])

        elif 3<=i<=5:
            if 0<=j<=2:
                aux.append(self.tablero[3][:3])
                aux.append(self.tablero[4][:3])
                aux.append(self.tablero[5][:3])
            elif 3<=j<=5:
                aux.append(self.tablero[3][3:6])
                aux.append(self.tablero[4][3:6])
                aux.append(self.tablero[5][3:6])
            elif 6<=j<=8:
                aux.append(self.tablero[3][6:9])
                aux.append(self.tablero[4][6:9])
                aux.append(self.tablero[5][6:9])

        elif 6<=i<=8:
            if 0<=j<=2:
                aux.append(self.tablero[6][:3])
                aux.append(self.tablero[7][:3])
                aux.append(self.tablero[8][:3])
            elif 3<=j<=5:
                aux.append(self.tablero[6][3:6])
                aux.append(self.tablero[7][3:6])
                aux.append(self.tablero[8][3:6])
            elif 6<=j<=8:
                aux.append(self.tablero[6][6:9])
                aux.append(self.tablero[7][6:9])
                aux.append(self.tablero[8][6:9])
        return aux

    def posibles(self, i, j):
        p = set()
        r = self.__region(i,j)
        p.update(r[0])
        p.update(r[1])
        p.update(r[2])
        p.update(self.__vertical(j))
        p.update(self.tablero[i])
        t = set(['0','1','2','3','4','5','6','7','8','9'])
        return list(p.symmetric_difference(t))

if __name__ == '__main__':
    s = Sudoku('Easy')
    print s.asd()
    # print s.toSudokubumSemilla(), self.toSudokubumTablero()
