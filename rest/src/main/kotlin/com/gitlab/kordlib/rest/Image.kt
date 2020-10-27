package com.gitlab.kordlib.rest

import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.statement.*
import io.ktor.http.HttpMethod
import io.ktor.util.toByteArray
import kotlinx.coroutines.Dispatchers
import mu.KotlinLogging
import java.awt.Dimension
import java.io.File
import java.io.IOException
import java.util.*
import javax.imageio.ImageIO
import javax.imageio.stream.ImageInputStream

private val logger = KotlinLogging.logger { }

class Image private constructor(val data: ByteArray, val format: Format) {

    val dataUri: String
        get() {
            val hash = Base64.getEncoder().encodeToString(data)
            return "data:image/${format.extension};base64,$hash"
        }

    companion object {
        fun raw(data: ByteArray, format: Format): Image {
            return Image(data, format)
        }

        suspend fun fromUrl(client: HttpClient, url: String): Image = with(Dispatchers.IO) {
            val call = client.request<HttpResponse>(url) { method = HttpMethod.Get }
            val contentType = call.headers["Content-Type"]
                ?: error("expected 'Content-Type' header in image request")

            @Suppress("EXPERIMENTAL_API_USAGE")
            val bytes = call.content.toByteArray()
            val format = Format.fromContentType(contentType)

            Image(bytes, format)
        }
    }

    sealed class Format(val extension: String) {
        object JPEG : Format("jpeg")
        object PNG : Format("png")
        object WEBP : Format("webp")
        object GIF : Format("gif")

        companion object {
            fun fromContentType(type: String) = when (type) {
                "image/jpeg" -> JPEG
                "image/png" -> PNG
                "image/webp" -> WEBP
                "image/gif" -> GIF
                else -> error(type)
            }
        }
    }

    /**
     * Represents size of the [Image], for requesting different sizes from the discord.
     * [Image.Resolution] (both height and width) will always be smaller than or equal to [maxRes] of the [Size].
     */
    enum class Size(val maxRes: Int) {
        Size16(16),
        Size32(32),
        Size64(64),
        Size128(128),
        Size256(256),
        Size512(512),
        Size1024(1024),
        Size2048(2048),
        Size4096(4096),
    }
}
