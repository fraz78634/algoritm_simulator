package com.fraz7.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.getColor
import android.view.*
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.animal_tickt.view.*
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {


    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)



        listOfAnimals.add(Animal("Sort",0,true ))
        listOfAnimals.add(Animal("Bubble Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Insertion Sort",R.drawable.book,false ))
        listOfAnimals.add(Animal("Heap Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Selection Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Merge Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Quick Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("List Search" ,0,true))
        listOfAnimals.add(Animal("Linear Search" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Binary Search" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Jump Search",R.drawable.book,false ))
        listOfAnimals.add(Animal("Data Structure",0,true ))
        listOfAnimals.add(Animal("Arrays" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Stacks" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Queues" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Lists" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Hash Tables",R.drawable.book,false ))
        listOfAnimals.add(Animal("Heaps" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Binary Search Tree" ,R.drawable.book,false))


        setSupportActionBar(findViewById(R.id.tool_bar))
        val actionBar = supportActionBar


        adapter = AnimalsAdapter(this, listOfAnimals)
        listOfAnimalsView.adapter = adapter

    }

     class AnimalsAdapter:BaseAdapter {

            var listOfAnimals= ArrayList<Animal>()
            var context:Context?=null
            constructor(context:Context , listOfAnimals: ArrayList<Animal>):super(){
                 this.listOfAnimals = listOfAnimals
                this.context = context


            }
         override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
             var animals = listOfAnimals[position]
             if (animals.Isheader == true)
             {
                 var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                 var myView = inflator.inflate(R.layout.header_tickt, null)
                 myView.nameView.text = animals.name!!
                 if (position == 0)
                 {
                     myView.nameView.setBackgroundResource(R.color.sort_color)

                 }
                 if (position == 7)
                 {
                     myView.nameView.setBackgroundResource(R.color.list_color)
                     //myView.nameView.setBackgroundColor(Color.parseColor("#09b693"))
                 }
                 if (position == 11)
                 {
                     myView.nameView.setBackgroundResource(R.color.datastru_color)

                 }

                 return myView
             }
             else {
                 var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                 var myView = inflator.inflate(R.layout.animal_tickt, null)
                 myView.nameView.text = animals.name!!
                 myView.resources.getLayout(R.layout.animal_tickt)
                 myView.imageView.setImageResource(animals.imageview)
                 myView.setOnClickListener {
                     if (position == 1) {
                         val intent = Intent(context, busort::class.java)
                         context!!.startActivity(intent)

                     }
                     if (position == 2) {
                         val intent = Intent(context, insertionSort::class.java)
                         context!!.startActivity(intent)

                     }
                     if (position == 3) {
                         val intent = Intent(context, heapSort::class.java)
                         context!!.startActivity(intent)

                     }
                     if (position == 4) {
                         val intent = Intent(context, selectionSort::class.java)
                         context!!.startActivity(intent)

                     }
                     if (position == 5) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                          val intent = Intent(context, merge_sort::class.java)
                          context!!.startActivity(intent)

                     }
                     if (position == 6) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     if (position == 8) {

                          val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent)

                     }
                     if (position == 9) {

                           val intent = Intent(context, binarysearch::class.java)
                           context!!.startActivity(intent)

                     }
                     if (position == 10) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     if (position == 12) {

                          val intent = Intent(context, ary::class.java)
                          context!!.startActivity(intent)

                     }
                     if (position == 13) {


                          val intent = Intent(context, stack::class.java)
                          context!!.startActivity(intent)

                     }
                     if (position == 14) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     if (position == 15) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     if (position == 16) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     if (position == 17) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     if (position == 18) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     if (position == 18) {
                         Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                         /* val intent = Intent(context, linear_search::class.java)
                          context!!.startActivity(intent) */

                     }
                     Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                 }
                 return myView
             }

         }

         override fun getItem(position: Int): Any {

             return listOfAnimals[position]
         }

         override fun getItemId(position: Int): Long {

             return position.toLong()
         }

         override fun getCount(): Int {

             return listOfAnimals.size
         }

     }



}
