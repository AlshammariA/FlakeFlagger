@Test public void addMultiValuedStringWithNull() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[3];
  values[0]=getAdminSession().getValueFactory().createValue(true);
  values[2]=getAdminSession().getValueFactory().createValue(false);
  parentNode.setProperty("multi with null",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi with null");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.BOOLEAN,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length - 1,values2.length);
  }
  finally {
    session2.logout();
  }
}
