package lab4.lab.com.lab4

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import lab4.lab.com.lab4.db.DB

class MainActivity : AppCompatActivity() {


    var db: DB? = null
    var notesViewModel: NotesViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        handle()
    }
    private fun handle()
    {
        initDB()
        pager?.adapter = FragmentAdapterPage(supportFragmentManager)
        pager?.addOnPageChangeListener(object: ViewPager.OnPageChangeListener
        {
            override fun onPageScrollStateChanged(state: Int) = Unit

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit

            override fun onPageSelected(position: Int) {
                if(position==0)
                {
//                    val f = (pager?.adapter as FragmentAdapterPage).getItem(0)
//                    (f as FragmentShow).load()
                }
            }

        })
    }

    private fun initDB() {
        // открываем подключение к БД
        db = DB(this)
        db?.open()
    }


    override fun onDestroy() {
        super.onDestroy()
        db?.close()
    }
}
