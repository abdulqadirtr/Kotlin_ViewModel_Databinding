package com.example.githubrepo_livedata.data.model

data class Repository(
    val id: Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val owner: Owner,
    val private: Boolean,
    val html_url: String,
    val description: String?,
    val stargazers_count: Int,
    val watchers_count: Int,
    val forks_count: Int,
    val open_issues_count: Int,
    val created_at: String,
    val updated_at: String,
    val pushed_at: String,
    val homepage: String?,
    val size: Int,
    val language: String?,
    val has_issues: Boolean,
    val has_projects: Boolean,
    val has_downloads: Boolean,
    val has_wiki: Boolean,
    val has_pages: Boolean,
    val forks: Int,
    val open_issues: Int,
    val watchers: Int,
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