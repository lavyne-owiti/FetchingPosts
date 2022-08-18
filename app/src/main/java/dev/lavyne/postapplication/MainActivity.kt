package dev.lavyne.postapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.lavyne.postapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getPosts()

    }

    fun getPosts(){
        val apiclient=ApiClient.buildAPiClient(ApiIterface::class.java)
        val request=apiclient.getPosts()
        request.enqueue(object :Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               if (response.isSuccessful){
                   val posts=response.body()
                   if (posts!=null){
                       displayPost(posts)
                   }
//                   Toast.makeText(baseContext,"fetched ${posts!!.size}posts",
//                       Toast.LENGTH_LONG).show()
//                   binding.rvViews.layoutManager=LinearLayoutManager(baseContext)
//                   binding.rvViews.adapter=PostsRVAdapter(baseContext,posts)

               }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun displayPost(postList: List<Post>){
       binding.rvViews.layoutManager=LinearLayoutManager(this)
        binding.rvViews.adapter=PostsRVAdapter(postList)
    }
}