package com.fraz7.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_tickt.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfAnimals.add(Animal("Sort",0,true ))
        listOfAnimals.add(Animal("Bubble Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Insertion Sort",R.drawable.book,false ))
        listOfAnimals.add(Animal("Heap Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Merge Sort" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Zebra" ,0,true))
        listOfAnimals.add(Animal("White Tiger" ,R.drawable.book,false))
        listOfAnimals.add(Animal("White Tiger" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Baboon",0,true ))
        listOfAnimals.add(Animal("White Tiger" ,R.drawable.book,false))
        listOfAnimals.add(Animal("White Tiger" ,R.drawable.book,false))
        listOfAnimals.add(Animal("White Tiger" ,R.drawable.book,false))
        listOfAnimals.add(Animal("Zebra" ,0,true))
        listOfAnimals.add(Animal("White Tiger" ,R.drawable.book,false))

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
                 return myView
             }
             else{
                 var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                 var myView = inflator.inflate(R.layout.animal_tickt, null)
                 myView.nameView.text = animals.name!!
                 myView.imageView.setImageResource(animals.imageview)
                 myView.nameView.setOnClickListener {
                     if(position == 1)
                     {
                         val intent = Intent(context, busort::class.java)
                         intent.putExtra("Tool_tile",animals.name!!)
                         context!!.startActivity(intent)

                     }
                     if(position == 2)
                     {
                         val intent = Intent(context, busort::class.java)
                         intent.putExtra("Tool_tile",animals.name!!)
                         context!!.startActivity(intent)

                     }
                     if(position == 3)
                     {
                         val intent = Intent(context, busort::class.java)
                         intent.putExtra("Tool_tile",animals.name!!)
                         context!!.startActivity(intent)

                     }
                     if(position == 4)
                     {
                         val intent = Intent(context, busort::class.java)
                         intent.putExtra("Tool_tile",animals.name!!)
                         context!!.startActivity(intent)

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
