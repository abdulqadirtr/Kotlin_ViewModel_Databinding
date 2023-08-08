package com.example.githubrepo_livedata.data.model

data class GithubRepositoryModel(
    val id: Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val private: Boolean,
    val owner: Owner,
    val html_url: String,
    val description: String?,
    val fork: Boolean,
    val url: String,
    val created_at: String,
    val updated_at: String,
    val pushed_at: String,
    val homepage: String?,
    val size: Int,
    val stargazers_count: Int,
    val watchers_count: Int,
    val language: String?,
    val forks_count: Int,
    val open_issues_count: Int,
    val default_branch: String
) {
    data class Owner(
        val login: String,
        val id: Int,
        val node_id: String,
        val avatar_url: String,
        val gravatar_id: String,
        val url: String,
        val received_events_url: String,
        val type: String
    )
}
