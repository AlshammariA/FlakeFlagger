@Test public void shouldRenameWithConfiguredStrategy() throws Exception {
  final String orignalName="original.js";
  Assert.assertEquals(orignalName,victim.rename(orignalName,null));
}
