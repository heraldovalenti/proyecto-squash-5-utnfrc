package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(PartidoController)
@Mock(Partido)
class PartidoControllerTests {

    def populateValidParams(params) {
        assert params != null
		params["estado"] = "Creado"
		params["ordenPartido"] = "1ro"
		
    }

    void testIndex() {
        controller.index()
        assert "/partido/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list1()

        assert model.partidoInstanceList.size() == 0
        assert model.partidoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.partidoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.partidoInstance != null
        assert view == '/partido/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/partido/show/1'
        assert controller.flash.message != null
        assert Partido.count() == 1
    }

    void testShow() {
        controller.show1()

        assert flash.message != null
        assert response.redirectedUrl == '/partido/list'

        populateValidParams(params)
        def partido = new Partido(params)

        assert partido.save() != null

        params.id = partido.id

        def model = controller.show1()

        assert model.partidoInstance == partido
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/partido/list'

        populateValidParams(params)
        def partido = new Partido(params)

        assert partido.save() != null

        params.id = partido.id

        def model = controller.edit()

        assert model.partidoInstance == partido
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/partido/list'

        response.reset()

        populateValidParams(params)
        def partido = new Partido(params)

        assert partido.save() != null

        // test invalid parameters in update
        params.id = partido.id
		params["estado"] = ""

        controller.update()

        assert view == "/partido/edit"
        assert model.partidoInstance != null

        partido.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/partido/show/$partido.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        partido.clearErrors()

        populateValidParams(params)
        params.id = partido.id
        params.version = -1
        controller.update()

        assert view == "/partido/edit"
        assert model.partidoInstance != null
        assert model.partidoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/partido/list'

        response.reset()

        populateValidParams(params)
        def partido = new Partido(params)

        assert partido.save() != null
        assert Partido.count() == 1

        params.id = partido.id

        controller.delete()

        assert Partido.count() == 0
        assert Partido.get(partido.id) == null
        assert response.redirectedUrl == '/partido/list'
    }
}
