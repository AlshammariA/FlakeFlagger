@Test public void testSyncCreateUser() throws Exception {
  UserManager userManager=getUserManager(root);
  ContentSession cs=null;
  try {
    assertNull(userManager.getAuthorizable(userId));
    cs=login(new SimpleCredentials(userId,new char[0]));
    root.refresh();
    Authorizable a=userManager.getAuthorizable(userId);
    assertNotNull(a);
    ExternalUser user=idp.getUser(userId);
    for (    String prop : user.getProperties().keySet()) {
      assertTrue(a.hasProperty(prop));
    }
    assertEquals(TEST_CONSTANT_PROPERTY_VALUE,a.getProperty(TEST_CONSTANT_PROPERTY_NAME)[0].getString());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
