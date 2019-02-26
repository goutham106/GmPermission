package com.gm.demo

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class FragmentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.container, BlankFragment(), null)
        trans.commit()
    }


    fun openAlertDialog(
        title: String = "",
        message: String,
        positiveButtonName: String = "Ok",
        positiveListner: DialogInterface.OnClickListener
    ) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(positiveButtonName, positiveListner)

        val dialog = builder.create()
        dialog.setCancelable(true)
        dialog.show()
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(this, R.color.colorAccent))

    }


}
