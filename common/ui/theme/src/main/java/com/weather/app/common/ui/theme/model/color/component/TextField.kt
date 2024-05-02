package com.spares.propeller.commons.ui.theme.model.color.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class TextFieldColors(
    val border: TextFieldBorder,
    val text : TextFieldText,
    val background: TextFieldBackground,
    val cursor: TextFieldCursor,
    val icons: TextFieldIcons,
    val label: TextFieldLabel,
    val placeholder: TextFieldPlaceholder,
    val credential: Credentials,
    val localSearch: LocalSearch,
    val globalSearch: GlobalSearch
){

    fun clone(
        border: TextFieldBorder = this.border.clone(),
        text: TextFieldText = this.text.clone(),
        background: TextFieldBackground = this.background.clone(),
        cursor: TextFieldCursor = this.cursor.clone(),
        icons: TextFieldIcons = this.icons.clone(),
        label: TextFieldLabel = this.label.clone(),
        placeholder: TextFieldPlaceholder = this.placeholder.clone(),
        credential: Credentials = this.credential.clone(),
        localSearch: LocalSearch = this.localSearch.clone(),
        globalSearch: GlobalSearch = this.globalSearch.clone()
    )=TextFieldColors(
        border = border,
        text = text,
        background = background,
        cursor = cursor,
        icons = icons,
        label = label,
        placeholder = placeholder,
        credential = credential,
        localSearch = localSearch,
        globalSearch = globalSearch
    )

    fun updateFrom(other:TextFieldColors){
        border.updateFrom(other.border)
        text.updateFrom(other.text)
        background.updateFrom(other.background)
        cursor.updateFrom(other.cursor)
        icons.updateFrom(other.icons)
        label.updateFrom(other.label)
        placeholder.updateFrom(other.placeholder)
        credential.updateFrom(other.credential)
        localSearch.updateFrom(other.localSearch)
        globalSearch.updateFrom(other.globalSearch)
    }
}

data class TextFieldBackground(
    val normal: MutableState<Color>,
    val disabled: MutableState<Color>
){
    fun clone (
        normal: MutableState<Color> = mutableStateOf(this.normal.value),
        disabled: MutableState<Color> = mutableStateOf(this.disabled.value)
    ) = TextFieldBackground(
        normal = normal,
        disabled =disabled
    )
    fun updateFrom(other:TextFieldBackground){
        normal.value = other.normal.value
        disabled.value = other.disabled.value
    }
}

data class TextFieldCursor(
    val normal: MutableState<Color>,
    val error : MutableState<Color>
){
    fun clone (
        normal: MutableState<Color> = mutableStateOf(this.normal.value),
        error: MutableState<Color> = mutableStateOf(this.error.value)
    ) = TextFieldCursor(
        normal = normal,
        error = error
    )
    fun updateFrom(other:TextFieldCursor){
        normal.value = other.normal.value
        error.value = other.error.value
    }
}

data class TextFieldPlaceholder(
    val normal: MutableState<Color>,
    val disabled: MutableState<Color>,
){
    fun clone (
        normal: MutableState<Color> = mutableStateOf(this.normal.value),
        disabled: MutableState<Color> = mutableStateOf(this.disabled.value)
    ) = TextFieldPlaceholder(
        normal = normal,
        disabled = disabled
    )
    fun updateFrom(other:TextFieldPlaceholder){
       normal.value = other.normal.value
       disabled.value = other.disabled.value
    }
}

data class TextFieldIcons(
    val leading: MutableState<Color>,
    val disabledLeading: MutableState<Color>,
    val errorLeading: MutableState<Color>,
    val trailing: MutableState<Color>,
    val disabledTrailing: MutableState<Color>,
    val errorTrailing: MutableState<Color>,
){
    fun clone (
        leading: MutableState<Color> = mutableStateOf(this.leading.value),
        disabledLeading: MutableState<Color> = mutableStateOf(this.disabledLeading.value),
        errorLeading: MutableState<Color> = mutableStateOf(this.errorLeading.value),
        trailing: MutableState<Color> = mutableStateOf(this.trailing.value),
        disabledTrailing: MutableState<Color> = mutableStateOf(this.disabledTrailing.value),
        errorTrailing: MutableState<Color> = mutableStateOf(this.errorTrailing.value)
    ) = TextFieldIcons(
        leading = leading,
        disabledLeading = disabledLeading,
        errorLeading = errorLeading,
        trailing = trailing,
        disabledTrailing = disabledTrailing,
        errorTrailing = errorTrailing,
    )


    fun updateFrom(other:TextFieldIcons){
        leading.value = other.leading.value
        disabledLeading.value = other.disabledLeading.value
        errorLeading.value = other.errorLeading.value
        trailing.value = other.trailing.value
        disabledTrailing.value = other.disabledTrailing.value
        errorLeading.value = other.errorTrailing.value
    }
}

data class TextFieldText(
    val normal: MutableState<Color>,
    val disabled: MutableState<Color>,
){
    fun clone(
        normal: MutableState<Color> = mutableStateOf(this.normal.value),
        disabled: MutableState<Color> = mutableStateOf(this.disabled.value)
    )= TextFieldText(
        normal = normal,
        disabled = disabled
    )

    fun updateFrom(other:TextFieldText){
       normal.value = other.normal.value
       disabled.value = other.disabled.value
    }
}

