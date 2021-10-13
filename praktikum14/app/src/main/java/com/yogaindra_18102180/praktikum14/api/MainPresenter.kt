package com.yogaindra_18102180.praktikum14.api

import com.yogaindra_18102180.praktikum14.CoroutineContextProvider
import com.yogaindra_18102180.praktikum14.QuoteAddUpdateActivity
import com.yogaindra_18102180.praktikum14.`interface`.MainView
import com.yogaindra_18102180.praktikum14.model.Login
import com.yogaindra_18102180.praktikum14.model.Message
import com.yogaindra_18102180.praktikum14.model.QuoteResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainPresenter(private val view: MainView, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getMyQuotes(token:String?) {
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.getMyQuotes("Bearer "+token).enqueue(object :
                        retrofit2.Callback<QuoteResponse> {
                    override fun onResponse(call: Call<QuoteResponse>, response: Response<QuoteResponse>) {
                        if(response.code() == 200) {
                            response.body()?.quotes?.let {
                                view.resultQuote(it)
                            }
                        }
                    }
                    override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun getClassQuotes(token:String?) {
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.getClassQuotes("Bearer "+token).enqueue(object :
                        retrofit2.Callback<QuoteResponse> {
                    override fun onResponse(call: Call<QuoteResponse>, response: Response<QuoteResponse>) {
                        if(response.code() == 200) {
                            response.body()?.quotes?.let {
                                view.resultQuote(it)
                            }
                        }
                    }
                    override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun getAllQuotes(token: String) {
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.getAllQuotes("Bearer "+token).enqueue(object :
                        retrofit2.Callback<QuoteResponse> {
                    override fun onResponse(call: Call<QuoteResponse>, response: Response<QuoteResponse>) {
                        if(response.code() == 200) {
                            response.body()?.quotes?.let {
                                view.resultQuote(it)
                            }
                        }
                    }
                    override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun addQuote(token:String, title:String, description: String) {
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.addQuote("Bearer "+token,title,description).enqueue(object :
                        retrofit2.Callback<Message> {
                    override fun onResponse(call: Call<Message>, response: Response<Message>) {
                        if(response.code() == 200) {
                            response.body()?.message?.let {
                                view.showMessage(it)
                            }
                        }
                    }
                    override fun onFailure(call: Call<Message>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun updateQuote(token:String, quote_id:String, title:String, description: String) {
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.updateQuote("Bearer "+token,quote_id,title,description).enqueue(object :
                        retrofit2.Callback<Message> {
                    override fun onResponse(call: Call<Message>, response: Response<Message>) {
                        if(response.code() == 200) {
                            response.body()?.message?.let {
                                view.showMessage(it)
                            }
                        }
                    }
                    override fun onFailure(call: Call<Message>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun deleteQuote(token: String, quote_id: String) {
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.deleteQuote("Bearer "+token,quote_id).enqueue(object :
                        retrofit2.Callback<Message> {
                    override fun onResponse(call: Call<Message>, response: Response<Message>) {
                        if(response.code() == 200) {
                            response.body()?.message?.let {
                                view.showMessage(it)
                            }
                        }
                    }
                    override fun onFailure(call: Call<Message>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }
    fun login(nim:String, password:String) {
        GlobalScope.launch (context.main){
            try {
                ApiMain().services.login(nim,password).enqueue(object :
                        retrofit2.Callback<Login> {
                    override fun onResponse(call: Call<Login>, response: Response<Login>) {
                        if(response.code()==200){
                            response.body()?.let { it1 -> view.resultLogin(it1) }
                            view.showMessage("Login Berhasil")
                        }
                        else{
                            view.showMessage("Login Gagal")
                        }

                    }
                    override fun onFailure(call: Call<Login>, t: Throwable) {
                        view.showMessage("Koneksi Terputus")
                    }
                })
            }
            catch (e:Exception){
            }
        }
    }

}