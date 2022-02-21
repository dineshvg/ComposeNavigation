package com.dinesh.android.bonprix.category.presentation

import com.dinesh.android.bonprix.model.AllCategoryUiState
import com.dinesh.android.bonprix.model.category.CategoryUiState
import com.dinesh.android.data.models.DomainModel
import io.kotest.core.Tuple2
import io.kotest.core.spec.style.WordSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@ExperimentalCoroutinesApi
class CategoryViewModelTest : WordSpec() {

    private lateinit var sut : CategoryViewModel

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        Dispatchers.setMain(StandardTestDispatcher())
        sut = CategoryViewModel()
        sut.getCategory(MOCK_DATA, SELECTED)
    }

    override fun afterTest(f: suspend (Tuple2<TestCase, TestResult>) -> Unit) {
        super.afterTest(f)
        Dispatchers.resetMain()
    }

    init {
        "CategoryViewModel" should {

            "get the initial state" {
                sut.uiState.value shouldBe CategoryUiState(
                    isLoading = true,
                    title = "",
                    innerCategory = emptyList()
                )
            }
        }
    }

    companion object {
        private val MOCK_DATA = AllCategoryUiState(
            isLoading = false,
            categories = listOf(
                DomainModel.TopCategory(
                    label = "label",
                    innerCategories = listOf(
                        DomainModel.WebCategory(
                            label = "label",
                            webUrl = "weburl"
                        )
                    )
                )
            )
        )

        private val SELECTED = listOf("label")
    }
}
