@Test public void testFindNodesNonExactWithApostrophe() throws Exception {
  Value vs=valueFactory.createValue("value ' with apostrophe");
  try {
    user.setProperty(propertyName,vs);
    root.commit();
    Iterator<Authorizable> result=queryMgr.findAuthorizables(propertyName,"value ' with apostrophe",AuthorizableType.USER,false);
    assertTrue("expected result",result.hasNext());
    assertEquals(user.getID(),result.next().getID());
    assertFalse("expected no more results",result.hasNext());
  }
  finally {
    user.removeProperty(propertyName);
    root.commit();
  }
}
