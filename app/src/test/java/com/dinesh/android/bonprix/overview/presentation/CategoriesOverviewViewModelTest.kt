package com.dinesh.android.bonprix.overview.presentation

import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.bonprix.model.overview.OverviewUiState
import com.dinesh.android.data.models.DomainModel
import io.kotest.core.Tuple2
import io.kotest.core.spec.style.WordSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@ExperimentalCoroutinesApi
class CategoriesOverviewViewModelTest : WordSpec() {

    private lateinit var sut: CategoriesOverviewViewModel

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        Dispatchers.setMain(StandardTestDispatcher())
        sut = CategoriesOverviewViewModel()
    }

    override fun afterTest(f: suspend (Tuple2<TestCase, TestResult>) -> Unit) {
        super.afterTest(f)
        Dispatchers.resetMain()
        clearAllMocks()
    }

    init {
        "CategoriesOverviewViewModel" should {

            "update ui_state" {
                sut.getOverview(MOCK_DATA)

                sut.uiState.value shouldBe OverviewUiState(
                    isLoading = true,
                    title = "",
                    link = "",
                    innerNames = emptyList()
                )
            }
        }
    }

    companion object {
        private val MOCK_DATA = AllCategoryUiState(
            isLoading = false,
            categories = listOf(
                DomainModel.TopCategory(
                    innerCategories = listOf(
                        DomainModel.WebCategory(
                            label = "label",
                            webUrl = "weburl"
                        )
                    )
                )
            )
        )
    }
}
