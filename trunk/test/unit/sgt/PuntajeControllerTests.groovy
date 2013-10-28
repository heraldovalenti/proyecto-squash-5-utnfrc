package sgt
import sgt.administracion.torneos.PuntajeController


import org.junit.*
import grails.test.mixin.*

@TestFor(PuntajeController)
@Mock(Puntaje)
class PuntajeControllerTests {

    def populateValidParams(params) {
        assert params != null
        params["categoria"] = null
    }

    void testIndex() {
        controller.index()
        assert "/puntaje/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.puntajeInstanceList.size() == 0
        assert model.puntajeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.puntajeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.puntajeInstance != null
        assert view == '/puntaje/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/puntaje/show/1'
        assert controller.flash.message != null
        assert Puntaje.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/puntaje/list'

        populateValidParams(params)
        def puntaje = new Puntaje(params)

        assert puntaje.save() != null

        params.id = puntaje.id

        def model = controller.show()

        assert model.puntajeInstance == puntaje
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/puntaje/list'

        populateValidParams(params)
        def puntaje = new Puntaje(params)

        assert puntaje.save() != null

        params.id = puntaje.id

        def model = controller.edit()

        assert model.puntajeInstance == puntaje
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/puntaje/list'

        response.reset()

        populateValidParams(params)
        def puntaje = new Puntaje(params)

        assert puntaje.save() != null

        // test invalid parameters in update
        params.id = puntaje.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/puntaje/edit"
        assert model.puntajeInstance != null

        puntaje.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/puntaje/show/$puntaje.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        puntaje.clearErrors()

        populateValidParams(params)
        params.id = puntaje.id
        params.version = -1
        controller.update()

        assert view == "/puntaje/edit"
        assert model.puntajeInstance != null
        assert model.puntajeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/puntaje/list'

        response.reset()

        populateValidParams(params)
        def puntaje = new Puntaje(params)

        assert puntaje.save() != null
        assert Puntaje.count() == 1

        params.id = puntaje.id

        controller.delete()

        assert Puntaje.count() == 0
        assert Puntaje.get(puntaje.id) == null
        assert response.redirectedUrl == '/puntaje/list'
    }
}
