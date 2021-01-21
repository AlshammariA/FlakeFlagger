@Test public void shouldFindTheGroupContainingResource(){
  final Collection<String> groups=victim.getGroupNamesContainingResource("/path/to/resource");
  assertEquals(2,groups.size());
  assertEquals("[g2, g3]",Arrays.toString(groups.toArray()));
}
