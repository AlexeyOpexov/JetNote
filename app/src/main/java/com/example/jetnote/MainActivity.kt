package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnote.ui.components.AppDrawer
import com.example.jetnote.ui.screens.NotesScreen
import com.example.jetnote.ui.theme.Note
import com.example.jetnote.viewmodel.MainViewModel
import com.raywenderlich.android.jetnotes.routing.Screen
import com.raywenderlich.android.jetnotes.theme.JetNotesTheme
import com.raywenderlich.android.jetnotes.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        MainViewModelFactory(
            this,
            (application as JetNotesApplication).dependencyInjector.repository
        )
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNotesTheme {
                NotesScreen(viewModel = viewModel)
            }
        }
    }
}




@Composable
@Preview(showBackground = true)
private fun NotePreview() {
    JetNotesTheme {
        AppDrawer(Screen.Notes, {})
    }
}


























