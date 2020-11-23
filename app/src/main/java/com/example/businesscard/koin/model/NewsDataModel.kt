package com.example.businesscard.koin.model

class NewsDataModel {
    var status: String? = null
    var articles: List<Article>? = null
}

class Article {
    var author: String? = null
    var title: String? = null
    var description: String? = null
    var url: String? = null
    var urlToImage: String? = null
    var publishedAt: String? = null
}