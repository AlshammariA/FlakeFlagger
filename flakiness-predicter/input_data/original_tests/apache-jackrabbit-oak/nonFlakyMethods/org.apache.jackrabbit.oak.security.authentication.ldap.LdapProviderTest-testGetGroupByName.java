@Test public void testGetGroupByName() throws Exception {
  ExternalGroup group=idp.getGroup(TEST_GROUP1_NAME);
  assertNotNull("Group 1 must exist",group);
  assertEquals("Group Ref",TEST_GROUP1_DN,group.getExternalId().getId());
}
