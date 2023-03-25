// THIS FILE IS AUTO-GENERATED BY KordEnumProcessor.kt, DO NOT EDIT!
@file:Suppress(names = arrayOf("RedundantVisibilityModifier", "IncorrectFormatting",
                "ReplaceArrayOfWithLiteral", "SpellCheckingInspection", "GrazieInspection"))

package dev.kord.common.entity

import kotlin.Any
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.LazyThreadSafetyMode.PUBLICATION
import kotlin.ReplaceWith
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Style of a [button][dev.kord.common.entity.ComponentType.Button].
 *
 * See [ButtonStyle]s in the
 * [Discord Developer Documentation](https://discord.com/developers/docs/interactions/message-components#button-object-button-styles).
 */
@Serializable(with = ButtonStyle.NewSerializer::class)
public sealed class ButtonStyle(
    /**
     * The raw value used by Discord.
     */
    public val `value`: Int,
) {
    public final override fun equals(other: Any?): Boolean = this === other ||
            (other is ButtonStyle && this.value == other.value)

    public final override fun hashCode(): Int = value.hashCode()

    public final override fun toString(): String =
            "ButtonStyle.${this::class.simpleName}(value=$value)"

    /**
     * An unknown [ButtonStyle].
     *
     * This is used as a fallback for [ButtonStyle]s that haven't been added to Kord yet.
     */
    public class Unknown(
        `value`: Int,
    ) : ButtonStyle(value)

    /**
     * Blurple.
     */
    public object Primary : ButtonStyle(1)

    /**
     * Grey.
     */
    public object Secondary : ButtonStyle(2)

    /**
     * Green.
     */
    public object Success : ButtonStyle(3)

    /**
     * Red.
     */
    public object Danger : ButtonStyle(4)

    /**
     * Grey, navigates to a URL.
     */
    public object Link : ButtonStyle(5)

    internal object NewSerializer : KSerializer<ButtonStyle> {
        public override val descriptor: SerialDescriptor =
                PrimitiveSerialDescriptor("dev.kord.common.entity.ButtonStyle", PrimitiveKind.INT)

        public override fun serialize(encoder: Encoder, `value`: ButtonStyle) =
                encoder.encodeInt(value.value)

        public override fun deserialize(decoder: Decoder) = when (val value = decoder.decodeInt()) {
            1 -> Primary
            2 -> Secondary
            3 -> Success
            4 -> Danger
            5 -> Link
            else -> Unknown(value)
        }
    }

    @Deprecated(
        level = DeprecationLevel.HIDDEN,
        message = "Use 'ButtonStyle.serializer()' instead.",
        replaceWith = ReplaceWith(expression = "ButtonStyle.serializer()", imports =
                    arrayOf("dev.kord.common.entity.ButtonStyle")),
    )
    public object Serializer : KSerializer<ButtonStyle> by NewSerializer {
        @Deprecated(
            level = DeprecationLevel.HIDDEN,
            message = "Use 'ButtonStyle.serializer()' instead.",
            replaceWith = ReplaceWith(expression = "ButtonStyle.serializer()", imports =
                        arrayOf("dev.kord.common.entity.ButtonStyle")),
        )
        public fun serializer(): KSerializer<ButtonStyle> = this
    }

    public companion object {
        /**
         * A [List] of all known [ButtonStyle]s.
         */
        public val entries: List<ButtonStyle> by lazy(mode = PUBLICATION) {
            listOf(
                Primary,
                Secondary,
                Success,
                Danger,
                Link,
            )
        }


        @Suppress(names = arrayOf("DEPRECATION_ERROR"))
        @Deprecated(
            level = DeprecationLevel.HIDDEN,
            message = "Binary compatibility",
        )
        @JvmField
        public val Serializer: Serializer = Serializer
    }
}
