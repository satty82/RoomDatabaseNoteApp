package satyam.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [NOte::class],    // this is array of entities
    version =1  // this is version of the database
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() :NoteDao   // this will helps get the instance from the NoteDao interface whc will help set or get the values

    companion object{       // Building Room Db here , to do this we use companion object

        @Volatile private var instance : NoteDatabase? = null  // volatile means this instance is immediately available for
                                                                // all the other Threads
        private val LOCK = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){  // this invoke function will tell instance is not null

            instance ?: buildDatabase(context).also {
                instance = it
            }
            // this is synchronized block
            // we are checking out instance is null or not null
        }

        // if instance is null we will call our below function
        // Below Fun will built a Room Database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "notedb"
        ).build()

    }
}