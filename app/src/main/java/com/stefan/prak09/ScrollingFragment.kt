package com.stefan.prak09

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.stefan.prak09.Api.Article
import com.stefan.prak09.Api.ArticlesJson
import com.stefan.prak09.Api.NewsApi
import com.stefan.prak09.databinding.FragmentScrollingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val ARG_PARAM1 = "param1"

/**
 * @author Stefanus - 2072013, Vina Anjelina - 2072022
 * **
 */


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ScrollingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScrollingFragment : Fragment() {
    private var article: Article? = null
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private lateinit var fragmentScrollingBinding: FragmentScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            article = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentScrollingBinding = FragmentScrollingBinding.inflate(inflater, container, false)
//        setContentView(fragmentScrollingbinding.root)
//        setSupportActionBar(findViewById(R.id.toolbar))
        return fragmentScrollingBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(article: Article) =
            ScrollingFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, article)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        //article?.let { (showMoreArticleData(it)) }
        fragmentScrollingBinding.toolbarLayout.title = article?.title
        fragmentScrollingBinding.icContent.tvPublishedDate?.text = article?.publishedAt
        fragmentScrollingBinding.icContent.tvAuthor?.text = article?.author
        fragmentScrollingBinding.icContent.tvDescription?.text = article?.description
        fragmentScrollingBinding.icContent.tvContent?.text = article?.content
        fragmentScrollingBinding.icContent.tvUrl?.setOnClickListener {
         val webUrl = Uri.parse(article?.url);
         val webIntent = Intent(Intent.ACTION_VIEW, webUrl);
         startActivity(webIntent)
        }

    }

    //private fun showMoreArticleData(article: Article) {
//        val service = retrofit.create(NewsApi::class.java)
//        val call = service.getCurrentNewsData("Twitter",
//            "f0c081794a864a8ca72ebbebc350efc9") //Getting Twitter Related News
//        call?.enqueue(object : Callback<ArticlesJson?> {
//            override fun onResponse(call: Call<ArticlesJson?>, response: Response<ArticlesJson?>) {
//                val responseArticle = response.body()?.articles;
//                fragmentScrollingBinding.toolbarLayout.title =
//                    responseArticle?.let {
//                        article.title
//                    }.toString()
//                fragmentScrollingBinding.icContent.tvPublishedDate?.text =
//                    responseArticle?.let {
//                        article.publishedAt
//                    }.toString()
//                fragmentScrollingBinding.icContent.tvAuthor?.text = "Written By : ${responseArticle?.let {
//                    article.author
//                }.toString()}"
//
//                fragmentScrollingBinding.icContent.tvDescription?.text =
//                    responseArticle?.let {
//                        article.description
//                    }.toString()
//                fragmentScrollingBinding.icContent.tvContent?.text = responseArticle?.let {
//                    article.content
//                }.toString()
//                fragmentScrollingBinding.icContent.tvUrl?.setOnClickListener {
//                    val webUrl = Uri.parse(responseArticle?.let {
//                        article.url
//                    }.toString());
//                    //implicit intent
//                    val webIntent = Intent(Intent.ACTION_VIEW, webUrl);
//                    startActivity(webIntent)
//                }
//            }
//
//            override fun onFailure(call: Call<ArticlesJson?>, t: Throwable) {
//                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
//
//            }
//
//        })
//    }

}