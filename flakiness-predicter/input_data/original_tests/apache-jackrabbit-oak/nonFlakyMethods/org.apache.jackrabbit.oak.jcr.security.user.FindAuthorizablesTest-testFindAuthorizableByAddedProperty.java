@Test public void testFindAuthorizableByAddedProperty() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  Authorizable auth=null;
  try {
    auth=userMgr.createGroup(p);
    auth.setProperty("E-Mail",new Value[]{superuser.getValueFactory().createValue("anyVal")});
    superuser.save();
    boolean found=false;
    Iterator<Authorizable> result=userMgr.findAuthorizables("E-Mail","anyVal");
    while (result.hasNext()) {
      Authorizable a=result.next();
      if (a.getID().equals(auth.getID())) {
        found=true;
      }
    }
    assertTrue(found);
  }
  finally {
    if (auth != null) {
      auth.remove();
      superuser.save();
    }
  }
}
