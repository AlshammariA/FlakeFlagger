@Test public void addEmptyMultiValue() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[0];
  parentNode.setProperty("multi value",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi value");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.STRING,property.getType());
    Value[] values2=property.getValues();
    assertEquals(0,values2.length);
  }
  finally {
    session2.logout();
  }
}
