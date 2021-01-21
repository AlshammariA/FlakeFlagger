@Test public void addMultiValuedDouble() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[2];
  values[0]=getAdminSession().getValueFactory().createValue(42.1d);
  values[1]=getAdminSession().getValueFactory().createValue(99.0d);
  parentNode.setProperty("multi double",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi double");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.DOUBLE,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length,values2.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
