package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RecommendationViewModel: ViewModel() {

    data class RecommendationUiState(
        val placeList: List<Recommendation> = emptyList(),
        val currentPlace: Recommendation = LocalDataProvider.default
    )

    private val _uiState = MutableStateFlow(
        RecommendationUiState(
            placeList = LocalDataProvider.placeRecommendation(),
            currentPlace = LocalDataProvider.placeRecommendation().getOrElse(0) {
                LocalDataProvider.default
            }
        )
    )

    val uiState: StateFlow<RecommendationUiState> = _uiState

    fun updateCurrentPlace(selectedPlace: Recommendation) {
        _uiState.update {
            it.copy(currentPlace = selectedPlace)
        }
    }

}