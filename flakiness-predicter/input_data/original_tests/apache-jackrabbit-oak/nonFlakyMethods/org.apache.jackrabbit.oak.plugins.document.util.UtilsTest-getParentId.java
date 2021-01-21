@Test public void getParentId() throws Exception {
  String longPath=PathUtils.concat("/" + Strings.repeat("p",Utils.PATH_LONG + 1),"foo");
  assertTrue(Utils.isLongPath(longPath));
  assertNull(Utils.getParentId(Utils.getIdFromPath(longPath)));
  assertNull(Utils.getParentId(Utils.getIdFromPath("/")));
  assertEquals("1:/foo",Utils.getParentId("2:/foo/bar"));
}
