package com.example.inventory.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun InputOutlinedTextField(
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String = "",
    enabled: Boolean = false,
    leadingIcon: String = "empty",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    when (leadingIcon) {
        "empty" -> {
            OutlinedTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                label = { Text(text = label) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                keyboardOptions = keyboardOptions,
                singleLine = true
            )
        }

        else -> {
            OutlinedTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                label = { Text(text = label) },
                leadingIcon = {
                    Text(leadingIcon)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                keyboardOptions = keyboardOptions,
                singleLine = true
            )
        }
    }


}
