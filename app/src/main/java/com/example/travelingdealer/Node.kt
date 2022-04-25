package com.example.travelingdealer

import kotlin.math.pow
import kotlin.math.sqrt

class Node(var x:Int ,var y: Int) {

    var path:Double? =null
    var next:Node?=null
    private var fabricNode:String="Factory(3,7)"

    fun appendtoEnd(x:Int,y: Int){

        val head=this
        val newNode=Node(x,y)
        var temp:Node? = this

        newNode.path=calculateEuclideanDistance(head,newNode)

        while(temp!!.next !=null){
            temp=temp.next
        }
         temp.next=newNode
    }
    private fun calculateEuclideanDistance(Point1: Node, Point2: Node): Double {

        val diffX = (Point1.x - Point2.x).toDouble().pow(2)
        val diffY = (Point1.y - Point2.y).toDouble().pow(2)

        return sqrt((diffX + diffY))
    }

    fun printNodes(): String {

        var printNodes = fabricNode
        val head = this
        var tempNode: Node? = head.next

        while (tempNode != null) {
            val stringPath = String.format("%.5f", tempNode.path)
            printNodes =
                "$printNodes\nCustomer(${tempNode.x}, ${tempNode.y}) - $stringPath"
            tempNode = tempNode.next
        }
        return printNodes
    }

    fun length(): Int {
        var length = 0
        var tempNode: Node? = this

        while (tempNode != null) {
            length++
            tempNode = tempNode.next
        }
        return length
    }

    fun deleteNode(data:Node): String {
        val head = this
        var tempNode: Node? = head
        var prevNode: Node? = null

        if (tempNode != null && tempNode.x == data.x && tempNode.y == data.y) {
            return "You can't delete the factory node"
        }

        while (tempNode != null && !(tempNode.x == data.x && tempNode.y == data.y)) {
            prevNode = tempNode
            tempNode = tempNode.next
        }

        if (tempNode == null) {
            return "($x, $y) node not found"
        }

        prevNode?.next = tempNode.next
        return "($x, $y) node deleted"
    }

    fun sumOfNodes(): Double {
        var sumOfNodes = 0.0
        val head = this
        var tempNode: Node? = head

        while (tempNode != null) {
            sumOfNodes += tempNode.path!!
            tempNode = tempNode.next
        }
        return sumOfNodes
    }
}