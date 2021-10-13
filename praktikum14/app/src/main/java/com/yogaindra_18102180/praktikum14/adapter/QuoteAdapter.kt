package com.yogaindra_18102180.praktikum14.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yogaindra_18102180.praktikum14.QuoteAddUpdateActivity
import com.yogaindra_18102180.praktikum14.R
import com.yogaindra_18102180.praktikum14.databinding.ItemQuoteBinding
import com.yogaindra_18102180.praktikum14.helper.EXTRA_POSITION
import com.yogaindra_18102180.praktikum14.helper.EXTRA_QUOTE
import com.yogaindra_18102180.praktikum14.helper.REQUEST_UPDATE
import com.yogaindra_18102180.praktikum14.model.Quote

class QuoteAdapter(private val activity: Activity): RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    var listQuotes = ArrayList<Quote>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return QuoteViewHolder(view)
    }

    override fun getItemCount(): Int = this.listQuotes.size

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(listQuotes[position],position)
    }

    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemQuoteBinding.bind(itemView)
        fun bind(quote: Quote, position: Int) {
            binding.tvItemTitle.text = quote.quote_name
            binding.tvOwner.text = quote.user_name+" ("+quote.class_name+")"
            binding.tvItemDate.text = quote.created_at
            binding.tvItemDescription.text = quote.quote_description
            binding.cvItemQuote.setOnClickListener{
                val intent = Intent(activity, QuoteAddUpdateActivity::class.java)
                intent.putExtra(EXTRA_POSITION, position)
                intent.putExtra(EXTRA_QUOTE, quote)
                activity.startActivityForResult(intent, REQUEST_UPDATE)
            }
        }
    }

}