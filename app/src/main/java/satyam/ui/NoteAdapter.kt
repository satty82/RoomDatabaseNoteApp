package satyam.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_layout.view.*
import satyam.andyprojects.roomdatabasenoteapp.R
import satyam.db.NOte

class NoteAdapter(private val notes : List<NOte>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        )
    }

    override fun getItemCount() = notes.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
//  Here binding Recyc.View data with holder
        holder.view.textViewTitle.text = notes[position].title
        holder.view.textViewDes.text = notes[position].note

      holder.view.setOnClickListener{
          val action = HomeFragmentDirections.actionAddNote()
          action.note = notes[position]
          Navigation.findNavController(it).navigate(action)
      }


    }
    class NoteViewHolder(val view : View) :RecyclerView.ViewHolder(view)

}
