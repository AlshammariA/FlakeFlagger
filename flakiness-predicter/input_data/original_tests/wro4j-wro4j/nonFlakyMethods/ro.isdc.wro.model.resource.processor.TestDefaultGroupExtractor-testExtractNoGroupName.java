@Test public void testExtractNoGroupName(){
  String groupName=victim.getGroupName(mockRequestForUri("/app/test.js"));
  Assert.assertEquals("test",groupName);
  groupName=victim.getGroupName(mockRequestForUri("/app/test.group.js"));
  Assert.assertEquals("test.group",groupName);
  Assert.assertEquals(null,victim.getGroupName(mockRequestForUri("/123/")));
}
