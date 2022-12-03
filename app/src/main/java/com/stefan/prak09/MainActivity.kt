package com.stefan.prak09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stefan.prak09.databinding.ActivityMainBinding

/**
 * @author Stefanus - 2072013, Vina Anjelina - 2072022
 * **
 */


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var articles: ArrayList<Article>
//    private lateinit var newsArticleAdapter: NewsArticleAdapter
//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://newsapi.org/v2/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(binding.fragmentContainer.id, MainFragment.newInstance())
        fragmentTransaction.commit()
    }
}
//
//        articles = ArrayList()
//        newsArticleAdapter = NewsArticleAdapter(articles)
//
//        //click to view more data
//        newsArticleAdapter.setArticleDataListener(object : NewsArticleAdapter.ArticleDataListener {
//            override fun articleItemClicked(article: Article) {
//                showMoreArticleData(article)
//            }
//        })
//
//        binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity)
//        binding.rvNews.adapter = newsArticleAdapter
//
//        binding.srLayout.setOnRefreshListener {
//            fetchArticleData()
//            binding.srLayout.isRefreshing = false
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        fetchArticleData()
//    }
//
//    private fun fetchArticleData() {
//        val service = retrofit.create(NewsApi::class.java)
//        val call = service.getCurrentNewsData("Twitter",
//            "f0c081794a864a8ca72ebbebc350efc9") //Getting Twitter Related News
//        call?.enqueue(object : Callback<ArticlesJson?> {
//            override fun onResponse(call: Call<ArticlesJson?>, response: Response<ArticlesJson?>) {
//                response.body()!!.articles?.let {
//                    articles.addAll(it)
//                }
//                newsArticleAdapter.notifyItemChanged(0)
//            }
//
//            override fun onFailure(call: Call<ArticlesJson?>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
//
//            }
//
//        })
//
//    }
//
//    private fun showMoreArticleData(article: Article) {
//        val service = retrofit.create(NewsApi::class.java)
//        val call = service.getCurrentNewsData("Twitter",
//            "f0c081794a864a8ca72ebbebc350efc9") //Getting Twitter Related News
//        call?.enqueue(object : Callback<ArticlesJson?> {
//            override fun onResponse(call: Call<ArticlesJson?>, response: Response<ArticlesJson?>) {
//                response.body()!!.articles?.let {
//                    articles.addAll(it)
//                }
//
////               Toast.makeText(this@MainActivity, article.content,
////                   Toast.LENGTH_SHORT).show()
//
//
//                val intent = Intent(this@MainActivity, ScrollingActivity::class.java)
//                intent.putExtra("news",article)
//                startActivity(intent)
//            }
//
//
//            override fun onFailure(call: Call<ArticlesJson?>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
//
//            }
//
//        })
//    }
//}




