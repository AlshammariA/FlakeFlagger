@Test public void testFindAuthorizableByRelativePath() throws NotExecutableException, RepositoryException {
  Principal p=getTestPrincipal();
  Authorizable auth=null;
  try {
    auth=userMgr.createGroup(p);
    Value[] vs=new Value[]{superuser.getValueFactory().createValue("v1"),superuser.getValueFactory().createValue("v2")};
    String relPath="relPath/" + propertyName1;
    String relPath2="another/" + propertyName1;
    String relPath3="relPath/relPath/" + propertyName1;
    auth.setProperty(relPath,vs);
    auth.setProperty(relPath2,vs);
    auth.setProperty(relPath3,superuser.getValueFactory().createValue("v3"));
    superuser.save();
    Iterator<Authorizable> result=userMgr.findAuthorizables(propertyName1,"v1");
    assertTrue("expected result",result.hasNext());
    assertEquals(auth.getID(),result.next().getID());
    assertFalse("expected no more results",result.hasNext());
    result=userMgr.findAuthorizables(propertyName1,"v3");
    assertTrue("expected result",result.hasNext());
    assertEquals(auth.getID(),result.next().getID());
    assertFalse("expected no more results",result.hasNext());
    result=userMgr.findAuthorizables(relPath,"v1");
    assertTrue("expected result",result.hasNext());
    assertEquals(auth.getID(),result.next().getID());
    assertFalse("expected no more results",result.hasNext());
    result=userMgr.findAuthorizables("./" + propertyName1,"v1");
    assertFalse("expected result",result.hasNext());
  }
  finally {
    if (auth != null) {
      auth.remove();
      superuser.save();
    }
  }
}
