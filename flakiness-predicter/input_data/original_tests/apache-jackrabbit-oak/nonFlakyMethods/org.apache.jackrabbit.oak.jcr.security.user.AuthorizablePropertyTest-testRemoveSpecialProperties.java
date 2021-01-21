@Test public void testRemoveSpecialProperties() throws NotExecutableException, RepositoryException {
  for (  String pName : protectedUserProps.keySet()) {
    try {
      if (user.removeProperty(pName)) {
        superuser.save();
        fail("removing the '" + pName + "' property on a User should fail.");
      }
    }
 catch (    RepositoryException e) {
    }
 finally {
      superuser.refresh(false);
    }
  }
  for (  String pName : protectedGroupProps.keySet()) {
    try {
      if (group.removeProperty(pName)) {
        superuser.save();
        fail("removing the '" + pName + "' property on a Group should fail.");
      }
    }
 catch (    RepositoryException e) {
    }
 finally {
      superuser.refresh(false);
    }
  }
}
