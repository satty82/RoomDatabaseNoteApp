package satyam.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : Fragment(), CoroutineScope {

    private lateinit var job : Job     // job is background task in coroutine

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main  // In coroutine we have dispatchers whc define threads where we exceute the job
                                        // Main is the context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()

        job.cancel()
    }


}