package modelo



import org.junit.*
import grails.test.mixin.*

@TestFor(DetalleDisponibilidadController)
@Mock(DetalleDisponibilidad)
class DetalleDisponibilidadControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/detalleDisponibilidad/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.detalleDisponibilidadInstanceList.size() == 0
        assert model.detalleDisponibilidadInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.detalleDisponibilidadInstance != null
    }

    void testSave() {
        controller.save()

        assert model.detalleDisponibilidadInstance != null
        assert view == '/detalleDisponibilidad/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/detalleDisponibilidad/show/1'
        assert controller.flash.message != null
        assert DetalleDisponibilidad.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleDisponibilidad/list'

        populateValidParams(params)
        def detalleDisponibilidad = new DetalleDisponibilidad(params)

        assert detalleDisponibilidad.save() != null

        params.id = detalleDisponibilidad.id

        def model = controller.show()

        assert model.detalleDisponibilidadInstance == detalleDisponibilidad
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleDisponibilidad/list'

        populateValidParams(params)
        def detalleDisponibilidad = new DetalleDisponibilidad(params)

        assert detalleDisponibilidad.save() != null

        params.id = detalleDisponibilidad.id

        def model = controller.edit()

        assert model.detalleDisponibilidadInstance == detalleDisponibilidad
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleDisponibilidad/list'

        response.reset()

        populateValidParams(params)
        def detalleDisponibilidad = new DetalleDisponibilidad(params)

        assert detalleDisponibilidad.save() != null

        // test invalid parameters in update
        params.id = detalleDisponibilidad.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/detalleDisponibilidad/edit"
        assert model.detalleDisponibilidadInstance != null

        detalleDisponibilidad.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/detalleDisponibilidad/show/$detalleDisponibilidad.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        detalleDisponibilidad.clearErrors()

        populateValidParams(params)
        params.id = detalleDisponibilidad.id
        params.version = -1
        controller.update()

        assert view == "/detalleDisponibilidad/edit"
        assert model.detalleDisponibilidadInstance != null
        assert model.detalleDisponibilidadInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/detalleDisponibilidad/list'

        response.reset()

        populateValidParams(params)
        def detalleDisponibilidad = new DetalleDisponibilidad(params)

        assert detalleDisponibilidad.save() != null
        assert DetalleDisponibilidad.count() == 1

        params.id = detalleDisponibilidad.id

        controller.delete()

        assert DetalleDisponibilidad.count() == 0
        assert DetalleDisponibilidad.get(detalleDisponibilidad.id) == null
        assert response.redirectedUrl == '/detalleDisponibilidad/list'
    }
}
