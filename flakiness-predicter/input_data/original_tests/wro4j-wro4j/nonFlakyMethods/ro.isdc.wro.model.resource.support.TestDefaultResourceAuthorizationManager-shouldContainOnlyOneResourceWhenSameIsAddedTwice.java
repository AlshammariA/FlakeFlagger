@Test public void shouldContainOnlyOneResourceWhenSameIsAddedTwice(){
  final String resource="/resource.js";
  victim.add(resource);
  victim.add(resource);
  assertEquals(1,victim.list().size());
  assertEquals(resource,victim.list().iterator().next());
}
