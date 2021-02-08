package com.yogaindra_18102180.praktikum14.ui.globalquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogaindra_18102180.praktikum14.CoroutineContextProvider
import com.yogaindra_18102180.praktikum14.R
import com.yogaindra_18102180.praktikum14.TokenPref
import com.yogaindra_18102180.praktikum14.`interface`.MainView
import com.yogaindra_18102180.praktikum14.adapter.QuoteAdapter
import com.yogaindra_18102180.praktikum14.api.MainPresenter
import com.yogaindra_18102180.praktikum14.databinding.FragmentGlobalQuotesBinding
import com.yogaindra_18102180.praktikum14.model.Login
import com.yogaindra_18102180.praktikum14.model.Quote
import com.yogaindra_18102180.praktikum14.model.Token
import kotlinx.android.synthetic.main.fragment_global_quotes.*
import kotlinx.android.synthetic.main.fragment_global_quotes.progressbar
import kotlinx.android.synthetic.main.fragment_global_quotes.swiperefresh
import kotlinx.android.synthetic.main.fragment_my_quotes.*
import org.jetbrains.anko.support.v4.onRefresh

class GlobalQuotesFragment : Fragment(), MainView {
    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: QuoteAdapter
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
            Bundle?
    ): View? = inflater.inflate(R.layout.fragment_global_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGlobalQuotesBinding.bind(view)
        binding.recyclerviewGlobalQuotes.layoutManager = LinearLayoutManager(activity)
        tokenPref = TokenPref(requireActivity())
        token = tokenPref.getToken()
        adapter = QuoteAdapter(requireActivity())
        binding.recyclerviewGlobalQuotes.adapter = adapter
        presenter =
                MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getMyQuotes(token.token)
        swiperefresh.onRefresh {
            progressbar.visibility = View.INVISIBLE
            presenter.getAllQuotes(token.token.toString())
        }
    }
    override fun onResume() {
        super.onResume()
        presenter.getClassQuotes(token.token)
    }

    override fun showMessage(messsage: String) {
        Toast.makeText(requireActivity(),messsage, Toast.LENGTH_SHORT).show()
    }
    override fun resultQuote(data: ArrayList<Quote>) {
        quotes.clear()
        adapter.listQuotes = data
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        progressbar.visibility = View.INVISIBLE
        swiperefresh.isRefreshing = false
    }
    override fun resultLogin(data: Login) {
    }
}