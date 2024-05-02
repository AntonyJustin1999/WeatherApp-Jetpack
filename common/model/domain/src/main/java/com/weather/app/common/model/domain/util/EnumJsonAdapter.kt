package com.weather.app.common.model.domain.util

class EnumJsonAdapter<T>
    //: JsonDeserializer<T>, JsonSerializer<T>
//    where T : Enum<T>, T : HasValue {
//    private var values: Map<String, T>? = null
//    override fun deserialize(
//        json: JsonElement?,
//        typeOfT: Type?,
//        context: JsonDeserializationContext?
//    ): T? {
//        return (values ?: @Suppress("UNCHECKED_CAST") (typeOfT as Class<T>).enumConstants
//            ?.associateBy { it.value }.also { values = it })?.get(json?.asString)
//    }
//
//    override fun serialize(
//        src: T,
//        typeOfSrc: Type?,
//        context: JsonSerializationContext?
//    ): JsonElement {
//        return JsonPrimitive(src.value)
//    }
//
//}
//
//interface HasValue {
//    val value: String
//}