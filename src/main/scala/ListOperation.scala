import org.apache.log4j.Logger

import scala.collection.mutable.ListBuffer

class ListOperation {

  def length[A](l: List[A]): Int = l.foldRight(0) {
    (_, c) => c + 1
  }

  def concateList[A](l1: List[A], l2: List[A]): List[A] = {
    val listBuffer = ListBuffer[A]()
    l1.foreach(element => {
      listBuffer += element
    })
    l2.foreach(element => {
      listBuffer += element
    })
    listBuffer.toList
  }

  def splitList[A](l: List[A], f: A => Boolean): (List[A], List[A]) = {

    val listBuffer1 = ListBuffer[A]()
    val listBuffer2 = ListBuffer[A]()

    l.foreach(element =>
      if (f(element)) {
        listBuffer1 += element
      }
      else {
        listBuffer2 += element
      })
    (listBuffer1.toList, listBuffer2.toList)
  }
}

/* def hasSubsequence[A](list:List[A],sub:List[A]):Boolean = {


 }
}*/

object ListOperation extends App {

  val log = Logger.getLogger(this.getClass)
  val myList1 = (1 to 10).toList
  val myList2 = (20 to 11).toList
  val obj = new ListOperation

  //Length of list with foldRight
  log.info(s"Length of the list is ${obj.length(myList1)}\n")
  //Concatenated list
  log.info(s"\nConcatenated list is ${obj.concateList(myList1, myList2)}\n")
  //splitting a list in to two on the basis of given function
  log.info(s"\nTwo lists after split on the basis of given function are: \n")
  log.info(s"${obj.splitList(myList1, isEven(_))}")

  private def isEven(number: Int): Boolean = {
    if (number % 2 == 0) {
      true
    }
    else {
      false
    }
  }
}
