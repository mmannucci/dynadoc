package org.dynadoc.model

import grails.test.*

class DocumentTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
        Document.collection.drop()
    }

    void testDynamicProperties() {
        def doc = new Document(type:'xyz')
        doc['foo'] = 'bar'

        assert doc.save(flush:true)

        doc = Document.get(doc.id)
        assert doc['foo'] == 'bar'
    }
}
