package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(DetalleResultadosController)
@Mock(DetalleResultados)
class DetalleResultadosControllerTests {

    def populateValidParams(params) {
        assert params != null
		params["jugador1"] = '1'
		params["jugador2"] = '2'
		params["nroSet"] = "1er SET"
		
    }

    void testIndex() {
        controller.index()
        assert "/detalleResultados/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.detalleResultadosInstanceList.size() == 0
        assert model.detalleResultadosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.detalleResultadosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.detalleResultadosInstance != null
        assert view == '/detalleResultados/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/detalleResultados/show/1'
        assert controller.flash.message != null
        assert DetalleResultados.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleResultados/list'

        populateValidParams(params)
        def detalleResultados = new DetalleResultados(params)

        assert detalleResultados.save() != null

        params.id = detalleResultados.id

        def model = controller.show()

        assert model.detalleResultadosInstance == detalleResultados
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleResultados/list'

        populateValidParams(params)
        def detalleResultados = new DetalleResultados(params)

        assert detalleResultados.save() != null

        params.id = detalleResultados.id

        def model = controller.edit()

        assert model.detalleResultadosInstance == detalleResultados
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/detalleResultados/list'

        response.reset()

        populateValidParams(params)
        def detalleResultados = new DetalleResultados(params)

        assert detalleResultados.save() != null

        // test invalid parameters in update
        params.id = detalleResultados.id
		params["jugador1"] = '33'
		params["jugador2"] = '33'
		params["nroSet"] = ""

        controller.update()

        assert view == "/detalleResultados/edit"
        assert model.detalleResultadosInstance != null

        detalleResultados.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/detalleResultados/show/$detalleResultados.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        detalleResultados.clearErrors()

        populateValidParams(params)
        params.id = detalleResultados.id
        params.version = -1
        controller.update()

        assert view == "/detalleResultados/edit"
        assert model.detalleResultadosInstance != null
        assert model.detalleResultadosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/detalleResultados/list'

        response.reset()

        populateValidParams(params)
        def detalleResultados = new DetalleResultados(params)

        assert detalleResultados.save() != null
        assert DetalleResultados.count() == 1

        params.id = detalleResultados.id

        controller.delete()

        assert DetalleResultados.count() == 0
        assert DetalleResultados.get(detalleResultados.id) == null
        assert response.redirectedUrl == '/detalleResultados/list'
    }
}
