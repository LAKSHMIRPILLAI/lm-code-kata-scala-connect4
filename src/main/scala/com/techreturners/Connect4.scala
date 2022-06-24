package com.techreturners
import scala.util.control.Breaks._

class Connect4(grid:(Int,Int),player1:Player,player2:Player) {
    val gridSize:(Int,Int)=grid
    val gridRow:Int=gridSize._1
    val gridCol:Int=gridSize._2

    val gridStatusInitial :Array[Array[String]]=createGrid(gridSize)
    var gridStatus:Array[Array[String]]=gridStatusInitial

   def checkGrid(gridStatus:Array[Array[String]]):String={
       var result:String=""

       breakable{
        for (i<- 0 until gridSize._1;j<- 0 until gridSize._2) {
            val status = gridStatus(i)(j) == "X" || gridStatus(i)(j) =="O"
            if (status) {
                val a = gridStatus(i)(j) == gridStatus(i)(j + 1) && gridStatus(i)(j + 1) == gridStatus(i)(j + 2) && gridStatus(i)(j + 2) == gridStatus(i)(j + 3)
                val b = gridStatus(i)(j) == gridStatus(i + 1)(j) && gridStatus(i + 1)(j) == gridStatus(i + 2)(j) && gridStatus(i + 2)(j) == gridStatus(i + 3)(j)
                val c = gridStatus(i)(j) == gridStatus(i + 1)(j + 1) && gridStatus(i + 1)(j + 1) == gridStatus(i + 2)(j + 2) && gridStatus(i + 2)(j + 2) == gridStatus(i + 3)(j + 3) && j < gridCol-3 && i < gridRow-3
                val d=  gridStatus(i)(j+3) == gridStatus(i + 1)(j +2) && gridStatus(i + 1)(j+2) == gridStatus(i + 2)(j +1) && gridStatus(i + 2)(j +1) == gridStatus(i + 3)(j ) && j < gridCol-3 && i < gridRow-3
                println(a,b,c,d)
                if (a || b || c ||d ) {
                    if (gridStatus(i)(j) == "X") {
                        println("Here")
                        result = "X"
                        break
                    }
                    else if (gridStatus(i)(j) == "O") {
                        println("There")
                        result = "O"
                        break
                    }
                }
            }
        }
       }
      /* breakable {
           Console.println("Enter 2")
           for (i <- gridSize._1 to 0 by -1; j <- gridSize._2 to 0 by -1) {
               val status = gridStatus(i)(j) == "X"|| gridStatus(i)(j) == "O"
               if (status) {
                   val d = gridStatus(i)(j) == gridStatus(i - 1)(j + 1) && gridStatus(i - 1)(j + 1) == gridStatus(i - 2)(j + 2) && gridStatus(i - 2)(j + 2) == gridStatus(i - 3)(j + 3) && i < gridRow && j < gridCol
                   Console.println(d)
                   if (d) {
                       if (gridStatus(i)(j) == "X") {
                           result = "X"
                           break
                       }
                       else if (gridStatus(i)(j) == "O") {
                           result = "O"
                           break
                       }
                   }

               }
           }
       }*/

               result
    }

    def updateGrid(value: String, position: Int, gridStatus: Array[Array[String]]): Array[Array[String]] = {
        //Console.println(s"$position" +gridStatus(position._1)(position._2))
        breakable {
            for (i <- 0 until gridSize._1) {
                if (gridStatus(i)(position) == ".") {
                    gridStatus(i)(position) = value
                    //println(s"$i $position $value")
                    break
                }
            }
        }
        //Console.println(s"$position" +gridStatus(position._1)(position._2))
       /* for (i <- 0 until gridSize._1; j <- 0 until gridSize._2) {
            println(s"($i)($j) ",gridStatus(i)(j))
        }*/
        gridStatus
    }


    def gridCurrentStatus:Array[Array[String]]= gridStatus

    def displayGrid(gridStatus:Array[Array[String]]):Unit={
        for (i<- 0 until  gridSize._1;j<- 0 until  gridSize._2)
        {
          println(s"($i)($j)=${gridStatus(i)(j)}")
        }
    }

    def createGrid(gridSize:(Int,Int)) :Array[Array[String]]={
        val grid=Array.ofDim[String](gridSize._1,gridSize._2)
        for (i<- 0 until  gridSize._1;j<- 0 until  gridSize._2)
        {
            grid(i)(j)="."
            //println(s"($i)($j)=${grid(i)(j)}")
        }
       grid
    }

}
