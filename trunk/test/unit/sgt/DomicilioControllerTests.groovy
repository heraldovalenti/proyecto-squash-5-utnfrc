package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(DomicilioController)
@Mock(Domicilio)
class DomicilioControllerTests {

    def populateValidParams(params) {
        assert params != null
		params["provincia"] = "Córdoba"
		params["ciudad"] = "Córdoba"
		params["domicilio"] = "qwea  333"
    }

    void testIndex() {
        controller.index()
        assert "/domicilio/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.domicilioInstanceList.size() == 0
        assert model.domicilioInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.domicilioInstance != null
    }

    void testSave() {
        controller.save()

        assert model.domicilioInstance != null
        assert view == '/domicilio/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/domicilio/show/1'
        assert controller.flash.message != null
        assert Domicilio.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/domicilio/list'

        populateValidParams(params)
        def domicilio = new Domicilio(params)

        assert domicilio.save() != null

        params.id = domicilio.id

        def model = controller.show()

        assert model.domicilioInstance == domicilio
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/domicilio/list'

        populateValidParams(params)
        def domicilio = new Domicilio(params)

        assert domicilio.save() != null

        params.id = domicilio.id

        def model = controller.edit()

        assert model.domicilioInstance == domicilio
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/domicilio/list'

        response.reset()

        populateValidParams(params)
        def domicilio = new Domicilio(params)

        assert domicilio.save() != null

        // test invalid parameters in update
        params.id = domicilio.id
		params["provincia"] = ""

        controller.update()

        assert view == "/domicilio/edit"
        assert model.domicilioInstance != null

        domicilio.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/domicilio/show/$domicilio.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        domicilio.clearErrors()

        populateValidParams(params)
        params.id = domicilio.id
        params.version = -1
        controller.update()

        assert view == "/domicilio/edit"
        assert model.domicilioInstance != null
        assert model.domicilioInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/domicilio/list'

        response.reset()

        populateValidParams(params)
        def domicilio = new Domicilio(params)

        assert domicilio.save() != null
        assert Domicilio.count() == 1

        params.id = domicilio.id

        controller.delete()

        assert Domicilio.count() == 0
        assert Domicilio.get(domicilio.id) == null
        assert response.redirectedUrl == '/domicilio/list'
    }
}
