package com.malinskiy.statz.entity.base

import com.malinskiy.statz.extensions.parse
import org.parse4j.ParseObject
import kotlin.properties.Delegates

open class CommitMetric(className: String?) : ParseObject(className) {
    var gitCommitSha: String by Delegates.parse()
    var buildId: String by Delegates.parse()
}