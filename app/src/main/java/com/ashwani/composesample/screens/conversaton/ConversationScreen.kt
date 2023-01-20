package com.ashwani.composesample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashwani.composesample.R
import com.ashwani.composesample.model.Message
import com.ashwani.composesample.model.SampleData
import com.ashwani.composesample.ui.theme.ComposeSampleTheme

@Composable
fun ConversationScreen(onButtonClick: () -> Unit,
                       messages: List<Message>) {

    Column(modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Bottom) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages) { message ->
                MessageCard(message)
            }
        }
        Button(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
            onClick = { onButtonClick() }) {
            Text(text = stringResource(R.string.back))
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeSampleTheme {
        ConversationScreen(onButtonClick = { /*TODO*/ }, messages = SampleData.conversationSample)
    }
}