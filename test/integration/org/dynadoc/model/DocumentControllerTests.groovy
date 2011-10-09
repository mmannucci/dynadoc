package org.dynadoc.model

import grails.test.*

class DocumentControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
        controller.metaClass.message = {args -> return 'message'}
    }

    protected void tearDown() {
        super.tearDown()
        Document.collection.drop()
    }

    void testSomething() {
        controller.params.type = 'xyz'
        controller.params.foo = 'bar'

        controller.save()

        assertEquals 'show', controller.redirectArgs["action"]
        def doc = Document.get(controller.redirectArgs["id"])
        assert doc.type == 'xyz'
        assert doc['foo'] == 'bar'

    }
}
