@Test public void verifyReferencePropertiesContent() throws Exception {
  Session session=createAdminSession();
  try {
    assertTrue(session.nodeExists("/referenceable"));
    String testNodeIdentifier=session.getNode("/referenceable").getIdentifier();
    assertTrue(session.nodeExists("/properties"));
    Node properties=session.getNode("/properties");
    assertEquals(PropertyType.REFERENCE,properties.getProperty("reference").getType());
    assertEquals(testNodeIdentifier,properties.getProperty("reference").getString());
    assertEquals("/referenceable",properties.getProperty("reference").getNode().getPath());
    PropertyIterator refs=session.getNode("/referenceable").getReferences();
    assertTrue(refs.hasNext());
    assertEquals(properties.getPath() + "/reference",refs.nextProperty().getPath());
    assertFalse(refs.hasNext());
    PropertyIterator refs2=session.getNode("/versionable").getReferences();
    assertTrue(refs2.hasNext());
    assertEquals(properties.getPath() + "/mv_reference",refs2.nextProperty().getPath());
    assertFalse(refs2.hasNext());
    assertEquals(PropertyType.WEAKREFERENCE,properties.getProperty("weak_reference").getType());
    assertEquals(testNodeIdentifier,properties.getProperty("weak_reference").getString());
    assertEquals("/referenceable",properties.getProperty("weak_reference").getNode().getPath());
    PropertyIterator weakRefs=session.getNode("/referenceable").getWeakReferences();
    assertTrue(weakRefs.hasNext());
    assertEquals(properties.getPath() + "/weak_reference",weakRefs.nextProperty().getPath());
    assertFalse(weakRefs.hasNext());
    PropertyIterator weakRefs2=session.getNode("/versionable").getWeakReferences();
    assertTrue(weakRefs2.hasNext());
    assertEquals(properties.getPath() + "/mv_weak_reference",weakRefs2.nextProperty().getPath());
    assertFalse(weakRefs2.hasNext());
  }
  finally {
    session.logout();
  }
}
