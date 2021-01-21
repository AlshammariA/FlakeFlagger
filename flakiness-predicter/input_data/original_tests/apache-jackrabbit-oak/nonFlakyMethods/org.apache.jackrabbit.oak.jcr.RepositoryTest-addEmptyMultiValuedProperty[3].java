@Test public void addEmptyMultiValuedProperty() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[0];
  parentNode.setProperty("multi empty",values,PropertyType.BOOLEAN);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi empty");
    assertTrue(property.isMultiple());
    Value[] values2=property.getValues();
    assertEquals(0,values2.length);
  }
  finally {
    session2.logout();
  }
}
