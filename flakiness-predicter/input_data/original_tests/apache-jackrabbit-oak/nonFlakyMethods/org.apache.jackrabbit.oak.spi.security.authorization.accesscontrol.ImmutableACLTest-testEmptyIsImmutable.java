@Test public void testEmptyIsImmutable() throws Exception {
  JackrabbitAccessControlList acl=createEmptyACL();
  assertTrue(acl.isEmpty());
  assertEquals(0,acl.size());
  assertEquals(getTestPath(),acl.getPath());
  assertImmutable(acl);
}
