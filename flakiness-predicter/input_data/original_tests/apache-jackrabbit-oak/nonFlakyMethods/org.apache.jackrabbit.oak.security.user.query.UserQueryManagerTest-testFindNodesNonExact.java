@Test public void testFindNodesNonExact() throws Exception {
  Value vs=valueFactory.createValue("value \\, containing backslash");
  user.setProperty(propertyName,vs);
  root.commit();
  try {
    Iterator<Authorizable> result=queryMgr.findAuthorizables(propertyName,"value \\, containing backslash",AuthorizableType.USER,false);
    assertTrue("expected result",result.hasNext());
    assertEquals(user.getID(),result.next().getID());
    assertFalse("expected no more results",result.hasNext());
  }
  finally {
    user.removeProperty(propertyName);
    root.commit();
  }
}
