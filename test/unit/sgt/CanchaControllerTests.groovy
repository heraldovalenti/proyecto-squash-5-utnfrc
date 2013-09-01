package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(CanchaController)
@Mock(Cancha)
class CanchaControllerTests {

    def populateValidParams(params) {
        assert params != null
		params["ancho"] =10.0f
		params["largo"] =10.0f
		params["techo"] =true
		params["tipoSuelo"] ="Cemento"
		params["paredes"] ="Cemento"
		params["nombre"] ="Cancha 1"
		params["disponibilidad"] = new Disponibilidad()
    }

    void testIndex() {
        controller.index()
        assert "/cancha/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.canchaInstanceList.size() == 0
        assert model.canchaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.canchaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.canchaInstance != null
        assert view == '/cancha/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/cancha/show/1'
        assert controller.flash.message != null
        assert Cancha.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/cancha/list'

        populateValidParams(params)
        def cancha = new Cancha(params)

        assert cancha.save() != null

        params.id = cancha.id

        def model = controller.show()

        assert model.canchaInstance == cancha
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/cancha/list'

        populateValidParams(params)
        def cancha = new Cancha(params)

        assert cancha.save() != null

        params.id = cancha.id

        def model = controller.edit()

        assert model.canchaInstance == cancha
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/cancha/list'

        response.reset()

        populateValidParams(params)
        def cancha = new Cancha(params)

        assert cancha.save() != null

        // test invalid parameters in update
        params.id = cancha.id
		params["ancho"] =-10.0f
		params["largo"] =-10.0f
		params["tipoSuelo"] =""
		params["nombre"] =""
		params["disponibilidad"] =null

        controller.update()

        assert view == "/cancha/edit"
        assert model.canchaInstance != null

        cancha.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/cancha/show/$cancha.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        cancha.clearErrors()

        populateValidParams(params)
        params.id = cancha.id
        params.version = -1
        controller.update()

        assert view == "/cancha/edit"
        assert model.canchaInstance != null
        assert model.canchaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/cancha/list'

        response.reset()

        populateValidParams(params)
        def cancha = new Cancha(params)

        assert cancha.save() != null
        assert Cancha.count() == 1

        params.id = cancha.id

        controller.delete()

        assert Cancha.count() == 0
        assert Cancha.get(cancha.id) == null
        assert response.redirectedUrl == '/cancha/list'
    }
}
