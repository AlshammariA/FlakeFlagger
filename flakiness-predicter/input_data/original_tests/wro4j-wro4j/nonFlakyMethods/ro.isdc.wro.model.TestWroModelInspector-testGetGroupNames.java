@Test public void testGetGroupNames(){
  final List<String> groupNames=victim.getGroupNames();
  Collections.sort(groupNames);
  final List<String> expected=Arrays.asList("g1","g2","g3");
  Assert.assertEquals(expected,groupNames);
}
