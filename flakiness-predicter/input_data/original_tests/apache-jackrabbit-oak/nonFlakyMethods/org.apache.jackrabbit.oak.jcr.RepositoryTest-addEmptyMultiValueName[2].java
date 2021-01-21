@Test public void addEmptyMultiValueName() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[0];
  parentNode.setProperty("multi name",values,PropertyType.NAME);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi name");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.NAME,property.getType());
    Value[] values2=property.getValues();
    assertEquals(0,values2.length);
  }
  finally {
    session2.logout();
  }
}
