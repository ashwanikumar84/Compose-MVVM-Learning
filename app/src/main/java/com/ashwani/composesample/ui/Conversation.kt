package com.ashwani.composesample.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ashwani.composesample.model.Message
import com.ashwani.composesample.model.SampleData
import com.ashwani.composesample.ui.theme.ComposeSampleTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeSampleTheme {
        Conversation(SampleData.conversationSample)
    }
}