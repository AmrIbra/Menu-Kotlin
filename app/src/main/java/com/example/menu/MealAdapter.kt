package com.example.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.withContext
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MealAdapter(val data: List<MealClass>, val context: Context):RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    class ViewHolder(val row: View):RecyclerView.ViewHolder(row){
        val layout:ConstraintLayout=row.findViewById(R.id.row)
        val thumbnail:ImageView=row.findViewById(R.id.imageView)
        val name:TextView=row.findViewById(R.id.textName)
        val buttonAdd:Button=row.findViewById(R.id.btnAdd)



    }

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(recyclerView.context)
        val inflatedView=inflater.inflate(R.layout.item,recyclerView,false)
        val holder=ViewHolder(inflatedView)



        return holder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.thumbnail.setImageResource(data.get(position).img)
        holder.name.text=data.get(position).name
        holder.layout.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,data.get(position).name, Toast.LENGTH_SHORT).show()
        })



        val mealDao=MealDatabase.getInstance(context = context).mealDao()
        val newMeal=MealClass(img = data[position].img, name = holder.name.toString())


        holder.buttonAdd.setOnClickListener {
            GlobalScope.launch {
                mealDao.insert(newMeal)
            Toast.makeText(context, "Meal added to favorites", Toast.LENGTH_SHORT).show()
            }
        }


    }
}