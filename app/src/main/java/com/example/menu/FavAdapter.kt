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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavAdapter(val fav_data:List<MealClass>, val context:Context): RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    class ViewHolder(val fav_row: View):RecyclerView.ViewHolder(fav_row){
        val layout: ConstraintLayout =fav_row.findViewById(R.id.fav_row)
        val thumbnail: ImageView =fav_row.findViewById(R.id.imageView2)
        val name: TextView =fav_row.findViewById(R.id.textName2)
        val buttonDel: Button =fav_row.findViewById(R.id.btnDel)

    }

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int): FavAdapter.ViewHolder {
        val inflater= LayoutInflater.from(recyclerView.context)
        val inflatedView=inflater.inflate(R.layout.fav_item,recyclerView,false)
        val holder= FavAdapter.ViewHolder(inflatedView)

        return holder
    }
    override fun getItemCount(): Int {
        return fav_data.size
    }

    override fun onBindViewHolder(holder: FavAdapter.ViewHolder, position: Int) {
        holder.thumbnail.setImageResource(fav_data.get(position).img)
        holder.name.text=fav_data.get(position).name
        holder.layout.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,fav_data.get(position).name, Toast.LENGTH_SHORT).show()
        })

        val mealDao=MealDatabase.getInstance(context = context).mealDao()
        val newMeal=fav_data[position]

        holder.buttonDel.setOnClickListener {
            GlobalScope.launch {
            mealDao.delete(newMeal)
            }
            //Toast.makeText(context, "Meal removed from favorites", Toast.LENGTH_SHORT).show()
        }


    }
}