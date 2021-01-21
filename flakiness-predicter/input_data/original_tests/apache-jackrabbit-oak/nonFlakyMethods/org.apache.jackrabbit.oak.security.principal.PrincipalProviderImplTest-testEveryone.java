@Test public void testEveryone() throws Exception {
  Principal everyone=principalProvider.getPrincipal(EveryonePrincipal.NAME);
  assertTrue(everyone instanceof EveryonePrincipal);
  Group everyoneGroup=null;
  try {
    UserManager userMgr=getUserManager(root);
    everyoneGroup=userMgr.createGroup(EveryonePrincipal.NAME);
    root.commit();
    Principal ep=principalProvider.getPrincipal(EveryonePrincipal.NAME);
    assertFalse(ep instanceof EveryonePrincipal);
  }
  finally {
    if (everyoneGroup != null) {
      everyoneGroup.remove();
      root.commit();
    }
  }
}
