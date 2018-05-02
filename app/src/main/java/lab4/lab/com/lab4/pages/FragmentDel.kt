package lab4.lab.com.lab4.pages


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_del.*
import lab4.lab.com.lab4.MainActivity

import lab4.lab.com.lab4.R


/**
 * A simple [Fragment] subclass.
 */
class FragmentDel : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_del, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_delete?.setOnClickListener {
            val text = edit_note_id?.text?.toString()
            text?.let {
                if((activity as MainActivity).db?.delRec(it.toLong())==true)
                {
                    Toast.makeText(context,"Deleted", Toast.LENGTH_SHORT).show()
                    (activity as MainActivity).notesViewModel?.log?.postValue((activity as MainActivity).notesViewModel?.log?.value!!+1)

                }
                else
                    Toast.makeText(context,"No such note", Toast.LENGTH_SHORT).show()

            }
        }
    }
}// Required empty public constructor
