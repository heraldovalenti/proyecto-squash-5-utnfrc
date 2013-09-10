package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(RankingController)
@Mock(Ranking)
class RankingControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/ranking/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.rankingInstanceList.size() == 0
        assert model.rankingInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.rankingInstance != null
    }

    void testSave() {
        controller.save()

        assert model.rankingInstance != null
        assert view == '/ranking/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ranking/show/1'
        assert controller.flash.message != null
        assert Ranking.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ranking/list'

        populateValidParams(params)
        def ranking = new Ranking(params)

        assert ranking.save() != null

        params.id = ranking.id

        def model = controller.show()

        assert model.rankingInstance == ranking
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ranking/list'

        populateValidParams(params)
        def ranking = new Ranking(params)

        assert ranking.save() != null

        params.id = ranking.id

        def model = controller.edit()

        assert model.rankingInstance == ranking
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ranking/list'

        response.reset()

        populateValidParams(params)
        def ranking = new Ranking(params)

        assert ranking.save() != null

        // test invalid parameters in update
        params.id = ranking.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/ranking/edit"
        assert model.rankingInstance != null

        ranking.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ranking/show/$ranking.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ranking.clearErrors()

        populateValidParams(params)
        params.id = ranking.id
        params.version = -1
        controller.update()

        assert view == "/ranking/edit"
        assert model.rankingInstance != null
        assert model.rankingInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ranking/list'

        response.reset()

        populateValidParams(params)
        def ranking = new Ranking(params)

        assert ranking.save() != null
        assert Ranking.count() == 1

        params.id = ranking.id

        controller.delete()

        assert Ranking.count() == 0
        assert Ranking.get(ranking.id) == null
        assert response.redirectedUrl == '/ranking/list'
    }
}
