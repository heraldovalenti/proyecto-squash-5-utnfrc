package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(PersonaController)
@Mock(Persona)
class PersonaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/persona/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personaInstanceList.size() == 0
        assert model.personaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.personaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.personaInstance != null
        assert view == '/persona/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/persona/show/1'
        assert controller.flash.message != null
        assert Persona.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/persona/list'

        populateValidParams(params)
        def persona = new Persona(params)

        assert persona.save() != null

        params.id = persona.id

        def model = controller.show()

        assert model.personaInstance == persona
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/persona/list'

        populateValidParams(params)
        def persona = new Persona(params)

        assert persona.save() != null

        params.id = persona.id

        def model = controller.edit()

        assert model.personaInstance == persona
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/persona/list'

        response.reset()

        populateValidParams(params)
        def persona = new Persona(params)

        assert persona.save() != null

        // test invalid parameters in update
        params.id = persona.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/persona/edit"
        assert model.personaInstance != null

        persona.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/persona/show/$persona.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        persona.clearErrors()

        populateValidParams(params)
        params.id = persona.id
        params.version = -1
        controller.update()

        assert view == "/persona/edit"
        assert model.personaInstance != null
        assert model.personaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/persona/list'

        response.reset()

        populateValidParams(params)
        def persona = new Persona(params)

        assert persona.save() != null
        assert Persona.count() == 1

        params.id = persona.id

        controller.delete()

        assert Persona.count() == 0
        assert Persona.get(persona.id) == null
        assert response.redirectedUrl == '/persona/list'
    }
}
