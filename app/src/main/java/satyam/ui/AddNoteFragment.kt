package satyam.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

import satyam.andyprojects.roomdatabasenoteapp.R
import satyam.db.NOte
import satyam.db.NoteDatabase
import java.nio.channels.AsynchronousByteChannel


class AddNoteFragment : BaseFragment() {

   private val note : NOte? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
            button_done.setOnClickListener {view->

                val noteTitle = editText.text.toString().trim()
                val noteBody = editText2.text.toString().trim()

                if (noteTitle.isEmpty()) {
                    editText.error = "title  required"
                    editText.requestFocus()
                    return@setOnClickListener
                }
                if (noteBody.isEmpty())
                {
                    editText.error = "note required"
                    editText.requestFocus()
                    return@setOnClickListener

                }


                // This replaces AsyncTask
                launch {

                    val note = NOte(noteTitle,noteBody)
                    context?.let {
                        NoteDatabase(it).getNoteDao().addNote(note)
                        Toast.makeText(it , "Note Saved", Toast.LENGTH_LONG).show()

                        val action = AddNoteFragmentDirections.actionSaveNote()
                        Navigation.findNavController(view).navigate(action)
                    }

                }

            }

    }
//    private fun saveNote(note : NOte){
//
//        class saveNote: AsyncTask<Void,Void,Void>() {
//            override fun doInBackground(vararg params: Void?): Void? {
//                NoteDatabase(activity!!).getNoteDao().addNote(note)
//            return null
//            }
//
//            override fun onPostExecute(result: Void?) {
//                super.onPostExecute(result)
//
//                Toast.makeText(activity,"Note Saved",Toast.LENGTH_LONG).show()
//            }
//        }
//
//        saveNote().execute()

    }



