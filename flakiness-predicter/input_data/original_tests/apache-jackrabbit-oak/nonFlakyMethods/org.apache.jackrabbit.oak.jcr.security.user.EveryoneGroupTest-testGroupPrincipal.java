@Test public void testGroupPrincipal() throws Exception {
  Principal everyonePrincipal=everyone.getPrincipal();
  assertTrue(everyonePrincipal instanceof java.security.acl.Group);
  assertTrue(everyonePrincipal.equals(EveryonePrincipal.getInstance()));
  assertTrue(EveryonePrincipal.getInstance().equals(everyonePrincipal));
  java.security.acl.Group gr=(java.security.acl.Group)everyonePrincipal;
  assertFalse(gr.isMember(everyonePrincipal));
  assertTrue(gr.isMember(getTestUser(superuser).getPrincipal()));
  assertTrue(gr.isMember(new PrincipalImpl("test")));
}
