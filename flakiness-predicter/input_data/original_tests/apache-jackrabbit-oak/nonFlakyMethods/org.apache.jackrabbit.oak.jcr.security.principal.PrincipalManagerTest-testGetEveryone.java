@Test public void testGetEveryone(){
  Principal principal=principalMgr.getEveryone();
  assertTrue(principal != null);
  assertTrue(isGroup(principal));
}
