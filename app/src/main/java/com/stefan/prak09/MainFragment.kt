package com.stefan.prak09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.stefan.prak09.Api.Article
import com.stefan.prak09.Api.ArticlesJson
import com.stefan.prak09.Api.NewsApi
import com.stefan.prak09.adapter.NewsArticleAdapter
import com.stefan.prak09.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Stefanus - 2072013, Vina Anjelina - 2072022
 * **
 */

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var articles: ArrayList<Article>
    private lateinit var newsArticleAdapter: NewsArticleAdapter
    private lateinit var fragmentMainBinding: FragmentMainBinding
    val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articles = ArrayList()
        newsArticleAdapter = NewsArticleAdapter(articles)
        //click to view more data
        newsArticleAdapter.setArticleDataListener(object : NewsArticleAdapter.ArticleDataListener {
            override fun articleItemClicked(article: Article) {
                val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
                if (fragmentMainBinding.fragmentContainerTablet != null) {
                    fragmentTransaction?.replace(R.id.fragment_container_tablet,
                        ScrollingFragment.newInstance(article))

                } else {
                    fragmentTransaction?.replace(R.id.fragment_container,
                        ScrollingFragment.newInstance(article))
                    fragmentTransaction?.addToBackStack(null)


                }
                fragmentTransaction?.commit()

            }
        })

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        fragmentMainBinding.rvNews.layoutManager = LinearLayoutManager(activity)
        fragmentMainBinding.rvNews.adapter = newsArticleAdapter
        fragmentMainBinding.srLayout.setOnRefreshListener {
            this.fetchArticleData()
            fragmentMainBinding.srLayout.isRefreshing = false
        }
        return fragmentMainBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onStart() {
        super.onStart()
        fetchArticleData()
    }

    private fun fetchArticleData() {
        val service = retrofit.create(NewsApi::class.java)
        val call = service.getCurrentNewsData("Twitter",
            "f0c081794a864a8ca72ebbebc350efc9") //Getting Twitter Related News
        call?.enqueue(object : Callback<ArticlesJson?> {
            override fun onResponse(call: Call<ArticlesJson?>, response: Response<ArticlesJson?>) {
                response.body()!!.articles?.let {
                    articles.addAll(it)
                }
                newsArticleAdapter.notifyItemChanged(0)
            }

            override fun onFailure(call: Call<ArticlesJson?>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()

            }

        })

    }

}