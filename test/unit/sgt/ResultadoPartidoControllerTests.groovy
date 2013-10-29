package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(ResultadoPartidoController)
@Mock(ResultadoPartido)
class ResultadoPartidoControllerTests {

    def populateValidParams(params) {
        assert params != null
        params["ganador"] = null
    }

    void testIndex() {
        controller.index()
        assert "/resultadoPartido/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.resultadoPartidoInstanceList.size() == 0
        assert model.resultadoPartidoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.resultadoPartidoInstance != null
    }

    void testSave() {	
				
        controller.save()

        assert model.resultadoPartidoInstance != null
        assert view == '/resultadoPartido/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/resultadoPartido/show/1'
        assert controller.flash.message != null
        assert ResultadoPartido.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/resultadoPartido/list'

        populateValidParams(params)
        def resultadoPartido = new ResultadoPartido(params)

        assert resultadoPartido.save() != null

        params.id = resultadoPartido.id

        def model = controller.show()

        assert model.resultadoPartidoInstance == resultadoPartido
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/resultadoPartido/list'

        populateValidParams(params)
        def resultadoPartido = new ResultadoPartido(params)

        assert resultadoPartido.save() != null

        params.id = resultadoPartido.id

        def model = controller.edit()

        assert model.resultadoPartidoInstance == resultadoPartido
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/resultadoPartido/list'

        response.reset()

        populateValidParams(params)
        def resultadoPartido = new ResultadoPartido(params)

        assert resultadoPartido.save() != null

        // test invalid parameters in update
        params.id = resultadoPartido.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/resultadoPartido/edit"
        assert model.resultadoPartidoInstance != null

        resultadoPartido.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/resultadoPartido/show/$resultadoPartido.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        resultadoPartido.clearErrors()

        populateValidParams(params)
        params.id = resultadoPartido.id
        params.version = -1
        controller.update()

        assert view == "/resultadoPartido/edit"
        assert model.resultadoPartidoInstance != null
        assert model.resultadoPartidoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/resultadoPartido/list'

        response.reset()

        populateValidParams(params)
        def resultadoPartido = new ResultadoPartido(params)

        assert resultadoPartido.save() != null
        assert ResultadoPartido.count() == 1

        params.id = resultadoPartido.id

        controller.delete()

        assert ResultadoPartido.count() == 0
        assert ResultadoPartido.get(resultadoPartido.id) == null
        assert response.redirectedUrl == '/resultadoPartido/list'
    }
}
