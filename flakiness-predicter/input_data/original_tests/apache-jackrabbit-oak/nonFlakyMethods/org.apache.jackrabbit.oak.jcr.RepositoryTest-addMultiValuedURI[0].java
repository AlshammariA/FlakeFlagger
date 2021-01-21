@Test public void addMultiValuedURI() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[2];
  values[0]=getAdminSession().getValueFactory().createValue("http://www.day.com",PropertyType.URI);
  values[1]=getAdminSession().getValueFactory().createValue("file://var/dam",PropertyType.URI);
  parentNode.setProperty("multi uri",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi uri");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.URI,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length,values2.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
