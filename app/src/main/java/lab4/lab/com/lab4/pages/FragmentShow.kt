package lab4.lab.com.lab4.pages


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_show.*
import lab4.lab.com.lab4.MainActivity
import lab4.lab.com.lab4.NotesViewModel

import lab4.lab.com.lab4.R
import lab4.lab.com.lab4.db.Note


/**
 * A simple [Fragment] subclass.
 */
class FragmentShow : Fragment() {

    private var cursor: Cursor? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_show, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load()
        (activity as MainActivity).notesViewModel?.log?.observe(this, Observer {
            load()
        })
    }
    private fun load()
    {
        cursor = (activity as MainActivity).db?.allData
        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        cursor?.let {
            if (it.moveToFirst()) {
                val list = ArrayList<Note>()
                // определяем номера столбцов по имени в выборке
                val idColIndex = it.getColumnIndex("id")
                val textColIndex = it.getColumnIndex("text")
                do {
                    // получаем значения по номерам столбцов и пишем в лог
                    Log.d("PPP",
                            "ID = " + it.getInt(idColIndex) +
                                    ", text = " + it.getString(textColIndex))
                    list.add(Note(it.getInt(idColIndex), it.getString(textColIndex)))
                    // переход на следующую строку, а если следующей нет\
                } while (it.moveToNext())

                list_notes?.adapter = NotesAdapter(context,list)
            } else {
                Toast.makeText(context,"o rows",Toast.LENGTH_SHORT).show()
            }
            it.close()
        }

    }

}// Required empty public constructor
