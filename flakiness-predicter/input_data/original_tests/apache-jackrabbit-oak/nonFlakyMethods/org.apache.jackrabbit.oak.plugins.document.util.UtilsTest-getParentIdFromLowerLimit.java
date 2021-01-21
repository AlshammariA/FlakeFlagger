@Test public void getParentIdFromLowerLimit() throws Exception {
  assertEquals("1:/foo",Utils.getParentIdFromLowerLimit(Utils.getKeyLowerLimit("/foo")));
  assertEquals("1:/foo",Utils.getParentIdFromLowerLimit("2:/foo/bar"));
}
