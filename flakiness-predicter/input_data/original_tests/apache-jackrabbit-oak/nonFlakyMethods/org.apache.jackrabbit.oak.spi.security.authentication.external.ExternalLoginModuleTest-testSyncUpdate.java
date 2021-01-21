@Test public void testSyncUpdate() throws Exception {
  UserManager userManager=getUserManager(root);
  ExternalUser externalUser=idp.getUser(userId);
  Authorizable user=userManager.createUser(externalUser.getId(),null);
  user.setProperty("rep:externalId",new ValueFactoryImpl(root,NamePathMapper.DEFAULT).createValue(externalUser.getExternalId().getString()));
  root.commit();
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(userId,new char[0]));
    root.refresh();
    Authorizable a=userManager.getAuthorizable(userId);
    assertNotNull(a);
    for (    String prop : externalUser.getProperties().keySet()) {
      assertTrue(a.hasProperty(prop));
    }
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
