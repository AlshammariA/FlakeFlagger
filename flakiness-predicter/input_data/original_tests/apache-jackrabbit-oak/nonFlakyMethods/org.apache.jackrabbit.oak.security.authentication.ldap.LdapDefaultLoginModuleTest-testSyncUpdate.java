@Test public void testSyncUpdate() throws Exception {
  Authorizable user=userManager.createUser(USER_ID,null);
  ExternalUser externalUser=idp.getUser(USER_ID);
  user.setProperty("rep:externalId",new ValueFactoryImpl(root,NamePathMapper.DEFAULT).createValue(externalUser.getExternalId().getString()));
  root.commit();
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(USER_ID,USER_PWD.toCharArray()));
    root.refresh();
    user=userManager.getAuthorizable(USER_ID);
    assertNotNull(user);
    assertTrue(user.hasProperty(USER_PROP));
    assertNull(userManager.getAuthorizable(GROUP_DN));
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
