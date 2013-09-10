package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(DetalleRankingController)
@Mock(DetalleRanking)
class DetalleRankingControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/detalleRanking/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.detalleRankingInstanceList.size() == 0
        assert model.detalleRankingInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.detalleRankingInstance != null
    }

    void testSave() {
        controller.save()

        assert model.detalleRankingInstance != null
        assert view == '/detalleRanking/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/detalleRanking/show/1'
        assert controller.flash.message != null
        assert DetalleRanking.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleRanking/list'

        populateValidParams(params)
        def detalleRanking = new DetalleRanking(params)

        assert detalleRanking.save() != null

        params.id = detalleRanking.id

        def model = controller.show()

        assert model.detalleRankingInstance == detalleRanking
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleRanking/list'

        populateValidParams(params)
        def detalleRanking = new DetalleRanking(params)

        assert detalleRanking.save() != null

        params.id = detalleRanking.id

        def model = controller.edit()

        assert model.detalleRankingInstance == detalleRanking
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleRanking/list'

        response.reset()

        populateValidParams(params)
        def detalleRanking = new DetalleRanking(params)

        assert detalleRanking.save() != null

        // test invalid parameters in update
        params.id = detalleRanking.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/detalleRanking/edit"
        assert model.detalleRankingInstance != null

        detalleRanking.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/detalleRanking/show/$detalleRanking.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        detalleRanking.clearErrors()

        populateValidParams(params)
        params.id = detalleRanking.id
        params.version = -1
        controller.update()

        assert view == "/detalleRanking/edit"
        assert model.detalleRankingInstance != null
        assert model.detalleRankingInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/detalleRanking/list'

        response.reset()

        populateValidParams(params)
        def detalleRanking = new DetalleRanking(params)

        assert detalleRanking.save() != null
        assert DetalleRanking.count() == 1

        params.id = detalleRanking.id

        controller.delete()

        assert DetalleRanking.count() == 0
        assert DetalleRanking.get(detalleRanking.id) == null
        assert response.redirectedUrl == '/detalleRanking/list'
    }
}
