@Test public void testSetSpecialProperties() throws NotExecutableException, RepositoryException {
  Value v=superuser.getValueFactory().createValue("any_value");
  for (  String pName : protectedUserProps.keySet()) {
    try {
      boolean isMultiValued=protectedUserProps.get(pName);
      if (isMultiValued) {
        user.setProperty(pName,new Value[]{v});
      }
 else {
        user.setProperty(pName,v);
      }
      superuser.save();
      fail("changing the '" + pName + "' property on a User should fail.");
    }
 catch (    RepositoryException e) {
    }
 finally {
      superuser.refresh(false);
    }
  }
  for (  String pName : protectedGroupProps.keySet()) {
    try {
      boolean isMultiValued=protectedGroupProps.get(pName);
      if (isMultiValued) {
        group.setProperty(pName,new Value[]{v});
      }
 else {
        group.setProperty(pName,v);
      }
      superuser.save();
      fail("changing the '" + pName + "' property on a Group should fail.");
    }
 catch (    RepositoryException e) {
    }
 finally {
      superuser.refresh(false);
    }
  }
}
