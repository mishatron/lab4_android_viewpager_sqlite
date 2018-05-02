package lab4.lab.com.lab4.pages


import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add.*
import lab4.lab.com.lab4.MainActivity

import lab4.lab.com.lab4.R
import lab4.lab.com.lab4.db.DB




/**
 * A simple [Fragment] subclass.
 */
class FragmentAdd : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_save?.setOnClickListener{
            (activity as MainActivity).db?.addRec(edit_note?.text.toString())
            edit_note?.text?.clear()
            (activity as MainActivity).notesViewModel?.log?.postValue((activity as MainActivity).notesViewModel?.log?.value!!+1)
        }
    }

}// Required empty public constructor
