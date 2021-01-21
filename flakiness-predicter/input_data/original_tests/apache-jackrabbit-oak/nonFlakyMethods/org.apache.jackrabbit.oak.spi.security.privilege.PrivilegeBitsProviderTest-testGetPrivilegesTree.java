@Test public void testGetPrivilegesTree(){
  assertNotNull(bitsProvider.getPrivilegesTree());
  assertEquals(PRIVILEGES_PATH,bitsProvider.getPrivilegesTree().getPath());
}
