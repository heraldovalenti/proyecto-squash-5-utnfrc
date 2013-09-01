package sgt



import org.junit.*
import grails.test.mixin.*

@TestFor(PermisoController)
@Mock(Permiso)
class PermisoControllerTests {

    def populateValidParams(params) {
        assert params != null
		params["nombre"] = 'Todo'
		params["descripcion"] = 'Acceso a todo'
    }

    void testIndex() {
        controller.index()
        assert "/permiso/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.permisoInstanceList.size() == 0
        assert model.permisoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.permisoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.permisoInstance != null
        assert view == '/permiso/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/permiso/show/1'
        assert controller.flash.message != null
        assert Permiso.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/permiso/list'

        populateValidParams(params)
        def permiso = new Permiso(params)

        assert permiso.save() != null

        params.id = permiso.id

        def model = controller.show()

        assert model.permisoInstance == permiso
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/permiso/list'

        populateValidParams(params)
        def permiso = new Permiso(params)

        assert permiso.save() != null

        params.id = permiso.id

        def model = controller.edit()

        assert model.permisoInstance == permiso
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/permiso/list'

        response.reset()

        populateValidParams(params)
        def permiso = new Permiso(params)

        assert permiso.save() != null

        // test invalid parameters in update
        params.id = permiso.id
        params["nombre"] = new Date()

        controller.update()

        assert view == "/permiso/edit"
        assert model.permisoInstance != null

        permiso.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/permiso/show/$permiso.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        permiso.clearErrors()

        populateValidParams(params)
        params.id = permiso.id
        params.version = -1
        controller.update()

        assert view == "/permiso/edit"
        assert model.permisoInstance != null
        assert model.permisoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/permiso/list'

        response.reset()

        populateValidParams(params)
        def permiso = new Permiso(params)

        assert permiso.save() != null
        assert Permiso.count() == 1

        params.id = permiso.id

        controller.delete()

        assert Permiso.count() == 0
        assert Permiso.get(permiso.id) == null
        assert response.redirectedUrl == '/permiso/list'
    }
}
