package com.example.travelingdealer

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var printLengthOfListBtn: Button
    private lateinit var deleteNodeBtn: Button
    private lateinit var clearListBtn: Button
    private lateinit var addCustomerToListBtn: Button
    private lateinit var sumOfNodesBtn: Button
    private lateinit var printList: Button

    private var headNode: Node? = null
    private var deleteNodeExampleList = ArrayList<Node>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        observe()
        initData()
    }

    private fun initData() {
        headNode = Node(3, 7)
        headNode?.path = 0.0

        deleteNodeExampleList.add(Node(3, 7))
        deleteNodeExampleList.add(Node(8, 4))
        deleteNodeExampleList.add(Node(6, 5))
        deleteNodeExampleList.add(Node(1, 4))
        deleteNodeExampleList.add(Node(2, 1))
    }

    private fun observe() {
        printLengthOfListBtn.setOnClickListener {
            printLengthOfList()
        }

        deleteNodeBtn.setOnClickListener {
            deleteNodeExampleList.shuffle()
            deleteNode(deleteNodeExampleList[0])
        }

        clearListBtn.setOnClickListener {
            clearList()
        }

        addCustomerToListBtn.setOnClickListener {
            addCustomerToList()
        }

        sumOfNodesBtn.setOnClickListener {
            sumOfNodes()
        }

        printList.setOnClickListener {
            printList()
        }
    }

    private fun initViews() {
        deleteNodeBtn = findViewById(R.id.deleteNodeButton)
        clearListBtn = findViewById(R.id.clearListButton)
        addCustomerToListBtn = findViewById(R.id.addCustomerToListButton)
        sumOfNodesBtn = findViewById(R.id.sumOfNodesButton)
        printList = findViewById(R.id.printListButton)
        printLengthOfListBtn = findViewById(R.id.printLengthOfListButton)
    }

    private fun addCustomerToList() {
        headNode?.appendtoEnd(1, 10)
        headNode?.appendtoEnd(1, 4)
        headNode?.appendtoEnd(2, 1)
        headNode?.appendtoEnd(5, 2)
        headNode?.appendtoEnd(6, 5)
        headNode?.appendtoEnd(8, 4)
        headNode?.appendtoEnd(8, 9)
        headNode?.appendtoEnd(9, 2)
    }


    private fun clearList() {
        headNode?.next = null
        showAlertDialog("All node deleted.", "Clear List")
    }

    private fun deleteNode(data: Node) {
        val deleteResultMessage = headNode?.deleteNode(data)
        showAlertDialog(deleteResultMessage, "Delete Node")
    }

    private fun printLengthOfList() {
        val lengthOfList = headNode?.length()
        showAlertDialog(lengthOfList?.toString(), "Length Of List")
    }

    private fun printList() {
        val printListString = headNode?.printNodes()
        showAlertDialog(printListString, "Print List")
    }

    private fun sumOfNodes() {
        val sumOfNodes = headNode?.sumOfNodes()
        val stringTotalDistance = String.format("%.5f", sumOfNodes?.times(2))
        showAlertDialog("The Total Distance: $stringTotalDistance", "Sum Of Nodes")
    }


    private fun showAlertDialog(message: String?, title: String?) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setTitle(title)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }
}