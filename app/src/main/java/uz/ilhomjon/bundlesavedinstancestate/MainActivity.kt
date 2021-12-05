package uz.ilhomjon.bundlesavedinstancestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import uz.ilhomjon.bundlesavedinstancestate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSet.setOnClickListener {
            val text = binding.edt.text.toString()
            binding.tv.text = text
        }
    }

    //activity ish faoliyatini to'xtatganda ishga tushadi
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", binding.edt.text.toString())
    }

    //onCreate ...
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val s = savedInstanceState.getString("name")
        binding.tv.text = s
    }
}