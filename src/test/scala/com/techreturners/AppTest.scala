package com.techreturners

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AppTest extends AnyFlatSpec with Matchers{

   "A value given as grid " should "give row and column size of grid" in {

    val player1=new Player("Player1")
    val player2=new Player("Player2")
    val newConnect=new Connect4((6,7),player1,player2)
    assert(newConnect.gridRow== 6)
    assert(newConnect.gridCol== 7)
  }
  "The grid created for a new game" should "have EMPTY . values in fields" in {
    val player1=new Player("Player1")
    val player2=new Player("Player2")
    val newConnect=new Connect4((6,7),player1,player2)
    val newGrid=newConnect.createGrid((6,7))
    assert(newGrid(0)(0)==".")
  }

  "The grid creation for a new game" should "make the same grid as passed to the create grid method" in {
    val player1=new Player("Player1")
    val player2=new Player("Player2")
    val newConnect=new Connect4((6,7),player1,player2)
    val newGrid=newConnect.createGrid((6,7))
    assert(newGrid===newConnect.gridCurrentStatus)
  }
  "The grid value to be updated" should "show value X at position 3,3" in {
    val player1=new Player("Player1")
    val player2=new Player("Player2")
    val newConnect=new Connect4((6,7),player1,player2)
    val grid=newConnect.updateGrid("X",3,newConnect.gridCurrentStatus)
     assert(newConnect.gridStatus(0)(3)=="X")
     assert(grid(0)(3)=="X")
     assert(newConnect.gridCurrentStatus(0)(3)=="X")
     assert(newConnect.gridCurrentStatus(3)(3)!="X")
  }
  "The check grid " should "return X if 4 values in a row have same value of X" in {
    val player1=new Player("Player1")
    val player2=new Player("Player2")
    val newConnect=new Connect4((6,7),player1,player2)

    newConnect.updateGrid("X",3,newConnect.gridCurrentStatus)
    newConnect.updateGrid("X",2,newConnect.gridCurrentStatus)
    newConnect.updateGrid("X",4,newConnect.gridCurrentStatus)
    newConnect.updateGrid("X",5,newConnect.gridCurrentStatus)
    assert(newConnect.gridCurrentStatus(0)(2)=="X")
    assert(newConnect.gridCurrentStatus(0)(3)=="X")
    assert(newConnect.gridCurrentStatus(0)(4)=="X")
    assert(newConnect.gridCurrentStatus(0)(5)=="X")
    assert(newConnect.checkGrid(newConnect.gridCurrentStatus)=="X")
  }

  "The check grid " should "return O if 4 values in a row have same value of O" in {
    val player1=new Player("Player1")
    val player2=new Player("Player2")
    val newConnect=new Connect4((6,7),player1,player2)
    newConnect.updateGrid("O",3,newConnect.gridCurrentStatus)
    newConnect.updateGrid("O",2,newConnect.gridCurrentStatus)
    newConnect.updateGrid("O",4,newConnect.gridCurrentStatus)
    newConnect.updateGrid("O",5,newConnect.gridCurrentStatus)
    assert(newConnect.gridStatus(0)(2)=="O")
    assert(newConnect.gridStatus(0)(3)=="O")
    assert(newConnect.gridStatus(0)(4)=="O")
    assert(newConnect.gridStatus(0)(5)=="O")
    assert(newConnect.checkGrid(newConnect.gridStatus)=="O")
  }
  "The check grid " should "return O if 4 values in a diagonal have same value of O" in {
    val player1=new Player("Player1")
    val player2=new Player("Player2")
    val newConnect=new Connect4((6,7),player1,player2)
    newConnect.updateGrid("X", 0, newConnect.gridCurrentStatus)
    newConnect.updateGrid("X", 0, newConnect.gridCurrentStatus)
    newConnect.updateGrid("X", 0, newConnect.gridCurrentStatus)
    newConnect.updateGrid("O", 0, newConnect.gridCurrentStatus)
    newConnect.updateGrid("X", 1, newConnect.gridCurrentStatus)
    newConnect.updateGrid("O", 1, newConnect.gridCurrentStatus)
    newConnect.updateGrid("O", 1, newConnect.gridCurrentStatus)
    newConnect.updateGrid("X", 2, newConnect.gridCurrentStatus)
    newConnect.updateGrid("O", 2, newConnect.gridCurrentStatus)
    newConnect.updateGrid("O", 3, newConnect.gridCurrentStatus)
    Console.println(newConnect.displayGrid(newConnect.gridStatus))
    assert(newConnect.checkGrid(newConnect.gridStatus) == "O")
  }
}

