@Test public void testGetChildNodeEntries(){
  List<String> names=new ArrayList<String>();
  for (  ChildNodeEntry entry : state.getChildNodeEntries()) {
    names.add(entry.getName());
  }
  Collections.sort(names);
  assertEquals(Arrays.asList("x","y","z"),names);
}
