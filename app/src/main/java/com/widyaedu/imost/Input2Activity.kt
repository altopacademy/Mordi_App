package com.widyaedu.imost

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.dinuscxj.progressbar.CircleProgressBar
import com.nineoldandroids.animation.ValueAnimator
import com.widyaedu.imost.ml.Model
import kotlinx.android.synthetic.main.fragment_trx.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class Input2Activity : AppCompatActivity() {

    lateinit var bitmap : Bitmap
    lateinit var imgview: ImageView
    private var pbar: CircleProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input2)

        imgview = findViewById(R.id.imageView)
        val fileName = "labels.txt"
        val inputString = application.assets.open(fileName).bufferedReader().use { it.readText() }
        val townList = inputString.split("\n")
        pbar = findViewById(R.id.custom_progress3)

        var tv: TextView = findViewById(R.id.textView)

        var select: Button = findViewById(R.id.buttoSelectn)
        pbar = findViewById(R.id.custom_progress3)

        select.setOnClickListener(View.OnClickListener {

            var intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            startActivityForResult(intent, 100)

        })

        var predict: Button = findViewById(R.id.buttonScreening)
        predict.setOnClickListener(View.OnClickListener {
            val animator = ValueAnimator.ofInt(0, 100)
            animator.addUpdateListener { animation ->
                val progress = animation.animatedValue as Int
                pbar!!.progress = progress
                pbar!!.visibility = View.VISIBLE
                if (progress == 100) {
                    pbar!!.visibility = View.GONE
                    tv.setVisibility(View.VISIBLE)
                }
            }
            animator.duration = 4000
            animator.start()

            var resized: Bitmap= Bitmap.createScaledBitmap(bitmap, 224 ,224, true)
            val model = Model.newInstance(this)

            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.UINT8)

            var tbuffer = TensorImage.fromBitmap(resized)
            var byteBuffer = tbuffer.buffer

            inputFeature0.loadBuffer(byteBuffer)

            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer

            var max = getMax(outputFeature0.floatArray)

            tv.setText(townList[max])

            model.close()


        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        imgview.setImageURI(data?.data)
        var uri: Uri?= data?.data
        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)

    }

    fun getMax(arr:FloatArray) : Int{

        var ind = 0
        var min = 0.00001f

        for(i in 0..4)
        {
            if(arr[i]>min)
            {
                ind = i
                min = arr[i]
            }
        }

        return ind

    }

    private fun simulateProgress() {

    }

}

