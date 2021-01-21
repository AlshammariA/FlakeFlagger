@Test public void addMultiValuedBinary() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Value[] values=new Value[2];
  InputStream is=new ByteArrayInputStream("foo".getBytes());
  Binary bin=getAdminSession().getValueFactory().createBinary(is);
  values[0]=getAdminSession().getValueFactory().createValue(bin);
  is=new ByteArrayInputStream("bar".getBytes());
  bin=getAdminSession().getValueFactory().createBinary(is);
  values[1]=getAdminSession().getValueFactory().createValue(bin);
  parentNode.setProperty("multi binary",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi binary");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.BINARY,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length,values2.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
