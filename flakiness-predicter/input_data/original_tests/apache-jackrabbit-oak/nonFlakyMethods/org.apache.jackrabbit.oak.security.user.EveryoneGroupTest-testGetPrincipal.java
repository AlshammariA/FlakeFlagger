@Test public void testGetPrincipal() throws Exception {
  assertEquals(EveryonePrincipal.getInstance(),everyoneGroup.getPrincipal());
  assertEquals(EveryonePrincipal.NAME,everyoneGroup.getPrincipal().getName());
}
