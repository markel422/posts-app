package com.example.mike0.redditkotlinactivity.data.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post : Parcelable {

    @SerializedName("subreddit_id")
    @Expose
    var subredditId: String? = null
    @SerializedName("approved_at_utc")
    @Expose
    var approvedAtUtc: Any? = null
    @SerializedName("send_replies")
    @Expose
    var sendReplies: Boolean? = null
    @SerializedName("mod_reason_by")
    @Expose
    var modReasonBy: Any? = null
    @SerializedName("banned_by")
    @Expose
    var bannedBy: Any? = null
    @SerializedName("num_reports")
    @Expose
    var numReports: Any? = null
    @SerializedName("removal_reason")
    @Expose
    var removalReason: Any? = null
    @SerializedName("subreddit")
    @Expose
    var subreddit: String? = null
    @SerializedName("selftext_html")
    @Expose
    var selftextHtml: String? = null
    @SerializedName("selftext")
    @Expose
    var selftext: String? = null
    @SerializedName("likes")
    @Expose
    var likes: Any? = null
    @SerializedName("suggested_sort")
    @Expose
    var suggestedSort: Any? = null
    @SerializedName("user_reports")
    @Expose
    var userReports: List<Any>? = null
    @SerializedName("secure_media")
    @Expose
    var secureMedia: Any? = null
    @SerializedName("is_reddit_media_domain")
    @Expose
    var isRedditMediaDomain: Boolean? = null
    @SerializedName("saved")
    @Expose
    var saved: Boolean? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("banned_at_utc")
    @Expose
    var bannedAtUtc: Any? = null
    @SerializedName("mod_reason_title")
    @Expose
    var modReasonTitle: Any? = null
    @SerializedName("view_count")
    @Expose
    var viewCount: Any? = null
    @SerializedName("archived")
    @Expose
    var archived: Boolean? = null
    @SerializedName("clicked")
    @Expose
    var clicked: Boolean? = null
    @SerializedName("no_follow")
    @Expose
    var noFollow: Boolean? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("num_crossposts")
    @Expose
    var numCrossposts: Int? = null
    @SerializedName("link_flair_text")
    @Expose
    var linkFlairText: Any? = null
    @SerializedName("mod_reports")
    @Expose
    var modReports: List<Any>? = null
    @SerializedName("can_mod_post")
    @Expose
    var canModPost: Boolean? = null
    @SerializedName("is_crosspostable")
    @Expose
    var isCrosspostable: Boolean? = null
    @SerializedName("pinned")
    @Expose
    var pinned: Boolean? = null
    @SerializedName("score")
    @Expose
    var score: Int? = null
    @SerializedName("approved_by")
    @Expose
    var approvedBy: Any? = null
    @SerializedName("over_18")
    @Expose
    var over18: Boolean? = null
    @SerializedName("report_reasons")
    @Expose
    var reportReasons: Any? = null
    @SerializedName("domain")
    @Expose
    var domain: String? = null
    @SerializedName("hidden")
    @Expose
    var hidden: Boolean? = null
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
    @SerializedName("edited")
    @Expose
    var edited: Boolean? = null
    @SerializedName("link_flair_css_class")
    @Expose
    var linkFlairCssClass: Any? = null
    @SerializedName("author_flair_css_class")
    @Expose
    var authorFlairCssClass: Any? = null
    @SerializedName("contest_mode")
    @Expose
    var contestMode: Boolean? = null
    @SerializedName("gilded")
    @Expose
    var gilded: Int? = null
    @SerializedName("downs")
    @Expose
    var downs: Int? = null
    @SerializedName("brand_safe")
    @Expose
    var brandSafe: Boolean? = null
    @SerializedName("author_flair_text")
    @Expose
    var authorFlairText: Any? = null
    @SerializedName("stickied")
    @Expose
    var stickied: Boolean? = null
    @SerializedName("visited")
    @Expose
    var visited: Boolean? = null
    @SerializedName("can_gild")
    @Expose
    var canGild: Boolean? = null
    @SerializedName("is_self")
    @Expose
    var isSelf: Boolean? = null
    @SerializedName("parent_whitelist_status")
    @Expose
    var parentWhitelistStatus: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("spoiler")
    @Expose
    var spoiler: Boolean? = null
    @SerializedName("permalink")
    @Expose
    var permalink: String? = null
    @SerializedName("subreddit_type")
    @Expose
    var subredditType: String? = null
    @SerializedName("locked")
    @Expose
    var locked: Boolean? = null
    @SerializedName("hide_score")
    @Expose
    var hideScore: Boolean? = null
    @SerializedName("created")
    @Expose
    var created: Int? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("whitelist_status")
    @Expose
    var whitelistStatus: String? = null
    @SerializedName("quarantine")
    @Expose
    var quarantine: Boolean? = null
    @SerializedName("subreddit_subscribers")
    @Expose
    var subredditSubscribers: Int? = null
    @SerializedName("created_utc")
    @Expose
    var createdUtc: Int? = null
    @SerializedName("subreddit_name_prefixed")
    @Expose
    var subredditNamePrefixed: String? = null
    @SerializedName("ups")
    @Expose
    var ups: Int? = null
    @SerializedName("media")
    @Expose
    var media: Any? = null
    @SerializedName("num_comments")
    @Expose
    var numComments: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("mod_note")
    @Expose
    var modNote: Any? = null
    @SerializedName("is_video")
    @Expose
    var isVideo: Boolean? = null
    @SerializedName("distinguished")
    @Expose
    var distinguished: Any? = null

    protected constructor(`in`: Parcel) {
        this.subredditId = `in`.readValue(String::class.java.classLoader) as String
        this.approvedAtUtc = `in`.readValue(Any::class.java.classLoader) as Any
        this.sendReplies = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.modReasonBy = `in`.readValue(Any::class.java.classLoader) as Any
        this.bannedBy = `in`.readValue(Any::class.java.classLoader) as Any
        this.numReports = `in`.readValue(Any::class.java.classLoader) as Any
        this.removalReason = `in`.readValue(Any::class.java.classLoader) as Any
        this.subreddit = `in`.readValue(String::class.java.classLoader) as String
        this.selftextHtml = `in`.readValue(String::class.java.classLoader) as String
        this.selftext = `in`.readValue(String::class.java.classLoader) as String
        this.likes = `in`.readValue(Any::class.java.classLoader) as Any
        this.suggestedSort = `in`.readValue(Any::class.java.classLoader) as Any
        `in`.readList(this.userReports, Any::class.java.classLoader)
        this.secureMedia = `in`.readValue(Any::class.java.classLoader) as Any
        this.isRedditMediaDomain = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.saved = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.id = `in`.readValue(String::class.java.classLoader) as String
        this.bannedAtUtc = `in`.readValue(Any::class.java.classLoader) as Any
        this.modReasonTitle = `in`.readValue(Any::class.java.classLoader) as Any
        this.viewCount = `in`.readValue(Any::class.java.classLoader) as Any
        this.archived = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.clicked = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.noFollow = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.author = `in`.readValue(String::class.java.classLoader) as String
        this.numCrossposts = `in`.readValue(Int::class.java.classLoader) as Int
        this.linkFlairText = `in`.readValue(Any::class.java.classLoader) as Any
        `in`.readList(this.modReports, Any::class.java.classLoader)
        this.canModPost = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.isCrosspostable = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.pinned = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.score = `in`.readValue(Int::class.java.classLoader) as Int
        this.approvedBy = `in`.readValue(Any::class.java.classLoader) as Any
        this.over18 = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.reportReasons = `in`.readValue(Any::class.java.classLoader) as Any
        this.domain = `in`.readValue(String::class.java.classLoader) as String
        this.hidden = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.thumbnail = `in`.readValue(String::class.java.classLoader) as String
        this.edited = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.linkFlairCssClass = `in`.readValue(Any::class.java.classLoader) as Any
        this.authorFlairCssClass = `in`.readValue(Any::class.java.classLoader) as Any
        this.contestMode = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.gilded = `in`.readValue(Int::class.java.classLoader) as Int
        this.downs = `in`.readValue(Int::class.java.classLoader) as Int
        this.brandSafe = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.authorFlairText = `in`.readValue(Any::class.java.classLoader) as Any
        this.stickied = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.visited = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.canGild = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.isSelf = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.parentWhitelistStatus = `in`.readValue(String::class.java.classLoader) as String
        this.name = `in`.readValue(String::class.java.classLoader) as String
        this.spoiler = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.permalink = `in`.readValue(String::class.java.classLoader) as String
        this.subredditType = `in`.readValue(String::class.java.classLoader) as String
        this.locked = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.hideScore = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.created = `in`.readValue(Int::class.java.classLoader) as Int
        this.url = `in`.readValue(String::class.java.classLoader) as String
        this.whitelistStatus = `in`.readValue(String::class.java.classLoader) as String
        this.quarantine = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.subredditSubscribers = `in`.readValue(Int::class.java.classLoader) as Int
        this.createdUtc = `in`.readValue(Int::class.java.classLoader) as Int
        this.subredditNamePrefixed = `in`.readValue(String::class.java.classLoader) as String
        this.ups = `in`.readValue(Int::class.java.classLoader) as Int
        this.media = `in`.readValue(Any::class.java.classLoader) as Any
        this.numComments = `in`.readValue(Int::class.java.classLoader) as Int
        this.title = `in`.readValue(String::class.java.classLoader) as String
        this.modNote = `in`.readValue(Any::class.java.classLoader) as Any
        this.isVideo = `in`.readValue(Boolean::class.java.classLoader) as Boolean
        this.distinguished = `in`.readValue(Any::class.java.classLoader) as Any
    }

    companion object {
        val CREATOR: Parcelable.Creator<Post> = object : Parcelable.Creator<Post> {


            override fun createFromParcel(`in`: Parcel): Post {
                return Post(`in`)
            }

            override fun newArray(size: Int): Array<Post?> {
                return arrayOfNulls(size)
            }

        }
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(subredditId)
        dest.writeValue(approvedAtUtc)
        dest.writeValue(sendReplies)
        dest.writeValue(modReasonBy)
        dest.writeValue(bannedBy)
        dest.writeValue(numReports)
        dest.writeValue(removalReason)
        dest.writeValue(subreddit)
        dest.writeValue(selftextHtml)
        dest.writeValue(selftext)
        dest.writeValue(likes)
        dest.writeValue(suggestedSort)
        dest.writeList(userReports)
        dest.writeValue(secureMedia)
        dest.writeValue(isRedditMediaDomain)
        dest.writeValue(saved)
        dest.writeValue(id)
        dest.writeValue(bannedAtUtc)
        dest.writeValue(modReasonTitle)
        dest.writeValue(viewCount)
        dest.writeValue(archived)
        dest.writeValue(clicked)
        dest.writeValue(noFollow)
        dest.writeValue(author)
        dest.writeValue(numCrossposts)
        dest.writeValue(linkFlairText)
        dest.writeList(modReports)
        dest.writeValue(canModPost)
        dest.writeValue(isCrosspostable)
        dest.writeValue(pinned)
        dest.writeValue(score)
        dest.writeValue(approvedBy)
        dest.writeValue(over18)
        dest.writeValue(reportReasons)
        dest.writeValue(domain)
        dest.writeValue(hidden)
        dest.writeValue(thumbnail)
        dest.writeValue(edited)
        dest.writeValue(linkFlairCssClass)
        dest.writeValue(authorFlairCssClass)
        dest.writeValue(contestMode)
        dest.writeValue(gilded)
        dest.writeValue(downs)
        dest.writeValue(brandSafe)
        dest.writeValue(authorFlairText)
        dest.writeValue(stickied)
        dest.writeValue(visited)
        dest.writeValue(canGild)
        dest.writeValue(isSelf)
        dest.writeValue(parentWhitelistStatus)
        dest.writeValue(name)
        dest.writeValue(spoiler)
        dest.writeValue(permalink)
        dest.writeValue(subredditType)
        dest.writeValue(locked)
        dest.writeValue(hideScore)
        dest.writeValue(created)
        dest.writeValue(url)
        dest.writeValue(whitelistStatus)
        dest.writeValue(quarantine)
        dest.writeValue(subredditSubscribers)
        dest.writeValue(createdUtc)
        dest.writeValue(subredditNamePrefixed)
        dest.writeValue(ups)
        dest.writeValue(media)
        dest.writeValue(numComments)
        dest.writeValue(title)
        dest.writeValue(modNote)
        dest.writeValue(isVideo)
        dest.writeValue(distinguished)
    }

    override fun describeContents(): Int {
        return 0
    }
}