data class TextFieldBorder(
    val focused: MutableState<Color>,
    val unfocused: MutableState<Color>,
    val disabled: MutableState<Color>,
    val error: MutableState<Color>,
){
    fun clone (
        focused: MutableState<Color> = mutableStateOf(this.focused.value),
        unfocused: MutableState<Color> = mutableStateOf(this.unfocused.value),
        disabled: MutableState<Color> = mutableStateOf(this.disabled.value),
        error: MutableState<Color> = mutableStateOf(this.error.value)
    )= TextFieldBorder(
        focused = focused,
        unfocused = unfocused,
        disabled = disabled,
        error = error
    )

    fun updateFrom(other:TextFieldBorder){
       focused.value = other.focused.value
       unfocused.value = other.unfocused.value
       disabled.value = other.disabled.value
       error.value = other.error.value
    }
}

data class TextFieldLabel(
    val label: MutableState<Color>,
    val disabled: MutableState<Color>,
    val focused: MutableState<Color>,
    val unfocused: MutableState<Color>,
    val error: MutableState<Color>,
){

    fun clone (
        label: MutableState<Color> = mutableStateOf(this.label.value),
        focused: MutableState<Color> = mutableStateOf(this.focused.value),
        unfocused: MutableState<Color> = mutableStateOf(this.unfocused.value),
        disabled: MutableState<Color> = mutableStateOf(this.disabled.value),
        error: MutableState<Color> = mutableStateOf(this.error.value)
    )= TextFieldLabel(
        label = label,
        focused = focused,
        unfocused = unfocused,
        disabled = disabled,
        error = error
    )

    fun updateFrom(other:TextFieldLabel){
        label.value = other.label.value
        disabled.value = other.disabled.value
        focused.value = other.focused.value
        unfocused.value = other.unfocused.value
        error.value = other.error.value
    }
}

data class Credentials(
    val normal: CredentialsPalette,
    val common: CredentialsPalette
) {
    fun clone(
        normal: CredentialsPalette = this.normal.clone(),
        common: CredentialsPalette = this.common.clone(),
    )=Credentials(
        normal = normal,
        common = common,
    )
    fun updateFrom(other:Credentials){
        normal.updateFrom(other.normal)
        common.updateFrom(other.common)
    }
}

data class CredentialsPalette(
    val border: TextFieldBorder,
    val text : TextFieldText,
    val background: TextFieldBackground,
    val placeholder: TextFieldPlaceholder,
){

    fun clone(
        border: TextFieldBorder = this.border.clone(),
        text:TextFieldText = this.text.clone(),
        background: TextFieldBackground = this.background.clone(),
        placeholder: TextFieldPlaceholder = this.placeholder.clone()
    )=CredentialsPalette(
        border = border,
        text = text,
        background = background,
        placeholder = placeholder
    )
    fun updateFrom(other:CredentialsPalette){
      border.updateFrom(other.border)
      text.updateFrom(other.text)
      background.updateFrom(other.background)
      placeholder.updateFrom(other.placeholder)
    }
}

data class LocalSearch(
    val normal: LocalSearchPalette,
    val common: LocalSearchPalette
) {
    fun clone(
        normal: LocalSearchPalette = this.normal.clone(),
        common: LocalSearchPalette = this.common.clone(),
    )=LocalSearch(
        normal = normal,
        common = common,
    )

    fun updateFrom(other:LocalSearch){
        normal.updateFrom(other.normal)
        common.updateFrom(other.common)
    }
}

data class LocalSearchPalette(
    val text : TextFieldText,
    val background: TextFieldBackground,
    val placeholder: TextFieldPlaceholder,
    val icons : TextFieldIcons,
    val border: TextFieldBorder
){

    fun clone(
        icons: TextFieldIcons = this.icons.clone(),
        text:TextFieldText = this.text.clone(),
        background: TextFieldBackground = this.background.clone(),
        placeholder: TextFieldPlaceholder = this.placeholder.clone(),
        border: TextFieldBorder = this.border.clone()
    )=LocalSearchPalette(
        icons = icons,
        text = text,
        background = background,
        placeholder = placeholder,
        border = border
    )

    fun updateFrom(other:LocalSearchPalette){
        text.updateFrom(other.text)
        background.updateFrom(other.background)
        placeholder.updateFrom(other.placeholder)
        icons.updateFrom(other.icons)
        border.updateFrom(other.border)
    }
}

data class GlobalSearch(
    val text : TextFieldText,
    val background: TextFieldBackground,
    val placeholder: TextFieldPlaceholder,
    val icons : TextFieldIcons,
    val border: TextFieldBorder
){

    fun clone(
        text:TextFieldText = this.text.clone(),
        background: TextFieldBackground = this.background.clone(),
        placeholder: TextFieldPlaceholder = this.placeholder.clone(),
        icons: TextFieldIcons = this.icons.clone(),
        border: TextFieldBorder = this.border.clone()
        )=GlobalSearch(
        icons = icons,
        text = text,
        background = background,
        placeholder = placeholder,
        border = border
    )
    fun updateFrom(other:GlobalSearch){
        text.updateFrom(other.text)
        background.updateFrom(other.background)
        placeholder.updateFrom(other.placeholder)
        icons.updateFrom(other.icons)
        border.updateFrom(other.border)
    }
}