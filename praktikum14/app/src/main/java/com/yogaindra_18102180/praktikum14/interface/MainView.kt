package com.yogaindra_18102180.praktikum14.`interface`

import com.yogaindra_18102180.praktikum14.model.Login
import com.yogaindra_18102180.praktikum14.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}