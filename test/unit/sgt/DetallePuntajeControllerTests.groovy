package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(DetallePuntajeController)
@Mock(DetallePuntaje)
class DetallePuntajeControllerTests {

    def populateValidParams(params) {
        assert params != null
        params["descripcion"] = 'blablabla'
    }

    void testIndex() {
        controller.index()
        assert "/detallePuntaje/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.detallePuntajeInstanceList.size() == 0
        assert model.detallePuntajeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.detallePuntajeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.detallePuntajeInstance != null
        assert view == '/detallePuntaje/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/detallePuntaje/show/1'
        assert controller.flash.message != null
        assert DetallePuntaje.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/detallePuntaje/list'

        populateValidParams(params)
        def detallePuntaje = new DetallePuntaje(params)

        assert detallePuntaje.save() != null

        params.id = detallePuntaje.id

        def model = controller.show()

        assert model.detallePuntajeInstance == detallePuntaje
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/detallePuntaje/list'

        populateValidParams(params)
        def detallePuntaje = new DetallePuntaje(params)

        assert detallePuntaje.save() != null

        params.id = detallePuntaje.id

        def model = controller.edit()

        assert model.detallePuntajeInstance == detallePuntaje
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/detallePuntaje/list'

        response.reset()

        populateValidParams(params)
        def detallePuntaje = new DetallePuntaje(params)

        assert detallePuntaje.save() != null

        // test invalid parameters in update
        params.id = detallePuntaje.id
		params["descripcion"] = ''

        controller.update()

        assert view == "/detallePuntaje/edit"
        assert model.detallePuntajeInstance != null

        detallePuntaje.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/detallePuntaje/show/$detallePuntaje.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        detallePuntaje.clearErrors()

        populateValidParams(params)
        params.id = detallePuntaje.id
        params.version = -1
        controller.update()

        assert view == "/detallePuntaje/edit"
        assert model.detallePuntajeInstance != null
        assert model.detallePuntajeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/detallePuntaje/list'

        response.reset()

        populateValidParams(params)
        def detallePuntaje = new DetallePuntaje(params)

        assert detallePuntaje.save() != null
        assert DetallePuntaje.count() == 1

        params.id = detallePuntaje.id

        controller.delete()

        assert DetallePuntaje.count() == 0
        assert DetallePuntaje.get(detallePuntaje.id) == null
        assert response.redirectedUrl == '/detallePuntaje/list'
    }
}
