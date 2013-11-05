package sgt



import org.junit.*
import grails.test.mixin.*
import sgt.club.ServicioClubController

@TestFor(ServicioClubController)
@Mock(ServicioClub)
class ServicioClubControllerTests {

    def populateValidParams(params) {
        assert params != null
		params["nombre"] = 'Venta de Humo'
		params["descripcion"] = 'Trabajo bien remunerado'
    }

    void testIndex() {
        controller.index()
        assert "/servicioClub/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.servicioClubInstanceList.size() == 0
        assert model.servicioClubInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.servicioClubInstance != null
    }

    void testSave() {
        controller.save()

        assert model.servicioClubInstance != null
        assert view == '/servicioClub/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/servicioClub/show/1'
        assert controller.flash.message != null
        assert ServicioClub.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/servicioClub/list'

        populateValidParams(params)
        def servicioClub = new ServicioClub(params)

        assert servicioClub.save() != null

        params.id = servicioClub.id

        def model = controller.show()

        assert model.servicioClubInstance == servicioClub
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/servicioClub/list'

        populateValidParams(params)
        def servicioClub = new ServicioClub(params)

        assert servicioClub.save() != null

        params.id = servicioClub.id

        def model = controller.edit()

        assert model.servicioClubInstance == servicioClub
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/servicioClub/list'

        response.reset()

        populateValidParams(params)
        def servicioClub = new ServicioClub(params)

        assert servicioClub.save() != null

        // test invalid parameters in update
        params.id = servicioClub.id
        params["nombre"] = ''
		params["descripcion"] = ''

        controller.update()

        assert view == "/servicioClub/edit"
        assert model.servicioClubInstance != null

        servicioClub.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/servicioClub/show/$servicioClub.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        servicioClub.clearErrors()

        populateValidParams(params)
        params.id = servicioClub.id
        params.version = -1
        controller.update()

        assert view == "/servicioClub/edit"
        assert model.servicioClubInstance != null
        assert model.servicioClubInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/servicioClub/list'

        response.reset()

        populateValidParams(params)
        def servicioClub = new ServicioClub(params)

        assert servicioClub.save() != null
        assert ServicioClub.count() == 1

        params.id = servicioClub.id

        controller.delete()

        assert ServicioClub.count() == 0
        assert ServicioClub.get(servicioClub.id) == null
        assert response.redirectedUrl == '/servicioClub/list'
    }
}
