package org.dynadoc.model

import grails.test.*
import grails.datastore.test.DatastoreUnitTestMixin

@Mixin(DatastoreUnitTestMixin)
class DocumentControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
        controller.metaClass.message = {def args -> return "I'm a message"}
    }

    protected void tearDown() {
        super.tearDown()
        disconnect()
    }

    void testSave() {
        mockDomain(Document)
        controller.params.type = 'xyz'
        controller.save()

        assertEquals 'show', controller.redirectArgs["action"]
    }
}
