package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnote.routing.JetNotesRouter
import com.example.jetnote.ui.components.AppDrawer
import com.example.jetnote.ui.screens.NotesScreen
import com.example.jetnote.viewmodel.MainViewModel
import com.example.jetnote.routing.Screen
import com.example.jetnote.ui.screens.SaveNoteScreen
import com.example.jetnote.ui.theme.JetNotesTheme
import com.example.jetnote.viewmodel.MainViewModelFactory


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
                MainActivityScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
private fun MainActivityScreen(viewModel: MainViewModel) {
    Surface {
        when (JetNotesRouter.currentScreen) {
            is Screen.Notes -> NotesScreen(viewModel)
            is Screen.SaveNote -> SaveNoteScreen(viewModel)
//            is Screen.Trash -> TrashScreen(viewModel)
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


























