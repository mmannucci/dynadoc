package org.dynadoc.model

import grails.test.*
import grails.datastore.test.DatastoreUnitTestMixin

@Mixin(DatastoreUnitTestMixin)
class DocumentTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
        disconnect()
    }

    void testSave() {
        mockDomain(Document)
        def doc = new Document(type:'xyz')
        assert doc.save(flush:true)

        assert doc.id != null

        doc = Document.get(doc.id)
        assert doc != null
    }

}
