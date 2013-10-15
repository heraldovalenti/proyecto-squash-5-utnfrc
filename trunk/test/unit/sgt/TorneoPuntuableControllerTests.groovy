package sgt
import sgt.administracion.torneos.TorneoPuntuableController



import org.junit.*
import grails.test.mixin.*

@TestFor(TorneoPuntuableController)
@Mock(TorneoPuntuable)
class TorneoPuntuableControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/torneoPuntuable/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.torneoPuntuableInstanceList.size() == 0
        assert model.torneoPuntuableInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.torneoPuntuableInstance != null
    }

    void testSave() {
        controller.save()

        assert model.torneoPuntuableInstance != null
        assert view == '/torneoPuntuable/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/torneoPuntuable/show/1'
        assert controller.flash.message != null
        assert TorneoPuntuable.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/torneoPuntuable/list'

        populateValidParams(params)
        def torneoPuntuable = new TorneoPuntuable(params)

        assert torneoPuntuable.save() != null

        params.id = torneoPuntuable.id

        def model = controller.show()

        assert model.torneoPuntuableInstance == torneoPuntuable
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/torneoPuntuable/list'

        populateValidParams(params)
        def torneoPuntuable = new TorneoPuntuable(params)

        assert torneoPuntuable.save() != null

        params.id = torneoPuntuable.id

        def model = controller.edit()

        assert model.torneoPuntuableInstance == torneoPuntuable
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/torneoPuntuable/list'

        response.reset()

        populateValidParams(params)
        def torneoPuntuable = new TorneoPuntuable(params)

        assert torneoPuntuable.save() != null

        // test invalid parameters in update
        params.id = torneoPuntuable.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/torneoPuntuable/edit"
        assert model.torneoPuntuableInstance != null

        torneoPuntuable.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/torneoPuntuable/show/$torneoPuntuable.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        torneoPuntuable.clearErrors()

        populateValidParams(params)
        params.id = torneoPuntuable.id
        params.version = -1
        controller.update()

        assert view == "/torneoPuntuable/edit"
        assert model.torneoPuntuableInstance != null
        assert model.torneoPuntuableInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/torneoPuntuable/list'

        response.reset()

        populateValidParams(params)
        def torneoPuntuable = new TorneoPuntuable(params)

        assert torneoPuntuable.save() != null
        assert TorneoPuntuable.count() == 1

        params.id = torneoPuntuable.id

        controller.delete()

        assert TorneoPuntuable.count() == 0
        assert TorneoPuntuable.get(torneoPuntuable.id) == null
        assert response.redirectedUrl == '/torneoPuntuable/list'
    }
}
