package com.stefan.prak09.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.stefan.prak09.R
import com.stefan.prak09.databinding.NewsItemBinding
import com.stefan.prak09.Api.Article
/**
 * @author Stefanus - 2072013
 * **
 */

class NewsArticleAdapter(val articles: ArrayList<Article>) : Adapter<NewsArticleAdapter.ArticleViewHolder>() {

    private lateinit var articleDataListener: ArticleDataListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ArticleViewHolder(view)    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.setArticleData(articles[position])
        holder.itemView.setOnClickListener {
            articleDataListener.articleItemClicked(articles[position])
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun setArticleDataListener(articleDataListener: ArticleDataListener){
        this.articleDataListener = articleDataListener
    }

    interface ArticleDataListener{
        fun articleItemClicked(article: Article)
    }

    inner class ArticleViewHolder(itemView: View): ViewHolder(itemView) {
        private var binding: NewsItemBinding
        init {
            binding = NewsItemBinding.bind(itemView)
        }

        fun setArticleData(article: Article){
            binding.tvTitle.text = article.title
            binding.tvPublishedDate.text = article.publishedAt
            binding.tvAuthor.text = article.author
            binding.tvDescription.text = article.description
            binding.button.text = article.author.subSequence(0,1)
        }
    }

}