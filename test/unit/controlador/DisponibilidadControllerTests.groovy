package controlador



import modelo.Disponibilidad;
import controlador.DisponibilidadController;

import org.junit.*
import grails.test.mixin.*

@TestFor(DisponibilidadController)
@Mock(Disponibilidad)
class DisponibilidadControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/disponibilidad/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.disponibilidadInstanceList.size() == 0
        assert model.disponibilidadInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.disponibilidadInstance != null
    }

    void testSave() {
        controller.save()

        assert model.disponibilidadInstance != null
        assert view == '/disponibilidad/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/disponibilidad/show/1'
        assert controller.flash.message != null
        assert Disponibilidad.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/disponibilidad/list'

        populateValidParams(params)
        def disponibilidad = new Disponibilidad(params)

        assert disponibilidad.save() != null

        params.id = disponibilidad.id

        def model = controller.show()

        assert model.disponibilidadInstance == disponibilidad
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/disponibilidad/list'

        populateValidParams(params)
        def disponibilidad = new Disponibilidad(params)

        assert disponibilidad.save() != null

        params.id = disponibilidad.id

        def model = controller.edit()

        assert model.disponibilidadInstance == disponibilidad
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/disponibilidad/list'

        response.reset()

        populateValidParams(params)
        def disponibilidad = new Disponibilidad(params)

        assert disponibilidad.save() != null

        // test invalid parameters in update
        params.id = disponibilidad.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/disponibilidad/edit"
        assert model.disponibilidadInstance != null

        disponibilidad.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/disponibilidad/show/$disponibilidad.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        disponibilidad.clearErrors()

        populateValidParams(params)
        params.id = disponibilidad.id
        params.version = -1
        controller.update()

        assert view == "/disponibilidad/edit"
        assert model.disponibilidadInstance != null
        assert model.disponibilidadInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/disponibilidad/list'

        response.reset()

        populateValidParams(params)
        def disponibilidad = new Disponibilidad(params)

        assert disponibilidad.save() != null
        assert Disponibilidad.count() == 1

        params.id = disponibilidad.id

        controller.delete()

        assert Disponibilidad.count() == 0
        assert Disponibilidad.get(disponibilidad.id) == null
        assert response.redirectedUrl == '/disponibilidad/list'
    }
}
