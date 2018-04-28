package demo.pc.demoshopcart

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import biz.gina.southernbreezetour.ui.view.notification.NotificationCountSetClass
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnAddToCart ->{
                notificationCountCart++
                NotificationCountSetClass.setNotifyCount(notificationCountCart)
                invalidateOptionsMenu()
            }
            R.id.btnRemoveToCart ->{
                notificationCountCart--
                NotificationCountSetClass.setNotifyCount(notificationCountCart)
                invalidateOptionsMenu()
            }
        }


    }



    var notificationCountCart = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAddToCart.setOnClickListener(this)
        btnRemoveToCart.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        // Get the notifications MenuItem and
        // its LayerDrawable (layer-list)
        var item = menu.findItem(R.id.action_cart)

        NotificationCountSetClass.setAddToCart(this@MainActivity, item, notificationCountCart!!)
        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu()

        return super.onPrepareOptionsMenu(menu)
    }


}
