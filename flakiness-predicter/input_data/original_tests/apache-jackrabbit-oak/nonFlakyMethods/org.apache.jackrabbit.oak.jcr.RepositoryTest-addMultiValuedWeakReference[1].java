@Test public void addMultiValuedWeakReference() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Node referee=getAdminSession().getNode("/foo");
  referee.addMixin("mix:referenceable");
  getAdminSession().save();
  Value[] values=new Value[2];
  values[0]=getAdminSession().getValueFactory().createValue(referee,true);
  values[1]=getAdminSession().getValueFactory().createValue(referee,true);
  parentNode.setProperty("multi weak reference",values);
  parentNode.getSession().save();
  Session session2=createAnonymousSession();
  try {
    Property property=session2.getProperty(TEST_PATH + "/multi weak reference");
    assertTrue(property.isMultiple());
    assertEquals(PropertyType.WEAKREFERENCE,property.getType());
    Value[] values2=property.getValues();
    assertEquals(values.length,values2.length);
    assertEquals(values[0],values2[0]);
    assertEquals(values[1],values2[1]);
  }
  finally {
    session2.logout();
  }
}
