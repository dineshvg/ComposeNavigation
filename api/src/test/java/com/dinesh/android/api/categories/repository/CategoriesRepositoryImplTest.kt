package com.dinesh.android.api.categories.repository

import com.dinesh.android.api.categories.mapper.DomainMapper
import com.dinesh.android.api.categories.remote.CategoriesRemote
import com.dinesh.android.data.models.DomainModel
import com.dinesh.android.data.models.RemoteCategoriesOverview
import com.dinesh.android.data.models.RemoteCategory
import com.dinesh.android.data.models.RemoteInnerCategory
import io.kotest.core.Tuple2
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
import kotlinx.coroutines.test.setMain

@ExperimentalCoroutinesApi
class CategoriesRepositoryImplTest : WordSpec() {

    private val remote: CategoriesRemote = mockk(relaxed = true)
    private val mapper: DomainMapper = DomainMapper()

    private lateinit var sut : CategoriesRepositoryImpl

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        Dispatchers.setMain(StandardTestDispatcher())
        sut = CategoriesRepositoryImpl(
            remote = remote,
            mapper = mapper,
        )
    }

    override fun afterTest(f: suspend (Tuple2<TestCase, TestResult>) -> Unit) {
        super.afterTest(f)
        Dispatchers.resetMain()
        clearAllMocks()
    }

    init {
        "CategoriesRepositoryImpl" should {

            "get all the categories" {

                coEvery { remote.getCategories() } returns MOCK_TOP_CAT_REMOTE

                sut.getAllCategories() shouldBe MOCK_TOP_CAT
            }
        }
    }

    companion object {
        private val MOCK_TOP_CAT_REMOTE = RemoteCategoriesOverview(
            categories = listOf(
                RemoteCategory(
                    label = "label",
                    children = listOf(
                        RemoteInnerCategory(
                            label = "1",
                        ),
                        RemoteInnerCategory(
                            label = "2",
                            children = listOf(
                                RemoteInnerCategory(
                                    label = "3"
                                )
                            )
                        )
                    )
                )
            )
        )

        private val MOCK_TOP_CAT = listOf(
            DomainModel.TopCategory(
                label = "label",
                innerCategories = listOf(
                    DomainModel.WebCategory(
                        label = "1",
                        webUrl = ""
                    ),
                    DomainModel.ListCategory(
                        label = "2",
                        webUrl = "",
                        children = listOf(
                            DomainModel.WebCategory(
                                label = "3",
                                webUrl = ""
                            )
                        )
                    )
                )
            )
        )
    }
}
