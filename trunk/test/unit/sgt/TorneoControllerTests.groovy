package sgt



import org.junit.*

import sgt.administracion.torneos.TorneoController;
import grails.test.mixin.*

@TestFor(TorneoController)
@Mock(Torneo)
class TorneoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/torneo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.torneoInstanceList.size() == 0
        assert model.torneoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.torneoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.torneoInstance != null
        assert view == '/torneo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/torneo/show/1'
        assert controller.flash.message != null
        assert Torneo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/torneo/list'

        populateValidParams(params)
        def torneo = new Torneo(params)

        assert torneo.save() != null

        params.id = torneo.id

        def model = controller.show()

        assert model.torneoInstance == torneo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/torneo/list'

        populateValidParams(params)
        def torneo = new Torneo(params)

        assert torneo.save() != null

        params.id = torneo.id

        def model = controller.edit()

        assert model.torneoInstance == torneo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/torneo/list'

        response.reset()

        populateValidParams(params)
        def torneo = new Torneo(params)

        assert torneo.save() != null

        // test invalid parameters in update
        params.id = torneo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/torneo/edit"
        assert model.torneoInstance != null

        torneo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/torneo/show/$torneo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        torneo.clearErrors()

        populateValidParams(params)
        params.id = torneo.id
        params.version = -1
        controller.update()

        assert view == "/torneo/edit"
        assert model.torneoInstance != null
        assert model.torneoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/torneo/list'

        response.reset()

        populateValidParams(params)
        def torneo = new Torneo(params)

        assert torneo.save() != null
        assert Torneo.count() == 1

        params.id = torneo.id

        controller.delete()

        assert Torneo.count() == 0
        assert Torneo.get(torneo.id) == null
        assert response.redirectedUrl == '/torneo/list'
    }
}
