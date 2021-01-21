@Test public void setStringProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"string",getAdminSession().getValueFactory().createValue("string \" value"));
  Property property=parentNode.getProperty("string");
  property.setValue("new value");
  assertTrue(parentNode.isModified());
  assertTrue(property.isModified());
  assertFalse(property.isNew());
  property.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property2=session2.getProperty(TEST_PATH + "/string");
    assertEquals("new value",property2.getString());
  }
  finally {
    session2.logout();
  }
}
