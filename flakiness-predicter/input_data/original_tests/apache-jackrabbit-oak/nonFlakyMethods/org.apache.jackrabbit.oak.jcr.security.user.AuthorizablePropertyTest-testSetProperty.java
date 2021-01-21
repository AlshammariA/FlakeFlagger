@Test public void testSetProperty() throws NotExecutableException, RepositoryException {
  String propName="Fullname";
  Value v=superuser.getValueFactory().createValue("Super User");
  try {
    user.setProperty(propName,v);
    superuser.save();
  }
 catch (  RepositoryException e) {
    throw new NotExecutableException("Cannot test 'Authorizable.setProperty'.");
  }
  try {
    boolean found=false;
    for (Iterator<String> it=user.getPropertyNames(); it.hasNext() && !found; ) {
      found=propName.equals(it.next());
    }
    assertTrue(found);
    found=false;
    for (Iterator<String> it=user.getPropertyNames("."); it.hasNext() && !found; ) {
      found=propName.equals(it.next());
    }
    assertTrue(found);
    assertTrue(user.hasProperty(propName));
    assertTrue(user.hasProperty("./" + propName));
    assertTrue(user.getProperty(propName).length == 1);
    assertEquals(v,user.getProperty(propName)[0]);
    assertEquals(v,user.getProperty("./" + propName)[0]);
    assertTrue(user.removeProperty(propName));
    assertFalse(user.hasProperty(propName));
    superuser.save();
  }
  finally {
    user.removeProperty(propName);
    superuser.save();
  }
}
