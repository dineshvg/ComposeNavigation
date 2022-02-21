package com.dinesh.android.domain.categories.usecases

import com.dinesh.android.data.models.DomainModel
import com.dinesh.android.data.repository.CategoriesRepository
import io.kotest.core.spec.style.WordSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllDataUseCaseTest : WordSpec() {

    private lateinit var sut : GetAllDataUseCase

    private val repository: CategoriesRepository = mockk(relaxed = true)

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        sut = GetAllDataUseCase(
            repository = repository,
            dispatcher = StandardTestDispatcher()
        )
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        super.afterTest(testCase, result)
        Dispatchers.resetMain()
        clearAllMocks()
    }

    init {
        "GetAllDataUseCase" should {

            "get the list of Categories" {
                coEvery { repository.getAllCategories() } returns MOCK_TOP_CAT
                sut.invoke() shouldBe MOCK_TOP_CAT
            }
        }
    }

    companion object {
        private val MOCK_TOP_CAT = listOf(
            DomainModel.TopCategory()
        )
    }
}
