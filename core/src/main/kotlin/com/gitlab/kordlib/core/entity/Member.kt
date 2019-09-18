package com.gitlab.kordlib.core.entity

import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.behavior.MemberBehavior
import com.gitlab.kordlib.core.cache.data.MemberData
import com.gitlab.kordlib.core.cache.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.format.DateTimeFormatter

/**
 * An instance of a [Discord Member](https://discordapp.com/developers/docs/resources/guild#guild-member-object).
 */
class Member(val memberData: MemberData, userData: UserData, kord: Kord) : User(userData, kord), MemberBehavior {

    override val guildId: Snowflake
        get() = Snowflake(memberData.guildId)

    val joinedAt: Instant get() = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(memberData.joinedAt, Instant::from)

    val nickname: String? get() = memberData.nick

    val displayName: String get() = nickname ?: username

    val roleIds: Set<Snowflake> get() = memberData.roles.asSequence().map { Snowflake(it) }.toSet()

    val roles: Flow<Role> get() = roleIds.asFlow().map { kord.getRole(guildId, it) }.filterNotNull()

    override suspend fun asMember(): Member = this

    override suspend fun asMember(guildId: Snowflake): Member? = when (guildId) {
        this.guildId -> this
        else -> kord.getMember(guildId, id)
    }

}
