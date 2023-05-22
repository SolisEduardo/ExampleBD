package com.example.examplebd.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examplebd.Model.QuestionViewModel
import com.example.examplebd.R

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {
    private var questionList : ArrayList<QuestionViewModel> = ArrayList()
    fun addItems (items: ArrayList<QuestionViewModel>){
        this.questionList = items
       // notifyItemChanged(items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= QuestionViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.cardview_stored_surveys,parent,false)
    )


    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questionList[position]
        holder.binView(question)
    }
    class QuestionViewHolder(var view : View): RecyclerView.ViewHolder(view){
        private var date = view.findViewById<TextView>(R.id.example_date)
        fun binView(question: QuestionViewModel)
        {
            date.text = question.date
        }
    }
}